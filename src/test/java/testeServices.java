/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import local.entities.Filme;
import local.entities.Locacao;
import local.entities.Usuario;
import local.exceptions.FilmeSemEstoqueException;
import local.exceptions.LocadoraException;
import local.services.LocacaoService;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Avell-Caetano
 */
public class testeServices {

    public testeServices() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test(expected = LocadoraException.class)
    public void testLocacaoFilmeSemEstoque() throws Exception {
        Filme[] filmes;
        filmes = new Filme[10];
        Filme filme;
        Usuario usuario;

        LocacaoService service = new LocacaoService();

        usuario = new Usuario("User 1");

        filme = new Filme("Filme 1", 1, 4.0);
        filmes[0] = filme;
        filme = new Filme("", 1, 4.0);
        filmes[1] = filme;
        //acao
        service.alugarFilme(usuario, filmes);

    }

    @Test(expected = LocadoraException.class)
    public void testLocacaoFilmeSemUsuario() throws Exception {
        Filme[] filmes;
        filmes = new Filme[10];
        Filme filme;
        Usuario usuario;

        LocacaoService service = new LocacaoService();

        usuario = null;

        filme = new Filme("Filme 1", 1, 4.0);
        filmes[0] = filme;
        filme = new Filme("", 1, 4.0);
        filmes[1] = filme;
        //acao
        service.alugarFilme(usuario, filmes);

    }

    @Test
    public void testLocacaoValorFilme() throws Exception {
        Filme[] filmes;
        filmes = new Filme[1];
        Filme filme;
        Usuario usuario;

        LocacaoService service = new LocacaoService();

        usuario = new Usuario("User 1");

        filme = new Filme("Filme 1", 1, 4.0);
        filmes[0] = filme;
        filme = new Filme("Filme 2", 1, 2.0);
        filmes[1] = filme;
        //acao
        Locacao l =service.alugarFilme(usuario, filmes);
        assertEquals(l.getValor(), filme.getPrecoLocacao(), 0.01);
    }
    
}
