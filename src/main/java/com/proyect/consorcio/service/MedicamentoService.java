package com.proyect.consorcio.service;

import java.util.List;

import com.proyect.consorcio.entity.Medicamento;

public interface MedicamentoService {
	public void registrar(Medicamento bean);
	public void actualizar(Medicamento bean);
	public void eliminar(int cod);
	public Medicamento buscar(int cod);
	public List<Medicamento> listarTodos();
}
