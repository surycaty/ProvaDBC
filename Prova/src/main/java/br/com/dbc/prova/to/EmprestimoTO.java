package br.com.dbc.prova.to;

import java.io.Serializable;

/**
 * 
 * @author Adriano
 * 
 * Classe que represanta o objeto Emprestimo
 *
 */
public class EmprestimoTO implements Serializable {
	
	/**
	 * Versão da Classe
	 */
	private static final long serialVersionUID = 5625931924996748437L;
	
	private Double valorEmprestimo;
	private int numeroParcela;
	private String riscoCliente;
	private Double valorCalculado;
	private Double valorParcela;
	private Double taxaJuros;
	
	/**
	 * @return the valorEmprestimo
	 */
	public Double getValorEmprestimo() {
		return valorEmprestimo;
	}
	
	/**
	 * @param valorEmprestimo the valorEmprestimo to set
	 */
	public void setValorEmprestimo(Double valorEmprestimo) {
		this.valorEmprestimo = valorEmprestimo;
	}
	
	/**
	 * @return the numeroParcela
	 */
	public int getNumeroParcela() {
		return numeroParcela;
	}
	
	/**
	 * @param numeroParcela the numeroParcela to set
	 */
	public void setNumeroParcela(int numeroParcela) {
		this.numeroParcela = numeroParcela;
	}
	
	/**
	 * @return the riscoCliente
	 */
	public String getRiscoCliente() {
		return riscoCliente;
	}
	
	/**
	 * @param riscoCliente the riscoCliente to set
	 */
	public void setRiscoCliente(String riscoCliente) {
		this.riscoCliente = riscoCliente;
	}
	
	/**
	 * @return the valorCalculado
	 */
	public Double getValorCalculado() {
		return valorCalculado;
	}
	
	/**
	 * @param valorCalculado the valorCalculado to set
	 */
	public void setValorCalculado(Double valorCalculado) {
		this.valorCalculado = valorCalculado;
	}
	
	/**
	 * @return the valorParcela
	 */
	public Double getValorParcela() {
		return valorParcela;
	}
	
	/**
	 * @param valorParcela the valorParcela to set
	 */
	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
	}
	
	/**
	 * @return the taxaJuros
	 */
	public Double getTaxaJuros() {
		return taxaJuros;
	}
	
	/**
	 * @param taxaJuros the taxaJuros to set
	 */
	public void setTaxaJuros(Double taxaJuros) {
		this.taxaJuros = taxaJuros;
	}
	
}
