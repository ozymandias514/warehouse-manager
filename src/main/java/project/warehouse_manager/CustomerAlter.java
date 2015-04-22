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

//customer alter section --------------------------------------------------
public class CustomerAlter extends JFrame{
	JButton changeFirstBut, changeLastBut, changeEmail, goBackBut, clearBut;
	JTextField idField,valueField;
	Customer theCustomer = new Customer();
	
	int userSession;
	String[] userSessionData = new String[5];
	
	public CustomerAlter(int userId, String[] userData){
		
		System.arraycopy(userData, 0, userSessionData, 0, userData.length);
		userSession = userId;
		this.setSize(500,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Customer Alter Page");
		
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
		
		idField = new JTextField("ID",3);
		valueField = new JTextField("",10);
		
		ListenForButton lForButton = new ListenForButton();
		
		clearBut = new JButton("Clear Fields");
		changeFirstBut = new JButton("Change First Name");
		changeLastBut = new JButton("Change Last Name");
		changeEmail = new JButton("Change Email");
		goBackBut = new JButton("go back");
		
		changeFirstBut.addActionListener(lForButton);
		changeLastBut.addActionListener(lForButton);
		changeEmail.addActionListener(lForButton);
		goBackBut.addActionListener(lForButton);
		clearBut.addActionListener(lForButton);
		
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 1;
		thePanel.add(idField,gridConstraints);
		gridConstraints.gridwidth = 10;
		gridConstraints.gridx = 5;
		thePanel.add(valueField,gridConstraints);
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 2;
		thePanel.add(changeFirstBut,gridConstraints);
		gridConstraints.gridx = 6;
		thePanel.add(changeLastBut,gridConstraints);
		gridConstraints.gridx = 9;
		thePanel.add(changeEmail,gridConstraints);
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 3;
		thePanel.add(clearBut,gridConstraints);
		gridConstraints.gridwidth = 10;
		gridConstraints.gridx = 5;
		thePanel.add(goBackBut,gridConstraints);

		
		this.add(thePanel);
		
		this.setVisible(true);
		
		idField.requestFocus();
	}
	
	private class ListenForButton implements ActionListener{

		public void actionPerformed(ActionEvent e) {
				//go back button ---------------------------
			if(e.getSource() == goBackBut){
				dispose();
				new CustomerLanding(userSession, userSessionData);
				//change first name button------------------
			}else if(e.getSource() == changeFirstBut){
				if(idField.getText().isEmpty() || valueField.getText().isEmpty()){
					JOptionPane.showMessageDialog(CustomerAlter.this, "Fields cannot be empty, Input required: ID, First Name", "Error"
							, JOptionPane.ERROR_MESSAGE);
				}else{
					try{
						String newFirstName = valueField.getText();
						int customerId = Integer.parseInt(idField.getText());
						theCustomer.changeCustomerFirstName(customerId, newFirstName);
						 JOptionPane.showMessageDialog(CustomerAlter.this,"The customer First Name has been succesfully changed",
								 "Solution", JOptionPane.INFORMATION_MESSAGE);
					}catch(Exception NumberFormatException){
						JOptionPane.showMessageDialog(CustomerAlter.this, "Field Customer Id cannot be empty, Input required: Customer ID", "Error"
								, JOptionPane.ERROR_MESSAGE);
					}
				}
				// change last name button------------------
			}else if(e.getSource() == changeLastBut){

				if(idField.getText().isEmpty() || valueField.getText().isEmpty()){
					JOptionPane.showMessageDialog(CustomerAlter.this, "Fields cannot be empty, Input required: ID, Last Name", "Error"
							, JOptionPane.ERROR_MESSAGE);
				}else{
					try{
						int customerId = Integer.parseInt(idField.getText());
						String newLastName = valueField.getText();
						theCustomer.changeCustomerLastName(customerId, newLastName);
						 JOptionPane.showMessageDialog(CustomerAlter.this,"The customer Last Name has been succesfully changed",
								 "Solution", JOptionPane.INFORMATION_MESSAGE);
					}catch(Exception NumberFormatException){
						JOptionPane.showMessageDialog(CustomerAlter.this, "Field cannot be a String, Input required: Customer ID", "Error"
								, JOptionPane.ERROR_MESSAGE);
					}
				}
				//change email button-----------------------
			}else if(e.getSource() == changeEmail){

				if(idField.getText().isEmpty() || valueField.getText().isEmpty()){
					JOptionPane.showMessageDialog(CustomerAlter.this, "Fields cannot be empty, Input required: ID, email", "Error"
							, JOptionPane.ERROR_MESSAGE);
				}else{
					try{
						int customerId = Integer.parseInt(idField.getText());
						String newEmail = valueField.getText();
						theCustomer.changeCustomerEmail(customerId, newEmail);
						 JOptionPane.showMessageDialog(CustomerAlter.this,"The customer email has been succesfully changed",
								 "Solution", JOptionPane.INFORMATION_MESSAGE);
					}catch(Exception NumberFormatException){
						JOptionPane.showMessageDialog(CustomerAlter.this, "Field cannot be a String, Input required: Customer ID", "Error"
								, JOptionPane.ERROR_MESSAGE);
					}
				}
			}else if(e.getSource() == clearBut){
				idField.setText("");
				valueField.setText("");
				 JOptionPane.showMessageDialog(CustomerAlter.this,"All fields have now been cleared",
						 "Solution", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}