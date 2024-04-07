package br.uefs.ecomp.bazar.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class ControllerBazar
{
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private ArrayList<Leilao> listaLeiloes = new ArrayList<>();
    public Usuario usuarioLogado;
    public int quantidadeUsuarios;
  

    public ControllerBazar() {

    }

    public int quantidadeUsuarios()
    {
        this.quantidadeUsuarios = listaUsuarios.size();
        return listaUsuarios.size();
    }
   
    public Usuario cadastrarUsuario(String uLogin, String uNome, String uSenha, String uCpf, String uEndereco, String uTelefone)
    {
       Usuario usuario = new Usuario(uLogin, uNome, uSenha, uCpf, uEndereco, uTelefone);
       listaUsuarios.add(usuario);
       return usuario;
    }

    public ArrayList<Leilao> getListaLeiloes()
    {
        return listaLeiloes;
    }
    
    public Usuario fazerLogin(String login, String senha)
    {
        for (Usuario usuario : listaUsuarios)
        {
            if(usuario.getLogin().equals(login))
            {
                if(usuario.getSenha().equals(senha))
                {
                    this.usuarioLogado = usuario;
                    return usuario;
                }
            }
        }
        return null;
    }
    
    public Produto cadastrarProduto(String tipo, String descricaoResumida, String descricaoDetalhada)
    {
        Produto produto = usuarioLogado.cadastrarProduto(tipo, descricaoResumida, descricaoDetalhada);
        return produto;  

    }
    
    public Iterator<Produto> listarProdutosCadastrados()
    {
        return usuarioLogado.listarProdutosCadastrados();
    }
    
    public Leilao cadastrarLeilao(Produto produto, double precoMinimo, double incrementoMinimo)
    {
        Leilao leilao = new Leilao(precoMinimo, incrementoMinimo, this.usuarioLogado, produto);
        listaLeiloes.add(leilao);
        return leilao;
    }
    
    public void iniciarLeilao(Leilao leilao)
    {
        leilao.iniciar();
    }
    
    public Iterator<Leilao> listarLeiloesIniciados()
    {
        return listaLeiloes.iterator();
    }
    
    public void participarLeilao(Leilao leilao)
    {
        usuarioLogado.participarLeilao(leilao);
    }
    
    public void darLanceMinimo()
    {
        usuarioLogado.darLanceMinimo();
    }
    
    public void darLance(double valor)
    {
        usuarioLogado.darLance(valor);
    }
    
    public Venda encerrarLeilao()
    {
        return usuarioLogado.encerrarLeilaoAtivo();
        
    }
}
