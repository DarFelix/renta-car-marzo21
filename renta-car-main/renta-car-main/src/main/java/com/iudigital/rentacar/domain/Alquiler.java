package com.iudigital.rentacar.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "alquileres")
public class Alquiler {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alq")
	private int idAlq;
	@Column(unique = true)
	private String factura;
	@Column(name = "nombre_sede")
	private String nombreSede;
	private int precio;
	@Column(name = "dias_minimo_prestamo")
	private int diasMinimoPrestamo;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "final_date")
	private Date finalDate;
	@Column(name = "id_car")
	private int idCar;
	@Column(name = "id_user")
	private int idUser;
	
	
	public int getIdAlq() {
		return idAlq;
	}
	public void setIdAlq(int idAlq) {
		this.idAlq = idAlq;
	}
	public String getFactura() {
		return factura;
	}
	public void setFactura(String factura) {
		this.factura = factura;
	}
	public String getNombreSede() {
		return nombreSede;
	}
	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getDiasMinimoPrestamo() {
		return diasMinimoPrestamo;
	}
	public void setDiasMinimoPrestamo(int diasMinimoPrestamo) {
		this.diasMinimoPrestamo = diasMinimoPrestamo;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}
	public int getIdCar() {
		return idCar;
	}
	public void setIdCar(int idCar) {
		this.idCar = idCar;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	

	
	

}
