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

import com.uisrael.petshome.controller.CabeceraAdopcionController;
import com.uisrael.petshome.controller.EmpleadoController;
import com.uisrael.petshome.controller.PersonaController;
import com.uisrael.petshome.controller.impl.CabeceraAdopcionControllerImpl;
import com.uisrael.petshome.controller.impl.EmpleadoControllerImpl;
import com.uisrael.petshome.controller.impl.PersonaControllerImpl;
import com.uisrael.petshome.model.entity.CabeceraAdopcion;
import com.uisrael.petshome.model.entity.Empleado;
import com.uisrael.petshome.model.entity.Persona;

@ManagedBean
@ViewScoped
public class CabeceraAdopcionView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CabeceraAdopcionController cabeceraAdopcionController;
	private CabeceraAdopcion cabeceraAdopcion;
	private List<CabeceraAdopcion> listaCabeceraAdopciones = new ArrayList<CabeceraAdopcion>();
	private EmpleadoController empleadoController;
	private List<Empleado> listaEmpleados = new ArrayList<Empleado>();
	private PersonaController personaController;
	private List<Persona> listaPersonas= new ArrayList<Persona>();
	@PostConstruct
	public void init() {
		cabeceraAdopcionController = new CabeceraAdopcionControllerImpl();
		cabeceraAdopcion = new CabeceraAdopcion();	
		listarCabeceraAdopciones();
		empleadoController = new EmpleadoControllerImpl();
		listaEmpleados = empleadoController.listar();
		personaController = new PersonaControllerImpl();
		listaPersonas= personaController.listar();
	}
	
	public void insertar() {
		if (cabeceraAdopcion.getIdCabeceraAdopcion()>0) {
			cabeceraAdopcionController.actualizar(cabeceraAdopcion);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Actualizado"));
		}
		else {
			cabeceraAdopcionController.insertar(cabeceraAdopcion);
			cabeceraAdopcion = new CabeceraAdopcion();	
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Ingresado"));
			
		}
			
		listarCabeceraAdopciones();
		PrimeFaces.current().ajax().update("frmCabeceraAdopcion:mensaje", "frmCabeceraAdopcion:dtCabeceraAdopciones");	
	}
	public void eliminar() {
			cabeceraAdopcionController.eliminar(cabeceraAdopcion);
			listarCabeceraAdopciones();
			cabeceraAdopcion = new CabeceraAdopcion();	
			PrimeFaces.current().ajax().update("frmCabeceraAdopcion:mensaje", "frmCabeceraAdopcion:dtCabeceraAdopciones");	
	}

	public void limpiar() {
		cabeceraAdopcion = new CabeceraAdopcion();	
	}
	
	public void listarCabeceraAdopciones() {
		listaCabeceraAdopciones = cabeceraAdopcionController.listar();
	}
	
	
	public CabeceraAdopcion getCabeceraAdopcion() {
		return cabeceraAdopcion;
	}

	public void setCabeceraAdopcion(CabeceraAdopcion cabeceraAdopcion) {
		this.cabeceraAdopcion = cabeceraAdopcion;
	}

	public List<CabeceraAdopcion> getListaCabeceraAdopciones() {
		return listaCabeceraAdopciones;
	}

	public void setListaCabeceraAdopciones(List<CabeceraAdopcion> listaCabeceraAdopciones) {
		this.listaCabeceraAdopciones = listaCabeceraAdopciones;
	}

	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	public List<Persona> getListaPersonas() {
		return listaPersonas;
	}

	public void setListaPersonas(List<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}
	
	
}
