package br.com.poli.testes;

import br.com.poli.calculaScore.CalculaScoreComIdade;
import br.com.poli.calculaScore.CalculaScoreSemIdade;
import br.com.poli.exception.MovimentoIncorretoException;
import br.com.poli.exception.MovimentoInvalidoException;
import br.com.poli.exception.SemSolucaoException;
import br.com.poli.principal.DificuldadePartida;
import br.com.poli.principal.Partida;
import java.util.Random;
//modificar os testes

public class TestePartida {

    public static void main(String[] args) {
        Partida jogo1;
        jogo1 = new Partida("Ana", DificuldadePartida.FACIL);
        //para forçar testes
        Random random = new Random();
        int x = 0, y = 0;
        //mostrar tabuleiro vazio
        for (int i = 0; i < jogo1.getGridTabuleiro().length; i++) {
            for (int j = 0; j < jogo1.getGridTabuleiro()[i].length; j++) {
                System.out.print(jogo1.getGridTabuleiro()[i][j]);
            }
            System.out.println("");
        }
        System.out.println("\nInicio do Jogo \n");
        //teste de executa movimento com MovimentoInvalidoException e MovimentoIncorretoException
        try {
            while(jogo1.getGridTabuleiro()[x][y]!=0){
                x= random.nextInt(9);
                y= random.nextInt(9);
            }
            int valor = 0;
            while(jogo1.getGabaritoTabuleiro()[x][y]== valor || valor == 0){
                valor= random.nextInt(9);
            }
            jogo1.executaMovimento(x, y, valor); //jogada incorreta
        } catch (MovimentoInvalidoException | MovimentoIncorretoException e) {
            System.out.println(e.getMessage());
        }
        try {
            jogo1.executaMovimento(11, -1, 8); // movimento inválido
        } catch (MovimentoInvalidoException | MovimentoIncorretoException e) {
            System.out.println(e.getMessage());
        }

        //provocar Fim de jogo
        while (jogo1.isFimDeJogo() != true) {
            try {
                while (jogo1.getGridTabuleiro()[x][y] != 0) {
                    x = random.nextInt(9);
                    y = random.nextInt(9);
                }
                int valor = 0;
                while (jogo1.getGabaritoTabuleiro()[x][y] == valor || valor == 0) {
                    valor = random.nextInt(9);
                }
                jogo1.executaMovimento(x, y, valor); //jogada incorreta
            } catch (MovimentoInvalidoException | MovimentoIncorretoException e1) {
                System.out.println(e1.getMessage());
            }

        }
        //mostrar a solução
        /*try {
            jogo1.resolvePartida();
        } catch (SemSolucaoException e) {
            System.out.println(e.getMessage());
        }*/
        //Calculo do score sem informar idade
        CalculaScoreSemIdade calcula = new CalculaScoreSemIdade();
        calcula.calcula(jogo1);
        System.out.println("Score:" + jogo1.getScore());
        jogo1.iniciaPartida();
        System.out.println("\nNOVO JOGO VAI COMEÇAR \n");
        //provocar vencer
        while (jogo1.isFimDeJogo() != true) {
            for (int i = 0; i < jogo1.getGridTabuleiro().length; i++) {
                for (int j = 0; j < jogo1.getGridTabuleiro()[i].length; j++) {
                    try {
                        if(jogo1.getGridTabuleiro()[i][j]==0){
                        jogo1.executaMovimento(i, j, jogo1.getGabaritoTabuleiro()[i][j]);
                        }
                    } catch (MovimentoInvalidoException | MovimentoIncorretoException e1) {
                        System.out.println(e1.getMessage());
                    }
                }
            }
        }
        jogo1.setIdadeJogador(20);
        //Calculo baseado na idade
        CalculaScoreComIdade calculaComIdade = new CalculaScoreComIdade();
        //cada movimento valido adiciona +100 ao score
        calculaComIdade.calcula(jogo1);
        System.out.println("Score:" + jogo1.getScore());
    }
}
