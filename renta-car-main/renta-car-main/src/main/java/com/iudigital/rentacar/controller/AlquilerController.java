package com.iudigital.rentacar.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

import com.iudigital.rentacar.controller.converter.AlquilerConverter;
import com.iudigital.rentacar.controller.dto.AlquilerDTO;
import com.iudigital.rentacar.domain.Alquiler;
import com.iudigital.rentacar.service.AlquilerService;

@RestController
@RequestMapping("/alquiler")
@CrossOrigin("*")
public class AlquilerController {

	@Autowired
	private AlquilerService alquilerService;
	@Autowired
	private AlquilerConverter alquilerConverter;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createAlquiler(@RequestBody AlquilerDTO alquilerDTO) {
		alquilerService.createAlquiler(alquilerConverter.convertAlquilerDTOToAlquiler(alquilerDTO));
	}
	
	@GetMapping
	public List<AlquilerDTO> getAlquilers() {
		return alquilerService.getAlquilers()
								.stream()
								.map(alquiler -> alquilerConverter.convertAlquilerToAlquilerDTO(alquiler))
								.collect(Collectors.toList());
	}
	
	@GetMapping("/{IdAlq}")
	public Alquiler getAlquiler(@PathVariable int IdAlq) {
		return alquilerService.getAlquilerById(IdAlq);
	}
	
	
	@PutMapping("/{IdAlq}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void  editAlquiler(@PathVariable int IdAlq, @RequestBody Alquiler alquiler) {
		 alquilerService.editAlquiler(IdAlq, alquiler );
	}
	
	@DeleteMapping("/{IdAlq}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAlquiler(@PathVariable int IdAlq) {
		 alquilerService.deleteAlquiler(IdAlq);
	}
	
	
	//5. busqueda de fechas entre un periodo dado
	
	@GetMapping("/startdate/desde/{desde}/hasta/{hasta}")
	public List<AlquilerDTO> getByStartDateBetween(@PathVariable Date desde, @PathVariable Date hasta ){
		return alquilerService.getByStartDateBetween(desde, hasta)
									.stream()
									.map(alquiler -> alquilerConverter.convertAlquilerToAlquilerDTO(alquiler))
									.collect(Collectors.toList());
		
	}
	
	//10. busqueda por fechas despues de
	
	@GetMapping("/startdate/desde/{desde}")
	public List<AlquilerDTO> getByStartDateAfter(@PathVariable Date desde){
		return alquilerService.getByStartDateAfter(desde)
								.stream()
								.map(alquiler -> alquilerConverter.convertAlquilerToAlquilerDTO(alquiler))
								.collect(Collectors.toList());
	}
	
	//11. busqueda por fechas antes de
	@GetMapping("/startdate/hasta/{hasta}")
	public List<AlquilerDTO> getByStartDateBefore(@PathVariable Date hasta){
		return alquilerService.getByStartDateBefore(hasta)
								.stream()
								.map(alquiler -> alquilerConverter.convertAlquilerToAlquilerDTO(alquiler))
								.collect(Collectors.toList());
	}
	
	
	
	
	
	
}
