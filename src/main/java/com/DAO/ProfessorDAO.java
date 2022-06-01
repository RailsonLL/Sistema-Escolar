package com.DAO;

import java.util.List;

import com.model.ProfessorModel;


public interface ProfessorDAO {

	ProfessorModel salvar(ProfessorModel professorModel);
	
	void alterar(ProfessorModel professorModel);
	
	void excluir(ProfessorModel professorModel);
	
	List<ProfessorModel> getProfessores();
	
}
