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


class UnitFill extends JFrame{
	
	JButton submitBut, goBack;
	JTextField unitIdField,descriptionField, pickUpField, customerIdField;
	
	int userSession;
	
	public UnitFill(int userId){
		
		this.setSize(500,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Warehouse");
		
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
		
		unitIdField = new JTextField("unit Id",20);
		descriptionField = new JTextField("description",20);
		pickUpField = new JTextField("pick date",20);
		customerIdField = new JTextField("customer id",20);
		
		submitBut = new JButton("Submit");
		goBack = new JButton("go back");
		
		submitBut.addActionListener(lForButton);
		goBack.addActionListener(lForButton);		
		
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 1;
		thePanel.add(unitIdField,gridConstraints);
		gridConstraints.gridx = 5;
		thePanel.add(unitIdField,gridConstraints);
		gridConstraints.gridx = 9;
		thePanel.add(pickUpField,gridConstraints);
		gridConstraints.gridwidth = 20;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 2;
		thePanel.add(descriptionField,gridConstraints);
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 3;
		thePanel.add(submitBut,gridConstraints);
		gridConstraints.gridx = 5;
		thePanel.add(goBack,gridConstraints);
		
		
		this.add(thePanel);
		
		this.setVisible(true);
		
		unitIdField.requestFocus();
		
	}
	
	private class ListenForButton implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == goBack){
				dispose();
				new UnitLanding(userSession);
			}
		}
	}
}
