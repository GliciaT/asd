package br.com.poli.principal;

public class Jogador extends Pessoa {

    private int scoreRecord;

    public Jogador(String nome) {
        super(nome);
    }

    public Jogador(String nome, int idade) {
        super(nome, idade);
    }

    public void setScoreRecord(int scoreRecord) {
        this.scoreRecord = scoreRecord;
    }

    public int getScoreRecord() {
        return this.scoreRecord;
    }
}
