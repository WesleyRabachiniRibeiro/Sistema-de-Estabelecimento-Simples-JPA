package br.com.fiap.main;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.fiap.dao.ProdutoDao;
import br.com.fiap.dao.impl.ProdutoDaoImpl;
import br.com.fiap.entities.Produto;
import br.com.fiap.singleton.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;

public class ProdutoTest {
	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance("smartcities").createEntityManager();
	
		ProdutoDao dao = new ProdutoDaoImpl(em);
		
		List<Produto> produtos = dao.dateSearch(new GregorianCalendar(2020, Calendar.JANUARY, 20));
		
		for(Produto produto : produtos) {
			System.out.println(produto.getNome());
		}
		
		em.close();
	}
}
