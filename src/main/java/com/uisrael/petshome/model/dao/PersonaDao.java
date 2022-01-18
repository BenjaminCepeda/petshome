package com.uisrael.petshome.model.dao;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.petshome.model.entity.Persona;

public interface PersonaDao {

	public void insertar(Persona persona);
	public void actualizar(Persona persona);
	public void eliminar(int id);
	public List<Persona> listar();
	public List<Tuple> listarTuple();
	
}
