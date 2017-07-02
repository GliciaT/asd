package br.com.poli.principal;

import br.com.poli.exception.MovimentoIncorretoException;
import br.com.poli.exception.MovimentoInvalidoException;
import br.com.poli.exception.SemSolucaoException;
import br.com.poli.interfaces.ResolvedorSudoku;
import java.util.Random;

public class Tabuleiro implements ResolvedorSudoku {

    private int[][] grid = new int[9][9];
    private int[][] gabarito = new int[9][9];
    public Cell cell;

    public int[][] getGabarito() {
        return gabarito;
    }

    public Tabuleiro(DificuldadePartida dificuldadePartida) {
        geraTabuleiro(dificuldadePartida);
        cell = new Cell(0, 0);
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

    private void geraTabuleiro(DificuldadePartida dificuldadePartida) {
        Random random = new Random();

        final int n = 3;//aqui vai o número de elementos do seu sudoku(3 vai ser um sudoku 3×3
        int x = random.nextInt(1000);//semente aleatória para não gerar o mesmo sudoku
        for (int i = 0; i < n; i++, x++) {
            for (int j = 0; j < n; j++, x += n) {
                for (int k = 0; k < n * n; k++, x++) {
                    this.grid[n * i + j][k] = (x % (n * n)) + 1;
                }
            }
        }
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                this.gabarito[i][j] = this.grid[i][j];
            }
        }
        //this.grid = new int[9][9];
        int y;
        //corrigir nas exceptions
        for (int d = 0; d <= 35 + (15 * dificuldadePartida.getValor()); d++) {
            x = random.nextInt(9);
            y = random.nextInt(9);
            if (this.grid[x][y] != 0) {
                this.grid[x][y] = 0;
            } else {
                d--;
            }
        }
    }

    public int[][] getGrid() {
        return grid;
    }

    //Class para fazer uma representação separada da matriz e resolver.
    public class Cell {

        int linha, col;

        public Cell(int linha, int col) {
            super();
            this.linha = linha;
            this.col = col;
        }

        @Override
        public String toString() {
            return "Cell [linha=" + linha + ", col=" + col + "]";
        }
    };

    boolean isValid(Cell cell, int value) {

        if (grid[cell.linha][cell.col] != 0) {
            throw new RuntimeException(
                    "Cannot call for cell which already has a value");
        }

        // se existir nessa linha, return false
        for (int c = 0; c < 9; c++) {
            if (grid[cell.linha][c] == value) {
                return false;
            }
        }

        // if existir nessa coluna, return false
        for (int r = 0; r < 9; r++) {
            if (grid[r][cell.col] == value) {
                return false;
            }
        }

        // se presente nesse quadrante, return false
        // para fazer o quadrante (x1,y1) (x2,y2)
        int x1 = 3 * (cell.linha / 3);
        int y1 = 3 * (cell.col / 3);
        int x2 = x1 + 2;
        int y2 = y1 + 2;

        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                if (grid[x][y] == value) {
                    return false;
                }
            }
        }

        // se não existir esse valor na mesma linha, coluna ou quadrante, return true
        return true;
    }

    Cell getNextCell(Cell cur) {

        int row = cur.linha;
        int col = cur.col;

        col++;

        if (col > 8) {
            // goto next line
            col = 0;
            row++;
        }

        // atingiu o final da matriz, return null
        if (row > 8) {
            return null; //
        }
        Cell next = new Cell(row, col);
        return next;
    }

    // deve retornar true, se o sudoku foi solucionado, retorna false caso n
    @Override
    public boolean resolveTabuleiro(Cell cur) {

        if (cur == null) {
            return true;
        }

        //se já tiver um valor preenchido, pula
        if (grid[cur.linha][cur.col] != 0) {
            return resolveTabuleiro(getNextCell(cur));
        }

        // Se grid[cur] não tem um valor válido, tenta o próximo valor
        for (int i = 1; i <= 9; i++) {
            // checa se está válido. Caso sim, atualiza
            boolean valid = isValid(cur, i);

            if (!valid) {
                continue;
            }

            grid[cur.linha][cur.col] = i;

            boolean solved = resolveTabuleiro(getNextCell(cur));

            if (solved) {
                return true;
            } else {
                grid[cur.linha][cur.col] = 0;
            }
        }
        return false;
    }

    @Override
    public boolean isResolvivel() throws SemSolucaoException {
        boolean resolve = resolveTabuleiro(cell);
        if (!resolve) {
            throw new SemSolucaoException("Sem solução.");
        }
        System.out.println("Solucao\n");
        for (int i = 0; i < getGrid().length; i++) {
            for (int j = 0; j < getGrid()[i].length; j++) {
                System.out.print(getGrid()[i][j]);
            }
            System.out.println("");
        }
        return true;
    }

    /*Serve para o proprio sistema poder mexer no tabuleiro depois,
    sendo limitado as classes do mesmo pacote (Interface não vai ter acesso a isso)
     */
    protected void setMovimentoEspecial(int x, int y, int valor) {
        this.grid[x][y] = valor;
    }
}
/*public void main(String[] args) {
  boolean solved = resolveTabuleiro(new Cell(0, 0));
  if (!solved) {
   System.out.println("SUDOKU cannot be solved.");
   return;
  }
  System.out.println("SOLUTION\n");
  printGrid(grid);
 }*/
// utility to print the grid

