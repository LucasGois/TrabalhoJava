package app.models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TodasAtividadesTableModel extends AbstractTableModel {

	private final List<TodasAtividadesModel> lista;

	public TodasAtividadesTableModel() {
		lista = new ArrayList<>();
	}

	public TodasAtividadesTableModel(List<TodasAtividadesModel> lista) {
		this.lista = lista;
	}

	public void add(TodasAtividadesModel atividades) {
		lista.add(atividades);
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return lista.get(rowIndex).getDisciplina();
		case 1:
			return lista.get(rowIndex).getAtividade();
		case 2:
			return lista.get(rowIndex).getData();
		case 3:
			return lista.get(rowIndex).getTipo();
		default:
			throw new RuntimeException("Não deve passar aqui");
		}
	}
}
