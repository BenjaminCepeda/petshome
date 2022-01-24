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

import com.uisrael.petshome.controller.MascotaController;
import com.uisrael.petshome.controller.impl.MascotaControllerImpl;
import com.uisrael.petshome.model.entity.Mascota;

@ManagedBean
@ViewScoped
public class MascotaView implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MascotaController mascotaController;
	private Mascota mascota;
	private List<Mascota> listaMascotas = new ArrayList<Mascota>();

	@PostConstruct
	public void init() {
		mascotaController = new MascotaControllerImpl();
		mascota = new Mascota();	
		listarMascotas();
	}
	
	public void insertar() {
		if (mascota.getIdMascota()>0) {
			mascotaController.actualizar(mascota);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Actualizado"));
		}
		else {
			mascotaController.insertar(mascota);
			mascota = new Mascota();	
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Ingresado"));
			
		}
			
		listarMascotas();
		PrimeFaces.current().ajax().update("frmMascota:mensaje", "frmMascota:dtMascotas");	
	}
	public void eliminar() {
			mascotaController.eliminar(mascota);
			listarMascotas();
			mascota = new Mascota();	
			PrimeFaces.current().ajax().update("frmMascota:mensaje", "frmMascota:dtMascotas");	
	}

	public void limpiar() {
		mascota = new Mascota();	
	}
	
	public void listarMascotas() {
		listaMascotas = mascotaController.listar();
	}
	
	
	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public List<Mascota> getListaMascotas() {
		return listaMascotas;
	}

	public void setListaMascotas(List<Mascota> listaMascotas) {
		this.listaMascotas = listaMascotas;
	}
	
	
}
