package com.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "curso")
public class CursoModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cur_codigo")
	Integer codigo;
	@Column(name = "cur_descricao", length = 50, nullable = false)
	String descricao;
	@Column(name = "cur_horarios", length = 50, nullable = true)
	String horarios;
	@ManyToOne
	@JoinColumn(name = "prof_codigo", referencedColumnName = "prof_codigo")
	ProfessorModel professorModel;
	
	public CursoModel() {
		// TODO Auto-generated constructor stub
	}

	public CursoModel(Integer codigo, String descricao, String horarios, ProfessorModel professorModel) {
		
		this.codigo = codigo;
		this.descricao = descricao;
		this.horarios = horarios;
		this.professorModel = professorModel;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getHorarios() {
		return horarios;
	}

	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}

	public ProfessorModel getProfessorModel() {
		return professorModel;
	}

	public void setProfessorModel(ProfessorModel professorModel) {
		this.professorModel = professorModel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CursoModel other = (CursoModel) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	
	
	
}
