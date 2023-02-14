package br.com.gabrieldragone.arquiteturahexagonal.infraestrutura.configuracao

import br.com.gabrieldragone.arquiteturahexagonal.dominio.adaptadores.services.PedidoServiceImp
import br.com.gabrieldragone.arquiteturahexagonal.dominio.portas.interfaces.ProdutoServicePort
import br.com.gabrieldragone.arquiteturahexagonal.dominio.portas.repositories.ProdutoRepositoryPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfiguration {

    @Bean
    fun produtoService(produtoRepositoryPort: ProdutoRepositoryPort): ProdutoServicePort {
        return PedidoServiceImp(produtoRepositoryPort)
    }

}