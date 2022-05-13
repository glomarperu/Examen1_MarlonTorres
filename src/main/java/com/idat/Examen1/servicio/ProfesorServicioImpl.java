package com.idat.Examen1.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.Examen1.dto.ProfesorDTORequest;
import com.idat.Examen1.dto.ProfesorDTOResponse;
import com.idat.Examen1.modelo.Profesor;
import com.idat.Examen1.repositorio.ProfesorRepositorio;

@Service
public class ProfesorServicioImpl implements ProfesorServicio {

	@Autowired
	public ProfesorRepositorio repositoriopro;
	
	@Override
	public void guardarProfesor(ProfesorDTORequest profesor) {

		Profesor obj = new Profesor();
		obj.setIdProfesor(profesor.getIdProfesorDTo());
		obj.setProfesor(profesor.getProfesorDTO());
		
		repositoriopro.save(obj);

	}

	@Override
	public void editarProfesor(ProfesorDTORequest profesor) {

		Profesor obj = new Profesor();
		obj.setIdProfesor(profesor.getIdProfesorDTo());
		obj.setProfesor(profesor.getProfesorDTO());
		
		repositoriopro.saveAndFlush(obj);

	}

	@Override
	public void eliminarProfesor(Integer id) {
		repositoriopro.deleteById(id);

	}

	@Override
	public List<ProfesorDTOResponse> listarProfesor() {
		List<ProfesorDTOResponse> lista = new ArrayList<ProfesorDTOResponse>();
		ProfesorDTOResponse obj = null;
		
		for(Profesor profesor : repositoriopro.findAll()) {
			obj = new ProfesorDTOResponse();
			obj.setIdProfesorDTo(profesor.getIdProfesor());
			obj.setProfesorDTO(profesor.getProfesor());
			
			lista.add(obj);
		}
		return lista;
	}

	@Override
	public ProfesorDTOResponse obtenerProfesorId(Integer id) {
		Profesor profesor = repositoriopro.findById(id).orElse(null);
		
		ProfesorDTOResponse obj = new ProfesorDTOResponse();
		obj.setIdProfesorDTo(profesor.getIdProfesor());
		obj.setProfesorDTO(profesor.getProfesor());
		return obj;
	}

}
