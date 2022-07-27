package br.com.fiap.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

	@Id
	@Column(name = "cd_cliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	
	@Column(name = "nm_cliente", nullable = false)
	private String nome;
	
	@ManyToMany(mappedBy = "cliente")
	private List<Estabelecimento> estabelecimento;
	
	public Cliente() {
		//TODO Auto-generated constructor stub
	}

	public Cliente(String nome, List<Estabelecimento> estabelecimento) {
		super();
		this.nome = nome;
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

	public List<Estabelecimento> getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(List<Estabelecimento> estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	
}
