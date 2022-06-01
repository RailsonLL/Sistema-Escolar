package com.DAO;

import java.util.List;

import javax.persistence.Query;

import com.model.CursoModel;
import com.transaction.TransactionCRUD;

public class CursoDAOImpl extends TransactionCRUD<CursoModel> implements CursoDAO{

	//@PersistenceContext(unitName = "sistemaescolarPU")
	//private EntityManager entityManager;
		
	@Override
	public CursoModel salvar(CursoModel cursoModel) {
		return salvarDados(cursoModel);
	}

	@Override
	public void alterar(CursoModel cursoModel) {
		alterarDados(cursoModel);
	}

	@Override
	public void excluir(CursoModel cursoModel) {
		excluirDados(cursoModel);
	}

	@Override
	public List<CursoModel> getCursos() {
		Query query = entityManager.createQuery("from CursoModel");
		return query.getResultList();
	}

}
