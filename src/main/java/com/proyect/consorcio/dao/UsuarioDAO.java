package com.proyect.consorcio.dao;

import java.util.List;
import com.proyect.consorcio.entity.Enlace;
import com.proyect.consorcio.entity.Usuario;

public interface UsuarioDAO {
	//public Usuario inicirSesion(String login, String clave);
	public Usuario inicirSesion(String login);
	public List<Enlace> traerEnlaces(int idRol);
}
