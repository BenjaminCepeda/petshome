package com.uisrael.petshome.model.dao;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.petshome.model.entity.Empleado;


public interface EmpleadoDao {
	public void insertar(Empleado empleado);
	public void actualizar(Empleado empleado);
	public void eliminar(Empleado empleado);
	public List<Empleado> listar();
	public List<Tuple> listarTuple();
	public Long  totalEmpleados();
	public Empleado buscar(int id);
}
