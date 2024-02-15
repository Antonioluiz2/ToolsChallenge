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
GET /api/pagamentos
  -> Lista todas as transacoes

GET /api/pagamentos/{id}
  -> Lista uma única transacao localizada pelo id

POST /api/v1/accounts
  -> Cria uma conta

POST /api/pagamentos/{id}/estorno
 -> Cria um estorno referenciado pelo id da transacao
