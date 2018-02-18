package com.prueba.apirest.dao;

import java.util.List;

import com.prueba.apirest.model.Recibo;

public interface ReciboDAO {
	
	List<Recibo> findAll();
	List<Recibo> findByPolizaNumeroPoliza(int numeroPoliza);
	Recibo findByNumero(int numeroRecibo);
	
}

