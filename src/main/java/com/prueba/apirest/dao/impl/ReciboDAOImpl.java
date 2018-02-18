package com.prueba.apirest.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.prueba.apirest.dao.AbstractSession;
import com.prueba.apirest.dao.ReciboDAO;
import com.prueba.apirest.model.Recibo;

@Repository
@Transactional
public class ReciboDAOImpl extends AbstractSession implements ReciboDAO{

	@Override
	public List<Recibo> findAll() {
		return (List<Recibo>) getSession().createQuery("from Recibo").list();
	}

	@Override
	public List<Recibo> findByPolizaNumeroPoliza(int numeroPoliza) {
		return  getSession()
				.createQuery("from Recibo r join r.poliza p where p.numeroPoliza = :numeroPoliza")
				.setParameter("numeroPoliza", numeroPoliza)
				.list();
	}

	@Override
	public Recibo findByNumero(int numeroRecibo) {
		return (Recibo) getSession()
				.createQuery("from Recibo where numero = :numeroRecibo")
				.setParameter("numeroRecibo", numeroRecibo)
				.uniqueResult();
	}

}
