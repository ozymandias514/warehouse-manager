package project.warehouse_manager;

import javax.swing.*;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UnitLanding extends JFrame{

	JButton byIdBut, byCustomerBut, getDataBut, 
	vacantSmallBut, vacantLargeBut, alterBut, 
			removeBut, fillBut, goBackBut;
	
	JTextField textResult;
	
	JTextArea textArea1;
	
	int userSession;
	
	public UnitLanding(int userId){
		
		userSession=userId;
		
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
		
		textResult = new JTextField("",20);
		textArea1 = new JTextArea(15,20);
		textArea1.setLineWrap(true);
		textArea1.setWrapStyleWord(true);
		JScrollPane scrollbar1 = new JScrollPane(textArea1, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		Font font = new Font("Helvetica", Font.PLAIN, 18);
		
		ListenForButton lForButton = new ListenForButton();
		
		byIdBut = new JButton("Find by unit Id");
		byCustomerBut = new JButton("Find By customer id");
		getDataBut = new JButton("get data");
		
		vacantSmallBut = new JButton("find small vacant");
		vacantSmallBut.setToolTipText("Find empty units in the small warehouse");
		
		vacantLargeBut = new JButton("find large vacant");
		alterBut = new JButton("alter");
		removeBut = new JButton("remove");
		fillBut = new JButton("fill");
		goBackBut = new JButton("go back");
		
		byIdBut.addActionListener(lForButton);
		byCustomerBut.addActionListener(lForButton);
		getDataBut.addActionListener(lForButton);
		vacantSmallBut.addActionListener(lForButton);
		vacantLargeBut.addActionListener(lForButton);
		fillBut.addActionListener(lForButton);
		alterBut.addActionListener(lForButton);
		removeBut.addActionListener(lForButton);
		
		goBackBut.addActionListener(lForButton);
		
		//thePanel.add(clearAll, gridConstraints);
		gridConstraints.gridwidth = 20;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 1;
		thePanel.add(textResult, gridConstraints);
		gridConstraints.gridwidth = 1;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 2;
		thePanel.add(byIdBut,gridConstraints);
		gridConstraints.gridx = 5;
		thePanel.add(byCustomerBut,gridConstraints);
		gridConstraints.gridx = 9;
		thePanel.add(getDataBut,gridConstraints);
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 3;
		thePanel.add(vacantSmallBut,gridConstraints);
		gridConstraints.gridx = 5;
		thePanel.add(vacantLargeBut,gridConstraints);
		gridConstraints.gridx = 9;
		thePanel.add(alterBut,gridConstraints);
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 4;
		thePanel.add(removeBut,gridConstraints);
		gridConstraints.gridwidth = 10;
		gridConstraints.gridx = 5;
		thePanel.add(fillBut,gridConstraints);
		gridConstraints.gridwidth = 20;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 5;
		thePanel.add(scrollbar1,gridConstraints);
		gridConstraints.gridwidth = 20;
		gridConstraints.gridx = 1;
		gridConstraints.gridy = 6;
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
			}else if(e.getSource() == fillBut){
				dispose();
				new UnitFill(userSession);
			}else if(e.getSource() == alterBut){
				dispose();
				new UnitAlter(userSession);
			}
		}
	}
}

