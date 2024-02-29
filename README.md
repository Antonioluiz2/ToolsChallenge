# Projeto ToolsChallenge - API
API de Pagamentos

## Tecnologias utilizadas:
  - Java 11
  - Spring Boot
  - Spring Web
  - Spring Data JPA
  - BD H2
  - Testes com Postman
    
## Rotas da API:
Method: POST http://localhost:8080/api/pagamentos (Processa um Pagamento e retona o Pagamento)

Method: GET http://localhost:8080/api/pagamentos/listar (Retona a Lista Completa de Pagamentos)

Method: GET http://localhost:8080/api/pagamento/{id} GET (Retona um Pagamento por ID)

Method: PUT http://localhost:8080/api/pagamentos/estornar/{id} (Extorna um Pagamento Autorizado por ID para alteração)

Method: Delete http://localhost:8080/api/pagamento/excluir/{id} GET (Exclui um Pagamento realizado)
