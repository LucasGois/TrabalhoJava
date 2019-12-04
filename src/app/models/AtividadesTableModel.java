package app.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class AtividadesTableModel extends AbstractTableModel {

	private final List<Atividades> lista;

	public AtividadesTableModel() {
		lista = new ArrayList<>();
	}

	public AtividadesTableModel(List<Atividades> lista) {
		this.lista = lista;
	}

	public void add(Atividades atividades) {
		lista.add(atividades);
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return lista.get(rowIndex).getId();
		case 1:
			return lista.get(rowIndex).getDescricao();
		default:
			return lista.get(rowIndex).getId();
		}
	}
}
