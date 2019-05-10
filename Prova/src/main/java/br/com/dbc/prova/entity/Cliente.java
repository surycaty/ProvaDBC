package br.com.dbc.prova.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Cliente
 *
 */
@Entity
@Table (name = "tb_cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private Integer codigoCliente;
	
	@Column(name="nome", nullable = false)
	private String nomeCliente;
	
	@Column(name="renda", nullable = false)
	private Double rendimentoMensal;
	
	@Column(name="risco", length = 1, nullable = false)
	private String risco;
	
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="tipo_cadastro", length = 1, nullable = false)
	private String tipoCliente;
	
	@Column(name="valor_patrimonio")
	private Double valorPatrimonio;
	
	@Column(name="valor_divida")
	private Double valorDivida;
	
	@Column(name="empregado")
	private boolean empregado;

	/**
	 * @return the codigoCliente
	 */
	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	/**
	 * @param codigoCliente the codigoCliente to set
	 */
	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	/**
	 * @return the nomeCliente
	 */
	public String getNomeCliente() {
		return nomeCliente;
	}

	/**
	 * @param nomeCliente the nomeCliente to set
	 */
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	/**
	 * @return the rendimentoMensal
	 */
	public Double getRendimentoMensal() {
		return rendimentoMensal;
	}

	/**
	 * @param rendimentoMensal the rendimentoMensal to set
	 */
	public void setRendimentoMensal(Double rendimentoMensal) {
		this.rendimentoMensal = rendimentoMensal;
	}

	/**
	 * @return the risco
	 */
	public String getRisco() {
		return risco;
	}

	/**
	 * @param risco the risco to set
	 */
	public void setRisco(String risco) {
		this.risco = risco;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @return the tipoCliente
	 */
	public String getTipoCliente() {
		return tipoCliente;
	}

	/**
	 * @param tipoCliente the tipoCliente to set
	 */
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	/**
	 * @return the valorPatrimonio
	 */
	public Double getValorPatrimonio() {
		return valorPatrimonio;
	}

	/**
	 * @param valorPatrimonio the valorPatrimonio to set
	 */
	public void setValorPatrimonio(Double valorPatrimonio) {
		this.valorPatrimonio = valorPatrimonio;
	}

	/**
	 * @return the valorDivida
	 */
	public Double getValorDivida() {
		return valorDivida;
	}

	/**
	 * @param valorDivida the valorDivida to set
	 */
	public void setValorDivida(Double valorDivida) {
		this.valorDivida = valorDivida;
	}

	/**
	 * @return the empregado
	 */
	public boolean isEmpregado() {
		return empregado;
	}

	/**
	 * @param empregado the empregado to set
	 */
	public void setEmpregado(boolean empregado) {
		this.empregado = empregado;
	}
	
	
   
}
