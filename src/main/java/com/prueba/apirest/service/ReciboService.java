package com.prueba.apirest.service;

import java.util.List;

import com.prueba.apirest.model.Recibo;

public interface ReciboService {

	List<Recibo> obtenerPorNumeroPoliza(int numeroPoliza);
	Recibo obtenerPorNumeroRecibo(int numeroRecibo);
	
}
