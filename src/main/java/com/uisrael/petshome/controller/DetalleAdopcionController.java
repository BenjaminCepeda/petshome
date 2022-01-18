package com.uisrael.petshome.controller;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.petshome.model.entity.DetalleAdopcion;

public interface DetalleAdopcionController {
	public void insertar(DetalleAdopcion detalleAdopcion);
	public void actualizar(DetalleAdopcion detalleAdopcion);
	public void eliminar(int id);
	public List<DetalleAdopcion> listar(int id);
	public List<Tuple> listarTuple(int id);

}
