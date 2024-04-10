package br.uefs.ecomp.bazar.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Usuario
{
    private String login;
    private String nome;
    private String senha;
    private String cpf;
    private String endereco;
    private String telefone;
    private Leilao leilaoAtivo;

    private ArrayList produtosCadastrados =  new ArrayList<>();

    
    public Usuario(String login, String nome, String senha, String cpf, String endereco, String telefone)
    {
        this.login = login;
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    public String getLogin()
    {
        return this.login;
    }
    public String getSenha()
    {
        return this.senha;
    }

    public Iterator listarProdutosCadastrados()
    {
        return produtosCadastrados.iterator();
       
    }
    
    public void participarLeilao(Leilao leilao)
    {
        leilao.cadastrarParticipante(this);
        this.leilaoAtivo = leilao;
    }
          
    public Produto cadastrarProduto(String pTipo, String pDescResum, String pDescDetalh )
    {
        Produto produto = new Produto(pTipo, pDescResum, pDescDetalh, this);
        produtosCadastrados.add(produto);
        return produto;
    }
    
    public Leilao cadastrarLeilao(double preco, double incremento, Produto produto)
    {
        Leilao leilao = new Leilao(preco, incremento, this, produto);
        return leilao;
    }
    
    public void iniciarLeilao(Leilao leilao)
    {
        this.leilaoAtivo = leilao;
    }
    
    public void darLance(Double valor)
    {
        leilaoAtivo.darLance(this, valor);
    }
    
    public void darLanceMinimo()
    {
       leilaoAtivo.darLanceMinimo(this);
    }
    public Venda encerrarLeilaoAtivo()
    {
        leilaoAtivo.encerrar();
        return leilaoAtivo.getVenda();
    }
    
    
}
