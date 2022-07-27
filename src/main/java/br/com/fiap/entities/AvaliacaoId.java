package br.com.fiap.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AvaliacaoId implements Serializable{

	@Column(name = "cd_cliente")
	private Integer cliente;
	
	@Column(name = "cd_estabelecimento")
	private Integer estabelecimento;

	public AvaliacaoId() {
		//TODO Auto-generated constructor stub
	}

	public AvaliacaoId(Integer cliente, Integer estabelecimento) {
		super();
		this.cliente = cliente;
		this.estabelecimento = estabelecimento;
	}
	
	public Integer getCliente() {
		return cliente;
	}
	
	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}
	
	public Integer getEstabelecimento() {
		return estabelecimento;
	}
	
	public void setEstabelecimento(Integer estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((estabelecimento == null) ? 0 : estabelecimento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvaliacaoId other = (AvaliacaoId) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (estabelecimento == null) {
			if (other.estabelecimento != null)
				return false;
		} else if (!estabelecimento.equals(other.estabelecimento))
			return false;
		return true;
	}

	
}
