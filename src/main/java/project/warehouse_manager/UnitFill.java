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
import javax.swing.JSpinner;
import javax.swing.JTextField;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.SpinnerDateModel;


class UnitFill extends JFrame{
	Unit theUnit = new Unit();
	JButton submitBut, goBack;
	JTextField unitIdField,descriptionField, pickUpField, customerIdField;
	JSpinner spinner;
	
	int userSession;
	String[] userSessionData = new String[5];
	
	public UnitFill(int userId, String[] userData){
		
		System.arraycopy(userData, 0, userSessionData, 0, userData.length );
		
		this.setSize(400,250);
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
		
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner, "dd/mm/yyyy");
		dateEditor.getTextField().setEditable(false);
		spinner.setEditor(dateEditor);
		
		unitIdField = new JTextField("unit Id",20);
		descriptionField = new JTextField("description",40);
		pickUpField = new JTextField("pick up date",20);
		customerIdField = new JTextField("customer id",20);
		
		submitBut = new JButton("Submit");
		goBack = new JButton("Go back");
		
		submitBut.addActionListener(lForButton);
		goBack.addActionListener(lForButton);		
		
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 1;
		thePanel.add(unitIdField,gridConstraints);
		gridConstraints.gridx = 4;
		thePanel.add(spinner,gridConstraints);
		gridConstraints.gridx = 9;
		thePanel.add(customerIdField,gridConstraints);
		gridConstraints.gridwidth = 20;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 2;
		thePanel.add(descriptionField,gridConstraints);
		gridConstraints.gridwidth = 8;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 3;
		thePanel.add(submitBut,gridConstraints);
		gridConstraints.gridx = 6;
		thePanel.add(goBack,gridConstraints);
		
		
		this.add(thePanel);
		
		this.setVisible(true);
		
		unitIdField.requestFocus();
		
	}
	
	private class ListenForButton implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == goBack){
				dispose();
				new UnitLanding(userSession, userSessionData);
			}else if(e.getSource() == submitBut){
				Date todaysDate = new Date();
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Calendar cal = Calendar.getInstance();
				
				if(unitIdField.getText().isEmpty() || customerIdField.getText().isEmpty() || descriptionField.getText().isEmpty()){
					JOptionPane.showMessageDialog(UnitFill.this,
							"Fields cannot be empty, Input required: UnitId, pick up date, customerId",
							"Error" , JOptionPane.ERROR_MESSAGE);
				}else{
					try{
						int unitId = Integer.parseInt(unitIdField.getText());
						int customerId = Integer.parseInt(customerIdField.getText());
						String pickupDate = dateFormat.format((spinner.getValue()));
						String unitDescription = descriptionField.getText();
						boolean check = theUnit.fillUnit(unitDescription, customerId, pickupDate, unitId);
						if(check == true){
							JOptionPane.showMessageDialog(UnitFill.this, "Unit " + pickupDate + " was sucesfully filled", "Information",
									JOptionPane.INFORMATION_MESSAGE);
						}else{
							JOptionPane.showMessageDialog(UnitFill.this, "Error connecting to the database, please try again later", "Error"
									, JOptionPane.ERROR_MESSAGE);
						}
									
					}catch(Exception NumberFormatException){
						JOptionPane.showMessageDialog(UnitFill.this, "Unit ID field, and Customer ID  must be numeric: Unit Id, Customer Id", "Error"
								, JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	}
}
