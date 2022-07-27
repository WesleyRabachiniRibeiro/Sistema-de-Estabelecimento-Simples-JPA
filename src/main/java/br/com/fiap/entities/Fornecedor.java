package br.com.fiap.entities;

import java.util.Calendar;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_fornecedor")
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_fornecedor")
	private Long id;
	
	@Column(name = "nm_fornecedor", nullable = false, length = 100)
	private String nome;
	
	@CreationTimestamp
	@Column(name = "dt_cadastro")
	private Calendar dataCadastro;

	@UpdateTimestamp
	@Column(name = "dt_modificacao")
	private Calendar dataModificacao;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(joinColumns = @JoinColumn(name = "cd_fornecedor"), 
	inverseJoinColumns = @JoinColumn(name = "cd_produto"), 
	name = "tb_fornecedor_produto")
	private List<Produto> produto;
	
	public Fornecedor() {
		//TODO Auto-generated constructor stub
	}

	
	public Fornecedor(String nome, Calendar dataCadastro, Calendar dataModificacao, List<Produto> produto) {
		super();
		this.nome = nome;
		this.dataCadastro = dataCadastro;
		this.dataModificacao = dataModificacao;
		this.produto = produto;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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


	public List<Produto> getProduto() {
		return produto;
	}


	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
	
}
