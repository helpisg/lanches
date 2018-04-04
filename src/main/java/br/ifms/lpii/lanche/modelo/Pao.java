/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifms.lpii.lanche.modelo;

/**
 *
 * @author Gustavo
 */
public class Pao extends Componente implements Comparable<Pao>{

    @Override
    public int compareTo(Pao obj) {
        if(this.getValor().compareTo(obj.getValor()) == 0){
            return 0;
        }    
        if(this.getValor().compareTo(obj.getValor()) < 0){
            return -1;
        }     
        return 1;
    }
    
}
