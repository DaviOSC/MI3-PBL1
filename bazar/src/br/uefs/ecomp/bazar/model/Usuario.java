package br.uefs.ecomp.bazar.model;
import java.util.List;


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

    public List<Produto> listarProdutosCadastrados()
    {
        return produtosCadastrados;
    }
    


}
