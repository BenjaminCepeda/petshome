package petshome;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

import javax.persistence.Tuple;

import org.junit.jupiter.api.Test;

import com.uisrael.petshome.controller.CabeceraAdopcionController;
import com.uisrael.petshome.controller.DetalleAdopcionController;
import com.uisrael.petshome.controller.EmpleadoController;
import com.uisrael.petshome.controller.MascotaController;
import com.uisrael.petshome.controller.PersonaController;
import com.uisrael.petshome.controller.impl.CabeceraAdopcionControllerImpl;
import com.uisrael.petshome.controller.impl.DetalleAdopcionControllerImpl;
import com.uisrael.petshome.controller.impl.EmpleadoControllerImpl;
import com.uisrael.petshome.controller.impl.MascotaControllerImpl;
import com.uisrael.petshome.controller.impl.PersonaControllerImpl;
import com.uisrael.petshome.model.entity.CabeceraAdopcion;
import com.uisrael.petshome.model.entity.DetalleAdopcion;
import com.uisrael.petshome.model.entity.Empleado;
import com.uisrael.petshome.model.entity.Mascota;
import com.uisrael.petshome.model.entity.Persona;



class PruebasPetshome {
	private PersonaController personaController = new PersonaControllerImpl();
	private MascotaController mascotaController = new MascotaControllerImpl();
	private EmpleadoController empleadoController = new EmpleadoControllerImpl();
	private CabeceraAdopcionController cabeceraAdopcionController = new CabeceraAdopcionControllerImpl();
	private DetalleAdopcionController detalleAdopcionController = new DetalleAdopcionControllerImpl();
	
	@Test
	void test() {
		Persona persona = new Persona();
		persona.setNombres("Juan");
		persona.setApellidos("Logroño");
		persona.setDireccion("Figueroa");
		persona.setIdentificacion("1111111111");
		persona.setTelefono("0988888888");
		persona.setEstadoRegistro(1);		
		personaController.insertar(persona);

		Empleado empleado = new Empleado();
		empleado.setNombres("Juanita");
		empleado.setApellidos("Perez");
		empleado.setCedula("1111111111");
		empleado.setFechaNacimiento(new Date());
		empleado.setTelefono("09999999999");
		empleado.setEstadoRegistro(1);
		empleadoController.insertar(empleado);

		Mascota mascota = new Mascota();
		mascota.setNombre("Firulais");
		mascota.setFechaNacimiento(new Date());
		mascota.setTipo("Perro");
		mascota.setCarateristicas("Runa cruzado con de la calle");
		mascota.setEstadoRegistro(1);
		mascotaController.insertar(mascota);

		CabeceraAdopcion cabeceraAdopcion = new CabeceraAdopcion();
		cabeceraAdopcion.setFecha(new Date());
		cabeceraAdopcion.setFkPersona(persona);
		cabeceraAdopcion.setFkEmpleado(empleado);
		cabeceraAdopcion.setObservacion("Inserción de prueba Perro");
		cabeceraAdopcion.setEstadoRegistro(1);
		cabeceraAdopcionController.insertar(cabeceraAdopcion);

		DetalleAdopcion detalleAdopcion = new DetalleAdopcion();
		detalleAdopcion.setFkCabeceraAdopcion(cabeceraAdopcion);
		detalleAdopcion.setFkMascota(mascota);
		detalleAdopcion.setObservacion("Se entrega en buen estado de salud");
		detalleAdopcion.setCantidad(1);
		detalleAdopcion.setEstadoRegistro(1);
		detalleAdopcionController.insertar(detalleAdopcion);
		
		persona = new Persona();
		persona.setNombres("Benjamin");
		persona.setApellidos("Cepeda");
		persona.setDireccion("Av. Occidental");
		persona.setIdentificacion("2222222222");
		persona.setTelefono("0999999999");
		persona.setEstadoRegistro(1);		
		personaController.insertar(persona);

		empleado = new Empleado();
		empleado.setNombres("Mónica");
		empleado.setApellidos("Arias");
		empleado.setCedula("2222222222");
		empleado.setFechaNacimiento(new Date());
		empleado.setTelefono("09222222222");
		empleado.setEstadoRegistro(1);
		empleadoController.insertar(empleado);

		mascota = new Mascota();
		mascota.setNombre("La Roca");
		mascota.setFechaNacimiento(new Date());
		mascota.setTipo("Lagartija");
		mascota.setCarateristicas("Verde con puntos amarillos");
		mascota.setEstadoRegistro(1);
		mascotaController.insertar(mascota);

		cabeceraAdopcion = new CabeceraAdopcion();
		cabeceraAdopcion.setFecha(new Date());
		cabeceraAdopcion.setFkPersona(persona);
		cabeceraAdopcion.setFkEmpleado(empleado);
		cabeceraAdopcion.setObservacion("Inserción de prueba Lagartija");
		cabeceraAdopcion.setEstadoRegistro(1);
		cabeceraAdopcionController.insertar(cabeceraAdopcion);

		detalleAdopcion = new DetalleAdopcion();
		detalleAdopcion.setFkCabeceraAdopcion(cabeceraAdopcion);
		detalleAdopcion.setFkMascota(mascota);
		detalleAdopcion.setObservacion("Tener cuidado con la alimentación");
		detalleAdopcion.setCantidad(1);
		detalleAdopcion.setEstadoRegistro(1);
		detalleAdopcionController.insertar(detalleAdopcion);
		
		persona = new Persona();
		persona.setNombres("Hernan");
		persona.setApellidos("Jimenez");
		persona.setDireccion("Av. 6 de Diciembre");
		persona.setIdentificacion("3333333333");
		persona.setTelefono("0933333333");
		persona.setEstadoRegistro(1);		
		personaController.insertar(persona);

		empleado = new Empleado();
		empleado.setNombres("Lorena");
		empleado.setApellidos("Morales");
		empleado.setCedula("3333333333");
		empleado.setFechaNacimiento(new Date());
		empleado.setTelefono("09333333333");
		empleado.setEstadoRegistro(1);
		empleadoController.insertar(empleado);
		

		mascota = new Mascota();
		mascota.setNombre("Claudio");
		mascota.setFechaNacimiento(new Date());
		mascota.setTipo("Gallo");
		mascota.setCarateristicas("Blanco patas amarillas");
		mascota.setEstadoRegistro(1);
		mascotaController.insertar(mascota);
		
		
		cabeceraAdopcion = new CabeceraAdopcion();
		cabeceraAdopcion.setFecha(new Date());
		cabeceraAdopcion.setFkPersona(persona);
		cabeceraAdopcion.setFkEmpleado(empleado);
		cabeceraAdopcion.setObservacion("Inserción de prueba Gallo");
		cabeceraAdopcion.setEstadoRegistro(1);
		cabeceraAdopcionController.insertar(cabeceraAdopcion);
		
		detalleAdopcion = new DetalleAdopcion();
		detalleAdopcion.setFkCabeceraAdopcion(cabeceraAdopcion);
		detalleAdopcion.setFkMascota(mascota);
		detalleAdopcion.setObservacion("Cuidado que el gallo es bravo");
		detalleAdopcion.setCantidad(1);
		detalleAdopcion.setEstadoRegistro(1);
		detalleAdopcionController.insertar(detalleAdopcion);
		
		System.out.println(" --- Listado General de personas --- ");		
		List<Persona> listadoPersonas = personaController.listar();
		for (Persona personaActual : listadoPersonas) {
			System.out.println(personaActual);
		}

		System.out.println(" --- Listado de personas ORDENADO POR APELLIDO--- ");		
		List<Tuple> listadoPersonasTuple = personaController.listarTuple();
		for (Tuple personaActual : listadoPersonasTuple) {
			System.out.println(personaActual.get(0)+" "+personaActual.get(2)+" "+personaActual.get(1));
		}
		
		System.out.println(" --- Listado de Empleados --- ");		
		List<Empleado> listadoEmpleados= empleadoController.listar();
		for (Empleado empleadoActual : listadoEmpleados) {
			System.out.println(empleadoActual);
		}

		System.out.println(" --- Listado de Empleados en TUPLAS--- ");
		List<Tuple> listadoEmpleadosTuple = empleadoController.listarTuple();
		for (Tuple empleadoActual : listadoEmpleadosTuple) {
			System.out.println(empleadoActual.get(0)+" "+empleadoActual.get(1)+" "+empleadoActual.get(2));
		}

		System.out.println(" --- Total de Empleados --- ");
		System.out.println(empleadoController.totalEmpleados());

		System.out.println(" --- Listado de Mascotas DATOS PARCIALES --- ");
		List<Tuple> listadoMascotas= mascotaController.listarTuple();
		for (Tuple mascotaActual : listadoMascotas) {
			System.out.println(mascotaActual.get(0)+" "+mascotaActual.get(1));
		}

		System.out.println(" --- Listado de Mascotas AGRUPADAS por Tipo --- ");
		List<Tuple> listadoMascotasPorRaza = mascotaController.totalMascotasPorTipo();
		for (Tuple mascotaActual : listadoMascotasPorRaza) {
			System.out.println(mascotaActual.get(0)+" "+mascotaActual.get(1));
		}
		
		// TODO  Sobrecargar el método "Listar" de DETALLEADOPCION para que 
		// Liste por ID de CABECERAADOPCION
		// y muestre el las adopciones por PERSONA 

		System.out.println(" --- ADOPCONES REALIZADAS y detalle usando WHERE --- ");		
		List<CabeceraAdopcion> listadoAdopciones= cabeceraAdopcionController.listar();
		for (CabeceraAdopcion cabeceraAdopcionActual : listadoAdopciones) {
			System.out.println(cabeceraAdopcionActual);
			List<Tuple> listadoDetalleAdopcion = detalleAdopcionController.listarTuple(cabeceraAdopcionActual.getIdCabeceraAdopcion());
			for (Tuple detalleAdopcionActual : listadoDetalleAdopcion) {
				
				System.out.println("\t Adopta a: " + detalleAdopcionActual.get(0) + " " + detalleAdopcionActual.get(1));
			}
		}

	}

}
