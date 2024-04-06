package br.uefs.ecomp.bazar.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Leilao
{
    private double precoMinimo;
    private double incrementoMinimo;
    private int status;
    private Produto produto;
    private Usuario vendedor;
    private Venda venda;
    
    private ArrayList<Lance> lances = new ArrayList<>();
    private ArrayList<Usuario> participantes = new ArrayList<>();
    
    public Leilao(double lPrecoMinimo, double lIncrementoMinimo, Usuario lVendedor, Produto lProduto)
    {
        this.precoMinimo = lPrecoMinimo;
        this.incrementoMinimo = lIncrementoMinimo;
        this.vendedor = lVendedor;
        this.produto = lProduto;
    }
    
    public void iniciar()
    {
        
    }
    
    public void encerrar()
    {
        
    }
    
    public int getStatus()
    {
        return status;
    }
    
    public void cadastrarParticipante(Usuario usuario)
    {
        participantes.add(usuario);
    }
    
    public void darLanceMinimo(Usuario usuario)
    {
        
    }
    
    public boolean darLance(Usuario usuario, double preco)
    {
        Lance lance = new Lance(usuario, preco);
        if (lance.getValor() >= this.precoMinimo)
        {
            lances.add(lance);
            return true;
        }
        else
        {
            return false;
        }
    }
    public Venda getVenda()
    {
        return venda;
    }
    public Lance getUltimoLance()
    {
        Lance ultimoLance = lances.get(lances.size()-1);
        return ultimoLance;
    }
    
    
}