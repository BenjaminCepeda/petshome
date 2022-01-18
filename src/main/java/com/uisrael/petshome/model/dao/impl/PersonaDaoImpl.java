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

public class PersonaDaoImpl implements PersonaDao {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PUPetshome");
	private EntityManager em = emf.createEntityManager();
	@Override
	public void insertar(Persona persona) {		
		em.getTransaction().begin();
		em.persist(persona);
		em.getTransaction().commit();


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
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);
		Root<Persona> persona = cq.from(Persona.class);
		cq.select(persona);
		
		return em.createQuery(cq).getResultList();	
	}

	@Override
	public List<Tuple> listarTuple(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Tuple> cq = cb.createTupleQuery();
		Root<Persona> persona = cq.from(Persona.class);
		cq.select(cb.tuple(persona.get("idPersona"), persona.get("nombres"), persona.get("apellidos"))).
			orderBy(cb.asc( persona.get("apellidos")));
		
		return em.createQuery(cq).getResultList();	
	}
	


}
