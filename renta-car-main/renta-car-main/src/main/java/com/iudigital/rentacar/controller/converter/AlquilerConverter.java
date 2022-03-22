package com.iudigital.rentacar.controller.converter;

import org.springframework.stereotype.Component;

import com.iudigital.rentacar.controller.dto.AlquilerDTO;
import com.iudigital.rentacar.domain.Alquiler;

@Component
public class AlquilerConverter {
	
	public Alquiler convertAlquilerDTOToAlquiler(AlquilerDTO alquilerDTO) {
		
		
		Alquiler alquiler = new Alquiler();
		
		alquiler.setIdAlq(alquilerDTO.getIdAlq());
		alquiler.setFactura(alquilerDTO.getFactura());
		alquiler.setNombreSede(alquilerDTO.getNombreSede());
		alquiler.setPrecio(alquilerDTO.getPrecio());
		alquiler.setDiasMinimoPrestamo(alquilerDTO.getDiasMinimoPrestamo());
		alquiler.setStartDate(alquilerDTO.getStartDate());
		alquiler.setFinalDate(alquilerDTO.getFinalDate());
		alquiler.setIdCar(alquilerDTO.getIdCar());
		alquiler.setIdUser(alquilerDTO.getIdUser());
		
		return alquiler;
		
	}
	
	public AlquilerDTO convertAlquilerToAlquilerDTO(Alquiler alquiler) {
		
		AlquilerDTO alquilerDTO = new AlquilerDTO();
		
		alquilerDTO.setIdAlq(alquiler.getIdAlq());
		alquilerDTO.setFactura(alquiler.getFactura());
		alquilerDTO.setNombreSede(alquiler.getNombreSede());
		alquilerDTO.setPrecio(alquiler.getPrecio());
		alquilerDTO.setDiasMinimoPrestamo(alquiler.getDiasMinimoPrestamo());
		alquilerDTO.setStartDate(alquiler.getStartDate());
		alquilerDTO.setFinalDate(alquiler.getFinalDate());
		alquilerDTO.setIdCar(alquiler.getIdCar());
		alquilerDTO.setIdUser(alquiler.getIdUser());
		
		return alquilerDTO;
		
		
		
		
	}

}
