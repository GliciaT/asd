package Principal;

class Jogador{
	private String nome;
	private int scoreRecord;

  public Jogador(String nome){
    this.nome= nome;
  }
	
	public void setNome(String nome){
		this.nome = nome;
	}

	public String getNome(){
		return this.nome;
	}

	public void setScoreRecord(int scoreRecord){
		this.scoreRecord = scoreRecord;
	}

	public int getScoreRecord(){
		return this.scoreRecord;
	}
}
