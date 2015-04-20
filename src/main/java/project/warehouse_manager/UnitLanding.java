package project.warehouse_manager;

import javax.swing.*;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UnitLanding extends JFrame{

	JButton byIdBut, byCustomerBut, getDataBut, 
	vacantSmallBut, vacantLargeBut, alterBut, 
			removeBut, fillBut, goBackBut;
	
	JTextField text;
	
	JTextArea textArea1;
	
	int userSession;
	String[] userSessionData = new String[5];
	
	Unit theUnit = new Unit();
	Customer theCustomer = new Customer();
	Users theUser = new Users();
	
	public UnitLanding(int userId, String[] userData){
		
		System.arraycopy(userData, 0, userSessionData, 0, userData.length );
		userSession=userId;
		
		this.setSize(500,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Warehouse");
		
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
		
		text = new JTextField("",20);
		textArea1 = new JTextArea(15,20);
		textArea1.setLineWrap(true);
		textArea1.setWrapStyleWord(true);
		JScrollPane scrollbar1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		Font font = new Font("Helvetica", Font.PLAIN, 18);
		
		ListenForButton lForButton = new ListenForButton();
		
		byIdBut = new JButton("Find by unit Id");
		byCustomerBut = new JButton("Find By customer id");
		getDataBut = new JButton("get data");
		
		vacantSmallBut = new JButton("find small vacant");
		vacantSmallBut.setToolTipText("Find empty units in the small warehouse");
		
		vacantLargeBut = new JButton("find large vacant");
		alterBut = new JButton("alter");
		removeBut = new JButton("remove");
		fillBut = new JButton("Fill Unit");
		goBackBut = new JButton("go back");
		
		byIdBut.addActionListener(lForButton);
		byCustomerBut.addActionListener(lForButton);
		getDataBut.addActionListener(lForButton);
		vacantSmallBut.addActionListener(lForButton);
		vacantLargeBut.addActionListener(lForButton);
		fillBut.addActionListener(lForButton);
		alterBut.addActionListener(lForButton);
		removeBut.addActionListener(lForButton);
		
		goBackBut.addActionListener(lForButton);
		
		//thePanel.add(clearAll, gridConstraints);
		gridConstraints.gridwidth = 20;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 1;
		thePanel.add(text, gridConstraints);
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 2;
		thePanel.add(byIdBut,gridConstraints);
		gridConstraints.gridx = 5;
		thePanel.add(byCustomerBut,gridConstraints);
		gridConstraints.gridx = 9;
		thePanel.add(getDataBut,gridConstraints);
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 3;
		thePanel.add(vacantSmallBut,gridConstraints);
		gridConstraints.gridx = 5;
		thePanel.add(vacantLargeBut,gridConstraints);
		gridConstraints.gridx = 9;
		thePanel.add(alterBut,gridConstraints);
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 4;
		thePanel.add(removeBut,gridConstraints);
		gridConstraints.gridwidth = 10;
		gridConstraints.gridx = 5;
		thePanel.add(fillBut,gridConstraints);
		gridConstraints.gridwidth = 20;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 5;
		thePanel.add(scrollbar1,gridConstraints);
		gridConstraints.gridwidth = 20;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 6;
		thePanel.add(goBackBut,gridConstraints);

		
		this.add(thePanel);
		
		this.setVisible(true);
		
		text.requestFocus();
		
	}

	private class ListenForButton implements ActionListener{

		public void actionPerformed(ActionEvent e) {
				//go back button----------------------
			if(e.getSource() == goBackBut){
				dispose();
				new LoggedInFrame(userSession, userSessionData);
				//fill unit button--------------------
			}else if(e.getSource() == fillBut){
				dispose();
				new UnitFill(userSession, userSessionData);
				//alter unit button-------------------
			}else if(e.getSource() == alterBut){
				dispose();
				new UnitAlter(userSession, userSessionData);
				//find unit by id button--------------
			}else if(e.getSource() == byIdBut){
				if(text.getText().isEmpty()){
					 JOptionPane.showMessageDialog(UnitLanding.this,"Fields cannot be empty, Input required: unit ID ",
							 "Solution", JOptionPane.INFORMATION_MESSAGE);
				}else{
					try{
						int unitId = Integer.parseInt(text.getText());
						ArrayList<String> unitData = new ArrayList<String>();
						unitData = theUnit.unitsById(unitId);
							
						// unit id
						textArea1.setText("Unit id	: " + unitId);
			  			//description
		  				textArea1.append("\nDescription	:  " + unitData.get(0));
		  				//warehouse Id
		  				textArea1.append("\nwarehouse Id	:  " + unitData.get(1));
		  				// occupied
		  				textArea1.append("\noccupied	:  " + unitData.get(2));
		  				// date Received
		  				textArea1.append("\ndate Received	:  " + unitData.get(3));
		  				// pickup date
		  				textArea1.append("\nPickup Date	:  " + unitData.get(4));
		  				// priority
		  				textArea1.append("\nPriority	:  " + unitData.get(5));
		  				// inQueue
		  				textArea1.append("\ninQueue	:  " + unitData.get(6));
		  				// position in queue
		  				textArea1.append("\nplace In Queue	:  " + unitData.get(7));
					}catch(Exception NumberFormatException){
						 JOptionPane.showMessageDialog(UnitLanding.this,"Fields cannot be Strings, Input required: unit ID ",
								 "Error", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
				//find by customer id button----------
			}else if(e.getSource() == byCustomerBut){
				if(text.getText().isEmpty()){
					JOptionPane.showMessageDialog(UnitLanding.this, "Fields cannot be empty, or strings, Input required: Customer ID (integer)", "Error"
							, JOptionPane.ERROR_MESSAGE);
				}else{
					try{
						ArrayList<Integer> customerSmallUnits = new ArrayList<Integer>();
						ArrayList<Integer> customerLargeUnits = new ArrayList<Integer>();
						String[] customerData = new String[]{"","",""};
						int customerId = Integer.parseInt(text.getText());
						int numberOfLargeOwned = theUnit.getNumberOfUnitsOwnedInLargeByCustomerId(customerId);
						int numberOfSmallOwned = theUnit.getNumberOfUnitsOwnedInSmallByCustomerId(customerId);
						customerSmallUnits = theUnit.getCustomerUnitsInSmall(customerId);
						customerLargeUnits = theUnit.getCustomerUnitsInLarge(customerId);
						customerData = theCustomer.getCustomerData(customerId);
						
						textArea1.setText("Customer # " + customerId + "\n" + customerData[0] + " "  + customerData[1] + "\n" +
								customerData[2]);
						textArea1.append("\nCurrently owns " + numberOfLargeOwned + " in the large warehouse");
						textArea1.append("\nCurrently owns " + numberOfSmallOwned + " in the small warehouse");
						
						if(numberOfLargeOwned > 0){
							textArea1.append("\nLarge units owned: ");
							for(int i = 0; i < customerLargeUnits.size(); i++){
								textArea1.append(customerLargeUnits.get(i) + ", ");
							}
						}
						
						if(numberOfSmallOwned > 0){
							textArea1.append("\nSmall units owned: ");
							for(int i = 0; i < customerSmallUnits.size(); i++){
								textArea1.append(customerSmallUnits.get(i) + ", ");
							}
						}
					}catch(Exception NumberFormatException){
						JOptionPane.showMessageDialog(UnitLanding.this, "Fields cannot strings, Input required: Customer ID (integer)", "Error"
								, JOptionPane.ERROR_MESSAGE);
					}
				}
				
				//get data button---------------------
			}else if(e.getSource() == getDataBut){
				ArrayList<String> largeUnitData = new ArrayList<String>();
				largeUnitData = theUnit.displayLargeWarehouseData();
							
		  		textArea1.setText("Large Units in the system\n");
		  		textArea1.append("-----------------------------------------------------------");
					
		  		for(int i = 0; i < largeUnitData.size(); i++){
	  				textArea1.append("\nid	:  " + largeUnitData.get(i));
	  				i++;
	  				textArea1.append("\ndescription	:  " + largeUnitData.get(i));
	  				i++;
	  				textArea1.append("\ncustomer Id	:  " + largeUnitData.get(i));
	  				i++;
	  				textArea1.append("\nwarehouse Id	:  " + largeUnitData.get(i));
	  				i++;
	  				textArea1.append("\noccupied	:  " + largeUnitData.get(i));
	  				i++;
	  				textArea1.append("\ndate Received	:  " + largeUnitData.get(i));
	  				i++;
	  				textArea1.append("\nPickup date	:  " + largeUnitData.get(i));
	  				i++;
	  				textArea1.append("\nPriority	:  " + largeUnitData.get(i));
	  				i++;
	  				textArea1.append("\ninQueue	:  " + largeUnitData.get(i));
	  				i++;
	  				textArea1.append("\nnPlaceInQueue	:  " + largeUnitData.get(i));
	  				textArea1.append("\n-----------------------------------------------------------");
		  		}
		  		
				ArrayList<String> smallUnitData = new ArrayList<String>();
				smallUnitData = theUnit.displaySmallWarehouseData();
				
		  		textArea1.append("\nSmall Units in the system\n");
		  		
		  		for(int i = 0; i < smallUnitData.size(); i++){
	  				textArea1.append("\nid	:  " + smallUnitData.get(i));
	  				i++;
	  				textArea1.append("\ndescription	:  " + smallUnitData.get(i));
	  				i++;
	  				textArea1.append("\ncustomer Id	:  " + smallUnitData.get(i));
	  				i++;
	  				textArea1.append("\nwarehouse Id	:  " + smallUnitData.get(i));
	  				i++;
	  				textArea1.append("\noccupied	:  " + smallUnitData.get(i));
	  				i++;
	  				textArea1.append("\ndate Received	:  " + smallUnitData.get(i));
	  				i++;
	  				textArea1.append("\nPickup date	:  " + smallUnitData.get(i));
	  				i++;
	  				textArea1.append("\nPriority	:  " + smallUnitData.get(i));
	  				i++;
	  				textArea1.append("\ninQueue	:  " + smallUnitData.get(i));
	  				i++;
	  				textArea1.append("\nPlaceInQueue	:  " + smallUnitData.get(i));
	  				textArea1.append("\n-----------------------------------------------------------");
		  		}
		  		
				// find small vacants button-----------
			}else if(e.getSource() == vacantSmallBut){
				ArrayList<Integer> smallUnitEmpty = new ArrayList<Integer>();
				smallUnitEmpty = theUnit.getEmptyUnitsInSmall();
				textArea1.setText("The following units are empty in the small warehouse: \n");
				for(int i = 0; i < smallUnitEmpty.size(); i++){
					textArea1.append(smallUnitEmpty.get(i) + ", ");
				}
				//find large vacants button------------
			}else if(e.getSource() == vacantLargeBut){
				ArrayList<Integer> largeUnitEmpty = new ArrayList<Integer>();
				largeUnitEmpty = theUnit.getEmptyUnitsInLarge();
				textArea1.setText("The following units are empty in the large warehouse: \n");
				for(int i = 0; i < largeUnitEmpty.size(); i++){
					textArea1.append(largeUnitEmpty.get(i) + ", ");
				}
			}else if(e.getSource() == removeBut){
				int unitId = Integer.parseInt(text.getText());
				if(text.getText().isEmpty()){
					JOptionPane.showMessageDialog(UnitLanding.this, "Fields cannot be empty, Input required: Unit ID", "Error"
							, JOptionPane.ERROR_MESSAGE);
				}else{
					boolean check = theUnit.removeUnit(unitId);
					if(check == true){
						 JOptionPane.showMessageDialog(UnitLanding.this,"The unit was sucessfully cleared ",
								 "Solution", JOptionPane.INFORMATION_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(UnitLanding.this, "Something went wrong in the database, please try again later", "Error"
								, JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	}
}

