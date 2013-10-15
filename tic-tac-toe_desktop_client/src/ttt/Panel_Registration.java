package ttt;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Panel_Registration extends JPanel
{
	public Panel_Registration()
	{
		JLabel labelRegistration = new JLabel("Registration");
		labelRegistration.setFont(new Font("Serif", Font.PLAIN, 40));
		
		JPanel panel = new JPanel(new GridLayout(3, 2));
		panel.setPreferredSize(new Dimension(440,150));
		
		JLabel labelUserName = new JLabel("UserName:");
		labelUserName.setHorizontalAlignment(JLabel.CENTER);
		JLabel labelEmail    = new JLabel("Email:");
		labelEmail.setHorizontalAlignment(JLabel.CENTER);
		JLabel labelPassword = new JLabel("Password:");
		labelPassword.setHorizontalAlignment(JLabel.CENTER);
		
		JTextField textUserName = new JTextField();
		textUserName.setPreferredSize(new Dimension(50,80));
		JTextField textEmail    = new JTextField();
		JTextField textPassword = new JTextField();
		
		panel.add(labelUserName);
		panel.add(textUserName);
		panel.add(labelEmail);
		panel.add(textEmail);
		panel.add(labelPassword);
		panel.add(textPassword);
		
		add(labelRegistration,BorderLayout.NORTH);
		add(panel,BorderLayout.CENTER);
		
	}
}
