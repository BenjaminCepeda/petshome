package com.uisrael.petshome.model.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.uisrael.petshome.model.dao.GenericDao;


public abstract class GenericDaoImpl <T>  implements GenericDao <T>{

	protected static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PUPetshome");
	protected EntityManager entityManager;

	private Class<T> entityClass;
	
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        entityClass = (Class<T>) pt.getActualTypeArguments()[0];		
		entityManager = emf.createEntityManager();//crear conexion
	}

	public GenericDaoImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
		entityManager = emf.createEntityManager();
	}

	// Definimos el CRUD
	@Override
	public T create(T t) {
		this.entityManager.persist(t);
		return t;
	}

	@Override
	public T read(Object id) {
		return this.entityManager.find(entityClass, id);
	}

	@Override
	public T update(T t) {
		return this.entityManager.merge(t);
	}

	@Override
	public void delete(T t) {
		t = this.entityManager.merge(t);
		this.entityManager.remove(t);
	}

	// Definir los par�metros
	@Override
	public void beginTransaction() {
		if (!entityManager.getTransaction().isActive()) //existe conexion activa
			entityManager = emf.createEntityManager(); //crear conexion

		entityManager.getTransaction().begin(); //inicializar transacci�n
	}

	@Override
	public void commit() {
		if (entityManager.getTransaction().isActive())
			entityManager.getTransaction().commit();
	}

	@Override
	public void rollback() {
		if (entityManager.getTransaction().isActive())
			entityManager.getTransaction().rollback();
	}

	@Override
	public void closeTransaction() {
		entityManager.close();
	}

	@Override
	public void commitAndCloseTransaction() {
		commit();
		closeTransaction();
	}

	@Override
	public void flush() {
		entityManager.flush();
	}

	@Override
	public List<T> findAll() {
		javax.persistence.criteria.CriteriaQuery cq = this.entityManager.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return this.entityManager.createQuery(cq).getResultList();
	}


}
