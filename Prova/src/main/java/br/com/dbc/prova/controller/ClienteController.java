/**
 * 
 */
package br.com.dbc.prova.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.dbc.prova.entity.Cliente;
import br.com.dbc.prova.repository.ClienteRepository;
import br.com.dbc.prova.to.EmprestimoTO;
import br.com.dbc.prova.util.Resultado;
import br.com.dbc.prova.util.Util;

/**
 * @author Adriano
 *
 */
@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private Resultado resultado;

	@Autowired
	private ClienteRepository repository;

	/**
	 * 
	 * Chama á view(cadastrar.jsp) para cadastrar um novo registro
	 * 
	 */
	@RequestMapping(value = "/cadastrar.html", method = RequestMethod.GET)
	public ModelAndView cadastrar() {
		return new ModelAndView("cadastrar");
	}

	/**
	 * Chama a view(consultarRegistros.jsp) para mostrar todos os registros
	 * cadastrados
	 * 
	 */
	@RequestMapping(value = "/consultarRegistros.html", method = RequestMethod.GET)
	public ModelAndView consultar() {
		return new ModelAndView("consultarRegistros");
	}

	/**
	 * Chama a view (editarRegistro.jsp) para editar um registro cadastrado
	 * 
	 */
	@RequestMapping(value = "/editarRegistro.html/{codigo}", method = RequestMethod.GET)
	public ModelAndView editarRegistro(@PathVariable int codigo) {

		Cliente cliente = repository.consultarPorCodigo(codigo);

		return new ModelAndView("editarRegistro", "cliente", cliente);
	}
	
	/**
	 * Chama a view (simulador.jsp) para editar um registro cadastrado
	 * 
	 */
	@RequestMapping(value = "/simulador.html/{codigo}", method = RequestMethod.GET)
	public ModelAndView simulador(@PathVariable int codigo) {

		Cliente cliente = repository.consultarPorCodigo(codigo);
		
		return new ModelAndView("simulador", "cliente", cliente);
	}
	
	/**
	 * 
	 * Calcula valor de emprestimo via ajax, esse método vai ser chamado pelo
	 * simuladorController.js através do AngularJS
	 * 
	 */
	@RequestMapping(value = "/calcular", method = RequestMethod.POST)
	public @ResponseBody EmprestimoTO calcular(@RequestBody EmprestimoTO emprestimo) {
		return Util.calcularEmprestimo(emprestimo);
	}

	/**
	 * 
	 * Salva um novo registro via ajax, esse método vai ser chamado pelo
	 * cadastrarController.js através do AngularJS
	 * 
	 */
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public @ResponseBody Resultado salvar(@RequestBody Cliente cliente) {

		try {

			repository.salvar(cliente);

			resultado.setCodigo(1);
			resultado.setMensagem("Registro inserido com sucesso!");

		} catch (Exception e) {

			resultado.setCodigo(2);
			resultado.setMensagem("Erro ao salvar o registro (" + e.getMessage() + ")");
		}

		return resultado;
	}

	/**
	 * 
	 * Altera um registro cadastrado (editarRegistroController.js)
	 */
	@RequestMapping(value = "/alterar", method = RequestMethod.POST)
	public @ResponseBody Resultado alterar(@RequestBody Cliente cliente) {

		try {

			repository.alterar(cliente);

			resultado.setCodigo(1);
			resultado.setMensagem("Registro alterado com sucesso!");

		} catch (Exception e) {

			resultado.setCodigo(2);
			resultado.setMensagem("Erro ao salvar o registro (" + e.getMessage() + ")");
		}

		return resultado;
	}

	/**
	 * Consulta todos os registros cadastrados(consultarRegistrosController.js)
	 * 
	 */
	@RequestMapping(value = "/consultarTodos", method = RequestMethod.GET)
	public @ResponseBody List<Cliente> consultarTodos() {
		return repository.todosClientes();
	}

	/**
	 * Excluir um cliente pelo código (consultarRegistrosController.js)
	 * 
	 */
	@RequestMapping(value = "/excluirRegistro/{codigo}", method = RequestMethod.DELETE)
	public @ResponseBody void excluirRegistro(@PathVariable int codigo) {
		repository.excluir(codigo);
	}
}
