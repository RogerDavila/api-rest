package com.prueba.apirest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.apirest.model.Recibo;
import com.prueba.apirest.repository.ReciboRepository;
import com.prueba.apirest.service.ReciboService;

@Service
public class ReciboServiceImpl implements ReciboService{

	@Autowired
	private ReciboRepository reciboRepository;
	
	@Override
	public List<Recibo> obtenerPorNumeroPoliza(int numeroPoliza) {
		return reciboRepository.findByPolizaNumeroPoliza(numeroPoliza);
	}

	@Override
	public Recibo obtenerPorNumeroRecibo(int numeroRecibo) {
		if(numeroRecibo == 0) {
			return null;
		}
		return reciboRepository.findByNumero(numeroRecibo);
	}

}
