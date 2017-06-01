package exemplos.loja;

import java.math.BigDecimal;

public class Produto {

    private String descricao;
    private Integer estoque;
    private BigDecimal preco;
    private Integer vendidos;

    public Produto(final String descricao, final int estoque, final String preco) {
    	this.descricao = descricao;
    	this.estoque = estoque;
    	this.preco = new BigDecimal(preco);
    	this.vendidos = 0;
    }

	public String getDescricao() {
		return this.descricao;
	}

	public Integer getEstoque() {
		return this.estoque;
	}

	public BigDecimal getPreco() {
		return this.preco;
	}
	
	public Integer getVendidos() {
		return this.vendidos;
	}

	public boolean vender(final int venda) {
		if (this.estoque >= venda) {
			this.estoque -= venda;
			this.vendidos += venda;
			return true;
		}
		
		return false;
	}

	public void repor(final int reposicao) {
		this.estoque += reposicao;
	}

}
