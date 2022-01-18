package com.uisrael.petshome.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.uisrael.petshome.model.dao.CabeceraAdopcionDao;
import com.uisrael.petshome.model.entity.CabeceraAdopcion;
import com.uisrael.petshome.model.entity.Empleado;


public class CabeceraAdopcionDaoImpl implements CabeceraAdopcionDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PUPetshome");
	private EntityManager em = emf.createEntityManager();

	@Override
	public void insertar(CabeceraAdopcion cabeceraAdopcion) {
		em.getTransaction().begin();
		em.persist(cabeceraAdopcion);
		em.getTransaction().commit();

	}

	@Override
	public void actualizar(CabeceraAdopcion cabeceraAdopcion) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CabeceraAdopcion> listar() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CabeceraAdopcion> cq = cb.createQuery(CabeceraAdopcion.class);
		Root<CabeceraAdopcion> cabeceraAdopcion= cq.from(CabeceraAdopcion.class);
		cq.select(cabeceraAdopcion);
		
		return em.createQuery(cq).getResultList();	

	}
	
	public List<Tuple> listarTuple(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Tuple> cq = cb.createTupleQuery();
		Root<CabeceraAdopcion> cabeceraAdopcion = cq.from(CabeceraAdopcion.class);
		cq.select(cb.tuple(cabeceraAdopcion.get("idCabeceraAdopcion"), cabeceraAdopcion.get("fecha")));
		
		return em.createQuery(cq).getResultList();	
	}
}
