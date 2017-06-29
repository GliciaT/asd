/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.poli.calculaScore;

import br.com.poli.interfaces.CalculaScore;
import br.com.poli.principal.Partida;

public class CalculaScoreComIdade implements CalculaScore{

    @Override
    public void calcula(Partida partida) {
        if(partida.getIdadeJogador()!= 0){
        partida.setScore((((partida.getQuantidadeMaximaErrosDificuldade()-partida.getQuantidadeErros())*(partida.getIdadeJogador()+1))*1000) + (partida.getScore()/(partida.diferencaTempo()+1)));
        partida.getIdadeJogador();//para pegar a idade do Jogor e usar nos calculos
        } else System.out.println("Não foi definido uma idade válida");
    }
    
}
