package com.prueba.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.apirest.model.Recibo;
import com.prueba.apirest.service.ReciboService;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

@RestController
@RequestMapping("/recibo")
public class ReciboController {

	@Autowired
	private ReciboService reciboService;
	
	@RequestMapping("/poliza/{numeroPoliza}")
	public ResponseEntity<List<Recibo>> obtenerRecibosPorNumeroPoliza(@PathVariable("numeroPoliza") int numeroPoliza){
		List<Recibo> recibos = reciboService.obtenerPorNumeroPoliza(numeroPoliza);
		for (Recibo recibo : recibos) {
			recibo.add(linkTo(methodOn(ReciboController.class).obtenerRecibosPorNumeroRecibo(recibo.getNumero())).withSelfRel());
			recibo.add(linkTo(methodOn(PolizaController.class).obtenerPolizasPorNumero(numeroPoliza)).withRel("poliza"));
		}
		return new ResponseEntity<List<Recibo>>(recibos, HttpStatus.OK);
	} 
	
	@RequestMapping("/{numeroRecibo}")
	public ResponseEntity<Recibo> obtenerRecibosPorNumeroRecibo(@PathVariable("numeroRecibo") int numeroRecibo) {
		
		Recibo recibo = reciboService.obtenerPorNumeroRecibo(numeroRecibo);
		recibo.add(linkTo(methodOn(ReciboController.class).obtenerRecibosPorNumeroRecibo(numeroRecibo)).withSelfRel());
		recibo.add(linkTo(methodOn(PolizaController.class).obtenerPolizasPorNumero(recibo.getPoliza().getNumeroPoliza())).withRel("poliza"));
		return new ResponseEntity<Recibo>(recibo, HttpStatus.OK);
	}
	
}
