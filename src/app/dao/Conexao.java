package app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import app.exception.SistemaException;

public class Conexao {
	private static Conexao instance;

	private Connection connection;

	private final String DATABASE = "trabalho";
	private final String IP = "127.0.0.1";
	private final String URL = "jdbc:mysql://" + IP + ":3306/" + DATABASE;
	private final String USER = "root";
	private final String PASSWORD = "";

	public synchronized static Conexao getInstance() {
		return instance == null ? new Conexao() : instance;
	}

	public Connection conectar() throws SistemaException {

		try {
			connection = DriverManager.getConnection(URL, USER, PASSWORD);

		} catch (SQLException e) {
			throw new SistemaException(e.getMessage());
		}
		return connection;
	}

	public void desconectar() throws SistemaException {

		try {

			if (connection != null && connection.isClosed() == false) {
				connection.close();
			}

		} catch (SQLException e) {
			throw new SistemaException(e.getMessage());
		}
	}
}