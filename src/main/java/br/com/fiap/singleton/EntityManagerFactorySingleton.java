package br.com.fiap.singleton;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactorySingleton {
	
	private static EntityManagerFactory factory;
	
	public EntityManagerFactorySingleton() {
		//TODO Auto-generated constructor stub
	}
	
	public static EntityManagerFactory getInstance(String conection) {
		if(factory == null) {
			factory = Persistence.createEntityManagerFactory(conection);
		}
		return factory;
	}

}
