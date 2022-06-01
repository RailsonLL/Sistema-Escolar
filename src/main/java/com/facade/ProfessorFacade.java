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

import com.DAO.ProfessorDAOImpl;
import com.model.ProfessorModel;

@Path("/professores")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class ProfessorFacade {

	@Inject
	private ProfessorDAOImpl professorDAOImpl;
		
	@GET
	public List<ProfessorModel> getProfessores(){
		return professorDAOImpl.getProfessores();
	}
	
	@POST
	public ProfessorModel salvar(ProfessorModel professorModel) {
		return professorDAOImpl.salvar(professorModel);
	}
	
	@PUT
	public void atualizar(ProfessorModel professorModel) {
		professorDAOImpl.alterar(professorModel);
	}
	
	@DELETE
	@Path("/{codigoProfessor}")
	public void excluir(@PathParam("codigoProfessor") Integer codigoProfessor) {
		ProfessorModel professorModel = new ProfessorModel();
		professorModel.setCodigo(codigoProfessor);
		professorDAOImpl.excluir(professorModel);
	}
	
}
