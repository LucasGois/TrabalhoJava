package app.dao;

import java.util.List;

import app.exception.SistemaException;
import app.models.TodasAtividadesModel;

public interface ViewDAO {

	public List<TodasAtividadesModel> vw_atividades_disciplina() throws SistemaException;
}
