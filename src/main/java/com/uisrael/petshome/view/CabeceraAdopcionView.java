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
import com.uisrael.petshome.controller.DetalleAdopcionController;
import com.uisrael.petshome.controller.EmpleadoController;
import com.uisrael.petshome.controller.MascotaController;
import com.uisrael.petshome.controller.PersonaController;
import com.uisrael.petshome.controller.impl.CabeceraAdopcionControllerImpl;
import com.uisrael.petshome.controller.impl.EmpleadoControllerImpl;
import com.uisrael.petshome.controller.impl.MascotaControllerImpl;
import com.uisrael.petshome.controller.impl.PersonaControllerImpl;
import com.uisrael.petshome.model.entity.CabeceraAdopcion;
import com.uisrael.petshome.model.entity.DetalleAdopcion;
import com.uisrael.petshome.model.entity.Empleado;
import com.uisrael.petshome.model.entity.Mascota;
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
	private DetalleAdopcionController detalleAdopcionController;
	private DetalleAdopcion detalleAdopcion;
	
	
	private List<DetalleAdopcion> detalleAdopciones = new ArrayList<DetalleAdopcion>();

	private EmpleadoController empleadoController;
	private PersonaController personaController;
	private MascotaController mascotaController;
	private Mascota mascota;

	private List<Empleado> listaEmpleados = new ArrayList<Empleado>();
	private List<Persona> listaPersonas= new ArrayList<Persona>();
	private List<Mascota> listaMascotas= new ArrayList<Mascota>();

	
	private DetalleAdopcion selectDetalleAdopcion;
	private Empleado selectEmpleado;
	private Persona selectPersona;
	private Mascota selectMascota;
	
	private int idEmpleado;
	private int idPersona;
	private int idMascota;
	
	
	@PostConstruct
	public void init() {
		cabeceraAdopcion = new CabeceraAdopcion();	
		cabeceraAdopcionController = new CabeceraAdopcionControllerImpl();
		empleadoController = new EmpleadoControllerImpl();
		personaController = new PersonaControllerImpl();
		mascotaController = new MascotaControllerImpl();
		listarEmpleados();
		listarPersonas();
		listarMascotas();
	}
	
	public void listarPersonas() {
		listaPersonas= personaController.listar();		
	}

	public void listarEmpleados() {
		listaEmpleados= empleadoController.listar();		
	}
	public void listarMascotas() {
		listaMascotas= mascotaController.listar();		
	}
	
	public void buscarPersona() {
		selectPersona= personaController.buscar(idPersona);		
	}
	public void buscarEmpleado() {
		selectEmpleado= empleadoController.buscar(idEmpleado);		
	}
	public void buscarMascota() {
		selectMascota= mascotaController.buscar(idPersona);		
	}

	
	public void insertar() {
		cabeceraAdopcion.setFkEmpleado(selectEmpleado);
		cabeceraAdopcion.setFkPersona(selectPersona);
		if (cabeceraAdopcion.getIdCabeceraAdopcion()>0) {
			cabeceraAdopcionController.actualizar(cabeceraAdopcion);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Actualizado"));
		}
		else {
			cabeceraAdopcionController.insertar(cabeceraAdopcion);
			cabeceraAdopcion = new CabeceraAdopcion();	
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Registro Ingresado"));			
		}
		limpiar();			
		PrimeFaces.current().ajax().update("frmCabeceraAdopcion frmCabeceraAdopcion:mensaje frmCabeceraAdopcion:opnNuevo");
	}
	
	public void eliminar() {
/*			cabeceraAdopcionController.eliminar(cabeceraAdopcion);
			listarCabeceraAdopciones();
*/			cabeceraAdopcion = new CabeceraAdopcion();	
			PrimeFaces.current().ajax().update("frmCabeceraAdopcion:mensaje", "frmCabeceraAdopcion:opNuevo");	
	}

	public void limpiar() {
		cabeceraAdopcion = new CabeceraAdopcion();	
		selectPersona= new Persona();
		selectEmpleado= new Empleado();
		PrimeFaces.current().ajax().update("frmCabeceraAdopcion", "frmCabeceraAdopcion:somPersona", "frmCabeceraAdopcion:somEmpleado");
		}
	
	
	public CabeceraAdopcion getCabeceraAdopcion() {
		return cabeceraAdopcion;
	}

	public void setCabeceraAdopcion(CabeceraAdopcion cabeceraAdopcion) {
		this.cabeceraAdopcion = cabeceraAdopcion;
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

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public int getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}

	public DetalleAdopcion getSelectDetalleAdopcion() {
		return selectDetalleAdopcion;
	}

	public void setSelectDetalleAdopcion(DetalleAdopcion selectDetalleAdopcion) {
		this.selectDetalleAdopcion = selectDetalleAdopcion;
	}

	public Empleado getSelectEmpleado() {
		return selectEmpleado;
	}

	public void setSelectEmpleado(Empleado selectEmpleado) {
		this.selectEmpleado = selectEmpleado;
	}

	public Persona getSelectPersona() {
		return selectPersona;
	}

	public void setSelectPersona(Persona selectPersona) {
		this.selectPersona = selectPersona;
	}

	public Mascota getSelectMascota() {
		return selectMascota;
	}

	public void setSelectMascota(Mascota selectMascota) {
		this.selectMascota = selectMascota;
	}
	
	
}
