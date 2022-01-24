package com.uisrael.petshome.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import com.uisrael.petshome.controller.EmpleadoController;
import com.uisrael.petshome.controller.impl.EmpleadoControllerImpl;
import com.uisrael.petshome.model.entity.Empleado;

@ManagedBean
@ViewScoped
public class EmpleadoView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private EmpleadoController empleadoController;
	private Empleado empleado;
	private List<Empleado> listaEmpleados = new ArrayList<Empleado>();

	@PostConstruct
	public void init() {
		empleadoController = new EmpleadoControllerImpl();
		empleado = new Empleado();	
		listarEmpleados();
	}
	
	public void insertar() {
		if (empleado.getIdEmpleado()>0) {
			empleadoController.actualizar(empleado);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Actualizado"));
		}
		else {
			empleadoController.insertar(empleado);
			empleado = new Empleado();	
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Ingresado"));
			
		}
			
		listarEmpleados();
		PrimeFaces.current().ajax().update("frmEmpleado:mensaje", "frmEmpleado:dtEmpleados");	
	}
	public void eliminar() {
			empleadoController.eliminar(empleado);
			listarEmpleados();
			empleado = new Empleado();	
			PrimeFaces.current().ajax().update("frmEmpleado:mensaje", "frmEmpleado:dtEmpleados");	
	}

	public void limpiar() {
		empleado = new Empleado();	
	}
	
	public void listarEmpleados() {
		listaEmpleados = empleadoController.listar();
	}
	
	
	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}
	
	
}
