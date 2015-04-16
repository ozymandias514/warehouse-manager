package project.warehouse_manager;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


//add remove section ----------------------------------------------
public class CustomerAddRemove extends JFrame{
	
	JButton addCustomerBut, deleteBut, goBackBut;
	JTextField firstNameField,lastNameField, emailField, idField;
	
	int userSession;
	
	Customer theCustomer = new Customer();
	Unit theUnit = new Unit();
	
	public CustomerAddRemove(int userId){
		
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
		
		addCustomerBut = new JButton("add customer");
		deleteBut = new JButton("delete customer");
		goBackBut = new JButton("go back");
		
		addCustomerBut.addActionListener(lForButton);
		deleteBut.addActionListener(lForButton);
		goBackBut.addActionListener(lForButton);
		
		gridConstraints.gridwidth = 1;
		gridConstraints.gridy = 1;
		gridConstraints.gridx = 1;
		thePanel.add(firstNameField, gridConstraints);
		gridConstraints.gridx = 5;
		thePanel.add(lastNameField, gridConstraints);
		gridConstraints.gridx = 9;
		thePanel.add(emailField, gridConstraints);
		gridConstraints.gridwidth = 20;
		gridConstraints.gridy = 2;
		gridConstraints.gridx = 1;
		thePanel.add(addCustomerBut, gridConstraints);
		gridConstraints.gridwidth = 1;
		gridConstraints.gridy = 3;
		gridConstraints.gridx = 1;
		thePanel.add(idField, gridConstraints);
		gridConstraints.gridwidth = 10;
		gridConstraints.gridx = 5;
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
				new CustomerLanding(userSession);
				//add customer button-------------------------
			}else if(e.getSource() == addCustomerBut){
				String userFirstName = firstNameField.getText();
				String userLastName = lastNameField.getText();
				String userEmail = emailField.getText();
				if(userFirstName.isEmpty() || userLastName.isEmpty() || userEmail.isEmpty()){
					JOptionPane.showMessageDialog(CustomerAddRemove.this,
							"Fields cannot be empty, Input required: First Name, Last Name, Email",
							"Error" , JOptionPane.ERROR_MESSAGE);
				}else{
					String answer = theCustomer.addCustomer(userFirstName, userLastName, userEmail);
					 JOptionPane.showMessageDialog(CustomerAddRemove.this,"The customer insertion " + answer,
							 "Solution", JOptionPane.INFORMATION_MESSAGE);
				}
				
				//delete customer button---------------------------
			}else if(e.getSource() == deleteBut){
				int customerId = Integer.parseInt(idField.getText());
				if(idField.getText().isEmpty()){
					JOptionPane.showMessageDialog(CustomerAddRemove.this,
							"Fields cannot be empty, Input required: ID",
							"Error" , JOptionPane.ERROR_MESSAGE);
				}else{
					 boolean checker = theUnit.emptyUnitByCustomer(customerId);
					 if(checker){
						 String answer = theCustomer.deleteCustomer(customerId);	
						 JOptionPane.showMessageDialog(CustomerAddRemove.this,"The customer deletion " + answer,
								 "Solution", JOptionPane.INFORMATION_MESSAGE);
						 

					 }else{
						JOptionPane.showMessageDialog(CustomerAddRemove.this,
								"We are currently experiencing database problems please try again later",
								"Error" , JOptionPane.ERROR_MESSAGE);
					 }
				 }
			}
		}
	}
}