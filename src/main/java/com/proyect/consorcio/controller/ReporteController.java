package com.proyect.consorcio.controller;

import java.io.File;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyect.consorcio.entity.Boleta;
import com.proyect.consorcio.entity.Cliente;
import com.proyect.consorcio.entity.Medicamento;
import com.proyect.consorcio.entity.MedicamentoHasBoleta;
import com.proyect.consorcio.service.BoletaService;
import com.proyect.consorcio.service.ClienteService;
import com.proyect.consorcio.service.MedicamentoService;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping("/reporte")
public class ReporteController {
	
	@Autowired
	private MedicamentoService medicamentoService;
	
	@Autowired
	private BoletaService boletaService;
	
	@RequestMapping("/medicamentos")
	public void medicamentos(HttpServletResponse response) {
		try {
			//Invocar al método
			List<Medicamento> lista = medicamentoService.listarTodos();
			//Obtener ruta del archivo de reporte "reporteMedicamentos.jrxml"
			File file = ResourceUtils.getFile("classpath:ReporteMedicametos.jrxml");
			//Crear un objeto de la clase JasperReport y referenciar el objeto file
			JasperReport jasper = JasperCompileManager.compileReport(file.getAbsolutePath());
			//Origen de datos
			JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(lista);
			//Reporte en print
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, null, data);
			//Formato de salida PDF
			response.setContentType("application/pdf");
			//Objeto de salida
			OutputStream salida = response.getOutputStream();
			//Exportar a PDF
			JasperExportManager.exportReportToPdfStream(jasperPrint, salida);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	@RequestMapping("/reporteBoleta")
	public void reporteBoleta(HttpServletResponse response, @RequestParam("numero")int num) {
		try {
			//Invocar al método
			List<MedicamentoHasBoleta> lista = boletaService.BuscarDetallePorNumero(num);
			//Obtener ruta del archivo de reporte "reporteMedicamentos.jrxml"
			File file = ResourceUtils.getFile("classpath:ReporteBoleta.jrxml");
			//Crear un objeto de la clase JasperReport y referenciar el objeto file
			JasperReport jasper = JasperCompileManager.compileReport(file.getAbsolutePath());
			//Origen de datos
			JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(lista);
			//Reporte en print
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, null, data);
			//Formato de salida PDF
			response.setContentType("application/pdf");
			//Objeto de salida
			OutputStream salida = response.getOutputStream();
			//Exportar a PDF
			JasperExportManager.exportReportToPdfStream(jasperPrint, salida);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	@RequestMapping("/boletaPorNumero")
	public String boletaPorNumero(@RequestParam("numero")int num) {
		try {
			List<MedicamentoHasBoleta> data = boletaService.BuscarBoletaPorNumero(num);
			//Cabezera
			System.out.println(bol.getNumeroBoleta()+"---"+bol.getCliente()+"---"+bol.getCliente().getNombre()+"---"+
			bol.getUsuario().getCodUsuario());
			//Detalle
			List<MedicamentoHasBoleta> lista = bol.getListaMedicamentoHasBoleta();
			for(MedicamentoHasBoleta mhb : lista) {
				System.out.println(mhb.getMedicamento().getCodMed());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	@RequestMapping("/boletaPorNumero2")
	public String boletaPorNumero2(@RequestParam("numero")int num) {
		try {
			List<MedicamentoHasBoleta> data = boletaService.BuscarDetallePorNumero(num);
			//Imprimir cabecera y detalle
			for(MedicamentoHasBoleta mhb : data)
				System.out.println(mhb.getBoleta().getNumeroBoleta()+"---"+
								   mhb.getBoleta().getCliente().getCodigo()+"---"+
								   mhb.getBoleta().getCliente().getNombre()+"---"+
								   mhb.getBoleta().getUsuario().getCodUsuario()+"---"+
								   mhb.getMedicamento().getCodMed()+"---"+
								   mhb.getMedicamento().getNomMed()+"---"+
								   mhb.getCantidad());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	*/
}
