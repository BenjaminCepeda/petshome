package com.uisrael.petshome.controller.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.petshome.controller.EmpleadoController;
import com.uisrael.petshome.model.dao.EmpleadoDao;
import com.uisrael.petshome.model.dao.impl.EmpleadoDaoimpl;
import com.uisrael.petshome.model.entity.Empleado;

public class EmpleadoControllerImpl implements EmpleadoController {

	private EmpleadoDao empleadoDao = new EmpleadoDaoimpl();
	@Override
	public void insertar(Empleado empleado) {
		empleadoDao.insertar(empleado);

	}

	@Override
	public void actualizar(Empleado empleado) {
		empleadoDao.actualizar(empleado);

	}

	@Override
	public void eliminar(Empleado empleado) {
		empleadoDao.eliminar(empleado);

	}

	@Override
	public List<Empleado> listar() {

		return empleadoDao.listar();
	}

	public Empleado buscar(int id) {
		return empleadoDao.buscar(id);
	}
	
	@Override
	public List<Tuple> listarTuple() {
		return empleadoDao.listarTuple();
	}

	@Override
	public Long totalEmpleados() {
		// TODO Auto-generated method stub
		return empleadoDao.totalEmpleados();
	}

}
