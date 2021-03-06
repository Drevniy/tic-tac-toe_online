package ttt;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import data_transfer.Security_Registration;

public class PanelRegistration extends JPanel {
	private JTextField textUserName;
	private JTextField textEmail;
	private JTextField textPassword;
	
	BaseFrame parentFrame;
	
	public PanelRegistration() {
		
		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		JLabel lblUserName = new JLabel("UserName:");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textUserName = new JTextField();
		textUserName.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		
		textPassword = new JTextField();
		textPassword.setColumns(10);
		
		JButton btnCreateAccount = new JButton("Create account");
		btnCreateAccount.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCreateAccount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parentFrame = (BaseFrame)PanelRegistration.this.getParent().getParent().getParent().getParent();
				
				Security_Registration registration = new Security_Registration();
				registration.setUserName(textUserName.getText());
				registration.setEmail(textEmail.getText());
				registration.setPassword(textPassword.getText());
				
				try {
					if(Security.registration(registration)){

						JOptionPane.showMessageDialog(parentFrame,
							    "Registration was successful. Please log in");
						CardLayout cards = (CardLayout) parentFrame.getContentPane().getLayout();
						cards.show(parentFrame.getContentPane(), BaseFrame.stringAuthorization);
					}else{
						JOptionPane.showMessageDialog(parentFrame,
							    "Registration failed. Try again");
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parentFrame = (BaseFrame)PanelRegistration.this.getParent().getParent().getParent().getParent();
				parentFrame.dispose();
				System.exit(0);
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(81)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUserName, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addPreferredGap(ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(textPassword, Alignment.LEADING, 141, 141, Short.MAX_VALUE)
						.addComponent(textUserName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
						.addComponent(textEmail, Alignment.LEADING))
					.addGap(68))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(110)
					.addComponent(lblRegistration)
					.addContainerGap(131, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(130, Short.MAX_VALUE)
					.addComponent(btnCreateAccount, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
					.addGap(125))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(162)
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(174, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(52, Short.MAX_VALUE)
					.addComponent(lblRegistration)
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblUserName, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblEmail)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblPassword))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textUserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(btnCreateAccount, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addGap(67)
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
}
