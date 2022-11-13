package com.proyect.consorcio.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_laboratorio")
public class Laboratorio implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lab")
	private int codLab;
	
	@Column(name = "nom_lab")
	private String nomLab;
	
	@Column(name = "dir_lab")
	private String dirLab;
	
	//Relación UNO(Laboratorio) a MUCHOS(TipoMedicamento)
	@OneToMany(mappedBy = "laboratorio")//Asociación
	@JsonIgnore
	private List<TipoMedicamento> listaTipoMedicamento;
	
	public int getCodLab() {
		return codLab;
	}

	public void setCodLab(int codLab) {
		this.codLab = codLab;
	}

	public String getNomLab() {
		return nomLab;
	}

	public void setNomLab(String nomLab) {
		this.nomLab = nomLab;
	}

	public String getDirLab() {
		return dirLab;
	}

	public void setDirLab(String dirLab) {
		this.dirLab = dirLab;
	}

	public List<TipoMedicamento> getListaTipoMedicamento() {
		return listaTipoMedicamento;
	}

	public void setListaTipoMedicamento(List<TipoMedicamento> listaTipoMedicamento) {
		this.listaTipoMedicamento = listaTipoMedicamento;
	}
	
}
