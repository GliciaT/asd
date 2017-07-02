package br.com.poli.calculaScore;

import br.com.poli.interfaces.CalculaScore;
import br.com.poli.principal.Partida;

public class CalculaScoreSemIdade implements CalculaScore{

    @Override
    public void calcula(Partida partida) {    
        
        partida.setScore((((partida.getQuantidadeMaximaErrosDificuldade()-partida.getQuantidadeErros())/(1+partida.diferencaTempo()))*1000) - (partida.getDicas()*100) + partida.getScore());
    }
    
}
