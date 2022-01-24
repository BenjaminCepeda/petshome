package com.uisrael.petshome.model.dao;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.petshome.model.entity.DetalleAdopcion;

public interface DetalleAdopcionDao {
	public void insertar(DetalleAdopcion detalleAdopcion);
	public void actualizar(DetalleAdopcion detalleAdopcion);
	public void eliminar(DetalleAdopcion detalleAdopcion);
	public List<DetalleAdopcion> listar(int id);
	public List<Tuple> listarTuple(int id);
}
