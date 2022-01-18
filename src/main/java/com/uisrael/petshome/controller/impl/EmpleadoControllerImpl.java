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
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Empleado> listar() {

		return empleadoDao.listar();
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
