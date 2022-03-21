package com.iudigital.rentacar.controller.dto;

import java.sql.Date;



public class AlquilerDTO {

	private int idAlq;
	private String factura;
	private String nombreSede;
	private int precio;
	private int diasMinimoPrestamo;
	private Date startDate;
	private Date finalDate;
	private int idCar;	
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
