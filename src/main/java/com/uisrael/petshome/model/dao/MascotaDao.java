package com.uisrael.petshome.model.dao;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.petshome.model.entity.Mascota;

public interface MascotaDao {
	public void insertar(Mascota mascota);
	public void actualizar(Mascota mascota);
	public void eliminar(int id);
	public List<Mascota> listar();
	public List<Tuple> listarTuple();
	public List<Tuple> totalMascotasPorTipo();
}
