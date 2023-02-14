package br.com.gabrieldragone.arquiteturahexagonal.infraestrutura.entidades

import br.com.gabrieldragone.arquiteturahexagonal.dominio.Produto
import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "produto")
data class ProdutoEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val codigo: UUID? = null,
    var sku: String,
    var nome: String,
    var preco: Double,
    var quantidade: Double
) {

    constructor(produto: Produto): this(
        sku = produto.sku,
        nome = produto.nome,
        preco = produto.preco,
        quantidade = produto.quantidade
    )

    fun toProduto(): Produto {
        return Produto(
            this.codigo,
            this.sku,
            this.nome,
            this.quantidade,
            this.preco
        )
    }

    fun atualizar(produto: Produto) {
        this.sku = produto.sku
        this.nome = produto.nome
        this.preco = produto.preco
        this.quantidade = produto.quantidade
    }

}