package br.com.alura.loja.business;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.modelo.Categoria;

import javax.persistence.EntityManager;

public class CategoriaBusiness {
    public void cadastrarCategoria(Categoria categoria, EntityManager em){
        CategoriaDao categoriaDao = new CategoriaDao(em);
        categoriaDao.cadastrar(categoria);
    }
}
