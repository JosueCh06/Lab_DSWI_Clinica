package com.proyect.consorcio.dao;

import java.util.List;

import com.proyect.consorcio.entity.Enlace;

public interface RolDAO {
	public List<Enlace> listAllEnlacesAtRol(int codRol);
}
