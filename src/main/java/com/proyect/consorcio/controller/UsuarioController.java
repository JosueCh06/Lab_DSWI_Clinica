package com.proyect.consorcio.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyect.consorcio.entity.Enlace;
import com.proyect.consorcio.entity.Usuario;
import com.proyect.consorcio.service.UsuarioService;

@Controller
//@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/login")
	public String inicio() {
		return "login";
	}
	
	@RequestMapping(value = "/menu")
	public String menu(Authentication auth, Model model, HttpSession session) {
		//recuperar nombre de usuario
		String nombUsu = auth.getName();
		//Invocar al metodo iniciarSesion
		Usuario bean = usuarioService.inicirSesion(nombUsu);
		session.setAttribute("usuario", bean);
		//Traer enlaces según rol
		List<Enlace> lista = usuarioService.traerEnlaces(bean.getRol().getIdRol());
		model.addAttribute("menus",lista);
		return "menu";
	}
	
	/*
	@RequestMapping(value = "/session")
	public String session() {
		Usuario bean;
		//Iniciar sesión
		//bean = usuarioService.inicirSesion("maria", "maria145");
		bean = usuarioService.inicirSesion("maria");
		if(bean != null) {
			//Traer enlaces según rol
			List<Enlace> lista = usuarioService.traerEnlaces(bean.getRol().getIdRol());
			//Imprimir
			System.out.println(bean.getCodUsuario());
			for(Enlace e:lista)
				System.out.println(e.getIdEnlace() + "----" + e.getDesEnlace() + "----" + e.getRutaEnlace());
		}
		return "";
	}*/
	
}
