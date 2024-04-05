package br.uefs.ecomp.bazar.model;
import java.util.List;
import java.util.Iterator;

public class Usuario
{
    private String login;
    private String nome;
    private String senha;
    private String cpf;
    private String endereco;
    private String telefone;

    List<Produto> produtosCadastrados;
    
    ControllerBazar sistema;

    public Usuario(String login, String nome, String senha, String cpf, String endereco, String telefone)
    {
        this.login = login;
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public void cadastrarUsuario()
    {
        Usuario novoUsuario = new Usuario(login, nome, senha, cpf, endereco, telefone);
        sistema.adicionaUsuario(novoUsuario);
    }

    public Iterator<Produto> listarProdutosCadastrados()
    {
        return produtosCadastrados.iterator();
    }
    
    public void participarLeilao()
    {
        
        
    }
    public void cadastrarProduto(String pTipo, String pDescResum, String pDescDetalh )
    {
        Produto produto = new Produto(pTipo, pDescResum, pDescDetalh, this);
        produtosCadastrados.add(produto);
    }
    
    public Leilao cadastrarLeilao(double preco, double incremento, Produto produto)
    {
        Leilao leilao = new Leilao(preco, incremento, this, produto);
        return leilao;
    }
    
    public void iniciarLeilao()
    {
        
    }
    public Venda encerrarLeilaoAtivo()
    {
        Venda venda = new Venda();
        return venda;
    }
    public Venda darLanceMinimo()
    {
        Venda venda = new Venda();
        return venda;
        
    }
    
}
