package br.com.poli.testes;

import br.com.poli.exception.MovimentoIncorretoException;
import br.com.poli.exception.MovimentoInvalidoException;
import br.com.poli.principal.Tabuleiro;
import br.com.poli.principal.Tabuleiro;

public class TesteTabuleiro {

    public static void main(String[] args) throws MovimentoInvalidoException, MovimentoIncorretoException {
        Tabuleiro jogo1 = new Tabuleiro();
        //mostrar tabuleiro vazio
        for (int i = 0; i < jogo1.getGrid().length; i++) {
            for (int j = 0; j < jogo1.getGrid()[i].length; j++) {
                System.out.print(jogo1.getGrid()[i][j]);
            }
            System.out.println("");
        }
        System.out.println("\nInicio do Jogo \n");

        //teste das exceptions do executaMovimento
        try {
            jogo1.executaMovimento(0, 0, 8); //teste de um jogada correta
            jogo1.executaMovimento(0, 0, 7); //jogada em um campo já preenchido

        } catch (MovimentoInvalidoException | MovimentoIncorretoException e) {
            System.out.println(e.getMessage());
        }
        try {
            jogo1.executaMovimento(0, 1, 9); //jogada incorreta
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
            System.out.println("Tabuleiro completo");
        } else {
            System.out.println("Falta preencher alguns campos");
        }
    }
}
