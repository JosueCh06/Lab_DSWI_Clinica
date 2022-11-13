package com.proyect.consorcio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyect.consorcio.dao.UsuarioDAO;
import com.proyect.consorcio.entity.Enlace;
import com.proyect.consorcio.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Override
	//public Usuario inicirSesion(String login, String clave)
	public Usuario inicirSesion(String login) {
		// TODO Auto-generated method stub
		return usuarioDAO.inicirSesion(login);
	}

	@Override
	public List<Enlace> traerEnlaces(int idRol) {
		// TODO Auto-generated method stub
		return usuarioDAO.traerEnlaces(idRol);
	}
	

}
