package com.proyect.consorcio.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable{
	
	@Id
	@Column(name = "cod_usu")
	private int codUsuario;
	
	@Column(name = "login")
	private String loginUsuario;
	
	@Column(name = "password")
	private String claveUsuario;
	
	@Column(name = "nom_usu")
	private String nombre;
	
	@Column(name = "ape_usu")
	private String apellido;
	
	//Relación de MUCHOS(USUARIO) a UNO(ROL)
	@ManyToOne
	@JoinColumn(name = "idrol")
	private Rol rol;//asociación

	public int getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getClaveUsuario() {
		return claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
}
