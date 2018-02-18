package com.prueba.apirest.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.apirest.model.Recibo;

@Repository
public interface ReciboRepository extends JpaRepository<Recibo, Serializable>{
	
	List<Recibo> findAll();
	List<Recibo> findByPolizaNumeroPoliza(int numeroPoliza);
	Recibo findByNumero(int numeroRecibo);
	
}
