package br.com.alura.loja.testes;

import br.com.alura.loja.business.CategoriaBusiness;
import br.com.alura.loja.business.ClienteBusiness;
import br.com.alura.loja.business.PedidoBusiness;
import br.com.alura.loja.business.ProdutoBusiness;
import br.com.alura.loja.config.EntityManagerConfig;
import br.com.alura.loja.modelo.*;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CadastroDePedido {
    private static final EntityManagerConfig ENTITY_MANAGER_CONFIG = new EntityManagerConfig();
    private static ProdutoBusiness produtoBusiness = new ProdutoBusiness();
    private static CategoriaBusiness categoriaBusiness = new CategoriaBusiness();

    private static ClienteBusiness clienteBusiness = new ClienteBusiness();

    private static PedidoBusiness pedidoBusiness = new PedidoBusiness();

    public static void main(String[] args) {
        preparaPedido();
        EntityManager em = ENTITY_MANAGER_CONFIG.openTrasaction();

        ENTITY_MANAGER_CONFIG.getTrasaction(em);

        Cliente cliente = buscaCliente(em);
        Produto produto = buscaProduto(em);

        Pedido pedido = new Pedido(produto.getPreco().multiply(new BigDecimal(10)), LocalDate.now(), cliente);
        pedido.adicionarItem(new ItemPedido(10L, produto, pedido));

        pedidoBusiness.cadastrarPedido(pedido, em);

        ENTITY_MANAGER_CONFIG.commitTransaction(em);

        printPedido(em);

        printValorTotalPedido(em);

        ENTITY_MANAGER_CONFIG.closeTransaction(em);
    }

    private static void printValorTotalPedido(EntityManager em) {
        BigDecimal valorTotal = pedidoBusiness.valotTotalPedido(em);
        System.out.println(valorTotal);
    }

    private static void printPedido(EntityManager em) {
        Pedido pedido = buscaPedido(em);
        System.out.println(pedido.getValorTotal());
    }

    private static Produto buscaProduto(EntityManager em) {
        return produtoBusiness.buscaProdutoPorID(1L, em);
    }

    private static Cliente buscaCliente(EntityManager em) {
        return clienteBusiness.buscarClientePorId(1L, em);
    }

    private static Pedido buscaPedido(EntityManager em) {
        return pedidoBusiness.buscarPedidoPorId(1L, em);
    }

    private static void preparaPedido() {
        EntityManager em = ENTITY_MANAGER_CONFIG.openTrasaction();

        ENTITY_MANAGER_CONFIG.getTrasaction(em);

        Cliente cliente = new Cliente("Rodrigo Silva", "14578942356");
        clienteBusiness.cadastrarCliente(cliente, em);

        Categoria categoria = new Categoria("CELULARES");
        categoriaBusiness.cadastrarCategoria(categoria, em);

        Produto produto = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), categoria);
        produtoBusiness.cadastrarProduto(produto, em);
        ENTITY_MANAGER_CONFIG.commitTransaction(em);

        ENTITY_MANAGER_CONFIG.closeTransaction(em);
    }
}
