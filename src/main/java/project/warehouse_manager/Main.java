package project.warehouse_manager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Main extends JFrame{
	
	JLabel userLabel, passwordLabel;
	JTextField userTextField, passwordTextField;
	JPasswordField passwordField;
	JButton acceptButton;
	JPanel mainPanel, loginPanel, loggedPanel;
	String outputString, password, username;
	Users theUser = new Users();
	Customer theCustomer = new Customer();
	Unit theUnit = new Unit();
	
	public static void main(String[] args) {

		
		new Main();
		

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
		loginPanel.add(acceptButton);
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
							new LoggedInFrame(userId, data);
						}else{
							outputString = "Invalid login id or password, please try again";
							JOptionPane.showMessageDialog(Main.this, outputString, "Information", JOptionPane.INFORMATION_MESSAGE);
							outputString = "";
					}
				}
			}
		}
	}
}