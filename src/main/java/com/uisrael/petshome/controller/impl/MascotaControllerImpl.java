package com.uisrael.petshome.controller.impl;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.petshome.controller.MascotaController;
import com.uisrael.petshome.model.dao.MascotaDao;
import com.uisrael.petshome.model.dao.impl.MascotaDaoImpl;
import com.uisrael.petshome.model.entity.Mascota;

public class MascotaControllerImpl implements MascotaController {
	private MascotaDao mascotaDao = new MascotaDaoImpl(); 
	
	@Override
	public void insertar(Mascota mascota) {
		mascotaDao.insertar(mascota);

	}

	@Override
	public void actualizar(Mascota mascota) {
		mascotaDao.actualizar(mascota);

	}

	@Override
	public void eliminar(Mascota mascota) {
		mascotaDao.eliminar(mascota);

	}

	@Override
	public List<Mascota> listar() {

		return mascotaDao.listar();
	}

	public Mascota buscar(int id) {
		return mascotaDao.buscar(id);
	}
	
	@Override
	public List<Tuple> listarTuple() {
		return mascotaDao.listarTuple();
	}

	@Override
	public List<Tuple> totalMascotasPorTipo() {
		// TODO Auto-generated method stub
		return mascotaDao.totalMascotasPorTipo();
	}

}
