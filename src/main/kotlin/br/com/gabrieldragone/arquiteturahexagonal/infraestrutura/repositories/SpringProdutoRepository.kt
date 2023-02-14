package br.com.gabrieldragone.arquiteturahexagonal.infraestrutura.repositories

import br.com.gabrieldragone.arquiteturahexagonal.infraestrutura.entidades.ProdutoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface SpringProdutoRepository: JpaRepository<ProdutoEntity, UUID> {

    fun findBySku(sku: String): Optional<ProdutoEntity>

}