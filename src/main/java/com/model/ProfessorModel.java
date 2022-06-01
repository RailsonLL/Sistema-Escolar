package com.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Table(name = "professor")
public class ProfessorModel implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prof_codigo")
	Integer codigo;
	@Column(name = "prof_nome", length = 50, nullable = false)
	String nome;
	@Column(name = "prof_email", length = 50, nullable = true)
	String email;
	@Column(name = "prof_fone", length = 20, nullable = true)
	String fone;
	
	@OneToMany(mappedBy = "professorModel")
	private List<CursoModel> cursoModel;

	@XmlTransient
	public List<CursoModel> getCursos(){
		return cursoModel;
	}
	
	public ProfessorModel() {
		// TODO Auto-generated constructor stub
	}
	
	public ProfessorModel(Integer codigo, String nome, String email, String fone) {
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.fone = fone;
	}

	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
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
		ProfessorModel other = (ProfessorModel) obj;
		return Objects.equals(codigo, other.codigo);
	}

		
	public void setCursoModel(List<CursoModel> cursoModel) {
		this.cursoModel = cursoModel;
	}
	
	
}
