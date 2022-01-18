package com.uisrael.petshome.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class CabeceraAdopcion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCabeceraAdopcion;

	//Delega a JPA el manejo de formatos con la BDD
	@Temporal(TemporalType.DATE)
	private Date fecha;
	private String observacion;
	private int estadoRegistro;

	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	/*Nombe de la columna foreign key*/
	@JoinColumn(name = "idPersona")
	private Persona fkPersona;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	/*Nombe de la columna foreign key*/
	@JoinColumn(name = "idEmpleado")
	private Empleado fkEmpleado;

	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "fkCabeceraAdopcion")
	private List<DetalleAdopcion> listaDetalleAdopcion= new ArrayList<DetalleAdopcion>();
	
	public int getIdCabeceraAdopcion() {
		return idCabeceraAdopcion;
	}
	public void setIdCabeceraAdopcion(int idCabeceraAdopcion) {
		this.idCabeceraAdopcion = idCabeceraAdopcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
	
	public Persona getFkPersona() {
		return fkPersona;
	}
	public void setFkPersona(Persona fkPersona) {
		this.fkPersona = fkPersona;
	}
	public Empleado getFkEmpleado() {
		return fkEmpleado;
	}
	public void setFkEmpleado(Empleado fkEmpleado) {
		this.fkEmpleado = fkEmpleado;
	}
	public List<DetalleAdopcion> getListaDetalleAdopcion() {
		return listaDetalleAdopcion;
	}
	public void setListaDetalleAdopcion(List<DetalleAdopcion> listaDetalleAdopcion) {
		this.listaDetalleAdopcion = listaDetalleAdopcion;
	}
	@Override
	public String toString() {
		return "CabeceraAdopcion [idCabeceraAdopcion=" + idCabeceraAdopcion + ", fecha=" + fecha + ", observacion="
				+ observacion + ", estadoRegistro=" + estadoRegistro + ", fkPersona=" + fkPersona + ", fkEmpleado="
				+ fkEmpleado + ", listaDetalleAdopcion=" + listaDetalleAdopcion + "]";
	}

	
	
}
