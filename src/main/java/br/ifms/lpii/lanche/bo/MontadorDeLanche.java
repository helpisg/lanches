/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifms.lpii.lanche.bo;

import br.ifms.lpii.lanche.modelo.Componente;
import br.ifms.lpii.lanche.modelo.Hamburger;
import br.ifms.lpii.lanche.modelo.Molho;
import br.ifms.lpii.lanche.modelo.Pao;
import br.ifms.lpii.lanche.modelo.Salada;
import br.ifms.lpii.lanche.modelo.Sanduiche;
import java.math.BigDecimal;

/**
 *
 * @author Gustavo
 */
public class MontadorDeLanche {

    private Sanduiche sanduiche;
    private Hamburger[] hambugeres;
    private Salada[] saladas;
    private Pao[] paes;
    private Molho[] molhos;

    public MontadorDeLanche() {
        Hamburger bovino = new Hamburger();
        bovino.setDescricao("Carne Bovina");
        bovino.setValor(new BigDecimal("5.0"));

        Hamburger frango = new Hamburger();
        frango.setDescricao("Carne de Frango");
        frango.setValor(new BigDecimal("4.50"));

        Hamburger cavalo = new Hamburger();
        cavalo.setDescricao("Carne de Cavalo");
        cavalo.setValor(new BigDecimal("7.00"));

        hambugeres = new Hamburger[]{bovino, frango, cavalo};

        Salada tomate = new Salada();
        tomate.setDescricao("Tomate");
        tomate.setValor(new BigDecimal("2.50"));

        Salada alface = new Salada();
        alface.setDescricao("Alface");
        alface.setValor(new BigDecimal("3.00"));

        Salada cebola = new Salada();
        cebola.setDescricao("Cebola");
        cebola.setValor(new BigDecimal("2.00"));

        saladas = new Salada[]{tomate, alface, cebola};

        Pao pao = new Pao();
        pao.setDescricao("Francês");
        pao.setValor(new BigDecimal("5.00"));

        Pao pao2 = new Pao();
        pao2.setDescricao("Forma");
        pao2.setValor(new BigDecimal("4.00"));

        Pao pao3 = new Pao();
        pao3.setDescricao("Pão Francês com Gergelim");
        pao3.setValor(new BigDecimal("6.00"));

        paes = new Pao[]{pao, pao2, pao3};

        Molho molho = new Molho();
        molho.setDescricao("Catchup");
        molho.setValor(new BigDecimal("2.00"));

        Molho molho2 = new Molho();
        molho2.setDescricao("Mostarda");
        molho2.setValor(new BigDecimal("2.25"));

        Molho molho3 = new Molho();
        molho3.setDescricao("Maionese");
        molho3.setValor(new BigDecimal("1.50"));

        molhos = new Molho[]{molho, molho2, molho3};
    }

    public void novoLanche() {
        sanduiche = new Sanduiche();
    }

    public void adicionarComponenteNoSanduiche(Componente comp) {
        if (comp instanceof Hamburger) {
            Hamburger hamburger = (Hamburger) comp;
            sanduiche.setHamburger(hamburger);
        } else if (comp instanceof Salada) {
            Salada salada = (Salada) comp;
            sanduiche.setSalada(salada);
        } else if (comp instanceof Molho) {
            Molho molho = (Molho) comp;
            sanduiche.setMolho(molho);
        } else if(comp instanceof Pao){
            Pao pao = (Pao) comp; //CAST
            sanduiche.setPao(pao);
        }
    }

    public void removerComponenteDoSanduiche(Componente comp) {

    }

    public BigDecimal getValorSanduiche() {
        BigDecimal total = BigDecimal.ZERO;
        if (sanduiche.getHamburger() != null) {
            total = total.add(sanduiche.getHamburger().getValor());
        }

        if (sanduiche.getPao() != null) {

            total = total.add(sanduiche.getPao().getValor());
        }

        if (sanduiche.getSalada() != null) {

            total = total.add(sanduiche.getSalada().getValor());
        }

        if (sanduiche.getMolho() != null) {
            total = total.add(sanduiche.getMolho().getValor());
        }
        if (total.compareTo(BigDecimal.ZERO) > 0) {
            total = total.add(new BigDecimal("3.00"));
        }
        return total;
    }

    public Molho[] listarMolhos() {
        return molhos;
    }

    public Salada[] listarSaladas() {
        return saladas;
    }

    public Hamburger[] listarHamburger() {
        return hambugeres;
    }

    public Pao[] listarPaes() {
        return paes;
    }

}
