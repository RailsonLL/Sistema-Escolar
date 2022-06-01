package com.DAO;

import java.util.List;

import javax.persistence.Query;

import com.model.ProfessorModel;
import com.transaction.TransactionCRUD;

public class ProfessorDAOImpl extends TransactionCRUD<ProfessorModel> implements ProfessorDAO{

	//@PersistenceContext(unitName = "sistemaescolarPU")
	//private EntityManager entityManager;
		
	@Override
	public ProfessorModel salvar(ProfessorModel professorModel) {
		return salvarDados(professorModel);
	}

	@Override
	public void alterar(ProfessorModel professorModel) {
		alterarDados(professorModel);
	}

	@Override
	public void excluir(ProfessorModel professorModel) {
		excluirDados(professorModel);
	}

	@Override
	public List<ProfessorModel> getProfessores() {
		Query query = entityManager.createQuery("from ProfessorModel");
		return query.getResultList();
	}

}
