/**
 * 
 */
package br.com.dbc.prova.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import br.com.dbc.prova.to.EmprestimoTO;

/**
 * @author Adriano
 *
 */
public class Util {
	
	/**
	 * Calcular Emprestimo baseado na 
	 * Fórmula do cálculo do coeficiente de financiamento
	 * 
	 * @param emprestimo
	 * @return
	 */
	public static EmprestimoTO calcularEmprestimo(EmprestimoTO emprestimo) {
		
		if( emprestimo.getRiscoCliente() != null && emprestimo.getRiscoCliente().equals("A")) {
			emprestimo.setTaxaJuros(1.9);
		} else if( emprestimo.getRiscoCliente() != null && emprestimo.getRiscoCliente().equals("B")) {
			emprestimo.setTaxaJuros(5.0);
		} else {
			emprestimo.setTaxaJuros(10.0);
		}
		
		
		double tx = emprestimo.getTaxaJuros()/100;
		double valorExpo = Math.pow(1+(tx), emprestimo.getNumeroParcela());
		
		double cf = ( (tx) / (1 - (1 / valorExpo)) );

		emprestimo.setValorParcela(Util.arredondar(emprestimo.getValorEmprestimo() * cf));
		emprestimo.setValorCalculado(arredondar(emprestimo.getValorParcela() * emprestimo.getNumeroParcela()));

		return emprestimo;
		
	}
	
	/**
	 * Arredondar para 2 casas decimais
	 * 
	 * @param valor
	 * @return
	 */
	public static double arredondar(double valor) {
		DecimalFormat df = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
		df.setRoundingMode(RoundingMode.HALF_UP);
		return new Double(df.format(valor));
	}

}
