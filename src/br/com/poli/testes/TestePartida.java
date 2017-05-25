package br.com.poli.testes;

import br.com.poli.exception.MovimentoIncorretoException;
import br.com.poli.exception.MovimentoInvalidoException;
import br.com.poli.principal.DificuldadePartida;
import br.com.poli.principal.Partida;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        } catch (MovimentoInvalidoException e1) {
            System.out.println(e1.getMessage());
        } catch (MovimentoIncorretoException e2) {
            System.out.println(e2.getMessage());
        }

        //provocar Fim de jogo
        while (jogo1.isFimDeJogo() != true) {
            try {
                jogo1.executaMovimento(1, 0, 7);
            } catch (MovimentoInvalidoException e1) {
                System.out.println(e1.getMessage());
            } catch (MovimentoIncorretoException e2) {
                System.out.println(e2.getMessage());
            }

        }

        jogo1.iniciaPartida();
        System.out.println("\nNOVO JOGO VAI COMEÇAR \n");
        //provocar vencer
        while (jogo1.isFimDeJogo() != true) {
            for (int i = 0; i < jogo1.getGridTabuleiro().length; i++) {
                for (int j = 0; j < jogo1.getGridTabuleiro()[i].length; j++) {
                    try {
                        jogo1.executaMovimento(i, j, jogo1.getGabaritoTabuleiro()[i][j]);
                    } catch (MovimentoInvalidoException e1) {
                        System.out.println(e1.getMessage());
                    } catch (MovimentoIncorretoException e2) {
                        System.out.println(e2.getMessage());
                    }
                }
            }
            if (jogo1.getVenceu() == true) {
                System.out.println("Voce venceu!!!");
                break;
            }
        }
        //loop feito para não ter que preencher o tabuleiro manualmente
        /*while(jogo1.isFimDeJogo()!=true){
                int b=3;
                for(int i=0;i < jogo1.getGridTabuleiro().length;i++) {
                    for(int j=0; j < jogo1.getGridTabuleiro().length; j++){
                        jogo1.executaMovimento(i, j, b);
                        System.out.print(jogo1.getGridTabuleiro()[i][j]);
                            }
                    System.out.println("");
                    b++;
                    }
                if(jogo1.getVenceu()==true){
                System.out.println("Voce venceu!!!");
                break;
                }
            }
     jogo1.iniciaPartida();
     System.out.println("\nNOVO JOGO VAI COMEÇAR \n");
    
     jogo1.escolherDificuldade("DIFICIL");
            while(jogo1.isFimDeJogo()!=true){
                int b=1;
                for(int i=0;i < jogo1.getGridTabuleiro().length;i++) {
                    for(int j=0; j < jogo1.getGridTabuleiro().length; j++){
                        jogo1.executaMovimento(i, j, b);
                        System.out.print(jogo1.getGridTabuleiro()[i][j]);
                            }
                    System.out.println("");
                    b++;
                    }
                if(jogo1.getVenceu()==true){
                System.out.println("Voce venceu!!!");
                break;
                }
            }*/
    }
}
