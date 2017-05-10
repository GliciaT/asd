
package br.com.teste;

import br.com.poli.DificuldadePartida;

public class TesteDificuldadePartida {
    public static void main(String[] args){
        DificuldadePartida dificuldade;
        dificuldade = null;
        System.out.println(DificuldadePartida.FACIL.getValor());
        System.out.println(DificuldadePartida.DIFICIL.getQuantidadeMaximaErros());
    }
}
