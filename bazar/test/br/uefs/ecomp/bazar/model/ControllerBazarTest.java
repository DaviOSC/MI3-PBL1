package br.uefs.ecomp.bazar.model;

import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class ControllerBazarTest {

    private Usuario u1, u2, u3;
    private Produto p1, p2, p3;
    private Leilao l1, l2, l3;
    ControllerBazar cb = new ControllerBazar();

    @Before
    public void setUp() throws Exception {
//		u1 = new Usuario("maria", "Maria dos Santos", "senha1", "123456789-01", "Rua Drummond, 23, Centro", "7532213456");
//		u2 = new Usuario("joao", "Joao dos Santos", "senha2", "987654321-01", "Rua Pessoa, 12, Centro", "7532216543");
//		u3 = new Usuario("pedro", "Pedro da Silva", "senha3", "456789123-01", "Rua Andrade, 45, Cidade Nova", "7532217890");
//		p1 = new Produto("telefone", "Galaxy S", "Samsung Galaxy S", u1);
//		p2 = new Produto("telefone", "iPhone 4S", "Apple iPhone 4S", u1);
//		p3 = new Produto("tablet", "iPad 2", "Apple iPad 2", u2);
//		l1 = new Leilao(200.00, 5.00, u1, p1);
//		l2 = new Leilao(500.00, 10.00, u1, p2);
//		l3 = new Leilao(1000.00, 20.00, u2, p3);
    }

    @Test
    public void testCadastrarUsuario() {
        assertEquals(0, cb.quantidadeUsuarios());
        u1 = cb.cadastrarUsuario("maria", "Maria dos Santos", "senha1", "123456789-01", "Rua Drummond, 23, Centro", "7532213456");
        assertEquals(1, cb.quantidadeUsuarios());
        u2 = cb.cadastrarUsuario("joao", "Joao dos Santos", "senha2", "987654321-01", "Rua Pessoa, 12, Centro", "7532216543");
        u3 = cb.cadastrarUsuario("pedro", "Pedro da Silva", "senha3", "456789123-01", "Rua Andrade, 45, Cidade Nova", "7532217890");
        assertEquals(3, cb.quantidadeUsuarios());
    }

    @Test
    public void testFazerLogin() {
        u1 = cb.cadastrarUsuario("maria", "Maria dos Santos", "senha1", "123456789-01", "Rua Drummond, 23, Centro", "7532213456");
        assertNull(cb.fazerLogin("maria", "senhaerrada"));
        assertNull(cb.fazerLogin("joao", "senha1"));
        Usuario usuarioLogado = cb.fazerLogin("maria", "senha1");
        assertNotNull(usuarioLogado);
        assertSame(u1, usuarioLogado);
    }

    @Test
    public void testCadastrarListarProdutos() {
        u1 = cb.cadastrarUsuario("maria", "Maria dos Santos", "senha1", "123456789-01", "Rua Drummond, 23, Centro", "7532213456");
        cb.fazerLogin("maria", "senha1");

        // cadastra produtos do usuario logado
        p1 = cb.cadastrarProduto("telefone", "Galaxy S", "Samsung Galaxy S");
        assertNotNull(p1);
        assertEquals("telefone", p1.getTipo());
        assertEquals("Galaxy S", p1.getDescricaoResumida());
        assertEquals("Samsung Galaxy S", p1.getDescricaoDetalhada());

        p2 = cb.cadastrarProduto("telefone", "iPhone 4S", "Apple iPhone 4S");
        assertNotNull(p2);

        Iterator iterador = cb.listarProdutosCadastrados();
        assertTrue(iterador.hasNext());
        iterador.next();
        assertTrue(iterador.hasNext());
        Produto proximo = (Produto) iterador.next();
        assertSame(p2, proximo);
        assertFalse(iterador.hasNext());
    }

    @Test
    public void testCadastrarLeiloes() {
        u1 = cb.cadastrarUsuario("maria", "Maria dos Santos", "senha1", "123456789-01", "Rua Drummond, 23, Centro", "7532213456");
        cb.fazerLogin("maria", "senha1");
        p1 = cb.cadastrarProduto("telefone", "Galaxy S", "Samsung Galaxy S");
        p2 = cb.cadastrarProduto("telefone", "iPhone 4S", "Apple iPhone 4S");

        assertEquals(0, cb.leiloes.tamanho());
        l1 = cb.cadastrarLeilao(p1, 200.00, 5.00);
        assertEquals(1, cb.leiloes.tamanho());
        l2 = cb.cadastrarLeilao(p1, 500.00, 10.00);
        assertEquals(2, cb.leiloes.tamanho());

        cb.fazerLogin("joao", "senha2");
        p3 = cb.cadastrarProduto("tablet", "iPad 2", "Apple iPad 2");
        l3 = cb.cadastrarLeilao(p3, 1000.00, 20.00);
        assertEquals(3, cb.leiloes.tamanho());
        assertSame(l3, cb.leiloes.recupera(2));
    }

    @Test
    public void testIniciarLeiloesListarLeiloesIniciados() {
        u1 = cb.cadastrarUsuario("maria", "Maria dos Santos", "senha1", "123456789-01", "Rua Drummond, 23, Centro", "7532213456");
        cb.fazerLogin("maria", "senha1");
        p1 = cb.cadastrarProduto("telefone", "Galaxy S", "Samsung Galaxy S");
        p2 = cb.cadastrarProduto("telefone", "iPhone 4S", "Apple iPhone 4S");
        l1 = cb.cadastrarLeilao(p1, 200.00, 5.00);
        l2 = cb.cadastrarLeilao(p2, 500.00, 10.00);

        Iterator iterador = cb.listarLeiloesIniciados();
        assertFalse(iterador.hasNext());
        cb.iniciarLeilao(l1);
        iterador = cb.listarLeiloesIniciados();
        assertTrue(true);
        Leilao proximo = (Leilao) iterador.next();
        assertEquals(Leilao.INICIADO, proximo.getStatus());
        assertFalse(iterador.hasNext());

        cb.iniciarLeilao(l2);

        u2 = cb.cadastrarUsuario("joao", "Joao dos Santos", "senha2", "987654321-01", "Rua Pessoa, 12, Centro", "7532216543");
        cb.fazerLogin("joao", "senha2");
        p3 = cb.cadastrarProduto("tablet", "iPad 2", "Apple iPad 2");
        l3 = cb.cadastrarLeilao(p3, 1000.00, 20.00);
        cb.iniciarLeilao(l3);

        iterador = cb.listarLeiloesIniciados();
        iterador.next();
        iterador.next();
        proximo = (Leilao) iterador.next();
        assertEquals(Leilao.INICIADO, proximo.getStatus());
        assertSame(l3, proximo);
    }

    @Test
    public void testLancesLeilaoEncerrarLeilao() {
        // Como o sistema ainda nao eh multi-usuario, cada usuario 
        // deve fazer login depois de acoes de outros usuarios.
        // Por enquanto, cada usuario so participa de um leilao de cada vez
        // e apenas um leilao pode ocorrer por vez.

        u1 = cb.cadastrarUsuario("maria", "Maria dos Santos", "senha1", "123456789-01", "Rua Drummond, 23, Centro", "7532213456");
        u2 = cb.cadastrarUsuario("joao", "Joao dos Santos", "senha2", "987654321-01", "Rua Pessoa, 12, Centro", "7532216543");
        u3 = cb.cadastrarUsuario("pedro", "Pedro da Silva", "senha3", "456789123-01", "Rua Andrade, 45, Cidade Nova", "7532217890");

        cb.fazerLogin("maria", "senha1");
        p1 = cb.cadastrarProduto("telefone", "Galaxy S", "Samsung Galaxy S");
        l1 = cb.cadastrarLeilao(p1, 200.00, 5.00);
        cb.iniciarLeilao(l1);

        cb.fazerLogin("joao", "senha2");
        cb.participarLeilao(l1);
        cb.darLanceMinimo();
        assertEquals(205.00, l1.getUltimoLance().getValor(), 0.001);

        cb.fazerLogin("pedro", "senha3");
        cb.participarLeilao(l1);
        cb.darLanceMinimo();
        assertEquals(210.00, l1.getUltimoLance().getValor(), 0.001);

        cb.fazerLogin("joao", "senha2");
        cb.darLanceMinimo();
        assertEquals(215.00, l1.getUltimoLance().getValor(), 0.001);

        cb.fazerLogin("pedro", "senha3");
        cb.darLanceMinimo();
        assertEquals(220.00, l1.getUltimoLance().getValor(), 0.001);

        cb.fazerLogin("joao", "senha2");
        cb.darLance(250.00);
        assertEquals(250.00, l1.getUltimoLance().getValor(), 0.001);

        cb.fazerLogin("maria", "senha1");
        Venda venda = cb.encerrarLeilao();
        assertEquals(250.00, venda.getValor(), 0.001);
    }
}
