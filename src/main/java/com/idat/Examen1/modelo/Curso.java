package com.idat.Examen1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name = "Curso")
@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer idCurso;	
	private String curso;
	private String descripcion;
	
	@ManyToMany(mappedBy = "curso", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Malla> malla = new ArrayList<Malla>();
	
	@OneToMany(mappedBy = "curso")
	private List<Profesor> profesor = new ArrayList<Profesor>();
	
	public Integer getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
