package com.proyect.consorcio.service;

import java.util.List;

import com.proyect.consorcio.entity.TipoMedicamento;

public interface TipoMedicamentoService {

	public void registrar(TipoMedicamento bean);
	public void actualizar(TipoMedicamento bean);
	public void eliminar(int cod);
	public TipoMedicamento buscar(int cod);
	public List<TipoMedicamento> listarTodos();
	
	public List<TipoMedicamento> listarTipoAtLaboratorio(int codLab);
	
}
