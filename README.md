# Exemplo de Arquitetura Hexagonal em Kotlin e Spring:

## O que é?
A arquitetura hexagonal é um padrão de arquitetura de software que visa separar a lógica de negócios de sua implementação. Ela se baseia na ideia de que o núcleo de negócios deve ser independente de qualquer infraestrutura e de qualquer interface de usuário, tornando-o mais fácil de manter e reutilizar. A arquitetura hexagonal é também conhecida como arquitetura de porta e adaptador ou arquitetura de núcleo e periféricos. Esta arquitetura é baseada no princípio de que a lógica de negócios é o centro de toda a aplicação, e que todas as outras partes da aplicação são adaptadores que se conectam a este núcleo. Estes adaptadores são responsáveis por se conectar a bancos de dados, serviços web, interfaces de usuário, etc.

## Referências:
  * https://www.youtube.com/watch?v=QqmkumHHNgY
  * https://www.youtube.com/watch?v=1PMCPgRIqNE

## Explicação video:
Nesse exemplo, o instrutor separou o sistema em 3 camadas, porém isso não é obrigatório, sendo apenas uma recomendação pra manter o código organizado. Sendo elas:
* Aplicação:
  * Controller, por onde entram as requisições. Como não faz parte do domínio, podemos anotar como ResController e RequestMapping, por exemplo.
* Domínio:
  * Core da aplicação, onde teremos nossa regra de negócio, perceba que dentro dele, não teremos nenhum acoplamento com infraestrutura ou qualquer outro componente.
* Infraestrutura:
  * Camada de persistência, onde teremos banco de dados, entidades e configurações.

TODO

## Swagger:
http://localhost:8080/swagger-ui/index.html