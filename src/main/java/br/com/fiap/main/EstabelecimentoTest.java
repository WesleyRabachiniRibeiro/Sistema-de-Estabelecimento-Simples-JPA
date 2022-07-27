package br.com.fiap.main;

import java.util.List;

import br.com.fiap.dao.EstabelecimentoDao;
import br.com.fiap.dao.impl.EstabelecimentoDaoImpl;
import br.com.fiap.entities.Estabelecimento;
import br.com.fiap.singleton.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class EstabelecimentoTest {
	public static void main(String[] args) {
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance("smartcities");
		EntityManager em = factory.createEntityManager();
		
		EstabelecimentoDao dao = new EstabelecimentoDaoImpl(em);
		
		List<Estabelecimento> estabelecimentos = dao.nameSearch("PetNets");
		
		for(Estabelecimento estabelecimento : estabelecimentos) {
			System.out.println(estabelecimento.getNome());
		}
		
		factory.close();
		em.close();
	}
}
