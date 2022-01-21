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

import com.uisrael.petshome.controller.PersonaController;
import com.uisrael.petshome.controller.impl.PersonaControllerImpl;
import com.uisrael.petshome.model.entity.Persona;

@ManagedBean
@ViewScoped
public class PersonaView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PersonaController personaController;
	private Persona persona;
	private List<Persona> listaPersonas = new ArrayList<Persona>();

	@PostConstruct
	public void init() {
		personaController = new PersonaControllerImpl();
		persona = new Persona();	
		listarPersonas();
	}
	
	public void insertar() {
		personaController.insertar(persona);
		listarPersonas();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Ingresado"));
		PrimeFaces.current().ajax().update("frmPersona:mensaje", "frmPersona:dtPersonas");	
	}
	
	public void listarPersonas() {
		listaPersonas = personaController.listar();
	}
	
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Persona> getListaPersonas() {
		return listaPersonas;
	}

	public void setListaPersonas(List<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}
	
	
}
