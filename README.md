# gestao-bancaria-api-rest

## Criar a rota "/conta" no Postman
![url de criacao da conta no Postman](main/resources/screenshots/conta/criacaoContaPostman.png)

- Criar a classe ContaController
- Criar o Record DadosConta (DTO)
- Criar a classe Conta (Entidade JPA)
- Criação do Database
![database criado](main/resources/screenshots/criacaoDatabase.png)

## Criação da Migration de criação da tabela
- A utilização de Migrations é feita para registrar as atualizações no banco de dados
- Para cada mudança que quisermos executar no banco, precisamos criar um arquivo ```.sql``` no projeto e escrever a 
  query que será executada
- O arquivo deve ser salvo em um diretório específico: ```db/migration```
- O nome do arquivo sempre deve começar com Vn__, com n seguindo a ordem dos scripts
- Após a execução do script ```V1__create-table-conta.sql```, a tabela foi criada no sistema
![tabela criada no sistema](main/resources/screenshots/conta/tabelaCriada.png)
- Ao executar o método POST no Postman, tem-se:
![conta criada na tabela](main/resources/screenshots/conta/contaCriadaNaTabela.png)

## Criação do método GET
- Foi criado o método GET fazendo com que seja impossível retornar todas as contas, por motivos de segurança.
- Ao utilizar o parâmetro "numero_conta" com um valor existente, obtém-se o seguinte resultado:
![get conta 200](main/resources/screenshots/conta/getConta200.png)
- Ao utilizar o parâmetro "numero_conta" com um valor não existente, obtém-se o seguinte resultado:
![get conta 404](main/resources/screenshots/conta/getConta404.png)
- Ao não utilizar o parâmetro "numero_conta", obtém-se o seguinte resultado:
![get conta 400](main/resources/screenshots/conta/getConta400.png)