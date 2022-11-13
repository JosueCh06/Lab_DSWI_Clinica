package com.proyect.consorcio.dao;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.proyect.consorcio.entity.Cliente;


@Repository
public class ClienteDAOImpl implements ClienteDAO{
	//inyectar la conexión a la base de datos
	@Autowired
	private SessionFactory factory;
	
	
	@Override
	@Transactional
	public void save(Cliente bean) {
		//obtener una session de la conexión(factory)
		Session session=factory.getCurrentSession();
		try {
			session.save(bean);//INSERT INTO
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void update(Cliente bean) {
		//obtener una session de la conexión(factory)
		Session session=factory.getCurrentSession();
		try {
			session.update(bean);//UPDATE
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public void delete(int cod) {
		//obtener una session de la conexión(factory)
		Session session=factory.getCurrentSession();
		try {
			Cliente bean=session.get(Cliente.class, cod);					
			session.delete(bean);//DELETE
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente find(int cod) {
		//obtener una session de la conexión(factory)
		Session session=factory.getCurrentSession();
		Cliente bean=null;
		try {
			bean=session.get(Cliente.class, cod);					
			session.delete(bean);//DELETE
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return bean;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> list() {
		//obtener una session de la conexión(factory)
		Session session=factory.getCurrentSession();
		Query query=null;
		try {
			String hql="select p from Cliente p";
			query=session.createQuery(hql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}
	
}
