package br.com.fiap.entities;

import java.io.Serializable;
import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_avaliacacao")
@IdClass(AvaliacaoId.class)
public class Avaliacao implements Serializable{

	@Id
	@JoinColumn(name = "cd_cliente")
	@ManyToOne(optional = false)
	private Cliente cliente;
	
	@Id
	@JoinColumn(name = "cd_estabelecimento")
	@ManyToOne(optional = false)
	private Estabelecimento estabelecimento;
	
	@Column(name = "vl_nota")
	private int nota;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_avaliacao")
	private Calendar dataAvaliacao;
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public Calendar getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Calendar dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

}
