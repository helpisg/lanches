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
public class Sanduiche {
    private Pao pao;
    private Hamburger hamburger;
    private Salada salada;
    private Molho molho;

    public Pao getPao() {
        return pao;
    }

    public void setPao(Pao pao) {
        this.pao = pao;
    }

    public Hamburger getHamburger() {
        return hamburger;
    }

    public void setHamburger(Hamburger hamburger) {
        this.hamburger = hamburger;
    }

    public Salada getSalada() {
        return salada;
    }

    public void setSalada(Salada salada) {
        this.salada = salada;
    }

    public Molho getMolho() {
        return molho;
    }

    public void setMolho(Molho molho) {
        this.molho = molho;
    }
}
