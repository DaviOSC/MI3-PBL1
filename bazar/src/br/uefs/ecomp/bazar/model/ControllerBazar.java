package br.uefs.ecomp.bazar.model;

import java.util.ArrayList;
import java.util.Iterator;

public class ControllerBazar
{
    private Usuario usuarioLogado;
    
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private ArrayList<Leilao> listaLeiloes = new ArrayList<>();
    //public MeuArrayList<Leilao> leiloes = new MeuArrayList<>();

    
    public class MeuArrayList<T> extends ArrayList<T> {
        public int tamanho()
        {
            return this.size();
        }
}
    public int quantidadeUsuarios()
    {
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
        Leilao leilao = this.usuarioLogado.cadastrarLeilao(precoMinimo, incrementoMinimo, produto);
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
    
    public int tamanho()
    {
        return leiloes.size();
    }
}
