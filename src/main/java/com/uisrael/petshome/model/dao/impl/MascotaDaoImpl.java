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



public class MascotaDaoImpl extends GenericDaoImpl<Mascota> implements MascotaDao {


	
	@Override
	public void insertar(Mascota mascota) {
		this.beginTransaction();
		this.create(mascota);
		this.commit();
		
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
		return this.findAll();
	}

	@Override
	public List<Tuple> listarTuple(){
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> cq = cb.createTupleQuery();
		Root<Mascota> mascota = cq.from(Mascota.class);
		cq.select(cb.tuple(mascota.get("idMascota"), mascota.get("nombre")));
		
		return this.entityManager.createQuery(cq).getResultList();	
	}

	@Override
	public List<Tuple> totalMascotasPorTipo() {
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> cq = cb.createTupleQuery();
		Root<Mascota> mascota = cq.from(Mascota.class);
		cq.multiselect(mascota.get("tipo"),cb.count(mascota.get("idMascota")));
		cq.groupBy(mascota.get("tipo"));
		
		return this.entityManager.createQuery(cq).getResultList();	
	}
}
