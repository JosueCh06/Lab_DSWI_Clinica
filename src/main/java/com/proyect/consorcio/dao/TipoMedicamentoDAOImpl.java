package com.proyect.consorcio.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.proyect.consorcio.entity.TipoMedicamento;

@Repository
public class TipoMedicamentoDAOImpl implements TipoMedicamentoDAO{

	@Autowired
	private SessionFactory factory;//Declarar
	
	@Transactional
	@Override
	public void registrar(TipoMedicamento bean) {
		// Crear una sesión de la conexion "factory"
		Session session = factory.getCurrentSession();
		try {
			session.save(bean);//insert into tb_tipo_medicamento values(null,'aaa');
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void actualizar(TipoMedicamento bean) {
		//Crear un sesión de la conexion "factory"
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
		//Crear un sesión de la conexion "factory"
		Session session = factory.getCurrentSession();
		try {
			TipoMedicamento obj = session.get(TipoMedicamento.class, cod);// select *from tb_tipo_medicamneto where cod_tipo=1
			session.delete(obj);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional(readOnly = true)//para la lectura de datos "SELECT"
	@Override
	public TipoMedicamento buscar(int cod) {
		//Crear un sesión de la conexion "factory"
		Session session = factory.getCurrentSession();
		TipoMedicamento obj = null;
		try {
			obj = session.get(TipoMedicamento.class, cod);// select *from tb_tipo_medicamneto where cod_tipo=1
		}catch(Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	@Transactional(readOnly = true)//para lectura de datos "SELECT"
	@Override
	public List<TipoMedicamento> listarTodos() {
		//Crear un sesión de la conexion "factory"
		Session session = factory.getCurrentSession();
		Query query = null;
		try {
			String hql = "Select tipo from TipoMedicamento tipo";//Select * from tb_tipo_medicamento
			query = session.createQuery(hql);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}

	@Transactional(readOnly = true)
	@Override
	public List<TipoMedicamento> listarTiposAtLaboratorio(int codLab) {
		//Crear un sesión de la conexion "factory"
		Session session = factory.getCurrentSession();
		Query query = null;
		try {
			String hql = "select tipo from TipoMedicamento tipo where tipo.laboratorio.codLab=?1";
			query = session.createQuery(hql);
			query.setParameter(1, codLab);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}
		
}
