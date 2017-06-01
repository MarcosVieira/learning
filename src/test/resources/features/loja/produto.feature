@Produto
Feature: Testar as operações básicas com um produto

Scenario Outline: Testar venda e reposição do produto na loja
Given um produto com a descricao "<descricao>" com estoque atual <estoque_atual> com preco <preco>
When é realizada um pedido de venda de <saida> unidades
And é feita uma reposição de <reposicao> unidades
Then o novo estoque do produto será de <estoque_esperado> unidades
And o valor da venda terá sido de $ <valor_venda_esperado>

Examples:
| descricao        | estoque_atual | preco | saida | reposicao | estoque_esperado | valor_venda_esperado |
| barra 6m cano 25 | 5             | 12.50 | 3     | 4         | 6                | 37.50                |
| barra 6m cano 32 | 10            | 17.00 | 10    | 0         | 0                | 170.00               |
| barra 6m cano 50 | 4             | 22.00 | 5     | 2         | 6                | 0.00                 |
