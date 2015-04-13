package project.warehouse_manager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.BorderLayout;

import javax.swing.event.*;

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Main extends JFrame{
	
	JLabel userLabel, passwordLabel;
	JTextField userTextField, passwordTextField;
	JPasswordField passwordField;
	JButton acceptButton;
	JPanel mainPanel, loginPanel, loggedPanel;
	String outputString, password, username;
	static Users theUser = new Users();
	static Customer theCustomer = new Customer();
	static Unit theUnit = new Unit();
	
	public static void main(String[] args) {
		//tableCreation creator = new tableCreation();
		//unit theUnit = new unit();
		//Customer theCustomer = new Customer();
		
		//customer theCustomer = new customer();
		//theCustomer.getDataFromCustomer();
		
		new Main();
		
		//theCustomer.getDataFromCustomer();
		
		//theuser.displayDataFromUsers();
		//theUnit.getData();
		//theUnit.getEmptyUnitsInSmall();
		//System.out.println(Connection.userExist("this should not work"));
		
		//creator.generateSmallWarehouseUnitsInsertStatements();
		//creator.generateLargeWarehouseUnitsInsertStatements();
	}
	
	public Main(){
		
		this.setSize(600,100);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Warehouse Management");
		// creating the panels ----------------------------
		
		mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(300, 300));
		loginPanel = new JPanel();
		loginPanel.setPreferredSize(new Dimension(280,280));
		// adding the button ------------------------------
		acceptButton = new JButton("OK");
		ListenForButton lForButton = new ListenForButton();
		acceptButton.addActionListener(lForButton);
		loginPanel.add(acceptButton);
		// adding the user Label
		userLabel = new JLabel("Username");
		passwordLabel = new JLabel("Password");
		
		// adding the username  and password textfield
		userTextField = new JTextField("", 15);		
		passwordField = new JPasswordField("", 15);
		
		loginPanel.add(userLabel);
		loginPanel.add(userTextField);
		loginPanel.add(passwordLabel);
		loginPanel.add(passwordField);
		
		this.add(loginPanel);
		this.setVisible(true);
	}
	
	private class ListenForButton implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == acceptButton){
					username = userTextField.getText();
					password = passwordField.getText();
					if(username.length() <= 0 || password.length() <= 0){
	   					JOptionPane.showMessageDialog(Main.this, "The fields cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
					}else{
						if(theUser.authenticate(username, password)){
							int userId = theUser.getIdFromUsername(username);
							String[] data = theUser.getDataFromId(userId);
							outputString = "Welcome back " + data[0]+ " " + data[1]+ " Hope you are having a good day";
							JOptionPane.showMessageDialog(Main.this, outputString, "Information", JOptionPane.INFORMATION_MESSAGE);
							outputString = "";
							
							
							dispose();
							new LoggedInFrame(userId);
						}else{
							outputString = "Invalid login id, please try again";
							JOptionPane.showMessageDialog(Main.this, outputString, "Information", JOptionPane.INFORMATION_MESSAGE);
							outputString = "";
					}
				}
			}
		}
	}
}


class LoggedInFrame extends JFrame{
	
	static Users theUser = new Users();
	static Unit theUnit = new Unit();
	JPanel mainPanel, loginPanel, loggedPanel;
	JButton customerButton, unitButton, adminButton;
	JLabel username, emptyUnits;
	int userSession, queuedUnits, smallEmpty, largeEmpty;
	String[] data;
	
	public LoggedInFrame(int userId){
		
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		String date = dateFormat.format(cal.getTime());
		
		userSession = userId;
		this.setSize(400,200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Warehouse Management");
		loggedPanel = new JPanel();
		loggedPanel.setPreferredSize(new Dimension(480,280));
		loggedPanel.setLayout(new BorderLayout());
		
		
		data = theUser.getDataFromId(userId);
		queuedUnits = theUnit.numberOfItemsInQueue();
		smallEmpty= theUnit.getNumberOfEmptyUnitsInSmall();
		largeEmpty = theUnit.getNumberOfEmptyUnitsInLarge();
		
		username = new JLabel("Logged in as: " + data[2] + "          	           	  " + "       Today's date is: " + date);
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
				new CustomerLanding(userSession);
			}else{
				dispose();
				new UnitLanding(userSession);
			}
		}
	}
}
