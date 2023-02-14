package br.com.gabrieldragone.arquiteturahexagonal.dominio.adaptadores.services

import br.com.gabrieldragone.arquiteturahexagonal.dominio.Produto
import br.com.gabrieldragone.arquiteturahexagonal.dominio.dtos.EstoqueDTO
import br.com.gabrieldragone.arquiteturahexagonal.dominio.dtos.ProdutoDTO
import br.com.gabrieldragone.arquiteturahexagonal.dominio.portas.interfaces.ProdutoServicePort
import br.com.gabrieldragone.arquiteturahexagonal.dominio.portas.repositories.ProdutoRepositoryPort
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import java.lang.Exception
import java.util.Objects
import java.util.stream.Collectors

class PedidoServiceImp(val produtoRepositoryPort: ProdutoRepositoryPort): ProdutoServicePort {

    override fun buscarProdutos(): List<ProdutoDTO> {
        val produtos = produtoRepositoryPort.buscarTodos()
        val produtosDto = produtos.stream().map(Produto::toProdutoDto).collect(Collectors.toList())
        return produtosDto
    }

    override fun criarProduto(dto: ProdutoDTO) {
        val produto = Produto(dto)
        produtoRepositoryPort.salvar(produto)
    }

    override fun atualizarEstoque(sku: String, estoqueDto: EstoqueDTO) {
        val produto = produtoRepositoryPort.buscarPorSku(sku)

        if (Objects.isNull(produto)) throw Exception("Produto não encontrado!")

        produto.atualizarEstoque(estoqueDto.quantidade)

        produtoRepositoryPort.salvar(produto)
    }

}