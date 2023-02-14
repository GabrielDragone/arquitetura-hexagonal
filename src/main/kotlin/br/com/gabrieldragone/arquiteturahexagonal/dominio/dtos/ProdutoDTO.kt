package br.com.gabrieldragone.arquiteturahexagonal.dominio.dtos

data class ProdutoDTO(
    val sku: String,
    val nome: String,
    val preco: Double,
    val quantidade: Double
)