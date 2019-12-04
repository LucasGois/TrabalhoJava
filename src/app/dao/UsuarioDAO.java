package app.dao;

import app.exception.SistemaException;
import app.models.Usuario;

public interface UsuarioDAO {

	public abstract Usuario logar(String email, String senha) throws SistemaException;
}