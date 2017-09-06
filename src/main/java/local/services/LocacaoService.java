package local.services;

import static local.utils.DataUtils.adicionarDias;
import java.util.Date;
import local.entities.Filme;
import local.entities.Locacao;
import local.entities.Usuario;
import local.exceptions.FilmeSemEstoqueException;
import local.exceptions.LocadoraException;
import org.junit.Test;

public class LocacaoService {

    @Test(expected = ArithmeticException.class)
    public Locacao alugarFilme(Usuario usuarios, Filme[] filmes) throws FilmeSemEstoqueException, LocadoraException {
        Locacao locacao = null;
        Integer i = 0;
        do {
            if (usuarios == null) {
                throw new LocadoraException("Impossivel locar sem um usuário");
            }

            if (filmes[i] == null) {
                throw new LocadoraException("Nenhum filme foi selecionado");
            }

            if (filmes[i] != null) {

                if (filmes[i].getEstoque() == 0) {
                    throw new FilmeSemEstoqueException("Filme sem estoque");
                }

                locacao = new Locacao();

                locacao.setFilme(filmes[i]);
                locacao.setUsuario(usuarios);
                locacao.setDataLocacao(new Date());
                locacao.setValor(filmes[i].getPrecoLocacao());

                //Entrega no dia seguinte
                Date dataEntrega = new Date();
                dataEntrega = adicionarDias(dataEntrega, 1);
                locacao.setDataRetorno(dataEntrega);
                i++;
            }
        } while (filmes != null);

        return locacao;

//        Locacao locacao = new Locacao();
//
//        locacao.setFilme(filme);
//        locacao.setUsuario(usuario);
//        locacao.setDataLocacao(new Date());
//        locacao.setValor(filme.getPrecoLocacao());
//
//        //Entrega no dia seguinte
//        Date dataEntrega = new Date();
//        dataEntrega = adicionarDias(dataEntrega, 1);
//        locacao.setDataRetorno(dataEntrega);
        //Salvando a locacao...	
        //TODO adicionar método para salvar
    }
}
