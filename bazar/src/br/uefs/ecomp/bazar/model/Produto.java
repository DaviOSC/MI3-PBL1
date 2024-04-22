package br.uefs.ecomp.bazar.model;

public class Produto
{
    private String tipo;
    private String descricaoResumida;
    private String descricaoDetalhada;
    private double preco;
    private boolean vendido;
    private Usuario vendedor;
    
    // Construtor padrão da classe
    public Produto(String pTipo, String pDescResum, String pDescDetalh, Usuario pVendedor)
    {
        this.tipo = pTipo;
        this.descricaoResumida = pDescResum;
        this.descricaoDetalhada = pDescDetalh;
        this.vendedor = pVendedor;
        this.vendido = false;
    }
    
    // métodos que retornam ou modficam atributos do Produto
    public boolean isVendido()
    {
        return vendido;
    }
    
    public String getDescricaoResumida()
    {
        return descricaoResumida;
    }
    
    public String getDescricaoDetalhada()
    {
        return descricaoDetalhada;
    }
    
    public String getTipo()
    {
        return tipo;
    }
    
    public void setVendido()
    {
        this.vendido = true;
    }
    
            
}
