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

public class DetalleAdopcionDaoImpl extends GenericDaoImpl<DetalleAdopcion> implements DetalleAdopcionDao {


	@Override
	public void insertar(DetalleAdopcion detalleAdopcion) {
		this.beginTransaction();
		this.create(detalleAdopcion);
		this.commit();

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
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<DetalleAdopcion> cq = cb.createQuery(DetalleAdopcion.class);
		Root<DetalleAdopcion> detalleAdopcion= cq.from(DetalleAdopcion.class);
		cq.select(detalleAdopcion).where(cb.equal(detalleAdopcion.get("fkCabeceraAdopcion").get("idCabeceraAdopcion"), id));

		return this.entityManager.createQuery(cq).getResultList();	
	}
	
	@Override
	public List<Tuple> listarTuple(int id){
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> cq = cb.createTupleQuery();
		Root<DetalleAdopcion> detalleAdopcion = cq.from(DetalleAdopcion.class);
		cq.select(cb.tuple(detalleAdopcion.get("observacion"),detalleAdopcion.get("fkMascota"))).
			where(cb.equal(detalleAdopcion.get("fkCabeceraAdopcion").get("idCabeceraAdopcion"), id));
		
		return this.entityManager.createQuery(cq).getResultList();	
	}
}
