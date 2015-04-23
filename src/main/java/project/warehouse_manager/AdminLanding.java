package project.warehouse_manager;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class AdminLanding extends JFrame{

	JButton goBackBut, purgeSmallBut, runQueue;
	
	int userSession;
	String[] userSessionData = new String[5];
	Unit theUnit = new Unit();
	
	Queue<UnitData> queue;
	
	public AdminLanding(int userId, String[] userData){
		
		System.arraycopy(userData, 0, userSessionData, 0, userData.length );
		
		userSession = userId;
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Admin Page");
		
		JPanel thePanel = new JPanel();
		
		thePanel.setLayout(new GridBagLayout());
		
		GridBagConstraints gridConstraints = new GridBagConstraints();
		
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 1;
		gridConstraints.gridwidth = 1; 
		gridConstraints.gridheight = 1;
		gridConstraints.weightx = 50;
		gridConstraints.weighty = 100;
		gridConstraints.insets = new Insets(5,5,5,5);
		gridConstraints.anchor = gridConstraints.CENTER;
		gridConstraints.fill = gridConstraints.BOTH;
		
		ListenForButton lForButton = new ListenForButton();
		
		goBackBut = new JButton("Go Back");
		goBackBut.setToolTipText("sends you back to the previous screen");
		purgeSmallBut = new JButton("Purge Small warehouse");
		purgeSmallBut.setToolTipText("Will purge all items from the small warehouse");
		runQueue = new JButton("Run Queue");
		runQueue.setToolTipText("Will run the queue algorithm to decide which item will go next to the small warehouse");
		
		goBackBut.addActionListener(lForButton);
		purgeSmallBut.addActionListener(lForButton);
		runQueue.addActionListener(lForButton);
		
		gridConstraints.gridwidth = 20;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 1;
		thePanel.add(goBackBut, gridConstraints);
		gridConstraints.gridwidth = 20;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 2;
		thePanel.add(purgeSmallBut, gridConstraints);
		gridConstraints.gridwidth = 20;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 3;
		thePanel.add(runQueue, gridConstraints);
		
		this.add(thePanel);
		
		this.setVisible(true);		
		
	}
	
	private class ListenForButton implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == goBackBut){
				dispose();
				new LoggedInFrame(userSession, userSessionData);
			}else if(e.getSource() == purgeSmallBut){
					theUnit.purgeSmall();
					 JOptionPane.showMessageDialog(AdminLanding.this,"Small warehouse has been emptied",
							 "Solution", JOptionPane.INFORMATION_MESSAGE);
			}else if(e.getSource() == runQueue){
				
				 try {
					queue = new PriorityQueue<UnitData>(6, new UnitDataComparator());
					
					ArrayList<UnitData> largeWarehouseUnitList = theUnit.getAllLargeWarehouseUnits();
					ArrayList<UnitData> smallWarehouseUnitList = theUnit.getAllSmallWarehouseUnits();
					Date now = new Date();
					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					Calendar cal = Calendar.getInstance();
					String date = dateFormat.format(cal.getTime());
					
					String[] splitDate = date.split("/");
					int day   = Integer.parseInt(splitDate[0]);
					int month = Integer.parseInt(splitDate[1]);
					int year  = Integer.parseInt(splitDate[2]);
					
					int totalTime = day + month*30 + year * 360;

					for (UnitData unit : largeWarehouseUnitList) {
						if (!(unit.getPickUpDate() == null)){
							String pickUpDateUnit = unit.getPickUpDate();
							String[] pickSplitDate = pickUpDateUnit.split("/");
							int pickDay   = Integer.parseInt(pickSplitDate[0]);
							int pickMonth = Integer.parseInt(pickSplitDate[1]);
							int pickYear  = Integer.parseInt(pickSplitDate[2]);
							int pickTotalTime = pickDay + pickMonth * 30 + pickYear*12 * 30;
							
							
							/*
							System.out.println("Regular Times");
							System.out.println("day " + day+" month " + month + " year "+ year);
							System.out.println("total Time: " + totalTime);
							System.out.println("Pick up times");
							System.out.println("day " + pickDay+" month " + pickMonth + " year "+ pickYear);
							System.out.println("total Time: " + pickTotalTime);
							*/
							if (pickTotalTime <= totalTime) {
								System.out.println("Id: " + unit.getId());
								System.out.println("Has been added to the queue");
								System.out.println();
								queue.add(unit);
								//unit.setInQueue(1); //set to "true"
							}
						}
					}

					List<Integer> openUnits = new ArrayList<Integer>();
					for (UnitData unit : smallWarehouseUnitList) {
						if (unit.getOccupied() == 0) {
							openUnits.add(unit.getId());
							
						}
					}
					
					System.out.println("There are " + openUnits.size() + " unoccupied units");
					
					int totalOpenUnits = 0;
					//totalOpenUnits = openUnits.size();
					UnitData smallWarehouseUnit = null;
					
					for (int i=0; i<queue.size(); i++) {
						if (openUnits.size() > 0) {
							
							UnitData largeWarehouseUnit = queue.remove();
							int customerId = largeWarehouseUnit.getCustomerId();
							String description = largeWarehouseUnit.getDescription();
							//largeWarehouseUnit.setInQueue(0);
							largeWarehouseUnit.setOccupied(0); //set to "false"
							largeWarehouseUnit.setDescription("empty unit");
							largeWarehouseUnit.setDateReceived("null");
							largeWarehouseUnit.setCustomerId(0);
							largeWarehouseUnit.setPickUpDate("null");
							
							
							
							for (UnitData unit : smallWarehouseUnitList) {
								if (unit.getId() == openUnits.get(totalOpenUnits)) {
									smallWarehouseUnit = unit;
								}
							}
							totalOpenUnits++;
							smallWarehouseUnit.setCustomerId(customerId);
							smallWarehouseUnit.setDescription(description);
							smallWarehouseUnit.setOccupied(1); //set to "true"
						}
					}
					
					theUnit.repopulateTables(largeWarehouseUnitList, smallWarehouseUnitList);
					
					for (UnitData unitData : queue) {
			       /* 	System.out.println("Unit Number: " + unitData.getId());
			        	System.out.println(unitData.getDescription());
			        	System.out.print(unitData.getCustomerId() + " ");
			        	System.out.print(unitData.getWarehouseId() + " Occupied: ");
			        	System.out.print(unitData.getOccupied());
			        	System.out.println();
			        	System.out.print("date received: " + unitData.getDateReceived());
			        	System.out.print(" Pick up date: " + unitData.getPickUpDate());
			        	System.out.println();
			        	System.out.print("priority: " + unitData.getPriority());
			        	System.out.print("  inQueue: " + unitData.getInQueue());
			        	System.out.print(" Position In Queue: " + unitData.getPositionInQueue());
			        	System.out.println();
			        	System.out.println();
			        	*/
					}
					
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
	}
}
