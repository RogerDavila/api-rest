package com.prueba.apirest.dao;

import java.util.List;

import com.prueba.apirest.model.Poliza;

public interface PolizaDAO{

	List<Poliza> findAll();
	Poliza findByNumeroPoliza(int numeroPoliza);
	
}

