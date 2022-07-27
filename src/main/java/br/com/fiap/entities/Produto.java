package br.com.fiap.entities;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_produto")
public class Produto {

	@Id
	@Column(name = "cd_produto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nm_produto", nullable = false, length = 100)
	private String nome;
	
	@Column(name = "vl_preco")
	private BigDecimal preco;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_validade")
	private Calendar dataValidade;

	@Enumerated(EnumType.STRING)
	private Estado estado;
	
	@Column(name = "dt_cadastro")
	@CreationTimestamp
	private Calendar dataCadastro;
	
	@Column(name = "dt_modificacao")
	@UpdateTimestamp
	private Calendar dataModificacao;
	
	@Formula("vl_preco*0.9")
	private double precoDesconto;
	
	@ManyToMany(mappedBy = "produto", cascade = CascadeType.PERSIST)
	private List<Fornecedor> fornecedor; 
	
	@ManyToMany(mappedBy = "produto", cascade = CascadeType.PERSIST)
	private List<Estabelecimento> estabelecimento;
	
	public Produto() {
		//TODO Auto-generated constructor stub
	}
	


	public Produto(String nome, BigDecimal preco, Calendar dataValidade, Estado estado, Calendar dataCadastro,
			Calendar dataModificacao, double precoDesconto, List<Fornecedor> fornecedor,
			List<Estabelecimento> estabelecimento) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.dataValidade = dataValidade;
		this.estado = estado;
		this.dataCadastro = dataCadastro;
		this.dataModificacao = dataModificacao;
		this.precoDesconto = precoDesconto;
		this.fornecedor = fornecedor;
		this.estabelecimento = estabelecimento;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Calendar getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Calendar getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Calendar dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

	public double getPrecoDesconto() {
		return precoDesconto;
	}

	public void setPrecoDesconto(double precoDesconto) {
		this.precoDesconto = precoDesconto;
	}



	public List<Fornecedor> getFornecedor() {
		return fornecedor;
	}



	public void setFornecedor(List<Fornecedor> fornecedor) {
		this.fornecedor = fornecedor;
	}



	public List<Estabelecimento> getEstabelecimento() {
		return estabelecimento;
	}



	public void setEstabelecimento(List<Estabelecimento> estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	
	
}
