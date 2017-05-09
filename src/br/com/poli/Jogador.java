package Principal;

public class Jogador extends Pessoa {

    private int scoreRecord;

    public Jogador(String nome) {
        super(nome);
    }

    public void setScoreRecord(int scoreRecord) {
        this.scoreRecord = scoreRecord;
    }

    public int getScoreRecord() {
        return this.scoreRecord;
    }
}
