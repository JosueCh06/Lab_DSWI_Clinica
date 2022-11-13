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
@Table(name = "tb_rol")
public class Rol implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idrol")
	private int idRol;
	
	@Column(name = "descripcion")
	private String desRol;
	
	//Relación UNO(ROL) a MUCHOS(USUARIOS)
	@OneToMany(mappedBy = "rol")//asociación
	private List<Usuario> listaUsuarios;
	
	//Relación UNO(ROL) a MUCHOS(ROLENLACE)
	@OneToMany(mappedBy = "rol")//asociación
	private List<Rol_Enlace> listaRolEnlace;

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getDesRol() {
		return desRol;
	}

	public void setDesRol(String desRol) {
		this.desRol = desRol;
	}

	public List<Usuario> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public List<Rol_Enlace> getListaRolEnlace() {
		return listaRolEnlace;
	}

	public void setListaRolEnlace(List<Rol_Enlace> listaRolEnlace) {
		this.listaRolEnlace = listaRolEnlace;
	}
}
