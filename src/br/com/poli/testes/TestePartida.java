package br.com.poli.testes;

import br.com.poli.calculaScore.CalculaScoreComIdade;
import br.com.poli.calculaScore.CalculaScoreSemIdade;
import br.com.poli.exception.MovimentoIncorretoException;
import br.com.poli.exception.MovimentoInvalidoException;
import br.com.poli.principal.DificuldadePartida;
import br.com.poli.principal.Partida;
//modificar os testes

public class TestePartida {

    public static void main(String[] args) {
        Partida jogo1;
        jogo1 = new Partida("Ana", DificuldadePartida.FACIL);
        //mostrar tabuleiro vazio
        for (int i = 0; i < jogo1.getGridTabuleiro().length; i++) {
            for (int j = 0; j < jogo1.getGridTabuleiro()[i].length; j++) {
                System.out.print(jogo1.getGridTabuleiro()[i][j]);
            }
            System.out.println("");
        }
        System.out.println("\nInicio do Jogo \n");
        //teste de executa movimento
        try {
            jogo1.executaMovimento(0, 0, 8);
            jogo1.executaMovimento(0, 0, 7);
        } catch (MovimentoInvalidoException | MovimentoIncorretoException e1) {
            System.out.println(e1.getMessage());
        }

        //provocar Fim de jogo
        /*while (jogo1.isFimDeJogo() != true) {
            try {
                jogo1.executaMovimento(1, 0, 1);
            } catch (MovimentoInvalidoException | MovimentoIncorretoException e1) {
                System.out.println(e1.getMessage());
            }

        }
        
        //Calculo do score sem informar idade
        CalculaScoreSemIdade calcula = new CalculaScoreSemIdade();
        calcula.calcula(jogo1);
        System.out.println(jogo1.getScore());*/
        jogo1.iniciaPartida();
        System.out.println("\nNOVO JOGO VAI COMEÇAR \n");
        //provocar vencer
        while (jogo1.isFimDeJogo() != true) {
            for (int i = 0; i < jogo1.getGridTabuleiro().length; i++) {
                for (int j = 0; j < jogo1.getGridTabuleiro()[i].length; j++) {
                    try {
                        jogo1.executaMovimento(i, j, jogo1.getGabaritoTabuleiro()[i][j]);
                    } catch (MovimentoInvalidoException | MovimentoIncorretoException e1) {
                        System.out.println(e1.getMessage());
                    }
                }
            }
        }
        System.out.println("\nTabuleiro Final \n");
        for (int i = 0; i < jogo1.getGridTabuleiro().length; i++) {
            for (int j = 0; j < jogo1.getGridTabuleiro()[i].length; j++) {
                System.out.print(jogo1.getGridTabuleiro()[i][j]);
            }
            System.out.println("");
        }
        jogo1.setIdadeJogador(20);
        //Calculo baseado na idade
        CalculaScoreComIdade calculaComIdade = new CalculaScoreComIdade();
        //cada movimento valido adiciona +100 ao score
        calculaComIdade.calcula(jogo1);
        System.out.println(jogo1.getScore());
    }
}
