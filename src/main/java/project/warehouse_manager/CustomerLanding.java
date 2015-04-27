package project.warehouse_manager;

import javax.swing.*;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerLanding extends JFrame {

	JButton emailButton, idButton, listButton, 
	alterButton, addRemoveBut, clearFields, 
	goBackBut;
	
	JTextField textResult;
	
	JTextArea textArea1;
	
	int userSession;
	String[] userSessionData = new String[5];
	
	Customer theCustomer = new Customer();
	Users theUser = new Users();
	
	public CustomerLanding(int userId, String[] userData){
		// clone the data array
		
		System.arraycopy(userData, 0, userSessionData, 0, userData.length );
		
		userSession = userId;
		this.setSize(500,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Customer page");
		
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
		
		textResult = new JTextField("",20);
		textArea1 = new JTextArea(15,20);
		textArea1.setLineWrap(true);
		textArea1.setWrapStyleWord(true);
		JScrollPane scrollbar1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		Font font = new Font("Helvetica", Font.PLAIN, 18);
		
		ListenForButton lForButton = new ListenForButton();
		
		emailButton = new JButton("Find By Email");
		emailButton.setToolTipText("finds a user id with his email");
		idButton = new JButton("Find By Id");
		idButton.setToolTipText("allows you to find a customers data with his id");
		listButton = new JButton("display List");
		alterButton = new JButton("Alter records");
		alterButton.setToolTipText("allows you to change First name, Last name, or email");
		addRemoveBut = new JButton("Add/Delete customer");
		clearFields = new JButton("Clear Fields");
		goBackBut = new JButton("Go Back");
		goBackBut.setToolTipText("sends you back to the previous screen");
		
		emailButton.addActionListener(lForButton);
		idButton.addActionListener(lForButton);
		listButton.addActionListener(lForButton);
		alterButton.addActionListener(lForButton);
		addRemoveBut.addActionListener(lForButton);
		clearFields.addActionListener(lForButton);
		goBackBut.addActionListener(lForButton);

		
		gridConstraints.gridwidth = 20;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 1;
		thePanel.add(textResult, gridConstraints);
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 2;
		thePanel.add(emailButton,gridConstraints);
		gridConstraints.gridx = 5;
		thePanel.add(idButton,gridConstraints);
		gridConstraints.gridx = 9;
		thePanel.add(listButton,gridConstraints);
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 3;
		thePanel.add(alterButton,gridConstraints);
		gridConstraints.gridx = 5;
		thePanel.add(addRemoveBut,gridConstraints);
		gridConstraints.gridx = 9;
		thePanel.add(clearFields,gridConstraints);
		gridConstraints.gridwidth = 20;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 4;
		thePanel.add(scrollbar1,gridConstraints);
		gridConstraints.gridwidth = 20;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 5;
		thePanel.add(goBackBut,gridConstraints);
		
		this.add(thePanel);
		
		this.setVisible(true);
		
		textResult.requestFocus();		
		
	}
	
	private class ListenForButton implements ActionListener{

		public void actionPerformed(ActionEvent e) {
				//go back button -----------------------------------
			if(e.getSource() == goBackBut){
				dispose();
				new LoggedInFrame(userSession, userSessionData);
				// add and remove button ------------------------------
			}else if(e.getSource() == addRemoveBut){
				dispose();
				new CustomerAddRemove(userSession, userSessionData);
				// take to alter screen button ------------------------
			}else if(e.getSource() == alterButton){
				dispose();
				new CustomerAlter(userSession, userSessionData);
				// list all items button ------------------------------
			}else if(e.getSource() == listButton){
				ArrayList<String> userData = new ArrayList<String>();
				try {
					userData = theCustomer.displayData();
				} catch (SQLException e1) {
				}
			
		  		textArea1.setText("Customers in the system\n");
		  		textArea1.append("-----------------------------------------------------------");
					
		  		for(int i = 0; i < userData.size(); i++){
	  				textArea1.append("\nid	:  " + userData.get(i));
	  				i++;
	  				textArea1.append("\nfirst Name	:  " + userData.get(i));
	  				i++;
	  				textArea1.append("\nLast Name	:  " + userData.get(i));
	  				i++;
	  				textArea1.append("\nemail	:  " + userData.get(i));
	  				textArea1.append("\n-----------------------------------------------------------");
		  		}
		  				
				//get by email button ------------------------------------------
			}else if(e.getSource() == emailButton){
				
				if(textResult.getText().isEmpty()){
					JOptionPane.showMessageDialog(CustomerLanding.this, "Fields cannot be empty, Input required: email", "Error"
							, JOptionPane.ERROR_MESSAGE);
				}else{
					String email = textResult.getText();
					String data[] = null;
					try {
						data = theCustomer.getDataByEmail(email);
					} catch (SQLException e1) {
					}
					textArea1.setText("The user id pertaining to that email is: " + data[0] +
						"\nFirst Name: " + data[1] + "\nLast Name: " + data[2] + "\nemail: " + data[3]);	
				}
				// get by id button ----------------------------------
			}else if(e.getSource() == idButton){
				
				
				if(textResult.getText().isEmpty()){
					JOptionPane.showMessageDialog(CustomerLanding.this, "Fields cannot be empty, Input required: Customer ID", "Error"
							, JOptionPane.ERROR_MESSAGE);
				}else{
					try{
						int userId = Integer.parseInt(textResult.getText());
						int[] largeWare= theCustomer.largeUnitsByCustomer(userId);
						int[] smallWare= theCustomer.smallUnitsByCustomer(userId);
						String[] customerData = theCustomer.getCustomerData(userId);
						int largeLength = largeWare.length;
						int smallLength = smallWare.length;
						
						textArea1.setText("First Name: "+ customerData[0] + "\nLast Name : " 
						+ customerData[1] + "\nemail: " +customerData[2]);
						
						textArea1.append("\nLarge Units owned by this customer: ");
						int zero= 0;
						for(int x = 0;x < largeLength; x++){
							if(largeWare[x] != 0){
								zero++;
								textArea1.append(largeWare[x] + ", ");
							}
						}
						if(zero == 0){
							textArea1.append("none");
						}
						
						textArea1.append("\nSmall Units owned by this customer: ");
						int zero2= 0;
						for(int y = 0;y < smallLength; y++){
							if(smallWare[y] != 0){
								zero2++;
								textArea1.append(smallWare[y] + ", ");
							}
						}
						if(zero2 == 0){
							textArea1.append("none");
						}
					}catch(Exception numberFormatException){
						JOptionPane.showMessageDialog(CustomerLanding.this, "Field cannot be string, Input required: Customer ID", "Error"
								, JOptionPane.ERROR_MESSAGE);
					}
				}
					// clear screen button ------------------------------------
				}else if(e.getSource() == clearFields){
					textArea1.setText("");
					textResult.setText("");
					 JOptionPane.showMessageDialog(CustomerLanding.this,"All fields have now been cleared",
							 "Solution", JOptionPane.INFORMATION_MESSAGE);
				}
		}
	}
}