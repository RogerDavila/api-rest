package com.prueba.apirest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.apirest.dao.ReciboDAO;
import com.prueba.apirest.model.Recibo;
import com.prueba.apirest.repository.ReciboRepository;
import com.prueba.apirest.service.ReciboService;

@Service
public class ReciboServiceImpl implements ReciboService{

//	@Autowired
//	private ReciboRepository reciboRepository;
	
	@Autowired
	private ReciboDAO reciboDAO;
	
	@Override
	public List<Recibo> obtenerPorNumeroPoliza(int numeroPoliza) {
		return reciboDAO.findByPolizaNumeroPoliza(numeroPoliza);
	}

	@Override
	public Recibo obtenerPorNumeroRecibo(int numeroRecibo) {
		if(numeroRecibo == 0) {
			return null;
		}
		return reciboDAO.findByNumero(numeroRecibo);
	}

}
