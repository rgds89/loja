package br.com.alura.loja.business;

import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.modelo.Pedido;

import javax.persistence.EntityManager;

public class PedidoBusiness {
    public void cadastrarPedido(Pedido pedido, EntityManager em) {
        PedidoDao pedidoDao = new PedidoDao(em);
        pedidoDao.cadastrar(pedido);
    }

    public Pedido buscarPedidoPorId(Long id, EntityManager em){
        PedidoDao pedidoDao = new PedidoDao(em);
        return pedidoDao.buscarPorId(id);
    }
}
