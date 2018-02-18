package com.prueba.apirest.service;

import java.util.List;

import com.prueba.apirest.model.Poliza;

public interface PolizaService {

	List<Poliza> obtenerTodasPolizas();
	Poliza obtenerPolizasPorNumero(int numero);
	
}
