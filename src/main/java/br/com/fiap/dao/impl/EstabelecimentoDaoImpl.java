package br.com.fiap.dao.impl;

import java.util.List;

import br.com.fiap.dao.EstabelecimentoDao;
import br.com.fiap.entities.Estabelecimento;
import jakarta.persistence.EntityManager;

public class EstabelecimentoDaoImpl extends GenericDaoImpl<Estabelecimento, Integer> implements EstabelecimentoDao{

	public EstabelecimentoDaoImpl(EntityManager em) {
		super(em);
	}
	
	public List<Estabelecimento> list() {
		return em.createQuery("from Estabelecimento", Estabelecimento.class).getResultList();
	}

	public List<Estabelecimento> orderList() {
		return em.createQuery("from Estabelecimento e order by nome", Estabelecimento.class).setMaxResults(3).getResultList();
	}

	public List<Estabelecimento> pageList(int start, int end) {
		return em.createQuery("from Estabelecimento", Estabelecimento.class).setFirstResult(start).setMaxResults(end).getResultList();
	}

	public List<Estabelecimento> nameSearch(String name) {
		return em.createQuery("from Estabelecimento p where p.nome = :nomeEstabelecimento", Estabelecimento.class).setParameter("nomeEstabelecimento", name).getResultList();
	}

	
	
}
