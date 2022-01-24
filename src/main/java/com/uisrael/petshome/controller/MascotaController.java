package com.uisrael.petshome.controller;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.petshome.model.entity.Mascota;

public interface MascotaController {

	public void insertar(Mascota mascota);
	public void actualizar(Mascota mascota);
	public void eliminar(Mascota mascota);
	public List<Mascota> listar();
	public List<Tuple> listarTuple();
	public List<Tuple> totalMascotasPorTipo();
}
