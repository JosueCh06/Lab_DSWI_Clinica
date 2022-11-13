package com.proyect.consorcio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyect.consorcio.entity.TipoMedicamento;
import com.proyect.consorcio.service.TipoMedicamentoService;

@Controller
@RequestMapping(value = "/tipo")
public class TipoMedicamentoController {

	@Autowired
	private TipoMedicamentoService tipoMedicamentoService;
	
	@RequestMapping(value = "/registar")//Es una ruta
	public String registrar() {
		
		TipoMedicamento bean = new TipoMedicamento();
		bean.setNomTipo("prueba11111");
		tipoMedicamentoService.registrar(bean);
		return "tipoMedicamento";
	}
	
}
