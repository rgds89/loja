package br.com.alura.loja.business;

import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.modelo.Cliente;

import javax.persistence.EntityManager;

public class ClienteBusiness {
    public void cadastrarCliente(Cliente cliente, EntityManager em){
        ClienteDao clienteDao = new ClienteDao(em);
        clienteDao.cadastrar(cliente);
    }

    public Cliente buscarClientePorId(Long id, EntityManager em){
        ClienteDao clienteDao = new ClienteDao(em);
        return clienteDao.buscarPorID(id);
    }
}
