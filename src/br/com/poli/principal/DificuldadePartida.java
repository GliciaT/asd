package br.com.poli.principal;

public enum DificuldadePartida {
    FACIL(0, 10), NORMAL(1, 5), DIFICIL(2, 3);

    private final int valor;
    private final int quantidadeMaximaErros;
    private final int quantidadeMaximaDicas;

    //Foi determinado pela equipe que a quantidade maxima de dicas seria iqual a de erros
    private DificuldadePartida(int valor, int quantidadeMaximaErros) {
        this.valor = valor;
        this.quantidadeMaximaErros = quantidadeMaximaErros;
        this.quantidadeMaximaDicas = quantidadeMaximaErros;
    }

    public int getValor() {
        return this.valor;
    }

    public int getQuantidadeMaximaErros() {
        return this.quantidadeMaximaErros;
    }
    
    public int getQuantidadeMaximaDicas() {
        return this.quantidadeMaximaDicas;
    }
}
