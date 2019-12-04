package app.gui.menu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.gui.menu.atividades.AtividadesView;
import app.gui.menu.atividades.TodasAtividadesView;

public class MenuView extends JFrame {

	private JPanel contentPane;

	public MenuView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JButton btn_atividades = new JButton("Minhas Atividades");
		btn_atividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AtividadesView().setVisible(true);
			}
		});
		GridBagConstraints gbc_btn_atividades = new GridBagConstraints();
		gbc_btn_atividades.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_atividades.insets = new Insets(0, 0, 5, 5);
		gbc_btn_atividades.gridx = 0;
		gbc_btn_atividades.gridy = 0;
		contentPane.add(btn_atividades, gbc_btn_atividades);

		JButton btn_todas_atividades = new JButton("Todas Atividades");
		btn_todas_atividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TodasAtividadesView().setVisible(true);
			}
		});
		GridBagConstraints gbc_btn_todas_atividades = new GridBagConstraints();
		gbc_btn_todas_atividades.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_todas_atividades.insets = new Insets(0, 0, 0, 5);
		gbc_btn_todas_atividades.gridx = 0;
		gbc_btn_todas_atividades.gridy = 1;
		
		contentPane.add(btn_todas_atividades, gbc_btn_todas_atividades);
	}
}