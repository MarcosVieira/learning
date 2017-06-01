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
| descricao | quantidade | valor |
| pepino    | 4          | 1.10  |
| mandioca  | 5          | 2.20  |
| beringela | 6          | 4.40  |
When Pedir o cálculo do total do pedido
Then Deverá resultar em $ 41.80