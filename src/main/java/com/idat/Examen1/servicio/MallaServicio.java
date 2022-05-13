package com.idat.Examen1.servicio;

import java.util.List;

import com.idat.Examen1.dto.MallaDTORequest;
import com.idat.Examen1.dto.MallaDTOResponse;

public interface MallaServicio {
	
	public void guardarMalla(MallaDTORequest malla);
	public void editarMalla(MallaDTORequest malla);
	public void eliminarMalla(Integer id);
	public List<MallaDTOResponse> listarMalla();
	public MallaDTOResponse obtenerMallaId(Integer id);

}
