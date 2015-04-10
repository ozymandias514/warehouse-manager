package project.warehouse_manager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;

import java.util.Calendar;
import java.util.Date;

public class Main extends JFrame{
	
	JLabel userLabel, passwordLabel;
	JTextField userTextField, passwordTextField;
	JButton acceptButton;
	JPanel mainPanel, loginPanel, loggedPanel;
	String outputString, password, username;
	static Users theUser = new Users();
	static Customer theCustomer = new Customer();
	static Unit theUnit = new Unit();
	
	public static void main(String[] args) {
		//tableCreation creator = new tableCreation();
		//unit theUnit = new unit();
		//customer theCustomer = new customer();
		
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
		
		this.setSize(500,200);
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
		passwordTextField = new JTextField("", 15);
		
		loginPanel.add(userLabel);
		loginPanel.add(userTextField);
		loginPanel.add(passwordLabel);
		loginPanel.add(passwordTextField);
		
		this.add(loginPanel);
		this.setVisible(true);
	}
	
	private class ListenForButton implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == acceptButton){
					username = userTextField.getText();
					password = passwordTextField.getText();
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
	
	JPanel mainPanel, loginPanel, loggedPanel;
	JButton customerButton, unitButton;
	int userSession;
	
	public LoggedInFrame(int userId){
		
		userSession = userId;
		this.setSize(500,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Warehouse Management");
		loggedPanel = new JPanel();
		loggedPanel.setPreferredSize(new Dimension(480,280));
		
		ListenForButton lForButton = new ListenForButton();
		customerButton = new JButton("Customer");
		customerButton.addActionListener(lForButton);
		
		unitButton = new JButton("Unit");
		unitButton.addActionListener(lForButton);
		
		loggedPanel.add(customerButton);
		loggedPanel.add(unitButton);
		
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
