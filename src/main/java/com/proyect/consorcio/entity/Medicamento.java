package com.proyect.consorcio.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;


/**
 * The persistent class for the tb_medicamento database table.
 * 
 */
@Entity
@Table(name="tb_medicamento")
@NamedQuery(name="Medicamento.findAll", query="SELECT m FROM Medicamento m")
public class Medicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_med")
	private int codMed;

	@Column(name="des_med")
	private String desMed;

	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="fec_fab_med")
	private Date fecFabMed;

	

	
	@Column(name="nom_med")
	private String nomMed;

	

	@Column(name="pre_med")
	private double preMed;


	@Column(name="sto_med")
	private int stoMed;

	//bi-directional many-to-one association to TipoMedicamento
	@ManyToOne
	@JoinColumn(name="cod_tipo")
	private TipoMedicamento tbTipoMedicamento;

	public Medicamento(int codMed) {
		this.codMed = codMed;
	}
	
	public Medicamento() {
	}

	

	public int getCodMed() {
		return this.codMed;
	}

	public void setCodMed(int codMed) {
		this.codMed = codMed;
	}



	public String getDesMed() {
		return this.desMed;
	}

	public void setDesMed(String desMed) {
		this.desMed = desMed;
	}

	public Date getFecFabMed() {
		return this.fecFabMed;
	}

	public void setFecFabMed(Date fecFabMed) {
		this.fecFabMed = fecFabMed;
	}

	public String getNomMed() {
		return this.nomMed;
	}

	public void setNomMed(String nomMed) {
		this.nomMed = nomMed;
	}

	public double getPreMed() {
		return this.preMed;
	}

	public void setPreMed(double preMed) {
		this.preMed = preMed;
	}

	public int getStoMed() {
		return this.stoMed;
	}

	public void setStoMed(int stoMed) {
		this.stoMed = stoMed;
	}

	public TipoMedicamento getTbTipoMedicamento() {
		return this.tbTipoMedicamento;
	}

	public void setTipoMedicamento(TipoMedicamento tbTipoMedicamento) {
		this.tbTipoMedicamento = tbTipoMedicamento;
	}

}