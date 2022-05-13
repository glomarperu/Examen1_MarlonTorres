package com.idat.Examen1.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.idat.Examen1.dto.CursoDTORequest;
import com.idat.Examen1.dto.CursoDTOResponse;
import com.idat.Examen1.modelo.Curso;
import com.idat.Examen1.repositorio.CursoRepositorio;

@Service
public class CursoServicioImpl implements CursoServicio {

	@Autowired
	public CursoRepositorio repositoriocur;
	
	@Override
	public void guardarCurso(CursoDTORequest curso) {
		Curso obj = new Curso();
		obj.setIdCurso(curso.getIdCursoDTO());
		obj.setCurso(curso.getCursoDTO());
		obj.setDescripcion(curso.getDescripcionDTO());
		
		repositoriocur.save(obj);

	}

	@Override
	public void editarCurso(CursoDTORequest curso) {
		Curso obj = new Curso();
		obj.setIdCurso(curso.getIdCursoDTO());
		obj.setCurso(curso.getCursoDTO());
		obj.setDescripcion(curso.getDescripcionDTO());
		
		repositoriocur.saveAndFlush(obj);

	}

	@Override
	public void eliminarCurso(Integer id) {
		repositoriocur.deleteById(id);

	}

	@Override
	public List<CursoDTOResponse> listarCurso() {
		List<CursoDTOResponse> listacur = new ArrayList<CursoDTOResponse>();
		CursoDTOResponse obj = null;
		for(Curso curso : repositoriocur.findAll()) {
			obj = new CursoDTOResponse();
			obj.setIdCursoDTO(curso.getIdCurso());
			obj.setCursoDTO(curso.getCurso());
			obj.setDescripcionDTO(curso.getDescripcion());
			
			listacur.add(obj);
		}
		return listacur;
	}

	@Override
	public CursoDTOResponse obtenerCursoId(Integer id) {

		Curso curso = repositoriocur.findById(id).orElse(null);
		CursoDTOResponse obj = new CursoDTOResponse();
		obj.setIdCursoDTO(curso.getIdCurso());
		obj.setCursoDTO(curso.getCurso());
		obj.setDescripcionDTO(curso.getDescripcion());
		return obj;
	}

}
