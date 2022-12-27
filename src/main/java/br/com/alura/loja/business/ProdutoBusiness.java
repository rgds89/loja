package br.com.alura.loja.business;

import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;

public class ProdutoBusiness {
    public void cadastrarProduto(Produto produto, EntityManager em) {
       ProdutoDao produtoDao = new ProdutoDao(em);
       produtoDao.cadastrar(produto);
    }

    public Produto buscaProdutoPorID(Long id, EntityManager em){
        ProdutoDao produtoDao = new ProdutoDao(em);
        return produtoDao.buscarPorId(id);
    }
}
