package br.uefs.ecomp.bazar.model;

import java.util.List;
import java.util.ArrayList;

public class ControllerBazar
{
    private List<Usuario> listaUsuarios;
    private List<Leilao> listaLeiloes;

    public ControllerBazar() {
        this.listaUsuarios = new ArrayList<>();
    }



    public void adicionaUsuario(Usuario usuario)
    {
        listaUsuarios.add(usuario);
    }

    public void adicionaLeilao(Leilao leilao)
    {
        listaLeiloes.add(leilao);
    }

    public List<Leilao> getListaLeiloes()
    {
        return listaLeiloes;
    }
}
