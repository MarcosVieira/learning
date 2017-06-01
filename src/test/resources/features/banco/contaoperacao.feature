@ContaOperacao
Feature: Testar as operações de saque e depósito em uma conta

O sistema deve prover o saque e depósito na conta de forma correta, seguindo as seguintes restrições:
1) Só libera o saque, se o valor do saque for menor ou igual ao valor do saldo disponível na conta
2) Só libera o depósito, se o valor do depósito for menor ou igual ao valor do limite disponível na conta

Background: Cria uma conta no banco
Given foi criada a conta do "Zé" de número 123 com limite 600 e saldo 500

Scenario: Testar saque em conta com saldo disponível
When se tentar fazer um saque de 400 na conta
Then o saldo da conta fica 100 
And o saque é realizado

Scenario: Testar saque em conta de todo o saldo disponível
When se tentar fazer um saque de 500 na conta
Then o saldo da conta fica 0 
And o saque é realizado

Scenario: Testar saque em conta sem saldo disponível
When se tentar fazer um saque de 501 na conta
Then o saldo da conta fica 500 
And o saque não é realizado

