package com.uisrael.petshome.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "mascota")
public class Mascota implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int idMascota;
	private String tipo;
	private  String nombre;
	private int estadoRegistro;

	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "fkMascota")
	private List<DetalleAdopcion> listaDetalleAdopcion= new ArrayList<DetalleAdopcion>();
	
	//Delega a JPA el manejo de formatos con la BDD
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	private String carateristicas;
	
	public int getIdMascota() {
		return idMascota;
	}
	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getCarateristicas() {
		return carateristicas;
	}
	public void setCarateristicas(String carateristicas) {
		this.carateristicas = carateristicas;
	}
	
	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	@Override
	public String toString() {
		return "Mascota [idMascota=" + idMascota + ", tipo=" + tipo + ", nombre=" + nombre + ", estadoRegistro="
				+ estadoRegistro + ", fechaNacimiento=" + fechaNacimiento + ", carateristicas=" + carateristicas + "]";
	}

	
	

}
