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
@Table(name = "empleado")
public class Empleado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="idEmpleado")
	private int idEmpleado;
	private String cedula;
	private String nombres;
	private String apellidos;
	private String Telefono;
	private int estadoRegistro;
	
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "fkEmpleado")
	private List<CabeceraAdopcion> listaCabeceraAdopcion= new ArrayList<CabeceraAdopcion>();
	
	//Delega a JPA el manejo de formatos con la BDD
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
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
	
	
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public List<CabeceraAdopcion> getListaCabeceraAdopcion() {
		return listaCabeceraAdopcion;
	}
	public void setListaCabeceraAdopcion(List<CabeceraAdopcion> listaCabeceraAdopcion) {
		this.listaCabeceraAdopcion = listaCabeceraAdopcion;
	}
	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", cedula=" + cedula + ", nombres=" + nombres + ", apellidos="
				+ apellidos + ", Telefono=" + Telefono + ", estadoRegistro=" + estadoRegistro
				+ ", listaCabeceraAdopcion=" + listaCabeceraAdopcion + ", fechaNacimiento=" + fechaNacimiento + "]";
	}

	
	
	
}
