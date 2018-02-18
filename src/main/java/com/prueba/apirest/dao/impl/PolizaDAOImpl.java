package com.prueba.apirest.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.prueba.apirest.dao.AbstractSession;
import com.prueba.apirest.dao.PolizaDAO;
import com.prueba.apirest.model.Poliza;

@Repository
@Transactional
public class PolizaDAOImpl extends AbstractSession implements PolizaDAO{

	@Override
	public List<Poliza> findAll() {
		return (List<Poliza>) getSession().createQuery("from Poliza").list();
	}

	@Override
	public Poliza findByNumeroPoliza(int numeroPoliza) {
		System.out.println(numeroPoliza);
		return (Poliza) getSession()
				.createQuery("from Poliza where numeroPoliza = :numeroPoliza")
				.setParameter("numeroPoliza", numeroPoliza)
				.uniqueResult();
	}

}
