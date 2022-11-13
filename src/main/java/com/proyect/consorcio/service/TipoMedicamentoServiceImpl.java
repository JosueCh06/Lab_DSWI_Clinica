package com.proyect.consorcio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyect.consorcio.dao.TipoMedicamentoDAO;
import com.proyect.consorcio.entity.TipoMedicamento;

@Service
public class TipoMedicamentoServiceImpl implements TipoMedicamentoService{

	@Autowired
	private TipoMedicamentoDAO tipoMedicamentoDAO;
	
	@Override
	public void registrar(TipoMedicamento bean) {
		tipoMedicamentoDAO.registrar(bean);
	}

	@Override
	public void actualizar(TipoMedicamento bean) {
		tipoMedicamentoDAO.actualizar(bean);
	}

	@Override
	public void eliminar(int cod) {
		tipoMedicamentoDAO.eliminar(cod);
	}

	@Override
	public List<TipoMedicamento> listarTodos() {
		return tipoMedicamentoDAO.listarTodos();
	}

	@Override
	public TipoMedicamento buscar(int cod) {
		return tipoMedicamentoDAO.buscar(cod);
	}

	@Override
	public List<TipoMedicamento> listarTipoAtLaboratorio(int codLab) {
		return tipoMedicamentoDAO.listarTiposAtLaboratorio(codLab);
	}

}
