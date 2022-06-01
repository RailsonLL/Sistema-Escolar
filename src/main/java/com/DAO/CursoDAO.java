package com.DAO;

import java.util.List;

import com.model.CursoModel;


public interface CursoDAO {

	CursoModel salvar(CursoModel cursoModel);
	
	void alterar(CursoModel cursoModel);
	
	void excluir(CursoModel cursoModel);
	
	List<CursoModel> getCursos();
	
}
