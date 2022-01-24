package com.uisrael.petshome.controller;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.petshome.model.entity.CabeceraAdopcion;

public interface CabeceraAdopcionController {
	public void insertar(CabeceraAdopcion cabeceraAdopcion);
	public void actualizar(CabeceraAdopcion cabeceraAdopcion);
	public void eliminar(CabeceraAdopcion cabeceraAdopcion);
	public List<CabeceraAdopcion> listar();
	public List<Tuple> listarTuple();

}
