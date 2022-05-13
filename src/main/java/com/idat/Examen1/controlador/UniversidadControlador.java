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

import com.idat.Examen1.dto.UniversidadDTORequest;
import com.idat.Examen1.dto.UniversidadDTOResponse;
import com.idat.Examen1.servicio.UniversidadServicio;

@RestController
@RequestMapping("/universidad/v1")
public class UniversidadControlador {

	@Autowired
	private UniversidadServicio servicio;
	
	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<UniversidadDTOResponse>> listarProducto(){
		return new ResponseEntity<List<UniversidadDTOResponse>>(servicio.listarUniversidad(), HttpStatus.CREATED);
	}

	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody UniversidadDTORequest uni){
		
		servicio.guardarUniversidad(uni);
		return new ResponseEntity<Void> (HttpStatus.CREATED);
	}
	
	@RequestMapping(path = "/listar/{id}")
	public ResponseEntity<UniversidadDTOResponse> listarPorId(@PathVariable Integer id) {
		UniversidadDTOResponse p = servicio.obtenerUniversidadId(id);
		if(p != null)
			return new ResponseEntity<UniversidadDTOResponse>(p, HttpStatus.OK);
					
		return new ResponseEntity<UniversidadDTOResponse>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody UniversidadDTORequest uni){
		
		UniversidadDTOResponse p = servicio.obtenerUniversidadId(uni.getIdUniversidadDTO());
		if(p != null) {
			servicio.editarUniversidad(uni);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}			
					
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		UniversidadDTOResponse p = servicio.obtenerUniversidadId(id);
		if(p != null) {
			servicio.eliminarUniversidad(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}			
					
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
}
