package com.idat.Examen1.servicio;

import java.util.List;

import com.idat.Examen1.dto.UniversidadDTORequest;
import com.idat.Examen1.dto.UniversidadDTOResponse;

public interface UniversidadServicio {
	
	public void guardarUniversidad(UniversidadDTORequest universidad);
	public void editarUniversidad(UniversidadDTORequest universidad);
	public void eliminarUniversidad(Integer id);
	public List<UniversidadDTOResponse> listarUniversidad();
	public UniversidadDTOResponse obtenerUniversidadId(Integer id);

}
