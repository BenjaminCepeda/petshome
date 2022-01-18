package com.uisrael.petshome.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "persona")
public class Persona implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="idPersona")
	private int idPersona;
	
	@Column(nullable = false, unique = true)
	private String identificacion;
	
	private String nombres;
	private String apellidos;
	private String direccion;
	private String telefono;
	private int estadoRegistro;

	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "fkPersona")
	private List<CabeceraAdopcion> listaCabeceraAdopcion= new ArrayList<CabeceraAdopcion>();

	
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", identificacion=" + identificacion + ", nombres=" + nombres
				+ ", apellidos=" + apellidos + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", estadoRegistro=" + estadoRegistro + "]";
	}
	

}
