package br.com.fiap.entities;

import java.util.Calendar;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="tb_contrato_aluguel")
public class ContratoAluguel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_contrato")
	private int id;
	
	@Column(name = "vl_aluguel")
	private float valor;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dt_vencimento")
	private Calendar dataVencimento;


	@OneToOne
	@JoinColumn(name = "cd_estabelecimento")
	private Estabelecimento estabelecimento;

	public ContratoAluguel() {
		//TODO Auto-generated constructor stub
	}

	public ContratoAluguel(float valor, Calendar dataVencimento, Estabelecimento estabelecimento) {
		super();
		this.valor = valor;
		this.dataVencimento = dataVencimento;
		this.estabelecimento = estabelecimento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Calendar getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	
}
