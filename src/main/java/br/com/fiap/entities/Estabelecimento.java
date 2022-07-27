package br.com.fiap.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_estabelecimento")
public class Estabelecimento {

	@Id
	@Column(name = "cd_estabelecimento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nm_estabelecimento", length = 50)
	private String nome;
	
	@OneToOne(mappedBy = "estabelecimento", cascade = CascadeType.PERSIST)
	private ContratoAluguel contratoAluguel;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cd_tipo_estabelecimento")
	private TipoEstabelecimento tipoEstabelecimento;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(joinColumns = @JoinColumn(name = "cd_estabelecimento"), 
	 inverseJoinColumns = @JoinColumn(name = "cd_cliente"), 
	 name = "tb_cliente_estabelecimento")
	private List<Cliente> cliente;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(joinColumns = @JoinColumn(name = "cd_estabelecimento"),
	 inverseJoinColumns = @JoinColumn(name = "cd_produto"),
	 name = "tb_produto_estabelecimento")
	private List<Produto> produto;
	
	public Estabelecimento() {
		//TODO Auto-generated constructor stub
	}

	public Estabelecimento(String nome, ContratoAluguel contratoAluguel, TipoEstabelecimento tipoEstabelecimento,
			List<Cliente> cliente, List<Produto> produto) {
		super();
		this.nome = nome;
		this.contratoAluguel = contratoAluguel;
		this.tipoEstabelecimento = tipoEstabelecimento;
		this.cliente = cliente;
		this.produto = produto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ContratoAluguel getContratoAluguel() {
		return contratoAluguel;
	}

	public void setContratoAluguel(ContratoAluguel contratoAluguel) {
		this.contratoAluguel = contratoAluguel;
	}



	public TipoEstabelecimento getTipoEstabelecimento() {
		return tipoEstabelecimento;
	}



	public void setTipoEstabelecimento(TipoEstabelecimento tipoEstabelecimento) {
		this.tipoEstabelecimento = tipoEstabelecimento;
	}



	public List<Cliente> getCliente() {
		return cliente;
	}



	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}



	public List<Produto> getProduto() {
		return produto;
	}



	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
	
}
