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

//customer alter section --------------------------------------------------
public class CustomerAlter extends JFrame{
	JButton changeFirstBut, changeLastBut, changeEmail, goBackBut;
	JTextField idField,valueField;
	
	int userSession;
	public CustomerAlter(int userId){
		
		userSession = userId;
		this.setSize(500,600);
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
		
		changeFirstBut = new JButton("Change First Name");
		changeLastBut = new JButton("Change Last Name");
		changeEmail = new JButton("Change Email");
		goBackBut = new JButton("go back");
		
		changeFirstBut.addActionListener(lForButton);
		changeLastBut.addActionListener(lForButton);
		changeEmail.addActionListener(lForButton);
		goBackBut.addActionListener(lForButton);
		
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
		gridConstraints.gridwidth = 20;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 3;
		thePanel.add(goBackBut,gridConstraints);
		
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