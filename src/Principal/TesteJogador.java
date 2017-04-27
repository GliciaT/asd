package Principal;

public class TesteJogador {
    public static void main(String[] args){
        Jogador jogador1 = new Jogador("Abelardo");
        jogador1.setNome("Abigail ");
        jogador1.setScoreRecord(300);
        System.out.println(jogador1.getNome()+"tem "+jogador1.getScoreRecord()+" pontos");
        
    }
}
