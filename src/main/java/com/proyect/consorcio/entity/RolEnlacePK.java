package com.proyect.consorcio.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RolEnlacePK implements Serializable{

	private int idrol;
	private int idenlace;
	
	public int getIdrol() {
		return idrol;
	}
	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}
	public int getIdenlace() {
		return idenlace;
	}
	public void setIdenlace(int idenlace) {
		this.idenlace = idenlace;
	}
	
	//hasCode() = Genera una clave unicá - aleatorio
	//Necesita los atributos
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idenlace;
		result = prime * result + idrol;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolEnlacePK other = (RolEnlacePK) obj;
		if (idenlace != other.idenlace)
			return false;
		if (idrol != other.idrol)
			return false;
		return true;
	}
	
}
