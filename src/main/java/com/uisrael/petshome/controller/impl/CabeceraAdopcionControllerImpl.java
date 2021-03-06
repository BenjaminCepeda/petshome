package com.uisrael.petshome.controller.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.petshome.controller.CabeceraAdopcionController;
import com.uisrael.petshome.model.dao.CabeceraAdopcionDao;
import com.uisrael.petshome.model.dao.impl.CabeceraAdopcionDaoImpl;
import com.uisrael.petshome.model.entity.CabeceraAdopcion;

public class CabeceraAdopcionControllerImpl implements CabeceraAdopcionController {

	CabeceraAdopcionDao cabeceraAdopcionDao = new CabeceraAdopcionDaoImpl(); 
	
	@Override
	public void insertar(CabeceraAdopcion cabeceraAdopcion) {
		cabeceraAdopcionDao.insertar(cabeceraAdopcion);

	}

	@Override
	public void actualizar(CabeceraAdopcion cabeceraAdopcion) {
		cabeceraAdopcionDao.actualizar(cabeceraAdopcion);

	}

	@Override
	public void eliminar(CabeceraAdopcion cabeceraAdopcion) {
		cabeceraAdopcionDao.eliminar(cabeceraAdopcion);

	}

	@Override
	public List<CabeceraAdopcion> listar() {

		return cabeceraAdopcionDao.listar();
	}

	@Override
	public List<Tuple> listarTuple() {
		return cabeceraAdopcionDao.listarTuple();
	}

}
