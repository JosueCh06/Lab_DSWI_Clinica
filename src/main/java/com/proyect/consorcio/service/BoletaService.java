package com.proyect.consorcio.service;

import java.util.List;

import com.proyect.consorcio.entity.Boleta;
import com.proyect.consorcio.entity.MedicamentoHasBoleta;

public interface BoletaService {
	
	public void saveBoleta(Boleta bean);
	public Boleta BuscarBoletaPorNumero(int num);
	public List<MedicamentoHasBoleta> BuscarDetallePorNumero(int num);
}
