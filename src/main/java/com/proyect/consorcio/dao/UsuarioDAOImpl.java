package com.proyect.consorcio.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyect.consorcio.entity.Enlace;
import com.proyect.consorcio.entity.Usuario;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO{
	
	@Autowired
	private SessionFactory factory;

	@Transactional(readOnly = true)
	@Override
	//public Usuario inicirSesion(String login, String clave) 
	public Usuario inicirSesion(String login){
		Usuario bean = null;
		Session session = factory.getCurrentSession();
		try {
			//String jpql = "select u from Usuario u where u.loginUsuario=?1 and u.claveUsuario=?2";
			String jpql = "select u from Usuario u where u.loginUsuario=?1";
			Query query = session.createQuery(jpql);
			query.setParameter(1, login);
			//query.setParameter(2, clave);
			List<Usuario> data = query.getResultList();
			if(!data.isEmpty())
				bean = (Usuario) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Enlace> traerEnlaces(int idRol) {
		List<Enlace> lista = null;
		Session session = factory.getCurrentSession();
		Query query = null;
		try {
			String jpql = "select e from Rol_Enlace re join re.enlace e where re.rol.idRol=?1";
			query = session.createQuery(jpql);
			query.setParameter(1, idRol);
			lista = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
