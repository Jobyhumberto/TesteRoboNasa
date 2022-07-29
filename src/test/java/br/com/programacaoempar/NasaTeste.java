package br.com.programacaoempar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NasaTeste {

    Nasa nasa;

    @BeforeEach
    public void inicializar() {
        nasa = new Nasa();
    }

    @Test
    public void posicaoInicial() {
        assertEquals("(0,0,N)", nasa.getPosicaoAtual());
    }

    @Test
    public void movimentarRobo() {
        assertEquals("(2,0,S)", nasa.getMovimentar("MMRMMRMM"));
    }

    @Test
    public void posicaoInvalida() {
        assertEquals("(5,-5,S)", nasa.getMovimentar("MMMMMRMMMMMRMMMMMMMMMM")); //Ao colocar posição acima de 5 em qualquer direção ele gera 400 Bad Request
    }

    @Test
    public void comandoInvalida() {
        assertEquals("(0,1,N)", nasa.getMovimentar("M")); //Ao colocar comando que não possui no códico gera 400 Bad Request
    }
}
