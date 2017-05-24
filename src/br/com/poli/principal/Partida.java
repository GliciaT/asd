package br.com.poli.principal;

import br.com.poli.exception.MovimentoIncorretoException;
import br.com.poli.exception.MovimentoInvalidoException;
import java.util.Date;

public class Partida {

    private Jogador jogador;
    private Tabuleiro tabuleiro = new Tabuleiro();
    private int quantidadeErros = 0;
    private boolean venceu;
    private Date tempoInicial = new Date();
    private Date tempoFinal = new Date();
    private int score;
    public DificuldadePartida dificuldade;

    public Partida(String nome, DificuldadePartida dificuldade) {
        this.tempoInicial.getTime();
        this.jogador = new Jogador(nome);
        this.dificuldade = dificuldade;
    }

    public void executaMovimento(int x, int y, int valor) throws MovimentoInvalidoException, MovimentoIncorretoException {
        try {
            boolean movimentoValido = this.tabuleiro.executaMovimento(x, y, valor);
            if (movimentoValido) {
                this.venceu = tabuleiro.isTabuleiroPreenchido();
            }
        } catch (MovimentoInvalidoException e) {
            System.out.println(e.getMessage());
        } catch (MovimentoIncorretoException e) {
            System.out.println(e.getMessage());
            this.quantidadeErros += 1;
        }
    }

    public boolean isFimDeJogo() {
        this.tempoFinal.getTime();
        if (this.quantidadeErros >= this.dificuldade.getQuantidadeMaximaErros()) {
            System.out.println("Errou mais do que podia. GAME OVER");
            return true;
        }
        return false;
    }

    public void iniciaPartida() {
        this.quantidadeErros = 0;
        this.tempoInicial = new Date();
        this.venceu = false;
        this.tabuleiro.geraTabuleiro(DificuldadePartida.FACIL);
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

    public boolean getVenceu() {
        return this.venceu;
    }

    public void setVenceu(boolean venceu) {
        this.venceu = venceu;
        
    }
    public Date getTempoFinal(){
        return this.tempoFinal;
    }
    public Date getTempoInicial(){
        return this.tempoInicial;
    }
    
    
}
