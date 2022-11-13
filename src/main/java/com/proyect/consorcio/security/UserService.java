package com.proyect.consorcio.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.proyect.consorcio.dao.UsuarioDAO;
import com.proyect.consorcio.entity.Usuario;

@Service
public class UserService implements UserDetailsService{

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails userDet = null;
		Usuario bean = null;
		bean = usuarioDAO.inicirSesion(username);
		Set<GrantedAuthority>authorities = new HashSet<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(bean.getRol().getDesRol()));
		userDet = new User(username, bean.getClaveUsuario(), authorities);
		return userDet;
	}

}
