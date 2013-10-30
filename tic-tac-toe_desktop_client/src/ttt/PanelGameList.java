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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class PanelGameList extends JPanel {
	BaseFrame parentFrame;
	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public PanelGameList() {
		JLabel lblChooseGame = new JLabel("Choose game:");
		lblChooseGame.setFont(new Font("Dialog", Font.PLAIN, 34));
		lblChooseGame.setHorizontalAlignment(SwingConstants.LEFT);
		
		JTable table = new JTable();
		TableModel_GameList tableModel = new TableModel_GameList(BaseFrame.getSocketConnect(),table);
		table.setModel(tableModel);
		JScrollPane scrollPane = new JScrollPane(table);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parentFrame = (BaseFrame)PanelGameList.this.getParent().getParent().getParent().getParent();
				CardLayout cards = (CardLayout) parentFrame.getContentPane().getLayout();
				cards.show(parentFrame.getContentPane(), BaseFrame.stringPlayersOnline);
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
								.addComponent(lblChooseGame)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(162)
							.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblChooseGame, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
