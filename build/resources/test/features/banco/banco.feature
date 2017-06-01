@Banco
Feature: Testar as operacoes básicas de banco
O sistema deve prover operações básicas de banco de forma correta.

Background: Cria todas as contas e associa ao banco
Given que as contas são do "Banco do Brasil"

        | dono                       | numero | saldo | limite |
        | Abias Corpus Da Silva      | 111    | 100   | 1000   |
        | Antônio Morrendo das Dores | 222    | 200   | 1200   |
        | Carabino Tiro Certo        | 333    | 300   | 1300   |
   
Scenario: Verifica o total de contas criadas
When o cálculo da quantidade de contas criadas
Then no banco "Banco do Brasil"
And o total de contas é 3
   
Scenario: Verifica o total de dinheiro no banco
When o cálculo do total de dinheiro
Then o total de dinheiro no banco é 600

Scenario: Cliente com maior saldo no banco
When o cálculo do cliente com maior saldo
Then o nome do cliente com maior saldo é "Carabino Tiro Certo"
And o saldo da conta com maior saldo é 300

Scenario: Cliente com menor saldo no banco
When o cálculo do cliente com menor saldo
Then o nome do cliente com menor saldo é "Abias Corpus Da Silva"
And o saldo da conta com menor saldo é 100

Scenario: Contas com saldo acima de um valor
When o cálculo das contas com saldo igual ou acima de 200
Then a relação das contas é "222,333"
