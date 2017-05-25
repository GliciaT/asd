/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poli.calculaScore;

import br.com.poli.interfaces.CalculaScore;
import br.com.poli.principal.Partida;

public class CalculaScoreSemIdade implements CalculaScore{

    @Override
    public void calcula(Partida partida) {    

        partida.setScore(partida.getQuantidadeMaximaErrosDificuldade()-partida.getQuantidadeErros()/partida.diferencaTempo(0));
        
    }
    
}
