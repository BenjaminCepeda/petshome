package com.uisrael.petshome.controller.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.petshome.controller.PersonaController;
import com.uisrael.petshome.model.dao.PersonaDao;
import com.uisrael.petshome.model.dao.impl.PersonaDaoImpl;
import com.uisrael.petshome.model.entity.Persona;

public class PersonaControllerImpl implements PersonaController {

	private PersonaDao personaDao = new PersonaDaoImpl();
	
	@Override
	public void insertar(Persona persona) {
		personaDao.insertar(persona);
		

	}

	@Override
	public void actualizar(Persona persona) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Persona> listar() {
		return personaDao.listar();
	}

	@Override
	public List<Tuple> listarTuple() {
		return personaDao.listarTuple();
	}
}
