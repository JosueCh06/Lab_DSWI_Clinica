package com.proyect.consorcio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyect.consorcio.dao.LaboratorioDAO;
import com.proyect.consorcio.entity.Laboratorio;

@Service
public class LaboratorioServiceImpl implements LaboratorioService{

	@Autowired
	private LaboratorioDAO laboratorioDAO;

	@Override
	public List<Laboratorio> listAll() {
		return laboratorioDAO.listAll();
	}
}
