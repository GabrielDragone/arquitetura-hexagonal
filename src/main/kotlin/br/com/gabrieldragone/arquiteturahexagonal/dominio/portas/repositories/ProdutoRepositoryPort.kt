package br.com.gabrieldragone.arquiteturahexagonal.dominio.portas.repositories

import br.com.gabrieldragone.arquiteturahexagonal.dominio.Produto

interface ProdutoRepositoryPort {

    fun buscarTodos(): List<Produto>

    fun buscarPorSku(sku: String): Produto

    fun salvar(produto: Produto)

}