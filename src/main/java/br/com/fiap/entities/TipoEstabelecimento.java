package br.com.fiap.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_tipo_estabelecimento")
public class TipoEstabelecimento {

	@Id
	@Column(name = "cd_tipo_estabelecimento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nm_tipo_estabelecimento")
	private String tipo;

	@OneToMany(mappedBy = "tipoEstabelecimento")
	private List<Estabelecimento> estabelecimento;

	public TipoEstabelecimento() {
		// TODO Auto-generated constructor stub
	}
	
	public TipoEstabelecimento(String tipo, List<Estabelecimento> estabelecimento) {
		super();
		this.tipo = tipo;
		this.estabelecimento = estabelecimento;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Estabelecimento> getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(List<Estabelecimento> estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

}
