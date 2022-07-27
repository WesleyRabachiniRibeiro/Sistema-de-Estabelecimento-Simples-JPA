package br.com.fiap.dao.impl;

import br.com.fiap.dao.GenericDao;
import java.lang.reflect.ParameterizedType;
import jakarta.persistence.EntityManager;

public abstract class GenericDaoImpl<T,K> implements GenericDao<T, K> {

	protected EntityManager em;
	private Class<T> clazz; 
	
	@SuppressWarnings("all")
	public GenericDaoImpl(EntityManager em) {
		this.em = em;
		this.clazz = (Class<T>) 
				((ParameterizedType) getClass().getGenericSuperclass())
						.getActualTypeArguments()[0];
	}

	public void cadastrar(T entity) {
		em.persist(entity);
	}

	public T procurar(K id) {
		T entity = em.find(clazz, id);
		if (entity == null)
			throw new RuntimeException();
		return entity;
	}

	public void atualizar(T entity) {
		em.merge(entity);
	}

	public void apagar(K id){
		em.remove(procurar(id));
	}
	
	public void commit() {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}
}
