package br.com.gabrieldragone.arquiteturahexagonal.dominio.portas.interfaces

import br.com.gabrieldragone.arquiteturahexagonal.dominio.dtos.EstoqueDTO
import br.com.gabrieldragone.arquiteturahexagonal.dominio.dtos.ProdutoDTO
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException


interface ProdutoServicePort {

    fun buscarProdutos(): List<ProdutoDTO>

    fun criarProduto(dto: ProdutoDTO)

    @Throws(NotFoundException::class)
    fun atualizarEstoque(sku: String, estoqueDto: EstoqueDTO)

}