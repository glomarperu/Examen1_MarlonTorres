package com.idat.Examen1.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.idat.Examen1.dto.CursoDTORequest;
import com.idat.Examen1.dto.CursoDTOResponse;
import com.idat.Examen1.servicio.CursoServicio;

@RestController
@RequestMapping("/curso/v1")
public class CursoControlador {
	
	@Autowired
	public CursoServicio serviciocur;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<CursoDTOResponse>> listarCurso(){
		return new ResponseEntity<List<CursoDTOResponse>>(serviciocur.listarCurso(), HttpStatus.CREATED); 
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar (@RequestBody CursoDTORequest curso){
		serviciocur.guardarCurso(curso);;
		return new ResponseEntity<Void> (HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<CursoDTOResponse> listarCursoId(@PathVariable Integer id) {
		CursoDTOResponse p = serviciocur.obtenerCursoId(id);
		if(p != null)
			return new ResponseEntity<CursoDTOResponse>(p, HttpStatus.OK);
					
		return new ResponseEntity<CursoDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody CursoDTORequest curso){
		
		CursoDTOResponse p = serviciocur.obtenerCursoId(curso.getIdCursoDTO());
		if(p != null) {
			serviciocur.editarCurso(curso);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}			
					
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		CursoDTOResponse p = serviciocur.obtenerCursoId(id);
		if(p != null) {
			serviciocur.eliminarCurso(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}			
					
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
}
