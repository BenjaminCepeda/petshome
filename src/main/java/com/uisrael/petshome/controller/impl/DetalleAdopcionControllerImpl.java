package com.uisrael.petshome.controller.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.petshome.controller.DetalleAdopcionController;
import com.uisrael.petshome.model.dao.DetalleAdopcionDao;
import com.uisrael.petshome.model.dao.impl.DetalleAdopcionDaoImpl;
import com.uisrael.petshome.model.entity.DetalleAdopcion;

public class DetalleAdopcionControllerImpl implements DetalleAdopcionController {

	private DetalleAdopcionDao detalleAdopcionDao = new DetalleAdopcionDaoImpl();
	@Override
	public void insertar(DetalleAdopcion detalleAdopcion) {
		detalleAdopcionDao.insertar(detalleAdopcion);

	}

	@Override
	public void actualizar(DetalleAdopcion detalleAdopcion) {
		detalleAdopcionDao.actualizar(detalleAdopcion);

	}

	@Override
	public void eliminar(DetalleAdopcion detalleAdopcion) {
		detalleAdopcionDao.eliminar(detalleAdopcion);

	}

	@Override
	public List<DetalleAdopcion> listar(int id) {
		return detalleAdopcionDao.listar(id);
	}

	@Override
	public List<Tuple> listarTuple(int id) {
		return detalleAdopcionDao.listarTuple(id);
	}
}
