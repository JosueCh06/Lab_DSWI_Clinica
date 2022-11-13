package com.proyect.consorcio.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyect.consorcio.entity.Laboratorio;

@Repository
public class LaboratorioDAOImpl implements LaboratorioDAO{

	@Autowired
	private SessionFactory factory;

	@Transactional(readOnly = true)
	@Override
	public List<Laboratorio> listAll() {
		//jpql===>hql
		Session session = factory.getCurrentSession();
		Query query = null;
		try {
			String jpql = "select lab from Laboratorio lab";
			query=session.createQuery(jpql);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}
	
}
