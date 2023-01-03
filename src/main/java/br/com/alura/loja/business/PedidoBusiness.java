package br.com.alura.loja.business;

import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.modelo.Pedido;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class PedidoBusiness {
    public void cadastrarPedido(Pedido pedido, EntityManager em) {
        PedidoDao pedidoDao = new PedidoDao(em);
        pedidoDao.cadastrar(pedido);
    }

    public Pedido buscarPedidoPorId(Long id, EntityManager em) {
        PedidoDao pedidoDao = new PedidoDao(em);
        return pedidoDao.buscarPorId(id);
    }

    public BigDecimal valotTotalPedido(EntityManager em) {
        PedidoDao pedidoDao = new PedidoDao(em);
        return pedidoDao.valorTotalVendido();
    }
}
