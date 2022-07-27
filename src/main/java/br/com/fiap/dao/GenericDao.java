package br.com.fiap.dao;

public interface GenericDao<T, K> {

	void cadastrar(T entity);
	
	T procurar(K id);
	
	void atualizar(T entity);
	
	void apagar(K id);
	
	void commit();
}
