package com.idat.Examen1.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "Malla")
@Entity
public class Malla {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMalla;
	private String año;
	
	@OneToOne(mappedBy = "malla")	
	private Universidad universidad;
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "malla_curso", 
	
	joinColumns = @JoinColumn(name = "id_curso",
	nullable = false, unique = true, foreignKey = @ForeignKey(foreignKeyDefinition = 
	"foreign key(id_curso) references curso (id_curso)")),
	
	inverseJoinColumns = @JoinColumn(name = "id_malla",
	nullable = false, unique = true, foreignKey = @ForeignKey(foreignKeyDefinition = 
	"foreign key(id_malla) references malla (id_malla)")))
	List<Curso> curso;
	
	public Integer getIdMalla() {
		return idMalla;
	}
	public void setIdMalla(Integer idMalla) {
		this.idMalla = idMalla;
	}
	public String getAño() {
		return año;
	}
	public void setAño(String año) {
		this.año = año;
	}
	
	
	

}
