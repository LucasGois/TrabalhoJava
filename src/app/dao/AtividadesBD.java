package app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.exception.SistemaException;
import app.models.Atividades;

public class AtividadesBD implements AtividadesDAO {

	@Override
	public List<Atividades> getList() throws SistemaException {
		List<Atividades> list = new ArrayList<Atividades>();

		try {
			Statement statement = Conexao.getInstance().conectar().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM atividade;");

			while (resultSet.next()) {
				Atividades atividades = new Atividades();

				atividades.setId(resultSet.getLong(1));
				atividades.setDescricao(resultSet.getString(2));

				list.add(atividades);
			}
			resultSet.close();
			statement.close();
			Conexao.getInstance().desconectar();

			return list;

		} catch (SQLException e) {
			throw new SistemaException(e.getMessage());
		}
	}
}
