package com.prueba.apirest.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="poliza")
@JsonIgnoreProperties("recibos")
public class Poliza extends ResourceSupport implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="numero_poliza")
	private int numeroPoliza;
	@Column(name="contratante")
	private String contratante;
	@Column(name="descripcion")
	private String descripcion;
	@OneToMany(mappedBy="poliza")
	private List<Recibo> recibos;
	
	public Poliza(int numeroPoliza, String contratante, String descripcion, List<Recibo> recibos) {
		super();
		this.numeroPoliza = numeroPoliza;
		this.contratante = contratante;
		this.descripcion = descripcion;
		this.recibos = recibos;
	}
	
	public Poliza() {}
	
	public int getNumeroPoliza() {
		return numeroPoliza;
	}
	public void setNumeroPoliza(int numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}
	public String getContratante() {
		return contratante;
	}
	public void setContratante(String contratante) {
		this.contratante = contratante;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Recibo> getRecibos(){
		return recibos;
	}
	public void setRecibos(List<Recibo> recibos) {
		this.recibos = recibos;
	}
	
}
