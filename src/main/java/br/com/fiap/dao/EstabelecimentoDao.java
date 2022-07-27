package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entities.Estabelecimento;

public interface EstabelecimentoDao extends GenericDao<Estabelecimento, Integer>{
	
	List<Estabelecimento> list();
	
	List<Estabelecimento> orderList();

	List<Estabelecimento> pageList(int start, int end);

	List<Estabelecimento> nameSearch(String name);
	
}
