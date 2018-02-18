package com.prueba.apirest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.apirest.model.Poliza;
import com.prueba.apirest.repository.PolizaRepository;
import com.prueba.apirest.service.PolizaService;

@Service
public class PolizaServiceImpl implements PolizaService{

	@Autowired
	private PolizaRepository polizaRepository;
	
	@Override
	public List<Poliza> obtenerTodasPolizas(){
		return polizaRepository.findAll();
	}

	@Override
	public Poliza obtenerPolizasPorNumero(int numeroPoliza) {
		return polizaRepository.findByNumeroPoliza(numeroPoliza);
	}
	
}
