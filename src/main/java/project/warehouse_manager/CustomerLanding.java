package project.warehouse_manager;

import javax.swing.*;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerLanding extends JFrame {

	JButton emailButton, idButton, listButton, 
	alterButton, addRemoveBut, unitsOwnedButton, 
	goBackBut;
	
	JTextField textResult;
	
	JTextArea textArea1;
	
	int userSession;
	
	Customer theCustomer = new Customer();
	
	public CustomerLanding(int userId){
		
		
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
		unitsOwnedButton = new JButton("units owned by ID");
		goBackBut = new JButton("Go Back");
		goBackBut.setToolTipText("sends you back to the previous screen");
		
		emailButton.addActionListener(lForButton);
		idButton.addActionListener(lForButton);
		listButton.addActionListener(lForButton);
		alterButton.addActionListener(lForButton);
		addRemoveBut.addActionListener(lForButton);
		unitsOwnedButton.addActionListener(lForButton);
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
		thePanel.add(unitsOwnedButton,gridConstraints);
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
			if(e.getSource() == goBackBut){
				dispose();
				new LoggedInFrame(userSession);
			}else if(e.getSource() == addRemoveBut){
				dispose();
				new CustomerAddRemove(userSession);
			}else if(e.getSource() == alterButton){
				dispose();
				new CustomerAlter(userSession);
			}else if(e.getSource() == listButton){
				textArea1.setText("This will work soon");
			}else if(e.getSource() == emailButton){
				String email = textResult.getText();
				int userId = theCustomer.getIdByEmail(email);
				textArea1.setText("The user id pertaining to that email is: " + userId);
			}else if(e.getSource() == idButton){
				int userId = Integer.parseInt(textResult.getText());
				String[] customerData = theCustomer.getCustomerData(userId);
				textArea1.setText("First Name: "+ customerData[0] + "\nLast Name : " 
				+ customerData[1] + "\nemail: " +customerData[2]);
			}	
		}
	}
}
