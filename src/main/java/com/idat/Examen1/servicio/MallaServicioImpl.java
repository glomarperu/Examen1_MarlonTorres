package com.idat.Examen1.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.Examen1.dto.MallaDTORequest;
import com.idat.Examen1.dto.MallaDTOResponse;
import com.idat.Examen1.modelo.Malla;
import com.idat.Examen1.repositorio.MallaRepositorio;

@Service
public class MallaServicioImpl implements MallaServicio {

	@Autowired
	public MallaRepositorio repositoriomalla;
	
	@Override
	public void guardarMalla(MallaDTORequest malla) {
		
		Malla obj = new Malla();
		obj.setIdMalla(malla.getIdMallaDTO());
		obj.setAño(malla.getAñoDTO());
		
		repositoriomalla.save(obj);

	}

	@Override
	public void editarMalla(MallaDTORequest malla) {

		Malla obj = new Malla();
		obj.setIdMalla(malla.getIdMallaDTO());
		obj.setAño(malla.getAñoDTO());
		
		repositoriomalla.saveAndFlush(obj);

	}

	@Override
	public void eliminarMalla(Integer id) {
		
		repositoriomalla.deleteById(id);

	}

	@Override
	public List<MallaDTOResponse> listarMalla() {

		List<MallaDTOResponse> lista = new ArrayList<MallaDTOResponse>();
		MallaDTOResponse obj = null;
		
		for(Malla malla : repositoriomalla.findAll()) {
			obj = new MallaDTOResponse();
			obj.setIdMallaDTO(malla.getIdMalla());
			obj.setAñoDTO(malla.getAño());
			
			lista.add(obj);
		}
		return lista;
	}

	@Override
	public MallaDTOResponse obtenerMallaId(Integer id) {

		Malla malla = repositoriomalla.findById(id).orElse(null);
		
		MallaDTOResponse obj = new MallaDTOResponse();
		obj.setIdMallaDTO(malla.getIdMalla());
		obj.setAñoDTO(malla.getAño());
		return obj;
	}

}
