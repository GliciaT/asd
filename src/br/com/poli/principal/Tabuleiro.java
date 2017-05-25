package br.com.poli.principal;

import br.com.poli.exception.MovimentoIncorretoException;
import br.com.poli.exception.MovimentoInvalidoException;

public class Tabuleiro {

    private int[][] gabarito
            = {{8, 4, 2, 7, 3, 9, 1, 5, 6},
            {9, 5, 3, 1, 2, 6, 8, 7, 4},
            {1, 7, 6, 5, 4, 8, 2, 3, 9},
            {3, 8, 4, 6, 1, 2, 7, 9, 5},
            {7, 1, 9, 8, 5, 3, 6, 4, 2},
            {6, 2, 5, 9, 7, 4, 3, 1, 8},
            {5, 9, 8, 3, 6, 7, 4, 2, 1},
            {4, 6, 7, 2, 9, 1, 5, 8, 3},
            {2, 3, 1, 4, 8, 5, 9, 6, 7}};
    ;
    ;

    public int[][] getGabarito() {
        return gabarito;
    }
    private int[][] grid = new int[9][9];

    public Tabuleiro() {

    }

    public boolean executaMovimento(int x, int y, int valor) throws MovimentoInvalidoException, MovimentoIncorretoException {
        if (valor <= 9 && valor >= 1) {
            if (x >= 0 && x <= 8 && y >= 0 && y <= 8) {
                if (this.grid[x][y] == 0) {
                    if (this.gabarito[x][y] == valor) {
                        this.grid[x][y] = valor;
                        System.out.println("Acertou");
                        return true;
                    } else {
                        throw new MovimentoIncorretoException("Jogada errada");
                    }
                } else {
                    throw new MovimentoInvalidoException("Campo já preenchido");
                }
            } else {
                throw new MovimentoInvalidoException("Movimento invalido");
            }
        } else {
            throw new MovimentoInvalidoException("Valor invalido");
        }
    }

    public boolean isTabuleiroPreenchido() {
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                if (this.grid[i][j] == 0) {
                    return false;
                }

            }
        }
        return true;
    }

    public void resolveTabuleiro() {

    }

    public void geraTabuleiro(DificuldadePartida dificuldadePartida) {

    }

    public int[][] getGrid() {
        return grid;
    }
}
