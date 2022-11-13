package com.proyect.consorcio.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyect.consorcio.entity.Enlace;

@Repository
public class RolDAOImpl implements RolDAO{

	@Autowired
	private SessionFactory factory;
	
	@Transactional(readOnly = true)
	@Override
	public List<Enlace> listAllEnlacesAtRol(int codRol) {
		Query query= null;
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}
	
}
