package exemplos.banco;

import java.util.List;

public class Banco {
    
    private String nome;
    private List<Conta> listaDeContas;
    
    public Banco(final String nome, final List<Conta> listaDeContas) {
    	this.nome = nome;
        this.listaDeContas= listaDeContas;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(final String nome) {
    	this.nome = nome;
    }
    
    public List<Conta> getListaDeContas() {
        return this.listaDeContas;
    }
    
    public void setListaDeContas(final List<Conta> listaDeContas) {
          this.listaDeContas = listaDeContas;
    }
    
}
