package br.com.poli.interfaces;

import br.com.poli.principal.Tabuleiro;

public interface ResolvedorSudoku {
    public boolean resolveTabuleiro(Tabuleiro.Cell cur);
}
