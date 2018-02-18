package com.prueba.apirest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="recibo")
@JsonIgnoreProperties("poliza")
public class Recibo extends ResourceSupport implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="numero")
	private int numero;
	@Column(name="ordenante")
	private String ordenante;
	@Column(name="monto")
	private String monto;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="numero_poliza")
	private Poliza poliza;
	
	public Recibo(int numero, String ordenante, String monto, Poliza poliza) {
		super();
		this.numero = numero;
		this.ordenante = ordenante;
		this.monto = monto;
		this.poliza = poliza;
	}
	
	public Recibo() {}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getOrdenante() {
		return ordenante;
	}
	public void setOrdenante(String ordenante) {
		this.ordenante = ordenante;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}

	public Poliza getPoliza() {
		return poliza;
	}

	public void setPoliza(Poliza poliza) {
		this.poliza = poliza;
	}
	
}
