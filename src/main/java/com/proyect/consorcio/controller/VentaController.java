package com.proyect.consorcio.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyect.consorcio.entity.Boleta;
import com.proyect.consorcio.entity.Cliente;
import com.proyect.consorcio.entity.Detalle;
import com.proyect.consorcio.entity.Medicamento;
import com.proyect.consorcio.entity.MedicamentoHasBoleta;
import com.proyect.consorcio.entity.Usuario;
import com.proyect.consorcio.service.BoletaService;
import com.proyect.consorcio.service.ClienteService;
import com.proyect.consorcio.service.MedicamentoService;

@Controller
@RequestMapping("/venta")
public class VentaController {
	
	@Autowired
	private BoletaService boletaService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private MedicamentoService medicamentoService;
	
	@RequestMapping("/")
	public String index(Model model, HttpSession session) {
		List<Detalle> lista;
		if(session.getAttribute("detalle")==null)
			lista = new ArrayList<Detalle>();
		else
			lista = (List<Detalle>) session.getAttribute("detalle");
		model.addAttribute("clientes",clienteService.list());
		model.addAttribute("medicamentos",medicamentoService.listarTodos());
		model.addAttribute("listaDetalles", lista);
		return "boleta";
	}
	
	@RequestMapping("/adicionar")
	@ResponseBody
	public List<Detalle> adicionar(@RequestParam("codigo")int cod, 
							@RequestParam("nombre")String nom,
							@RequestParam("cantidad")int can,
							@RequestParam("precio")double pre,
							HttpSession session) {
		//Declarar arreglo de objetos
		List<Detalle> lista;
		//Validar si existe el atributo "detalle" dentro de "session"
		if(session.getAttribute("detalle")==null)
			lista = new ArrayList<Detalle>();
		else//Recuperar el atributo
			lista = (List<Detalle>) session.getAttribute("detalle");
		//Crear objeto de la clase Detalle
		Detalle det = new Detalle();
		//Asignar valor a los atributos del objeto "det" con los parámetros
		det.setCodigo(cod);
		det.setNombre(nom);
		det.setCantidad(can);
		det.setPrecio(pre);
		//Adicionar objeto "det" dentro de "lista"
		lista.add(det);
		//Crear o actualizar atributo "detalle"
		session.setAttribute("detalle", lista);
		
		return lista;
	}
	
	@RequestMapping("/eliminar")
	@ResponseBody
	public List<Detalle> eliminar(@RequestParam("codigo")int cod, HttpSession session) {
		List<Detalle> lista = (List<Detalle>) session.getAttribute("detalle");
		for(Detalle det : lista) {
			if(det.getCodigo()==cod) {
				lista.remove(det);
				break;
			}
		}
		//actualizar atributo "detalle"
		session.setAttribute("detalle", lista);
		return lista;
	}
	
	@RequestMapping("/grabar")
	public String grabar(HttpSession session, 
						 @RequestParam("codigoCliente")int codCli, 
						 RedirectAttributes redirect,
						 @RequestParam("total")double total) {
		try {
			//Cabezera
			Boleta bean = new Boleta();
			bean.setFechaEmision(new Date());
			bean.setMonto(total);
			//Usuario
			Usuario u;
			u = (Usuario) session.getAttribute("usuario");
			bean.setUsuario(u);
			//Cliente
			Cliente c = new Cliente();
			c.setCodigo(codCli);
			//
			bean.setCliente(c);
			//Detalle
			//Recuperar lista de detalle
			List<Detalle> lista = (List<Detalle>) session.getAttribute("detalle");
			//Arreglo de objetos
			List<MedicamentoHasBoleta> datos = new ArrayList<MedicamentoHasBoleta>();
			//Bucle
			for(Detalle d : lista) {
				MedicamentoHasBoleta mhb = new MedicamentoHasBoleta();
				mhb.setMedicamento(new Medicamento(d.getCodigo()));
				mhb.setPrecio(d.getPrecio());
				mhb.setCantidad(d.getCantidad());
				datos.add(mhb);
			}
			bean.setListaMedicamentoHasBoleta(datos);
			//
			boletaService.saveBoleta(bean);
			//
			lista.clear();
			session.setAttribute("detalle", lista);
			redirect.addFlashAttribute("MENSAJE", "Boleta registrada...");
		}catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE", "Error en el registro...");
		}
		return "redirect:/venta/";
	}

}
