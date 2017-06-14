package br.com.poli.testes;

import br.com.poli.exception.MovimentoIncorretoException;
import br.com.poli.exception.MovimentoInvalidoException;
import br.com.poli.exception.SemSolucaoException;
import static br.com.poli.principal.DificuldadePartida.DIFICIL;
import static br.com.poli.principal.DificuldadePartida.FACIL;
import static br.com.poli.principal.DificuldadePartida.NORMAL;
import br.com.poli.principal.Tabuleiro;
import java.util.Random;

public class TesteTabuleiro {

    public static void main(String[] args) throws MovimentoInvalidoException, MovimentoIncorretoException, SemSolucaoException {
        Tabuleiro jogo1 = new Tabuleiro(FACIL);
        //para testes
        Random random = new Random();
        int x=0, y=0;
        //mostrar tabuleiro vazio
        for (int i = 0; i < jogo1.getGrid().length; i++) {
            for (int j = 0; j < jogo1.getGrid()[i].length; j++) {
                System.out.print(jogo1.getGrid()[i][j]);
            }
            System.out.println("");
        }
        System.out.println("\nInicio do Jogo \n");

        //teste das exceptions do executaMovimento. Ireimos forçar para cair em uma das exceptions
        try {
            while(jogo1.getGrid()[x][y]!=0){
                x= random.nextInt(9);
                y= random.nextInt(9);
            }
            jogo1.executaMovimento(x, y, jogo1.getGabarito()[x][y]); //teste de um jogada correta
            jogo1.executaMovimento(x, y, 7); //jogada em um campo já preenchido

        } catch (MovimentoInvalidoException | MovimentoIncorretoException e) {
            System.out.println(e.getMessage());
        }
        try {
            while(jogo1.getGrid()[x][y]!=0){
                x= random.nextInt(9);
                y= random.nextInt(9);
            }
            int valor = 0;
            while(jogo1.getGabarito()[x][y]== valor || valor == 0){
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
        try {
            jogo1.executaMovimento(0, 1, 14); // valor invalido
        } catch (MovimentoInvalidoException | MovimentoIncorretoException e) {
            System.out.println(e.getMessage());
        }
        //Mostra o tabuleiro após as jogadas realizadas
        System.out.println("\nTabuleiro Atual \n");
        for (int i = 0; i < jogo1.getGrid().length; i++) {
            for (int j = 0; j < jogo1.getGrid()[i].length; j++) {
                System.out.print(jogo1.getGrid()[i][j]);
            }
            System.out.println("");
        }
        // verificar se o tabuleiro está prenchido
        boolean tabuleiroPreenchido = jogo1.isTabuleiroPreenchido();
        if (tabuleiroPreenchido == true) {
            System.out.println("Tabuleiro completo\n");
        } else {
            System.out.println("Falta preencher alguns campos\n");
        }
        
        //chamar o resolvedor
        try {
            jogo1.isResolvivel();
        } catch (SemSolucaoException e) {
            System.out.println(e.getMessage());
        }
    }
}
