package com.uisrael.petshome.model.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DetalleAdopcion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalleAdopcion;
	private int cantidad;
	private String observacion;
	private int estadoRegistro;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	/*Nombe de la columna foreign key*/
	@JoinColumn(name = "idCabeceraAdopcion")
	private CabeceraAdopcion fkCabeceraAdopcion;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	/*Nombe de la columna foreign key*/
	@JoinColumn(name = "idMascota")
	private Mascota fkMascota;

	
	public int getIdDetalleAdopcion() {
		return idDetalleAdopcion;
	}
	public void setIdDetalleAdopcion(int idDetalleAdopcion) {
		this.idDetalleAdopcion = idDetalleAdopcion;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	public CabeceraAdopcion getFkCabeceraAdopcion() {
		return fkCabeceraAdopcion;
	}
	public void setFkCabeceraAdopcion(CabeceraAdopcion fkCabeceraAdopcion) {
		this.fkCabeceraAdopcion = fkCabeceraAdopcion;
	}
	public Mascota getFkMascota() {
		return fkMascota;
	}
	public void setFkMascota(Mascota fkMascota) {
		this.fkMascota = fkMascota;
	}
	@Override
	public String toString() {
		return "DetalleAdopcion [idDetalleAdopcion=" + idDetalleAdopcion + ", cantidad=" + cantidad 
				+ ", observacion=" + observacion + ", estadoRegistro=" + estadoRegistro
				+ ", fkCabeceraAdopcion=" + fkCabeceraAdopcion + ", fkMascota=" + fkMascota + "]";
	}
		

}
