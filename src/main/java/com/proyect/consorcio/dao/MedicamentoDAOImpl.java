package com.proyect.consorcio.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyect.consorcio.entity.Medicamento;

@Repository
public class MedicamentoDAOImpl implements MedicamentoDAO{

	@Autowired
	private SessionFactory factory;
	
	@Transactional
	@Override
	public void registrar(Medicamento bean) {
		Session session = factory.getCurrentSession();
		try {
			session.save(bean);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void actualizar(Medicamento bean) {
		Session session = factory.getCurrentSession();
		try {
			session.update(bean);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void eliminar(int cod) {
		Session session = factory.getCurrentSession();
		try {
			Medicamento bean = session.get(Medicamento.class,cod);
			session.delete(bean);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional(readOnly = true)
	@Override
	public Medicamento buscar(int cod) {
		Session session = factory.getCurrentSession();
		Medicamento bean = null;
		try {
			bean = session.get(Medicamento.class,cod);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bean;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Medicamento> listarTodos() {
		Session session = factory.getCurrentSession();
		Query query = null;
		try {
			query = session.createQuery("Select m from Medicamento m");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

}
