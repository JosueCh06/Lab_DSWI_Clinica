package com.proyect.consorcio.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.proyect.consorcio.entity.Boleta;
import com.proyect.consorcio.entity.MedicamentoHasBoleta;
import com.proyect.consorcio.entity.MedicamentoHasBoletaPK;

@Repository
public class BoletaDAOImpl implements BoletaDAO{
	
	@Autowired
	private SessionFactory factory;

	@Transactional
	@Override
	public void saveBoleta(Boleta bean) {
		Session session = factory.getCurrentSession();
		try {
			//Guardar cabecera "tb_boleta"
			session.save(bean);
			//Guardar detalle
			//Bucle
			for(MedicamentoHasBoleta mhb : bean.getListaMedicamentoHasBoleta()) {
				//Llave
				MedicamentoHasBoletaPK pk = new MedicamentoHasBoletaPK();
				pk.setNumeroBoleta(bean.getNumeroBoleta());
				pk.setCodigoMedicamento(mhb.getMedicamento().getCodMed());
				mhb.setPk(pk);
				session.save(mhb);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional(readOnly = true)
	@Override
	public Boleta BuscarBoletaPorNumero(int num) {
		Session session = factory.getCurrentSession();
		Query query = null;
		try {
			String hql = "select b from Boleta b where b.numeroBoleta =? 1";
			query = session.createQuery(hql);
			query.setParameter(1, num);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return (Boleta) query.getSingleResult();
	}

	@Transactional(readOnly = true)
	@Override
	public List<MedicamentoHasBoleta> BuscarDetallePorNumero(int num) {
		Session session = factory.getCurrentSession();
		Query query = null;
		try {
			String hql = "select mhb from MedicamentoHasBoleta mhb where mhb.boleta =? 1";
			query = session.createQuery(hql);
			query.setParameter(1, num);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return query.getResultList();
	}
	
}









