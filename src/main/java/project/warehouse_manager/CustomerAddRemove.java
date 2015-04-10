package project.warehouse_manager;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


//add remove section ----------------------------------------------
public class CustomerAddRemove extends JFrame{
	
	JButton addCustomerBut, deleteBut, goBackBut;
	JTextField firstNameField,lastNameField, emailField, idField;
	
	int userSession;
	
	public CustomerAddRemove(int userId){
		
		userSession = userId;
		this.setSize(500,600);
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
		gridConstraints.gridwidth = 1;
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
			if(e.getSource() == goBackBut){
				dispose();
				new CustomerLanding(userSession);
			}
		}
	}
}