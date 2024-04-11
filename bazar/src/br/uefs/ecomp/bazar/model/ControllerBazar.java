package br.uefs.ecomp.bazar.model;

import java.util.ArrayList;
import java.util.Iterator;

public class ControllerBazar
{
    private Usuario usuarioLogado;
    
    private ArrayList listaUsuarios = new ArrayList<>();
    public ArrayListModficada leiloes = new ArrayListModficada<>();
    
    public class ArrayListModficada<T>
    {
        private ArrayList<T> arrayList;

        public ArrayListModficada()
        {
            this.arrayList = new ArrayList<>();
        }

       
        public int tamanho()
        {
            return arrayList.size();
        }

        
        public T recupera(int indice)
        {
            return arrayList.get(indice);
        }
        
        public void add(T elemento)
        {
            arrayList.add(elemento);
        }

        public void remove(int indice)
        {
            arrayList.remove(indice);
        }
        
        public Iterator iterator()
        {
            return arrayList.iterator();
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

    public ArrayListModficada getListaLeiloes()
    {
        return leiloes;
    }
    
    public Usuario fazerLogin(String login, String senha)
    {
        for (Object obj : listaUsuarios)
        {
            Usuario usuario = (Usuario) obj;
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
        leiloes.add(leilao);
        return leilao;
    }
    
    public void iniciarLeilao(Leilao leilao)
    {
        leilao.iniciar();
    }
    
    public Iterator listarLeiloesIniciados()
    {
        ArrayList leiloesIniciados = new ArrayList<>();
        for(int i=0;i<leiloes.tamanho();i++)
        {
            Object obj = leiloes.recupera(i);
            Leilao leilao = (Leilao) obj;
            if(leilao.getStatus() == Leilao.INICIADO)
            {
                leiloesIniciados.add(leilao);
            }
        }
        return leiloesIniciados.iterator();
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
