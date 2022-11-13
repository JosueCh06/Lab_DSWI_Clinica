package com.proyect.consorcio.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_enlace")
public class Enlace implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idenlace")
	private int idEnlace;
	
	@Column(name = "descripcion")
	private String desEnlace;
	
	@Column(name = "ruta")
	private String rutaEnlace;
	
	//Relación UNO(Enlace) a MUCHOS(Rol_Enlace)
	@OneToMany(mappedBy = "enlace")
	private List<Rol_Enlace> listaRolEnlace;

	public int getIdEnlace() {
		return idEnlace;
	}

	public void setIdEnlace(int idEnlace) {
		this.idEnlace = idEnlace;
	}

	public String getDesEnlace() {
		return desEnlace;
	}

	public void setDesEnlace(String desEnlace) {
		this.desEnlace = desEnlace;
	}

	public String getRutaEnlace() {
		return rutaEnlace;
	}

	public void setRutaEnlace(String rutaEnlace) {
		this.rutaEnlace = rutaEnlace;
	}

	public List<Rol_Enlace> getListaRolEnlace() {
		return listaRolEnlace;
	}

	public void setListaRolEnlace(List<Rol_Enlace> listaRolEnlace) {
		this.listaRolEnlace = listaRolEnlace;
	}
}
