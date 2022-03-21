package com.iudigital.rentacar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iudigital.rentacar.data.AlquilerRepository;
import com.iudigital.rentacar.domain.Alquiler;

import java.sql.Date;

@Service
public class AlquilerService {
	
	@Autowired	
	private AlquilerRepository alquilerRepository;
	
	public void createAlquiler(Alquiler alquiler) {
	   alquilerRepository.save(alquiler);
	}
	
	public List<Alquiler> getAlquilers() {
		List<Alquiler> alquileres = (List<Alquiler>) alquilerRepository.findAll();
		return alquileres;
	}
	
	public Alquiler getAlquilerById(int idAlq) {
	
		Alquiler alquiler = alquilerRepository.findById(idAlq).orElse(new Alquiler());
		return alquiler;
	
	}
	
	public void editAlquiler(int idAlq, Alquiler alquiler) {
	
		Alquiler alquilerUpdate = alquilerRepository.findById(idAlq).orElse(null);
		if (alquilerUpdate != null) {
			alquilerUpdate.setFactura(alquiler.getFactura());
			alquilerUpdate.setNombreSede(alquiler.getNombreSede());
			alquilerUpdate.setPrecio(alquiler.getPrecio());
			alquilerUpdate.setDiasMinimoPrestamo(alquiler.getDiasMinimoPrestamo());
			alquilerUpdate.setDiasMinimoPrestamo(alquiler.getDiasMinimoPrestamo());
			alquilerUpdate.setStartDate(alquiler.getStartDate());
			alquilerUpdate.setFinalDate(alquiler.getFinalDate());
			alquilerUpdate.setIdCar(alquiler.getIdCar());
			alquilerUpdate.setIdUser(alquiler.getIdUser());
			
			alquilerRepository.save(alquilerUpdate);
		}
	
	}
	
	public void deleteAlquiler(int idAlq) {
		
		alquilerRepository.deleteById(idAlq);
		
	}
	
	
	//5. busqueda de fechas entre un periodo dado
	
	public List<Alquiler> getByStartDateBetween(Date desde, Date hasta){
		List<Alquiler> alquilers = alquilerRepository.findByStartDateBetween(desde, hasta);
		return alquilers;
	}
	
	//10. busqueda por fechas despues de
	
	public List<Alquiler> getByStartDateAfter(Date desde){
		List<Alquiler> alquilers = alquilerRepository.findByStartDateAfter(desde);
		return alquilers;
	}
	
	//11. busqueda por fechas antes de
	public List<Alquiler> getByStartDateBefore(Date hasta){
		List<Alquiler> alquilers = alquilerRepository.findByStartDateBefore(hasta);
		return alquilers;
	}
	
	
	


}
