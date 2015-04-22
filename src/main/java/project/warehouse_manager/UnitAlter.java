package project.warehouse_manager;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

class UnitAlter extends JFrame{
	JButton changeDescBut, changePickBut, goBackBut, clearBut;
	JTextField idField,valueField;
	JSpinner spinner;
	
	Unit theUnit = new Unit();
	
	int userSession;
	String[] userSessionData = new String[5];
	
	public UnitAlter(int userId, String[] userData){
		
		System.arraycopy(userData, 0, userSessionData, 0, userData.length);
		this.setSize(500,300);
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
		
		Date todaysDate = new Date();
		spinner = new JSpinner(new SpinnerDateModel(todaysDate, null, null, Calendar.DAY_OF_MONTH));
		
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy");
		dateEditor.getTextField().setEditable(false);
		spinner.setEditor(dateEditor);
		
		idField = new JTextField("ID",3);
		valueField = new JTextField("value field",40);
		
		clearBut = new JButton("Clear Fields");
		changeDescBut = new JButton("Change Description");
		changePickBut = new JButton("Change pickup");
		goBackBut = new JButton("go back");
		
		changeDescBut.addActionListener(lForButton);
		changePickBut.addActionListener(lForButton);
		goBackBut.addActionListener(lForButton);
		clearBut.addActionListener(lForButton);
		
		gridConstraints.gridwidth = 20;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 1;
		thePanel.add(valueField,gridConstraints);
		gridConstraints.gridwidth = 1;
		gridConstraints.gridy = 2;
		gridConstraints.gridx = 1;
		thePanel.add(idField,gridConstraints);
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 5;
		thePanel.add(changeDescBut,gridConstraints);
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 9;
		thePanel.add(clearBut,gridConstraints);
		gridConstraints.gridwidth = 1;
		gridConstraints.gridy = 3;
		gridConstraints.gridx = 1;
		thePanel.add(spinner,gridConstraints);
		gridConstraints.gridx = 5;
		thePanel.add(changePickBut,gridConstraints);
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 9;
		thePanel.add(goBackBut,gridConstraints);
		
		this.add(thePanel);
		
		this.setVisible(true);
		
		idField.requestFocus();
	}
	
	private class ListenForButton implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == goBackBut){
				dispose();
				new UnitLanding(userSession, userSessionData);
			}else if(e.getSource() == changeDescBut){
				if(idField.getText().isEmpty() || valueField.getText().isEmpty()){
					JOptionPane.showMessageDialog(UnitAlter.this, "Fields cannot be empty, Input required: ID, Description", "Error"
							, JOptionPane.ERROR_MESSAGE);
				}else{
					try{					
						int unitId = Integer.parseInt(idField.getText());
						String newDescription = valueField.getText();
						boolean check = theUnit.changeDescription(newDescription, unitId);
						if(check == true){
							JOptionPane.showMessageDialog(UnitAlter.this, "The description for Unit " + unitId + " was sucesfully updated", "Information", JOptionPane.INFORMATION_MESSAGE);
						}else{
							JOptionPane.showMessageDialog(UnitAlter.this, "There was an error connecting to the database, Please try again", "Error"
									, JOptionPane.ERROR_MESSAGE);
						}
					}catch(Exception NumberFormatException){
						JOptionPane.showMessageDialog(UnitAlter.this, "ID field must be numeric: ID", "Error"
								, JOptionPane.ERROR_MESSAGE);
					}
				}
			}else if(e.getSource() == changePickBut){
				Date todaysDate = new Date();
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Calendar cal = Calendar.getInstance();
				
				if(idField.getText().isEmpty()){
					JOptionPane.showMessageDialog(UnitAlter.this, "Field cannot be empty, Input required: ID", "Error"
							, JOptionPane.ERROR_MESSAGE);
				}else{
					try{
						String newPickupDate = dateFormat.format((spinner.getValue()));
						int unitId = Integer.parseInt(idField.getText());
						boolean check = theUnit.changePickupDate(newPickupDate, unitId);
						if(check == true){
							JOptionPane.showMessageDialog(UnitAlter.this, "The pick up date for Unit " + unitId + " was sucesfully updated", "Information", JOptionPane.INFORMATION_MESSAGE);
						}else{
							JOptionPane.showMessageDialog(UnitAlter.this, "There was an error connecting to the database, Please try again", "Error"
									, JOptionPane.ERROR_MESSAGE);
						}
					}catch(Exception NumberFormatException){
						JOptionPane.showMessageDialog(UnitAlter.this, "ID field must be numeric: ID", "Error"
								, JOptionPane.ERROR_MESSAGE);
					}	
				}
			}else if(e.getSource() == clearBut){
				idField.setText("");
				valueField.setText("");
				 JOptionPane.showMessageDialog(UnitAlter.this,"All fields have now been cleared",
						 "Solution", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}