package br.com.gabrieldragone.arquiteturahexagonal.dominio

import br.com.gabrieldragone.arquiteturahexagonal.dominio.dtos.ProdutoDTO
import java.util.UUID

data class Produto (
    val codigo: UUID? = null,
    val sku: String,
    val nome: String,
    val preco: Double,
    var quantidade: Double
) {

    fun atualizarEstoque(quantidade: Double) {
        this.quantidade = quantidade
    }

    fun toProdutoDto(): ProdutoDTO {
        return ProdutoDTO(
            sku = this.sku,
            nome = this.nome,
            preco = this.preco,
            quantidade = this.quantidade
        )
    }

    constructor (dto: ProdutoDTO): this (
            sku = dto.sku,
            preco = dto.preco,
            nome = dto.nome,
            quantidade = dto.quantidade
    )

}