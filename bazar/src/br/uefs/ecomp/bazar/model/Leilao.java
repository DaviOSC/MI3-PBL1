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
    private Lance ultimoLance;
    
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
        this.ultimoLance = null;
        vendedor.setLeilaoAtivo(this);
    }
    
    public void encerrar()
    {
        this.status = 2;
        this.produto.setVendido();
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
        Lance lance = new Lance(usuario, this.precoMinimo + this.incrementoMinimo);
        this.ultimoLance = lance;
        this.precoMinimo = lance.getValor();
    }
    
    public boolean darLance(Usuario usuario, double preco)
    {
        Lance lance = new Lance(usuario, preco);
        if (lance.getValor() >= (this.precoMinimo + this.incrementoMinimo))
        {
            this.ultimoLance = lance;
            this.precoMinimo = lance.getValor()+ this.incrementoMinimo;
            return true;
        }
        else
        {
            return false;
        }
    }
    public Venda getVenda()
    {
        if (this.venda == null && this.ultimoLance != null)
        {
            this.venda = new Venda(this.ultimoLance, this);
        }
        
        return this.venda;
        
        
    }
    public Lance getUltimoLance()
    {
        return this.ultimoLance;
    }
    
    
}