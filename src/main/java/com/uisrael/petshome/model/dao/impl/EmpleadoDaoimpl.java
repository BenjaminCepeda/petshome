package com.uisrael.petshome.model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.uisrael.petshome.model.dao.EmpleadoDao;
import com.uisrael.petshome.model.entity.Empleado;
import com.uisrael.petshome.model.entity.Mascota;


public class EmpleadoDaoimpl implements EmpleadoDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PUPetshome");
	private EntityManager em = emf.createEntityManager();

	@Override
	public void insertar(Empleado empleado) {
		em.getTransaction().begin();
		em.persist(empleado);
		em.getTransaction().commit();


	}

	@Override
	public void actualizar(Empleado empleado) {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Empleado> listar() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Empleado> cq = cb.createQuery(Empleado.class);
		Root<Empleado> empleado= cq.from(Empleado.class);
		cq.select(empleado);
		
		return em.createQuery(cq).getResultList();	
	}

	@Override
	public List<Tuple> listarTuple(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Tuple> cq = cb.createTupleQuery();
		Root<Empleado> empleado = cq.from(Empleado.class);
		cq.select(cb.tuple(empleado.get("idEmpleado"), empleado.get("nombres"), empleado.get("apellidos")));
		
		return em.createQuery(cq).getResultList();	
	}

	@Override
	public Long  totalEmpleados(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<Empleado> empleado = cq.from(Empleado.class);
		cq.select(cb.count(empleado.get("idEmpleado")));
		
		return em.createQuery(cq).getSingleResult();	
	}
}
