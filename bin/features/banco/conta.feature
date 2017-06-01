@Conta
Feature: Testar as operações básicas de conta

Scenario Outline: Testar saque e depósito
Given a conta criada para o dono "<dono>" de número <numero> com limite <limite> e saldo <saldo>
When o dono realiza o depósito no valor de <deposito> na conta 
And o dono realiza o primeiro saque no valor de <primeiro_saque> na conta
And o dono realiza o segundo saque no valor de <segundo_saque> na conta
Then o dono tem saldo na conta no valor de <saldo_esperado>

Examples:
| dono   | numero | limite | saldo | deposito | primeiro_saque | segundo_saque | saldo_esperado |  
| Brendo | 111    | 1000   | 0     | 100      | 10             | 10            | 80             |
| Hiago  | 222    | 1000   | 0     | 200      | 10             | 10            | 180            |  
