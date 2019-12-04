package app.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import app.exception.SistemaException;
import app.models.Usuario;

public class UsuarioBD implements UsuarioDAO {

	@Override
	public Usuario logar(String email, String senha) throws SistemaException {
		Usuario usuario = null;

		try {
			PreparedStatement preparedStatement = Conexao.getInstance().conectar()
					.prepareStatement("SELECT id, nome, email FROM usuario WHERE email = ? AND senha = ?;");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, senha);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				usuario = new Usuario();
				usuario.setId(resultSet.getLong("id"));
				usuario.setNome(resultSet.getString("nome"));
				usuario.setEmail(resultSet.getString("email"));
			}
			resultSet.close();
			preparedStatement.close();

			Conexao.getInstance().desconectar();

			if (usuario == null) {
				throw new SistemaException("Usuário não encontrado!");
			} else {
				return usuario;
			}

		} catch (Exception e) {
			throw new SistemaException(e.getMessage());
		}
	}
}