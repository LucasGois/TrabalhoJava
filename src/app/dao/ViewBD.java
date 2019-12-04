package app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.exception.SistemaException;
import app.models.TodasAtividadesModel;

public class ViewBD implements ViewDAO {

	@Override
	public List<TodasAtividadesModel> vw_atividades_disciplina() throws SistemaException {
		List<TodasAtividadesModel> lista = new ArrayList<TodasAtividadesModel>();

		try {
			Statement statement = Conexao.getInstance().conectar().createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM vw_atividades_disciplina");

			while (resultSet.next()) {
				TodasAtividadesModel atividadesModel = new TodasAtividadesModel();
				atividadesModel.setDisciplina(resultSet.getString("disciplina"));
				atividadesModel.setAtividade(resultSet.getString("atividade"));
				atividadesModel.setData(resultSet.getString("data"));
				atividadesModel.setTipo(resultSet.getString("tipo"));
				lista.add(atividadesModel);
			}
			resultSet.close();
			statement.close();

			Conexao.getInstance().desconectar();

		} catch (SQLException e) {
			throw new SistemaException(e.getMessage());
		}
		return lista;
	}
}
