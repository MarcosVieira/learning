@Bomba
Feature: Testar as operações básicas numa bomba

Scenario Outline: Testar abastecimento feito na bomba
Given a bomba número <numero> foi aberta com o combustível "<combustível>" de preço <preco> e leitura <leitura_inicial>
When o frentista realiza um abastecimento de $ <valor_abastecimento> na bomba
And o frentista realiza um abastecimento de <litros_abastecimento> litros na bomba
Then a bomba teve uma venda de <valor_vendido>
And a leitura final da bomba é <leitura_final>

Examples:
| numero | combustível        | preco | leitura_inicial | valor_abastecimento | litros_abastecimento | valor_vendido | leitura_final |
| 01     | gasolina comum     | 3.60  | 1234500.00      | 100.00              | 11.11                | 139.99        | 1234538.88    |
| 02     | gasolina aditivada | 3.79  | 2345670.00      | 50.00               | 22.22                | 134.21        | 2345705.41    |
| 03     | etanol             | 3.30  | 3456789.00      | 150.00              | 33.33                | 259.98        | 3456867.78    |
