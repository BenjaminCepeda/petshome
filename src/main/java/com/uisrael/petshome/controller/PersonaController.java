package com.uisrael.petshome.controller;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.petshome.model.entity.Persona;

public interface PersonaController {
	public void insertar(Persona persona);
	public void actualizar(Persona persona);
	public void eliminar(Persona persona);
	public List<Persona> listar();
	public List<Tuple> listarTuple();
	
}
