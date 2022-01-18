package com.uisrael.petshome.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.uisrael.petshome.model.dao.DetalleAdopcionDao;
import com.uisrael.petshome.model.entity.CabeceraAdopcion;
import com.uisrael.petshome.model.entity.DetalleAdopcion;

public class DetalleAdopcionDaoImpl implements DetalleAdopcionDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PUPetshome");
	private EntityManager em = emf.createEntityManager();

	@Override
	public void insertar(DetalleAdopcion detalleAdopcion) {
		em.getTransaction().begin();
		em.persist(detalleAdopcion);
		em.getTransaction().commit();

	}

	@Override
	public void actualizar(DetalleAdopcion detalleAdopcion) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DetalleAdopcion> listar(int id) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<DetalleAdopcion> cq = cb.createQuery(DetalleAdopcion.class);
		Root<DetalleAdopcion> detalleAdopcion= cq.from(DetalleAdopcion.class);
		cq.select(detalleAdopcion).where(cb.equal(detalleAdopcion.get("fkCabeceraAdopcion").get("idCabeceraAdopcion"), id));

		return em.createQuery(cq).getResultList();	
	}
	
	@Override
	public List<Tuple> listarTuple(int id){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Tuple> cq = cb.createTupleQuery();
		Root<DetalleAdopcion> detalleAdopcion = cq.from(DetalleAdopcion.class);
		cq.select(cb.tuple(detalleAdopcion.get("observacion"),detalleAdopcion.get("fkMascota"))).
			where(cb.equal(detalleAdopcion.get("fkCabeceraAdopcion").get("idCabeceraAdopcion"), id));
		
		return em.createQuery(cq).getResultList();	
	}
}
