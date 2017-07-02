package br.com.poli.principal;

import br.com.poli.exception.MovimentoIncorretoException;
import br.com.poli.exception.MovimentoInvalidoException;
import br.com.poli.exception.SemSolucaoException;
import java.util.Date;
import java.util.Random;

public class Partida {

    private Jogador jogador;
    private Tabuleiro tabuleiro;
    private int quantidadeErros = 0;
    private boolean venceu;
    private Date tempoInicial;
    private Date tempoFinal;
    private DificuldadePartida dificuldade;
    private long score;
    private int dicas = 0;
    Random random = new Random();
    
    //apagar esse depois e alterar os testes que o usam
    public Partida(String nome, DificuldadePartida dificuldade) {
        this.tempoInicial = new Date(System.currentTimeMillis());
        //modificar para começar a partida com o metodo inicia partida
        this.tabuleiro = new Tabuleiro(dificuldade);
        this.jogador = new Jogador(nome);
        this.dificuldade = dificuldade;
    }

    public Partida(String nome, DificuldadePartida dificuldade, int idade) {
        this.tempoInicial = new Date(System.currentTimeMillis());
        this.jogador = new Jogador(nome, idade);
        this.dificuldade = dificuldade;
        this.tabuleiro = new Tabuleiro(dificuldade);
    }

    public void executaMovimento(int x, int y, int valor) throws MovimentoInvalidoException, MovimentoIncorretoException {
        try {
            boolean movimentoValido = this.tabuleiro.executaMovimento(x, y, valor);
            if (movimentoValido == true) {
                this.setScore(100);
                this.venceu = tabuleiro.isTabuleiroPreenchido();
            }
        } catch (MovimentoInvalidoException e1) {
            throw e1;
        } catch (MovimentoIncorretoException e2) {
            this.quantidadeErros += 1;
            throw e2;
        }
    }

    public boolean isFimDeJogo() {
        if (this.quantidadeErros >= this.dificuldade.getQuantidadeMaximaErros()) {
            System.out.println("Errou mais do que podia. GAME OVER\n");
            this.tempoFinal = new Date(System.currentTimeMillis());
            try {
                resolvePartida();
            } catch (SemSolucaoException e) {
                System.out.println(e.getMessage());
            }
            return true;
        }
        if (this.venceu == true) {
            System.out.println("Voce venceu!\n");
            this.tempoFinal = new Date(System.currentTimeMillis());
            System.out.println("\nTabuleiro Final \n");
            for (int i = 0; i < getGridTabuleiro().length; i++) {
                for (int j = 0; j < getGridTabuleiro()[i].length; j++) {
                    System.out.print(getGridTabuleiro()[i][j]);
                }
                System.out.println("");
            }
            return true;
        }
        return false;
    }

    public void iniciaPartida() {
        this.quantidadeErros = 0;
        this.tempoInicial = new Date(System.currentTimeMillis());
        this.venceu = false;
        this.tabuleiro = new Tabuleiro(dificuldade);
    }

    public String getNomeJogador() {
        return this.jogador.getNome();
    }

    public int getQuantidadeErros() {
        return this.quantidadeErros;
    }

    public int[][] getGridTabuleiro() {
        return tabuleiro.getGrid();
    }

    public int[][] getGabaritoTabuleiro() {
        return tabuleiro.getGabarito();
    }

    public int getQuantidadeMaximaErrosDificuldade() {
        return this.dificuldade.getQuantidadeMaximaErros();
    }

    public int getIdadeJogador() {
        return this.jogador.getIdade();
    }

    public void setIdadeJogador(int idade) {
        this.jogador.setIdade(idade);
    }

    public boolean getVenceu() {
        return this.venceu;
    }

    public void setVenceu(boolean venceu) {
        this.venceu = venceu;
    }

    public Date getTempoFinal() {
        return this.tempoFinal;
    }

    public Date getTempoInicial() {
        return this.tempoInicial;

    }

    public void setScore(long score) {
        this.score += score;
    }

    public long getScore() {
        return score;
    }

    public long diferencaTempo() {
        long tempo = tempoFinal.getTime() - tempoInicial.getTime();
        return tempo;
    }

    public boolean resolvePartida() throws SemSolucaoException {
        return this.tabuleiro.isResolvivel();
    }
    
    public void darDicas() throws MovimentoInvalidoException, MovimentoIncorretoException{
      if(this.dicas <= dificuldade.getQuantidadeMaximaDicas()){
          int x=0,y=0;
          while(tabuleiro.getGrid()[x][y]!=0){
                x= random.nextInt(9);
                y= random.nextInt(9);
            }
          tabuleiro.executaMovimento(x, y, tabuleiro.getGabarito()[x][y]);
          this.dicas++;
      }  
    }
    public int getQuantidadeMaximaErrosDicas() {
        return this.dificuldade.getQuantidadeMaximaDicas();
    }
}
