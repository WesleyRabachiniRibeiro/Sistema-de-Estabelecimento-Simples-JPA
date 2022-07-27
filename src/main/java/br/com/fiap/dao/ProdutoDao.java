package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entities.Produto;

public interface ProdutoDao extends GenericDao<Produto, Integer>{

	List<Produto> dateSearch(Calendar date);
	
}
