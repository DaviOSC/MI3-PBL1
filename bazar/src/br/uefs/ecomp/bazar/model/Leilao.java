package br.uefs.ecomp.bazar.model;
import java.util.List;
import java.util.Iterator;

public class Leilao
{
    private double precoMinimo;
    private double incrementoMinimo;
    private int status;
    private Produto produto;
    private Usuario vendedor;
    
    List<Lance> lances;
    List<Usuario> participantes;
    
    public Leilao(double lPrecoMinimo, double lIncrementoMinimo, Usuario lVendedor, Produto lProduto)
    {
        this.precoMinimo = lPrecoMinimo;
        this.incrementoMinimo = lIncrementoMinimo;
        this.vendedor = lVendedor;
        this.produto = lProduto;
    }
    
    
    
}