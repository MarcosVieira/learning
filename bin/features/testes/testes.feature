@Testes
Feature: Testar as opções de criar definições de passos

Scenario: Verificar o casamento dos padrões na definição de passos
Given Eu tenho um pepino
Given Eu tenho 15 bananas prata na minha cesta
Given Eu tenho uma banana prata na minha cesta
Given Eu tenho uma banana maça na minha cesta
Given Eu tenho uma banana nanica na minha cesta
Given Eu tenho uma manga rosa na minha cesta
Given Eu tenho uma manga coquinho na minha cesta
Given Eu tenho uma manga espada na minha cesta
Given Eu tenho um pedido
| descricao | quantidade | valor | total |
| pepino    | 4          | 1.10  | 4.40  |
| mandioca  | 5          | 2.20  | 11.00 |
| beringela | 6          | 4.40  | 26.40 |
When Pedir o cálculo do total do pedido
Then Deverá ser mostrado $ 41.80