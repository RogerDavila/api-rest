package com.prueba.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.apirest.model.Poliza;
import com.prueba.apirest.service.PolizaService;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
@RequestMapping("/poliza")
public class PolizaController {
	
	@Autowired
	private PolizaService polizaService;
	
	@RequestMapping("/{numeroPoliza}")
	public ResponseEntity<Poliza> obtenerPolizasPorNumero(@PathVariable("numeroPoliza") int numeroPoliza){
		
		Poliza poliza = polizaService.obtenerPolizasPorNumero(numeroPoliza);
		poliza.add(linkTo(methodOn(PolizaController.class).obtenerPolizasPorNumero(numeroPoliza)).withSelfRel());
		poliza.add(linkTo(methodOn(ReciboController.class).obtenerRecibosPorNumeroPoliza(numeroPoliza)).withRel("recibos"));
		
		return new ResponseEntity<Poliza>(poliza, HttpStatus.OK);
	}
	
}
