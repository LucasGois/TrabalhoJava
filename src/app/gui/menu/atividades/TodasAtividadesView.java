package app.gui.menu.atividades;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;

import app.dao.ViewBD;
import app.exception.SistemaException;
import app.models.TodasAtividadesTableModel;

public class TodasAtividadesView extends JDialog {
	private TodasAtividadesTableModel todasAtividadesTableModel;
	private JTable table;

	public TodasAtividadesView() {
		try {
			todasAtividadesTableModel = new TodasAtividadesTableModel(new ViewBD().vw_atividades_disciplina());

		} catch (SistemaException e) {
			e.printStackTrace();
		}

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setBounds(0, 0, 600, 400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 564, 340);
		getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		table = new JTable();
		table.setModel(todasAtividadesTableModel);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridwidth = 4;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		panel.add(table, gbc_table);

		JButton btnAdicionar = new JButton("Adicionar");
		GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
		gbc_btnAdicionar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdicionar.gridx = 0;
		gbc_btnAdicionar.gridy = 1;
		panel.add(btnAdicionar, gbc_btnAdicionar);

		JButton btnAlterar = new JButton("Alterar");
		GridBagConstraints gbc_btnAlterar = new GridBagConstraints();
		gbc_btnAlterar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAlterar.gridx = 1;
		gbc_btnAlterar.gridy = 1;
		panel.add(btnAlterar, gbc_btnAlterar);

		JButton btnExcluir = new JButton("Excluir");
		GridBagConstraints gbc_btnExcluir = new GridBagConstraints();
		gbc_btnExcluir.insets = new Insets(0, 0, 0, 5);
		gbc_btnExcluir.gridx = 2;
		gbc_btnExcluir.gridy = 1;
		panel.add(btnExcluir, gbc_btnExcluir);

		JButton btnSair = new JButton("Sair");
		GridBagConstraints gbc_btnSair = new GridBagConstraints();
		gbc_btnSair.anchor = GridBagConstraints.EAST;
		gbc_btnSair.gridx = 3;
		gbc_btnSair.gridy = 1;
		panel.add(btnSair, gbc_btnSair);
	}
}