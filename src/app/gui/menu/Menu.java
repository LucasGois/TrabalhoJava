package app.gui.menu;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import app.gui.menu.atividades.AtividadesView;
import java.awt.Insets;

public class Menu extends JFrame {

	private JPanel contentPane;

	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JButton btnAtividades = new JButton("Atividades");
		btnAtividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AtividadesView().setVisible(true);
			}
		});
		GridBagConstraints gbc_btnAtividades = new GridBagConstraints();
		gbc_btnAtividades.insets = new Insets(0, 0, 0, 5);
		gbc_btnAtividades.gridx = 0;
		gbc_btnAtividades.gridy = 0;
		contentPane.add(btnAtividades, gbc_btnAtividades);

		JButton btnUsuario = new JButton("Usuario");
		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "EXEMPLO");
			}
		});
		GridBagConstraints gbc_btnUsuario = new GridBagConstraints();
		gbc_btnUsuario.gridx = 1;
		gbc_btnUsuario.gridy = 0;
		contentPane.add(btnUsuario, gbc_btnUsuario);
	}
}