package Principal;

public class TestePartida {
    public static void main(String[] args){
        Partida jogo1;
        jogo1 = new Partida("Ana");
        jogo1.escolherDificuldade("NORMAL");
            while(System.currentTimeMillis()<jogo1.getTempo()){
                int b=3;
                for(int i=0;i < jogo1.getGridTabuleiro().length;i++) {
                    for(int j=0; j < jogo1.getGridTabuleiro().length; j++){
                        jogo1.executaMovimento(i, j, b);
                        System.out.print(jogo1.getGridTabuleiro()[i][j]);
                            }
                    System.out.println("");
                    b++;
                    }
                if(jogo1.isFimDeJogo()==true){
                    break;
                }
                if(jogo1.getVenceu()==true){
                System.out.println("Voce venceu!!!");
                break;
                }
            }
     jogo1.iniciaPartida();
     System.out.println("\nNOVO JOGO VAI COMEÇAR \n");
    
     jogo1.escolherDificuldade("DIFICIL");
            while(System.currentTimeMillis()<jogo1.getTempo()){
                int b=1;
                for(int i=0;i < jogo1.getGridTabuleiro().length;i++) {
                    for(int j=0; j < jogo1.getGridTabuleiro().length; j++){
                        jogo1.executaMovimento(i, j, b);
                        System.out.print(jogo1.getGridTabuleiro()[i][j]);
                            }
                    System.out.println("");
                    b++;
                    }
                if(jogo1.isFimDeJogo()==true){
                    break;
                }
                if(jogo1.getVenceu()==true){
                System.out.println("Voce venceu!!!");
                break;
                }
            }
    }
}
