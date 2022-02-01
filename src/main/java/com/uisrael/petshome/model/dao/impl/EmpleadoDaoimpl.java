package com.uisrael.petshome.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.uisrael.petshome.model.dao.impl.GenericDaoImpl;
import com.uisrael.petshome.model.dao.EmpleadoDao;
import com.uisrael.petshome.model.entity.Empleado;
import com.uisrael.petshome.model.entity.Mascota;


public class EmpleadoDaoimpl extends GenericDaoImpl<Empleado> implements  EmpleadoDao{

	@Override
	public void insertar(Empleado empleado) {
		this.beginTransaction();
		this.create(empleado);
		this.commit();

	}

	@Override
	public void actualizar(Empleado empleado) {
		this.beginTransaction();
		this.update(empleado);
		this.commit();

	}

	@Override
	public void eliminar(Empleado empleado) {
		this.beginTransaction();
		this.delete(empleado);
		this.commit();


	}

	@Override
	public List<Empleado> listar() {
		
		return this.findAll();	
	}


	@Override
	public Empleado buscar(int id) {

		return this.read(id);
	}

	public List<Tuple> listarTuple(){
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> cq = cb.createTupleQuery();
		Root<Empleado> empleado = cq.from(Empleado.class);
		cq.select(cb.tuple(empleado.get("idEmpleado"), empleado.get("nombres"), empleado.get("apellidos")));			

		return this.entityManager.createQuery(cq).getResultList();	
	}

	@Override
	public Long  totalEmpleados(){
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Empleado> empleado = cq.from(Empleado.class);
		cq.select(cb.count(empleado.get("idEmpleado")));
		
		return this.entityManager.createQuery(cq).getSingleResult();	
	}
}
