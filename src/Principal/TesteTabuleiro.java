
package Principal;

import java.util.Arrays;

public class TesteTabuleiro {
    public static void main(String[] args){
        Tabuleiro jogo1 = new Tabuleiro();
            //mostrar tabuleiro vazio
            for(int i=0;i < jogo1.getGrid().length;i++) {
		for(int j=0; j < jogo1.getGrid().length; j++){
                    System.out.print(jogo1.getGrid()[i][j]);
		}
                System.out.println("");
            }
            System.out.println("\nTabuleiro \n");
            
            //mostrar tabuleiro semi-completo
            int b=2;
            for(int i=0;i < jogo1.getGrid().length;i++) {
		for(int j=0; j < jogo1.getGrid().length; j++){
                    jogo1.executaMovimento(i, j, b);
                    System.out.print(jogo1.getGrid()[i][j]);
		}
                System.out.println("");
                b++;
            }
        // verificar se o tabuleiro está prenchido
        boolean tabuleiroPreenchido = jogo1.isTabuleiroPreenchido();
        if (tabuleiroPreenchido==true){
            System.out.println("Tabuleiro completo");
        }
        else System.out.println("Falta preencher alguns campos");
    }
}
