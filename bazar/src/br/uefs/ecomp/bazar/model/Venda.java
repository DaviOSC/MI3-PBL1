package br.uefs.ecomp.bazar.model;

public class Venda
{
    
    private double valor;
    private Usuario comprador;
    private Usuario vendedor;
    private Produto produto;
    private Leilao leilao;
    
    public double getValor()
    {
        return valor;
    }
    
    public Usuario getVendedor()
    {
        return vendedor;
    }
    
    public Usuario getComprador()
    {
        return comprador;
    }
    
    public Produto getProduto()
    {
        return produto;
    }
    
    public Leilao getLeilao()
    {
        return leilao;
    }
}
