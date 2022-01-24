package com.uisrael.petshome.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.uisrael.petshome.model.dao.PersonaDao;
import com.uisrael.petshome.model.entity.Persona;

public class PersonaDaoImpl extends GenericDaoImpl<Persona> implements PersonaDao {
	@Override
	public void insertar(Persona persona) {		
		this.beginTransaction();
		this.create(persona);
		this.commit();

	}

	@Override
	public void actualizar(Persona persona) {
		this.beginTransaction();
		this.update(persona);
		this.commit();

	}

	@Override
	public void eliminar(Persona persona) {
		this.beginTransaction();
		this.delete(persona);
		this.commit();
	}

	@Override
	public List<Persona> listar() {
		return this.findAll();	
	}

	@Override
	public List<Tuple> listarTuple(){
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> cq = cb.createTupleQuery();
		Root<Persona> persona = cq.from(Persona.class);
		cq.select(cb.tuple(persona.get("idPersona"), persona.get("nombres"), persona.get("apellidos"))).
			orderBy(cb.asc( persona.get("apellidos")));
		
		return this.entityManager.createQuery(cq).getResultList();	
	}
	


}
