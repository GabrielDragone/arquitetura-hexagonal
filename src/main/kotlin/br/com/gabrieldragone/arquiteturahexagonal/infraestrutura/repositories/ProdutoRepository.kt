package br.com.gabrieldragone.arquiteturahexagonal.infraestrutura.repositories

import br.com.gabrieldragone.arquiteturahexagonal.dominio.Produto
import br.com.gabrieldragone.arquiteturahexagonal.dominio.portas.repositories.ProdutoRepositoryPort
import br.com.gabrieldragone.arquiteturahexagonal.infraestrutura.entidades.ProdutoEntity
import org.springframework.stereotype.Component
import java.util.stream.Collectors

@Component
class ProdutoRepository(val springProdutoRepository: SpringProdutoRepository): ProdutoRepositoryPort {

    override fun buscarTodos(): List<Produto> {
        val produtosEntity = springProdutoRepository.findAll()
        val produtos = produtosEntity.stream().map(ProdutoEntity::toProduto).collect(Collectors.toList())
        return produtos
    }

    override fun buscarPorSku(sku: String): Produto {
        val produtoEntity = springProdutoRepository.findBySku(sku)
        
        if (produtoEntity.isPresent) {
            return produtoEntity.get().toProduto()
        }
        
        throw RuntimeException("Produto não encontrado!")
    }

    override fun salvar(produto: Produto) {
        val produtoEntity: ProdutoEntity

        if (produto.codigo == null) {
            produtoEntity = ProdutoEntity(produto)
        } else {
            produtoEntity = springProdutoRepository.findById(produto.codigo).get()
            produtoEntity.atualizar(produto)
        }

        springProdutoRepository.save(produtoEntity)
    }

}