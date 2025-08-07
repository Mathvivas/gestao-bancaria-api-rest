# gestao-bancaria-api-rest

## Endpoint Conta

### Criar a Rota "/conta" no Postman

![url de criacao da conta no Postman](src/main/resources/screenshots/conta/criacaoContaPostman.png)

### Criar a Classe ContaController
- Utilizada para definir a rota e os métodos HTTP

### Criar o Record DadosConta (DTO)
- Data Transfer Object
- Usado para transferir dados entre partes da aplicação
- Caso a conta possuísse mais campos e o usuário só precisasse de alguns desses dados retornados, uma DTO seria utilizada
- Exemplo: Classe Conta possui 3 atributos, mas um dos atributos não deve ser exposto, então ao invés de retornar a class Conta, é criada uma DTO e definida somente os dois campos dentro dela

```java
@Entity
public class Conta {
    @Id
    private Integer id;

    private float saldo;

    private String chavePix; // não quer expor
}

public record ContaDTO(Integer id, float saldo) {}
```

### Criação da Classe Conta (Entidade JPA)
- Classe que mapeia uma tabela
- A classe representa uma linha na tabela
- Cada campo representa uma coluna

### Criação da Interface Repositório
- Interface para acessar e manipular uma entidade JPA

### Criação do Database
- MYSQL no terminal: mysql -u root -p

![database criado](src/main/resources/screenshots/criacaoDatabase.png)

### Criação da Migration de criação da tabela
- A utilização de Migrations é feita para registrar as atualizações no banco de dados
- Para cada mudança que quisermos executar no banco, precisamos criar um arquivo ```.sql``` no projeto e escrever a 
  query que será executada
- O arquivo deve ser salvo em um diretório específico: ```db/migration```
- O nome do arquivo sempre deve começar com Vn__, com n seguindo a ordem dos scripts
- Após a execução do script ```V1__create-table-conta.sql```, a tabela foi criada no sistema

![tabela criada no sistema](src/main/resources/screenshots/conta/tabelaCriada.png)
- Ao executar o método POST no Postman, tem-se:

![conta criada no Postman](src/main/resources/screenshots/conta/contaCriada.png)

![conta criada na tabela](src/main/resources/screenshots/conta/contaCriadaNaTabela.png)

### Criação do método GET
- Foi criado o método GET fazendo com que seja impossível retornar todas as contas, por motivos de segurança.
- Ao utilizar o parâmetro "numero_conta" com um valor existente, obtém-se o seguinte resultado:

![get conta 200](src/main/resources/screenshots/conta/getConta200.png)
- Ao utilizar o parâmetro "numero_conta" com um valor não existente, obtém-se o seguinte resultado:

![get conta 404](src/main/resources/screenshots/conta/getConta404.png)
- Ao não utilizar o parâmetro "numero_conta", obtém-se o seguinte resultado:

![get conta 400](src/main/resources/screenshots/conta/getConta400.png)

## Endpoint Transacao

### Criar a Rota "/transacao" no Postman

![url de criacao da transacao no Postman](src/main/resources/screenshots/transacao/criacaoPostTransacaoPostman.png)

``IMPORTANTE``: <b>O parâmetro "numero_conta" foi modificado para "numeroConta".<b>

### Criação da Entidade JPA Transação, DTO Record e Controller

### Realização da Lógica de Taxas
- Saldo Antes PIX

![saldo antes da transação pix](src/main/resources/screenshots/transacao/saldoAntesTransacaoPix.png)
- Transação PIX

![transação pix](src/main/resources/screenshots/transacao/transacaoPix.png)
- Saldo Após PIX

![saldo após a transação pix](src/main/resources/screenshots/transacao/saldoAposTransacaoPix.png)
- Transação Crédito

![transação crédito](src/main/resources/screenshots/transacao/transacaoCredito.png)
- Saldo Após Crédito

![saldo após a transação crédito](src/main/resources/screenshots/transacao/saldoAposTransacaoCredito.png)
- Saldo Antes Débito

![saldo antes da transação débito](src/main/resources/screenshots/transacao/saldoAntesTransacaoDebito.png)
- Transação Débito

![transação débito](src/main/resources/screenshots/transacao/transacaoDebito.png)
- Saldo Após Débito

![saldo após a transação débito](src/main/resources/screenshots/transacao/saldoAposTransacaoDebito.png)
- Saldo Insuficiente

![saldo insuficiente](src/main/resources/screenshots/transacao/saldoInsuficiente.png)

## Testes Automatizados

- Foram testadas a ContaRepository e o TransacaoController
- Utilizado o MockMvc para simular requisições HTTP nos controllers
- Utilizado o DataJpaTest para testar os repositories com um banco de dados

### Testes do Repository

- Foram testadas a busca da conta pelo ID (numeroConta) e o salvamento da conta

![teste do repository](src/main/resources/screenshots/testes/testeRepository.png)

### Testes do Controller

- Foram testadas transações com uma conta não existente, uma transação débito com saldo suficiente e uma transação 
  com saldo insuficiente

![teste do controller](src/main/resources/screenshots/testes/testeController.png)

