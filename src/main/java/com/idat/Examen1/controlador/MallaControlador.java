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

import com.idat.Examen1.dto.MallaDTORequest;
import com.idat.Examen1.dto.MallaDTOResponse;
import com.idat.Examen1.servicio.MallaServicio;

@RestController
@RequestMapping("/malla/v1")
public class MallaControlador {

	@Autowired
	private MallaServicio servicio;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<MallaDTOResponse>> listarMalla(){
		return new ResponseEntity<List<MallaDTOResponse>>(servicio.listarMalla(), HttpStatus.CREATED);
	}

	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody MallaDTORequest malla){
		
		servicio.guardarMalla(malla);
		return new ResponseEntity<Void> (HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<MallaDTOResponse> listarPorId(@PathVariable Integer id) {
		MallaDTOResponse p = servicio.obtenerMallaId(id);
		if(p != null)
			return new ResponseEntity<MallaDTOResponse>(p, HttpStatus.OK);
					
		return new ResponseEntity<MallaDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody MallaDTORequest malla){
		
		MallaDTOResponse p = servicio.obtenerMallaId(malla.getIdMallaDTO());
		if(p != null) {
			servicio.editarMalla(malla);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}			
					
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		MallaDTOResponse p = servicio.obtenerMallaId(id);
		if(p != null) {
			servicio.eliminarMalla(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}			
					
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
}
