package project.warehouse_manager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoggedInFrame extends JFrame{
	
	//static Users theUser = new Users();
	Unit theUnit = new Unit();
	Users theUser = new Users();
	JPanel mainPanel, loginPanel, loggedPanel;
	JButton customerButton, unitButton, adminButton;
	JLabel username, emptyUnits;
	int userSession, queuedUnits, smallEmpty, largeEmpty;
	String[] userSessionData = new String[5];
	
	public LoggedInFrame(int userId, String[] userData){
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime());
		
		System.arraycopy(userData, 0, userSessionData, 0, userData.length );

		userSession = userId;
		this.setSize(400,200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Warehouse Management");
		loggedPanel = new JPanel();
		loggedPanel.setPreferredSize(new Dimension(480,280));
		loggedPanel.setLayout(new BorderLayout());
		
		
		queuedUnits = theUnit.numberOfItemsInQueue();
		smallEmpty= theUnit.getNumberOfEmptyUnitsInSmall();
		largeEmpty = theUnit.getNumberOfEmptyUnitsInLarge();
		
		username = new JLabel("Logged in as: " + userSessionData[2] + "          	           	  " + "       Today's date is: " + date);
		emptyUnits = new JLabel("Empty Large Units: " + largeEmpty  +"     Empty Small Units: " + smallEmpty + "     Items in Queue: " + queuedUnits);
		
		ListenForButton lForButton = new ListenForButton();
		customerButton = new JButton("Customer Options");
		customerButton.addActionListener(lForButton);
		
		unitButton = new JButton("Unit Options");
		unitButton.addActionListener(lForButton);
		
		adminButton = new JButton("Admin Panel");
		adminButton.addActionListener(lForButton);
		
		loggedPanel.add(username, BorderLayout.NORTH);
		loggedPanel.add(adminButton, BorderLayout.WEST);
		loggedPanel.add(unitButton, BorderLayout.CENTER);
		loggedPanel.add(customerButton, BorderLayout.EAST);
		loggedPanel.add(emptyUnits, BorderLayout.SOUTH);
		
		this.add(loggedPanel);
		this.setVisible(true);
	}
	
	private class ListenForButton implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == customerButton){
				dispose();
				new CustomerLanding(userSession, userSessionData);
				
				
			}else if(e.getSource() ==  unitButton){
				dispose();
				new UnitLanding(userSession, userSessionData);
				
			}else if(e.getSource() == adminButton){
				
				
				
				
				dispose();
				
				new AdminLanding(userSession, userSessionData);
			}
		}
	}
}
