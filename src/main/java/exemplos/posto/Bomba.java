package exemplos.posto;

import java.math.BigDecimal;

public class Bomba {

	private Integer numero;
	private String combustivel;
	private BigDecimal precoCombustivel;
	private BigDecimal leituraInicial;
	private BigDecimal valorVendido;
	
    public Bomba(final Integer numero, final String combustivel, final String precoCombustivel, final String leituraInicial) {
    	this.numero = numero;
    	this.combustivel = combustivel;
    	this.precoCombustivel = new BigDecimal(precoCombustivel);
    	this.leituraInicial = new BigDecimal(leituraInicial);
    	this.valorVendido = new BigDecimal("0");
    }

    public void abastecerValor(final String valor) {
    	this.valorVendido = this.valorVendido.add(new BigDecimal(valor).setScale(2, BigDecimal.ROUND_DOWN));
    }

    public void abastecerLitros(final String litros) {
    	this.valorVendido = this.valorVendido.add(new BigDecimal(litros).multiply(this.precoCombustivel).setScale(2, BigDecimal.ROUND_DOWN));
    }

    public Integer getNumero() {
        return this.numero;
    }
    
    public String getCombustivel() {
    	return this.combustivel;
    }
    
    public BigDecimal getValorVendido() {
    	return this.valorVendido;
    }
    
    public BigDecimal getLitrosVendidos() {
    	return this.valorVendido.divide(this.precoCombustivel, 2, BigDecimal.ROUND_DOWN);
    }
    
    public BigDecimal getLeituraInicial() {
    	return this.leituraInicial;
    }
    
    public BigDecimal getLeituraFinal() {
    	return this.leituraInicial.add(getLitrosVendidos());
    }
    
    public String getValorVendidoFormatado() {
    	return getValorVendido().setScale(2, BigDecimal.ROUND_DOWN).toPlainString();
    }
    
    public String getLitrosVendidosFormatado() {
    	return getLitrosVendidos().setScale(2, BigDecimal.ROUND_DOWN).toPlainString();
    }
    
    public String getLeituraInicialFormatado() {
    	return getLeituraInicial().setScale(2, BigDecimal.ROUND_DOWN).toPlainString();
    }
    
    public String getLeituraFinalFormatado() {
    	return getLeituraFinal().setScale(2, BigDecimal.ROUND_DOWN).toPlainString();
    }
    
    
}
