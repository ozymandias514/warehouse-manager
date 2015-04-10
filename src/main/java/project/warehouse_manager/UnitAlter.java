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

class UnitAlter extends JFrame{
	JButton changeDescBut, changePickBut, goBackBut;
	JTextField idField,valueField;
	
	int userSession;
	public UnitAlter(int userId){
		
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
		
		idField = new JTextField("ID",3);
		valueField = new JTextField("",10);
		
		changeDescBut = new JButton("Change Description");
		changePickBut = new JButton("Change pickup");
		goBackBut = new JButton("go back");
		
		changeDescBut.addActionListener(lForButton);
		changePickBut.addActionListener(lForButton);
		goBackBut.addActionListener(lForButton);
		
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 1;
		thePanel.add(idField,gridConstraints);
		gridConstraints.gridwidth = 10;
		gridConstraints.gridx = 5;
		thePanel.add(valueField,gridConstraints);
		gridConstraints.gridwidth = 10;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 2;
		thePanel.add(changeDescBut,gridConstraints);
		gridConstraints.gridx = 6;
		thePanel.add(changePickBut,gridConstraints);
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
				new UnitLanding(userSession);
			}
		}
	}
}