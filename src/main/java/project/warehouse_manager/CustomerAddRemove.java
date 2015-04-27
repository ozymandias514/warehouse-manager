package project.warehouse_manager;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


//add remove section ----------------------------------------------
public class CustomerAddRemove extends JFrame{
	
	JButton addCustomerBut, deleteBut, goBackBut, clearAll;
	JTextField firstNameField,lastNameField, emailField, idField, emailFieldErase;
	
	int userSession;
	String[] userSessionData = new String[5];
	
	Customer theCustomer = new Customer();
	Unit theUnit = new Unit();
	
	public CustomerAddRemove(int userId,  String[] userData){
		
		System.arraycopy(userData, 0, userSessionData, 0, userData.length);
		userSession = userId;
		this.setSize(500,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("customer add and remove");
		
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
		
		idField = new JTextField("ID",3);
		firstNameField = new JTextField("First Name",10);
		lastNameField = new JTextField("Last Name",10);
		emailField = new JTextField("email",10);
		emailFieldErase = new JTextField("email", 10);
		
		addCustomerBut = new JButton("add customer");
		deleteBut = new JButton("delete customer");
		goBackBut = new JButton("go back");
		clearAll = new JButton("Clear All");
		
		addCustomerBut.addActionListener(lForButton);
		deleteBut.addActionListener(lForButton);
		goBackBut.addActionListener(lForButton);
		clearAll.addActionListener(lForButton);
		
		gridConstraints.gridwidth = 1;
		gridConstraints.gridy = 1;
		gridConstraints.gridx = 1;
		thePanel.add(firstNameField, gridConstraints);
		gridConstraints.gridx = 5;
		thePanel.add(lastNameField, gridConstraints);
		gridConstraints.gridx = 9;
		thePanel.add(emailField, gridConstraints);
		gridConstraints.gridwidth = 1;
		gridConstraints.gridy = 2;
		gridConstraints.gridx = 1;
		thePanel.add(clearAll, gridConstraints);
		gridConstraints.gridwidth = 10;
		gridConstraints.gridx = 5;
		thePanel.add(addCustomerBut, gridConstraints);
		gridConstraints.gridwidth = 1;
		gridConstraints.gridy = 3;
		gridConstraints.gridx = 1;
		thePanel.add(idField, gridConstraints);
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 5;
		thePanel.add(emailFieldErase, gridConstraints);
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 9;
		thePanel.add(deleteBut, gridConstraints);
		gridConstraints.gridwidth = 20;
		gridConstraints.gridy = 4;
		gridConstraints.gridx = 1;
		thePanel.add(goBackBut, gridConstraints);
		
		this.add(thePanel);
		
		this.setVisible(true);
		
		idField.requestFocus();
	}
	
	private class ListenForButton implements ActionListener{

		public void actionPerformed(ActionEvent e) {
				//go back button -----------------------------
			if(e.getSource() == goBackBut){
				dispose();
				new CustomerLanding(userSession, userSessionData);
				//add customer button-------------------------
			}else if(e.getSource() == addCustomerBut){

				if(firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty() || emailField.getText().isEmpty()){
					JOptionPane.showMessageDialog(CustomerAddRemove.this,
							"Fields cannot be empty, Input required: First Name, Last Name, Email",
							"Error" , JOptionPane.ERROR_MESSAGE);
				}else{
					String userFirstName = firstNameField.getText();
					String userLastName = lastNameField.getText();
					String userEmail = emailField.getText();
					theCustomer.addCustomer(userFirstName, userLastName, userEmail);
				
					 JOptionPane.showMessageDialog(CustomerAddRemove.this,"The customer insertion was succesful",
							 "Solution", JOptionPane.INFORMATION_MESSAGE);
		
				}
				
				//delete customer button---------------------------
			}else if(e.getSource() == deleteBut){
				
				if(idField.getText().isEmpty() && emailFieldErase.getText().isEmpty()){
					JOptionPane.showMessageDialog(CustomerAddRemove.this,
							"Both Fields cannot be empty atleast one input is required, Input required: ID, or Email",
							"Error" , JOptionPane.ERROR_MESSAGE);
				}else if(!idField.getText().isEmpty() && emailFieldErase.getText().isEmpty() || !idField.getText().isEmpty() && !emailFieldErase.getText().isEmpty()){
					try{
						
						 int customerId = Integer.parseInt(idField.getText());
						 int totalUnits = theUnit.totalUnitsByCustomer(customerId);
						 
						 if(totalUnits > 0){
							 theUnit.emptyUnitByCustomer(customerId);
						 }
						 
						theCustomer.deleteCustomer(customerId);
					
							 JOptionPane.showMessageDialog(CustomerAddRemove.this,"The customer deletion succesful",
									 "Solution", JOptionPane.INFORMATION_MESSAGE);
				
				 }catch(Exception NumberFormatException){
						JOptionPane.showMessageDialog(CustomerAddRemove.this,
								"Field Cannot be a string, Input Required: Customer ID",
								"Error" , JOptionPane.ERROR_MESSAGE);
				 	}
				}else if(idField.getText().isEmpty() && !emailFieldErase.getText().isEmpty()){
					String customerEmail = emailFieldErase.getText();
					int customerId = 0;
					try {
						customerId = theCustomer.getIdByEmail(customerEmail);
					} catch (SQLException e1) {	}
					int totalUnits = 0;
					try {
						totalUnits = theUnit.totalUnitsByCustomer(customerId);
					} catch (SQLException e1) {	}
					
					if(totalUnits > 0){
						theUnit.emptyUnitByCustomer(customerId);
					}
					
					theCustomer.deleteCustomer(customerId);
					
						 JOptionPane.showMessageDialog(CustomerAddRemove.this,"The customer deletion was sucesful",
								 "Solution", JOptionPane.INFORMATION_MESSAGE);
			
				}
			}else if(e.getSource() == clearAll){
				 firstNameField.setText("");
				 lastNameField.setText("");
				 emailField.setText("");
				 idField.setText("");
				 emailFieldErase.setText("");
				 JOptionPane.showMessageDialog(CustomerAddRemove.this,"All fields have now been cleared",
						 "Solution", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}