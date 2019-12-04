package app.dao;

import java.util.List;

import app.exception.SistemaException;
import app.models.Atividades;

public interface AtividadesDAO {

	public abstract List<Atividades> getList() throws SistemaException;
}