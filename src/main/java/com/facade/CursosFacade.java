package com.facade;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.DAO.CursoDAOImpl;
import com.model.CursoModel;

@Path("/cursos")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class CursosFacade {

	@Inject
	private CursoDAOImpl cursoDAOImpl;
		
	@GET
	public List<CursoModel> getCursos(){
		return cursoDAOImpl.getCursos();
	}
	
	@POST
	public CursoModel salvar(CursoModel cursoModel) {
		return cursoDAOImpl.salvar(cursoModel);
	}
	
	@PUT
	public void atualizar(CursoModel cursoModel) {
		cursoDAOImpl.alterar(cursoModel);
	}
	
	@DELETE
	@Path("/{codigoCurso}")
	public void excluir(@PathParam("codigoCurso") Integer codigoCurso) {
		CursoModel cursoModel = new CursoModel();
		cursoModel.setCodigo(codigoCurso);
		cursoDAOImpl.excluir(cursoModel);
	}
	
}
