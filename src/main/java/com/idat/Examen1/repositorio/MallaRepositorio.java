package com.idat.Examen1.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.Examen1.modelo.Malla;

@Repository
public interface MallaRepositorio extends JpaRepository<Malla, Integer>{

}
