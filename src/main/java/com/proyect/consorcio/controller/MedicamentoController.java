package com.proyect.consorcio.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyect.consorcio.dao.LaboratorioDAO;
import com.proyect.consorcio.entity.Laboratorio;
import com.proyect.consorcio.entity.Medicamento;
import com.proyect.consorcio.entity.TipoMedicamento;
import com.proyect.consorcio.service.LaboratorioService;
import com.proyect.consorcio.service.MedicamentoService;
import com.proyect.consorcio.service.TipoMedicamentoService;

@Controller
@RequestMapping(value = "/medicamento")
public class MedicamentoController {
	
	@Autowired
	private MedicamentoService medicamentoService;
	
	@Autowired
	private TipoMedicamentoService tipoMedicamentoService;
	
	@Autowired
	private LaboratorioService laboratorioService;
	
	//
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "/generar")
	public String generar(Model model) {
		System.out.println(passwordEncoder.encode("123"));
		return "";
	}
	
	
	@RequestMapping(value = "/")
	public String index(Model model) {
		// crear atributos
		model.addAttribute("medicamentos", medicamentoService.listarTodos());
		model.addAttribute("laboratorios", laboratorioService.listAll());
		return "medicamento";
	}
	
	@RequestMapping(value = "/guardar")
	public String guardar(@RequestParam("codigo")int cod, 
						  @RequestParam("nombre")String nomb,
						  @RequestParam("descripcion")String desc,
						  @RequestParam("stock")int stock,
						  @RequestParam("precio")double pre,
						  @RequestParam("fecha")String fecha,
						  @RequestParam("tipo")int codTipo,
						  RedirectAttributes redirect) {
		try {
			//Crear un objeto de la clase Medicamento
			Medicamento bean = new Medicamento();
			//Setear
			bean.setNomMed(nomb);
			bean.setDesMed(desc);
			bean.setStoMed(stock);
			bean.setPreMed(pre);
			bean.setFecFabMed(new SimpleDateFormat("yyyy-MM-dd").parse(fecha));
			bean.setTipoMedicamento(new TipoMedicamento(codTipo));
			//Validar cod
			if(cod!=0) {
				bean.setCodMed(cod);
				medicamentoService.actualizar(bean);
				redirect.addFlashAttribute("MENSAJE","Medicamento actualizado...");
			}
			else {
				medicamentoService.registrar(bean);
				redirect.addFlashAttribute("MENSAJE","Medicamento guardado...");
			}
		}catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE","Error al guardar medicamento...");
			e.printStackTrace();
		}
		return "redirect:/medicamento/";
	}
	
	@RequestMapping(value = "/buscar")
	@ResponseBody
	public Medicamento buscar(@RequestParam("codigo")int cod) {
		Medicamento bean = null;
		try {
			bean = medicamentoService.buscar(cod);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	@RequestMapping(value="/eliminar")
	public String eliminar(@RequestParam("codigo") int cod, RedirectAttributes redirect) {
		try {
			medicamentoService.eliminar(cod);
			redirect.addFlashAttribute("MENSAJE","Medicamento eliminado...");
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE","Error al eliminar...");
		}
		return "redirect:/medicamento/";
	}
	
	@RequestMapping(value = "/listarTipoAtLaboratorio")
	@ResponseBody
	public List<TipoMedicamento> listarTipoAtLaboratorio(@RequestParam("codLab") int codigo){
		List<TipoMedicamento> lista = null;
		try {
			lista = tipoMedicamentoService.listarTipoAtLaboratorio(codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
}
