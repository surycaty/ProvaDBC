/**
 * 
 */
package br.com.dbc.prova.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;

import br.com.dbc.prova.entity.Cliente;

/**
 * @author Adriano
 *
 */
@Repository
public class ClienteRepository {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager manager;
 
 
	/**
	 * 
	 * @param cliente
	 * 
	 * Salva um novo registro
	 */
	@javax.transaction.Transactional
	public void salvar(Cliente cliente){
		manager.persist(cliente);		
	}
 
	/**
	 * 
	 * @param cliente
	 * 
	 * Realiza a alteração de um registro
	 */
	@javax.transaction.Transactional
	public void alterar(Cliente cliente){
		manager.merge(cliente);		
	}
 
	/**
	 * 
	 * @param codigo
	 * @return Cliente
	 * 
	 * Consulta um cliente por código
	 */	
	public Cliente consultarPorCodigo(int codigo){
		return manager.find(Cliente.class, codigo);		
	} 
 
	/**
	 * 
	 * @param codigo
	 * 
	 * Exclui um cliente pelo código
	 */
	@javax.transaction.Transactional
	public void excluir(int codigo){
 
		Cliente cliente = this.consultarPorCodigo(codigo);
 
		manager.remove(cliente);
 
	}
 
	/**
	 * 
	 * @return List<Cliente>
	 * 
	 * Consulta todos os clientes cadastrados no banco de dados
	 */
	public List<Cliente> todosClientes(){
		return manager.createQuery("SELECT c FROM Cliente c ORDER BY c.nomeCliente ", Cliente.class).getResultList();	
	}
}
