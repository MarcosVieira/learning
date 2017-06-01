package exemplos.banco.steps;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import exemplos.banco.Banco;
import exemplos.banco.Conta;

public class BancoTestSteps {
	 
    private Banco banco;
    private int totalContas;
    private Double totalDinheiro;
    private Conta contaMaiorSaldo;
    private Conta contaMenorSaldo;
    private List<Conta> listaContasComSaldoAcimaLimite;

    @Given("^que as contas são do \"(.*?)\"$")
    public void que_as_contas_sao_do(final String nome, final List<Conta> listaDeContas) throws Throwable {
          this.banco = new Banco(nome, listaDeContas);
    }

    @When("^o cálculo da quantidade de contas criadas$")
    public void o_calculo_da_quantidade_de_contas_criadas() throws Throwable {
        this.totalContas = banco.getListaDeContas().size();
    }

    @Then("^no banco \"([^\"]*)\"$")
    public void no_banco(final String nomeBancoEsperado) throws Throwable {
    	assertThat(this.banco.getNome()).isEqualTo(nomeBancoEsperado);
    }    
    
    @Then("^o total de contas é (\\d+)$")
    public void o_total_de_contas_e(final int totalContasEsperado) throws Throwable {
    	assertThat(totalContas).isEqualTo(totalContasEsperado);
    }

    @When("^o cálculo do total de dinheiro$")
    public void o_calculo_do_total_de_dinheiro() throws Throwable {
    	this.totalDinheiro = 0D;
    	for (final Conta conta : this.banco.getListaDeContas()) {
    		this.totalDinheiro += conta.getSaldo();
    	}
    }

    @Then("^o total de dinheiro no banco é (\\d+)$")
    public void o_total_de_dinheiro_no_banco_e(final Double totalDinheiroEsperado) throws Throwable {
    	assertThat(totalDinheiro).isEqualTo(totalDinheiroEsperado);
    }
    
    @When("^o cálculo do cliente com maior saldo$")
    public void o_calculo_do_cliente_com_maior_saldo() throws Throwable {
    	this.contaMaiorSaldo = null;
    	for (final Conta conta : this.banco.getListaDeContas()) {
    		if (this.contaMaiorSaldo == null || conta.getSaldo() > this.contaMaiorSaldo.getSaldo()) {
    			this.contaMaiorSaldo = conta;
    		}
    	}
    }

    @Then("^o nome do cliente com maior saldo é \"(.*?)\"$")
    public void o_nome_do_cliente_com_maior_saldo_e(final String nomeEsperado) throws Throwable {
    	assertThat(this.contaMaiorSaldo.getDono()).isEqualTo(nomeEsperado);
    }
    
    @And("^o saldo da conta com maior saldo é (\\d+)$")
    public void o_saldo_da_conta_com_maior_saldo_e(final Double saldoEsperado) throws Throwable {
    	assertThat(this.contaMaiorSaldo.getSaldo()).isEqualTo(saldoEsperado);
    }
    
    @When("^o cálculo do cliente com menor saldo$")
    public void o_calculo_do_cliente_com_menor_saldo() throws Throwable {
    	this.contaMenorSaldo = null;
    	for (final Conta conta : this.banco.getListaDeContas()) {
    		if (this.contaMenorSaldo == null || conta.getSaldo() < this.contaMenorSaldo.getSaldo()) {
    			this.contaMenorSaldo = conta;
    		}
    	}
    }

    @Then("^o nome do cliente com menor saldo é \"(.*?)\"$")
    public void o_nome_do_cliente_com_menor_saldo_e(final String nomeEsperado) throws Throwable {
    	assertThat(this.contaMenorSaldo.getDono()).isEqualTo(nomeEsperado);
    }
    
    @And("^o saldo da conta com menor saldo é (\\d+)$")
    public void o_saldo_da_conta_com_menor_saldo_e(final Double saldoEsperado) throws Throwable {
    	assertThat(this.contaMenorSaldo.getSaldo()).isEqualTo(saldoEsperado);
    }
    
    @When("^o cálculo das contas com saldo igual ou acima de (\\d+)$")
    public void o_cálculo_das_contas_com_saldo_igual_ou_acima_de(final Double saldoLimite) throws Throwable {
    	this.listaContasComSaldoAcimaLimite = new ArrayList<Conta>();
    	for (final Conta conta : this.banco.getListaDeContas()) {
    		if (conta.getSaldo() >= saldoLimite) {
    			this.listaContasComSaldoAcimaLimite.add(conta);
    		}
    	}
    }

    @Then("^a relação das contas é \"([^\"]*)\"$")
    public void a_relação_das_contas_e(final String relacaoNumerosDeContaEsperado) throws Throwable {
    	final List<String> numerosConta = new ArrayList<String>();
    	for (final Conta conta : this.listaContasComSaldoAcimaLimite) {
    		numerosConta.add(String.valueOf(conta.getNumero()));
    	}
    	assertThat(StringUtils.join(numerosConta, ",")).isEqualTo(relacaoNumerosDeContaEsperado);
    }    
    
}
