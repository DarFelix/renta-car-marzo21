package com.iudigital.rentacar.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iudigital.rentacar.domain.Alquiler;

import java.sql.Date;

@Repository
public interface AlquilerRepository extends CrudRepository<Alquiler, Integer>{
	
	
	
	// 5.SELECT * FROM alquiler WHERE fechaInicio BETWEEN '2022-01-01' AND '2022-01-31'
	public List<Alquiler> findByStartDateBetween(Date desde, Date hasta);
	
	//10. SELECT * FROM alquiler WHERE fechaInicio > 2021-01-01
	public List<Alquiler> findByStartDateAfter(Date desde);
	
	//11. SELECT * FROM alquiler WHERE fechaInicio < 2021-02-01
	public List<Alquiler> findByStartDateBefore(Date hasta);
	
}
