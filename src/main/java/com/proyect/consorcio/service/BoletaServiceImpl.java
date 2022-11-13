package com.proyect.consorcio.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyect.consorcio.dao.BoletaDAO;
import com.proyect.consorcio.entity.Boleta;
import com.proyect.consorcio.entity.MedicamentoHasBoleta;

@Service
public class BoletaServiceImpl implements BoletaService{
	
	@Autowired
	private BoletaDAO boletaDAO;
	
	@Override
	public void saveBoleta(Boleta bean) {
		boletaDAO.saveBoleta(bean);
		
	}

	@Override
	public Boleta BuscarBoletaPorNumero(int num) {
		return boletaDAO.BuscarBoletaPorNumero(num);
	}

	@Override
	public List<MedicamentoHasBoleta> BuscarDetallePorNumero(int num) {
		return boletaDAO.BuscarDetallePorNumero(num);
	}

}
