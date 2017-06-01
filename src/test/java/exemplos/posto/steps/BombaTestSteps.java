package exemplos.posto.steps;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import exemplos.posto.Bomba;

public class BombaTestSteps {
	
	private Bomba bomba;
 
	@Given("^a bomba número (\\d+) foi aberta com o combustível \"(.*?)\" de preço (.+) e leitura (.+)$")
	public void a_bomba_numero_numero_foi_aberta_com_o_combustivel_de_preco_e_leitura(
			final Integer numeroBomba,
			final String nomeCombustivel,
			final String precoCombustivel,
			final String leituraInicial) throws Throwable {
		this.bomba = new Bomba(numeroBomba, nomeCombustivel, precoCombustivel, leituraInicial);
	}
	
	@When("^o frentista realiza um abastecimento de \\$ (.+) na bomba$")
	public void o_frentista_realiza_um_abastecimento_de_valor_na_bomba(final String valorAbastecimento) throws Throwable {
		this.bomba.abastecerValor(valorAbastecimento);
	}

	@And("^o frentista realiza um abastecimento de (.+) litros na bomba$")
	public void o_frentista_realiza_um_abastecimento_de_litros_na_bomba(final String litrosAbastecimento) throws Throwable {
		this.bomba.abastecerLitros(litrosAbastecimento);
	}

	@Then("^a bomba teve uma venda de (.+)$")
	public void a_bomba_teve_uma_venda_de(final String valorVendidoEsperado) throws Throwable {
		assertThat(this.bomba.getValorVendidoFormatado()).isEqualTo(valorVendidoEsperado);
	}

	@And("^a leitura final da bomba é (.+)$")
	public void a_leitura_final_da_bomba_é(final String leituraFinalEsperado) throws Throwable {
		assertThat(this.bomba.getLeituraFinalFormatado()).isEqualTo(leituraFinalEsperado);
	}	
	
}
