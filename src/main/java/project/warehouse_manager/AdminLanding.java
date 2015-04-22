package project.warehouse_manager;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

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

public class AdminLanding extends JFrame{

	JButton goBackBut, purgeSmallBut, runQueue;
	
	int userSession;
	String[] userSessionData = new String[5];
	
	public AdminLanding(int userId, String[] userData){
		
		System.arraycopy(userData, 0, userSessionData, 0, userData.length );
		
		userSession = userId;
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Admin Page");
		
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
		
		goBackBut = new JButton("Go Back");
		goBackBut.setToolTipText("sends you back to the previous screen");
		purgeSmallBut = new JButton("Purge Small warehouse");
		purgeSmallBut.setToolTipText("Will purge all items from the small warehouse");
		runQueue = new JButton("Run Queue");
		runQueue.setToolTipText("Will run the queue algorithm to decide which item will go next to the small warehouse");
		
		goBackBut.addActionListener(lForButton);
		purgeSmallBut.addActionListener(lForButton);
		runQueue.addActionListener(lForButton);
		
		gridConstraints.gridwidth = 20;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 1;
		thePanel.add(goBackBut, gridConstraints);
		gridConstraints.gridwidth = 20;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 2;
		thePanel.add(purgeSmallBut, gridConstraints);
		gridConstraints.gridwidth = 20;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 3;
		thePanel.add(runQueue, gridConstraints);
		
		
		this.add(thePanel);
		
		this.setVisible(true);		
		
	}
	
	private class ListenForButton implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == goBackBut){
				dispose();
				new LoggedInFrame(userSession, userSessionData);
			}else if(e.getSource() == purgeSmallBut){
					
			}else if(e.getSource() == runQueue){
					
				
			}
		}
	}
}
