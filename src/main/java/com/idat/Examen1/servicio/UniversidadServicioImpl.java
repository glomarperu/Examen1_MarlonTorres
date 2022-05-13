package com.idat.Examen1.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.Examen1.dto.UniversidadDTORequest;
import com.idat.Examen1.dto.UniversidadDTOResponse;
import com.idat.Examen1.modelo.Universidad;
import com.idat.Examen1.repositorio.UniversidadRepositorio;

@Service
public class UniversidadServicioImpl implements UniversidadServicio {

	@Autowired
	public UniversidadRepositorio repositoriouni;
	
	@Override
	public void guardarUniversidad(UniversidadDTORequest universidad) {

		Universidad obj = new Universidad();
		obj.setIdUniversidad(universidad.getIdUniversidadDTO());
		obj.setUniversidad(universidad.getUniversidadDTO());
		
		repositoriouni.save(obj);

	}

	@Override
	public void editarUniversidad(UniversidadDTORequest universidad) {

		Universidad obj = new Universidad();
		obj.setIdUniversidad(universidad.getIdUniversidadDTO());
		obj.setUniversidad(universidad.getUniversidadDTO());
		
		repositoriouni.saveAndFlush(obj);

	}

	@Override
	public void eliminarUniversidad(Integer id) {
		repositoriouni.deleteById(id);

	}

	@Override
	public List<UniversidadDTOResponse> listarUniversidad() {

		List<UniversidadDTOResponse> lista = new ArrayList<UniversidadDTOResponse>();
		UniversidadDTOResponse obj = null;
		
		for(Universidad uni : repositoriouni.findAll()) {
			obj = new UniversidadDTOResponse();
			obj.setIdUniversidadDTO(uni.getIdUniversidad());
			obj.setUniversidadDTO(uni.getUniversidad());
			
			lista.add(obj);
		}
		return lista;
	}

	@Override
	public UniversidadDTOResponse obtenerUniversidadId(Integer id) {
		
		Universidad uni = repositoriouni.findById(id).orElse(null);
		
		UniversidadDTOResponse obj = new UniversidadDTOResponse();
		obj.setIdUniversidadDTO(uni.getIdUniversidad());
		obj.setUniversidadDTO(uni.getUniversidad());
		return obj;
	}

}
