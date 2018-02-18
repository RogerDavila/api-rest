package com.prueba.apirest.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.apirest.model.Poliza;

@Repository
public interface PolizaRepository extends JpaRepository<Poliza, Serializable>{

	List<Poliza> findAll();
	Poliza findByNumeroPoliza(int numeroPoliza);
	
}
