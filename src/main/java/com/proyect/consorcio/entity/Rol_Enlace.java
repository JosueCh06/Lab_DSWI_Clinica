package com.proyect.consorcio.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_rol_enlace")
public class Rol_Enlace implements Serializable{
	
	@EmbeddedId//Se puede llamar a la clase RolEnlacePK
	private RolEnlacePK id; //Llave primaria compuesta
	
	@ManyToOne 
	@JoinColumn(name = "idrol", referencedColumnName = "idrol", 
				insertable = false, updatable = false)
	private Rol rol;//asociación
	
	@ManyToOne
	@JoinColumn(name = "idenlace", referencedColumnName = "idenlace",
				insertable = false, updatable = false)
	private Enlace enlace;//asociación
	
	public RolEnlacePK getId() {
		return id;
	}

	public void setId(RolEnlacePK id) {
		this.id = id;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Enlace getEnlace() {
		return enlace;
	}

	public void setEnlace(Enlace enlace) {
		this.enlace = enlace;
	}
	
}
