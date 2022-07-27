package br.com.fiap.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.fiap.dao.EstabelecimentoDao;
import br.com.fiap.dao.impl.EstabelecimentoDaoImpl;
import br.com.fiap.entities.Cliente;
import br.com.fiap.entities.ContratoAluguel;
import br.com.fiap.entities.Estabelecimento;
import br.com.fiap.entities.Estado;
import br.com.fiap.entities.Fornecedor;
import br.com.fiap.entities.Produto;
import br.com.fiap.entities.TipoEstabelecimento;
import br.com.fiap.singleton.EntityManagerFactorySingleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Main {
	public static void main(String[] args) {

		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance("smartcities");
		
		EntityManager em = factory.createEntityManager();
		
		TipoEstabelecimento tipoEstabelecimento = new TipoEstabelecimento("Petshop", null);
		
		Cliente cliente = new Cliente("Wesley", null);
		Cliente cliente2 = new Cliente("Felipe", null);
		
		ContratoAluguel contrato = new ContratoAluguel(2000, new GregorianCalendar(2020, Calendar.DECEMBER, 10), null);

		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(cliente);
		clientes.add(cliente2);
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setNome("Mario");
		
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		fornecedores.add(fornecedor);
		
		Produto produto = new Produto("Pão Pulma", BigDecimal.valueOf(80), new GregorianCalendar(2020, Calendar.JANUARY, 20), Estado.NOVO, null, null, 0, fornecedores, null);

		Produto produto2 = new Produto("Celular Motorola", BigDecimal.valueOf(80), new GregorianCalendar(2020, Calendar.JANUARY, 20), Estado.USADO, null, null, 0, fornecedores, null);

		
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(produto);
		produtos.add(produto2);
		
		Estabelecimento estabelecimento = new Estabelecimento("Fiap Shop", contrato, tipoEstabelecimento, clientes, produtos);
		Estabelecimento estabelecimento2 = new Estabelecimento("Peteristicos", null, tipoEstabelecimento, clientes, produtos);
		
		contrato.setEstabelecimento(estabelecimento);
		
		EstabelecimentoDao dao = new EstabelecimentoDaoImpl(em);
		
		try {
			dao.cadastrar(estabelecimento);
			dao.commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			dao.cadastrar(estabelecimento2);
			dao.commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
