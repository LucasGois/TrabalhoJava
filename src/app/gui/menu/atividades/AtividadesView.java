package app.gui.menu.atividades;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JDialog;
import javax.swing.JTable;

import app.dao.AtividadesBD;
import app.exception.SistemaException;
import app.models.AtividadesTableModel;

public class AtividadesView extends JDialog {
	private JTable table;
	private AtividadesTableModel listaAtividades;

	/**
	 * Create the dialog.
	 */
	public AtividadesView() {
		setBounds(100, 100, 450, 300);
		setModal(true);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		try {
			listaAtividades = new AtividadesTableModel(new AtividadesBD().getList());
			
		} catch (SistemaException e) {
			e.printStackTrace();
		}

		table = new JTable();
		table.setModel(listaAtividades);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		getContentPane().add(table, gbc_table);

	}
}