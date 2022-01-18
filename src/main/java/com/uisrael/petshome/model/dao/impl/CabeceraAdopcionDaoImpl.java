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


public class CabeceraAdopcionDaoImpl extends GenericDaoImpl<CabeceraAdopcion> implements CabeceraAdopcionDao {


	@Override
	public void insertar(CabeceraAdopcion cabeceraAdopcion) {
		this.beginTransaction();
		this.create(cabeceraAdopcion);
		this.commit();
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
		
		return this.findAll();	

	}
	
	public List<Tuple> listarTuple(){
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> cq = cb.createTupleQuery();
		Root<CabeceraAdopcion> cabeceraAdopcion = cq.from(CabeceraAdopcion.class);
		cq.select(cb.tuple(cabeceraAdopcion.get("idCabeceraAdopcion"), cabeceraAdopcion.get("fecha")));
		
		return this.entityManager.createQuery(cq).getResultList();	
	}
}
