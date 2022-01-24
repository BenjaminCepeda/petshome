package com.uisrael.petshome.model.dao;

import java.util.List;

import javax.persistence.Tuple;

import com.uisrael.petshome.model.entity.CabeceraAdopcion;
import com.uisrael.petshome.model.entity.DetalleAdopcion;

public interface CabeceraAdopcionDao {
	public void insertar(CabeceraAdopcion cabeceraAdopcion);
	public void actualizar(CabeceraAdopcion cabeceraAdopcion);
	public void eliminar(CabeceraAdopcion cabeceraAdopcion);
	public List<CabeceraAdopcion> listar();
	public List<Tuple> listarTuple();
}
