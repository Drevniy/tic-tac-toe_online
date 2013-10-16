package ttt;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

public class PanelGame extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelGame() {
		
		JLabel lblYourName = new JLabel("your name:");
		lblYourName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblOpponentName = new JLabel("opponent name:");
		lblOpponentName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblTimeControl = new JLabel("            ");
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		
		JButton btnLeaveTheGame = new JButton("leave the game");
		btnLeaveTheGame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblYourName, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
							.addComponent(lblTimeControl)
							.addGap(66)
							.addComponent(lblOpponentName, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(90)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(141)
							.addComponent(btnLeaveTheGame)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblOpponentName, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
							.addComponent(lblTimeControl, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblYourName, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnLeaveTheGame, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		panel.setLayout(new GridLayout(3, 3, 0, 0));
		
		JLabel lbl1x1 = new JLabel("X");
		lbl1x1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1x1.setFont(new Font("Tahoma", Font.PLAIN, 99));
		panel.add(lbl1x1);
		
		JLabel lbl1x2 = new JLabel("O");
		lbl1x2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1x2.setFont(new Font("Tahoma", Font.PLAIN, 99));
		panel.add(lbl1x2);
		
		JLabel lbl1x3 = new JLabel("X");
		lbl1x3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1x3.setFont(new Font("Tahoma", Font.PLAIN, 99));
		panel.add(lbl1x3);
		
		JLabel lbl2x1 = new JLabel("O");
		lbl2x1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2x1.setFont(new Font("Tahoma", Font.PLAIN, 99));
		panel.add(lbl2x1);
		
		JLabel lbl2x2 = new JLabel("X");
		lbl2x2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2x2.setFont(new Font("Tahoma", Font.PLAIN, 99));
		panel.add(lbl2x2);
		
		JLabel lbl2x3 = new JLabel("O");
		lbl2x3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2x3.setFont(new Font("Tahoma", Font.PLAIN, 99));
		panel.add(lbl2x3);
		
		JLabel lbl3x1 = new JLabel("X");
		lbl3x1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3x1.setFont(new Font("Tahoma", Font.PLAIN, 99));
		panel.add(lbl3x1);
		
		JLabel lbl3x2 = new JLabel("O");
		lbl3x2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3x2.setFont(new Font("Tahoma", Font.PLAIN, 99));
		panel.add(lbl3x2);
		
		JLabel lbl3x3 = new JLabel("X");
		lbl3x3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3x3.setFont(new Font("Tahoma", Font.PLAIN, 99));
		panel.add(lbl3x3);
		setLayout(groupLayout);

	}
}
