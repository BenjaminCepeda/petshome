package com.uisrael.petshome.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.uisrael.petshome.model.dao.MascotaDao;
import com.uisrael.petshome.model.entity.Mascota;
import com.uisrael.petshome.model.entity.Persona;


public class MascotaDaoImpl implements MascotaDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PUPetshome");
	private EntityManager em = emf.createEntityManager();

	
	@Override
	public void insertar(Mascota mascota) {
		em.getTransaction().begin();
		em.persist(mascota);
		em.getTransaction().commit();

	}

	@Override
	public void actualizar(Mascota mascota) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Mascota> listar() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Mascota> cq = cb.createQuery(Mascota.class);
		Root<Mascota> mascota = cq.from(Mascota.class);
		cq.select(mascota);
		
		return em.createQuery(cq).getResultList();	

	}

	@Override
	public List<Tuple> listarTuple(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Tuple> cq = cb.createTupleQuery();
		Root<Mascota> mascota = cq.from(Mascota.class);
		cq.select(cb.tuple(mascota.get("idMascota"), mascota.get("nombre")));
		
		return em.createQuery(cq).getResultList();	
	}

	@Override
	public List<Tuple> totalMascotasPorTipo() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Tuple> cq = cb.createTupleQuery();
		Root<Mascota> mascota = cq.from(Mascota.class);
		cq.multiselect(mascota.get("tipo"),cb.count(mascota.get("idMascota")));
		cq.groupBy(mascota.get("tipo"));
		
		return em.createQuery(cq).getResultList();	
	}
}
