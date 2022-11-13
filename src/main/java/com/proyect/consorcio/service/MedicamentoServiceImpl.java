package com.proyect.consorcio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyect.consorcio.dao.MedicamentoDAO;
import com.proyect.consorcio.entity.Medicamento;

@Service
public class MedicamentoServiceImpl implements MedicamentoService{

	@Autowired
	private MedicamentoDAO medicamentoDAO;
	
	@Override
	public void registrar(Medicamento bean) {
		medicamentoDAO.registrar(bean);
	}

	@Override
	public void actualizar(Medicamento bean) {
		medicamentoDAO.actualizar(bean);
	}

	@Override
	public void eliminar(int cod) {
		medicamentoDAO.eliminar(cod);
	}

	@Override
	public Medicamento buscar(int cod) {
		return medicamentoDAO.buscar(cod);
	}

	@Override
	public List<Medicamento> listarTodos() {
		return medicamentoDAO.listarTodos();
	}
	

	
}
