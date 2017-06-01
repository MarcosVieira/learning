package exemplos.loja.steps;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import exemplos.loja.Produto;

public class ProdutoTestSteps_ {

	private Produto produto;
	
	@Given("^um produto com a descricao \"(.*?)\" com estoque atual (\\d+) com preco (.+)$")  
	public void um_produto_com_a_descricao_com_estoque_atual_com_preco(
			final String descricao, 
			final int estoque,  
			final String preco) throws Throwable {
	    this.produto = new Produto(descricao, estoque, preco);
	}

	@When("^é realizada um pedido de venda de (\\d+) unidades$")
	public void e_realizada_um_pedido_de_venda_de_unidades(final int unidadesVendidas) throws Throwable {
		this.produto.vender(unidadesVendidas);
	}

	@When("^é feita uma reposição de (\\d+) unidades$")
	public void e_feita_uma_reposicao_de_unidades(final int reposicao) throws Throwable {
		this.produto.repor(reposicao);
	}

	@Then("^o novo estoque do produto será de (\\d+) unidades$")
	public void o_novo_estoque_do_produto_sera_de_unidades(final int estoqueEsperado) throws Throwable {
		assertThat(this.produto.getEstoque()).isEqualTo(estoqueEsperado);
	}

	@Then("^o valor da venda terá sido de \\$ (.+)$")
	public void a_venda_realizada_tera_sido_de_$(final String vendaRealizada) throws Throwable {
		assertThat(this.produto.getPreco().multiply(BigDecimal.valueOf(this.produto.getVendidos())).setScale(2, BigDecimal.ROUND_DOWN).toPlainString()).isEqualTo(vendaRealizada);
	}
	
}
