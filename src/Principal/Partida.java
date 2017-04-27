package Principal;

public class Partida{
  private Jogador jogador;
  private Tabuleiro tabuleiro = new Tabuleiro();
  private int quantidadeErros=0;
  private boolean venceu;
  private long tempo;
  private int score;
  private DificuldadePartida dificuldade;
  private int quantidadeMaximaErrosAtual;
  
  public Partida(String nome){
    this.tempo = System.currentTimeMillis() + 5000;
    this.jogador = new Jogador(nome);
  }

  public void executaMovimento(int x, int y, int valor){
      if(x <= 9 && y <= 9){
          boolean movimentoValido = this.tabuleiro.executaMovimento(x, y, valor);
          if(movimentoValido==true){
              this.venceu = tabuleiro.isTabuleiroPreenchido();
          }
          if(movimentoValido==false){
              this.quantidadeErros+=1;
          }
        }
  }
  
  public void escolherDificuldade(String dificuldade){
    if (null != dificuldade)switch (dificuldade) {
          case "FACIL":
              this.quantidadeMaximaErrosAtual= DificuldadePartida.FACIL.getQuantidadeMaximaErros();
              break;
          case "NORMAL":
              this.quantidadeMaximaErrosAtual= DificuldadePartida.NORMAL.getQuantidadeMaximaErros();
              break;
          case "DIFICIL":
              this.quantidadeMaximaErrosAtual= DificuldadePartida.DIFICIL.getQuantidadeMaximaErros();
              break;
          default:
              break;
      }
    }
    
  public boolean isFimDeJogo(){
      if(this.quantidadeErros>=this.quantidadeMaximaErrosAtual){
          System.out.println("Errou mais do que podia. GAME OVER");
          return true;
      }
      return false;
      }
      
  
  
    public void iniciaPartida(){
      this.quantidadeErros=0;
      this.tempo = System.currentTimeMillis() + 200;
      this.venceu= false;
      this.tabuleiro.geraTabuleiro();
  }
  

  public String getNomeJogador(){
    return this.jogador.getNome();
  }
  
  public long getTempo(){
    return this.tempo;
  }
  public int getQuantidadeErros(){
    return this.quantidadeErros;
  }
   public int[][] getGridTabuleiro(){
            return tabuleiro.getGrid();
        }
   
   public boolean getVenceu(){
       return this.venceu;
   }
   
   public void setVenceu(boolean venceu){
       this.venceu=venceu;
   }
  /*public int getQuantidadeMaximaErrosAtual(){
		return this.quantidadeMaximaErrosAtual;*/
  }