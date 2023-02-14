package br.com.gabrieldragone.arquiteturahexagonal.aplicacao.adaptadores.controllers

import br.com.gabrieldragone.arquiteturahexagonal.dominio.dtos.EstoqueDTO
import br.com.gabrieldragone.arquiteturahexagonal.dominio.dtos.ProdutoDTO
import br.com.gabrieldragone.arquiteturahexagonal.dominio.portas.interfaces.ProdutoServicePort
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/produtos")
class ProdutoController(val produtoServicePort: ProdutoServicePort) {

    @GetMapping
    @Operation(description = "Retorna lista com todos os Produtos cadastrados")
    fun buscarProdutos(): List<ProdutoDTO> {
        return produtoServicePort.buscarProdutos()
    }

    @PostMapping
    @Operation(description = "Cria um Produto")
    fun criarProduto(@RequestBody produtoDTO: ProdutoDTO) {
        produtoServicePort.criarProduto(produtoDTO)
    }

    @PatchMapping("/{sku}")
    @Operation(description = "Atualiza o estoque de um Produto através de busca por sku")
    fun atualizarEstoque(@PathVariable sku: String, @RequestBody estoqueDTO: EstoqueDTO) {
        produtoServicePort.atualizarEstoque(sku, estoqueDTO)
    }

}