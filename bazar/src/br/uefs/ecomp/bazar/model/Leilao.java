package br.uefs.ecomp.bazar.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Leilao
{
    public static final int CADASTRADO = 0;
    public static final int INICIADO = 1;
    public static final int ENCERRADO = 2;
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
        this.status = 0;
    }
    
    public Usuario getVendedor()
    {
        return this.vendedor;
    }
    public Produto getProduto()
    {
        return this.produto;
    }
    public void iniciar()
    {
        this.status = 1;
    }
    
    public void encerrar()
    {
        this.status = 2;
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
        usuario.darLanceMinimo();
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
        Lance maiorLance = lances.get(0);
        for(Lance lance : lances)
        {
            if(lance.getValor() > maiorLance.getValor())
            {
                maiorLance = lance;
            }
        }
        Venda finalVenda = new Venda(maiorLance, this);
        return finalVenda;
    }
    public Lance getUltimoLance()
    {
        Lance ultimoLance = lances.get(lances.size()-1);
        return ultimoLance;
    }
    
    
}