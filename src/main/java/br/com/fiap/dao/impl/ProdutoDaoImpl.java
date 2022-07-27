package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.dao.ProdutoDao;
import br.com.fiap.entities.Produto;
import jakarta.persistence.EntityManager;

public class ProdutoDaoImpl extends GenericDaoImpl<Produto, Integer> implements ProdutoDao{

	public ProdutoDaoImpl(EntityManager em) {
		super(em);
		//TODO Auto-generated constructor stub
	}

	public List<Produto> dateSearch(Calendar date) {
		return em.createQuery("from Produto a where a.dataValidade = :d", Produto.class).setParameter("d", date).getResultList();
	}
	
	

}
