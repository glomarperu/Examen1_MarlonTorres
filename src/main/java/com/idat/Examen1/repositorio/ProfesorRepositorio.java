package com.idat.Examen1.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.Examen1.modelo.Profesor;

@Repository
public interface ProfesorRepositorio extends JpaRepository<Profesor, Integer>{

}
