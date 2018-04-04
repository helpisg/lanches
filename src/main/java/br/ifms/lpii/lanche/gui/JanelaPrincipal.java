/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifms.lpii.lanche.gui;

import br.ifms.lpii.lanche.bo.MontadorDeLanche;
import br.ifms.lpii.lanche.modelo.Hamburger;
import br.ifms.lpii.lanche.modelo.Molho;
import br.ifms.lpii.lanche.modelo.Pao;
import br.ifms.lpii.lanche.modelo.Salada;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Gustavo
 */
public class JanelaPrincipal extends JFrame {

    private JComboBox comboBoxPao;
    private JComboBox comboBoxHamburguer;
    private JComboBox comboBoxSalada;
    private JComboBox comboBoxMolho;

    private JLabel rotuloPao;
    private JLabel rotuloHamburguer;
    private JLabel rotuloSalada;
    private JLabel rotuloMolho;

    private JPanel painel;
    private JPanel painelBotaoNovo;
    private JPanel painelBotaoCalcular;
    private JPanel painel1;
    private JPanel painel2;
    private JPanel painel3;
    private JPanel painel4;

    private JButton botaoCalcular;
    private JButton botaoNovo;
    private MontadorDeLanche montador;

    private JLabel rotuloTotal;

    public JanelaPrincipal() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 400);
        painel = new JPanel(new GridLayout(4, 1, 2, 2));

        montador = new MontadorDeLanche();
        comboBoxHamburguer = new JComboBox(montador.listarHamburger());
        comboBoxPao = new JComboBox(montador.listarPaes());
        comboBoxMolho = new JComboBox(montador.listarMolhos());
        comboBoxSalada = new JComboBox(montador.listarSaladas());
        comboBoxHamburguer.setEnabled(false);
        comboBoxMolho.setEnabled(false);
        comboBoxPao.setEnabled(false);
        comboBoxSalada.setEnabled(false);
        
        rotuloHamburguer = new JLabel("Hamburguer");
        rotuloMolho = new JLabel("Molho");
        rotuloPao = new JLabel("Pao");
        rotuloSalada = new JLabel("Salada");
         rotuloTotal = new JLabel("Total: ");
        botaoNovo = new JButton("Novo Lanche");

        
        painelBotaoCalcular = new JPanel();
        painelBotaoNovo = new JPanel();

        painel1 = new JPanel();
        painel1.add(rotuloHamburguer);
        painel1.add(comboBoxHamburguer);

        painel2 = new JPanel();
        painel2.add(rotuloPao);
        painel2.add(comboBoxPao);

        painel3 = new JPanel();
        painel3.add(rotuloMolho);
        painel3.add(comboBoxMolho);

        painel4 = new JPanel();
        painel4.add(rotuloSalada);
        painel4.add(comboBoxSalada);

        botaoCalcular = new JButton("OK");
        botaoCalcular.setEnabled(false);
        painelBotaoNovo.add(botaoNovo);
        painelBotaoCalcular.add(botaoCalcular);
        painelBotaoCalcular.add(rotuloTotal);

        painel.add(painel1);
        painel.add(painel2);
        painel.add(painel3);
        painel.add(painel4);

        add(painelBotaoNovo, BorderLayout.NORTH);
        add(painel, BorderLayout.CENTER);
        add(painelBotaoCalcular, BorderLayout.SOUTH);
        
        botaoNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                montador.novoLanche();
                comboBoxHamburguer.setEnabled(true);
                comboBoxMolho.setEnabled(true);
                comboBoxPao.setEnabled(true);
                comboBoxSalada.setEnabled(true);
                botaoCalcular.setEnabled(true);
            }
        });

        botaoCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hamburger hamburger = (Hamburger) comboBoxHamburguer.getSelectedItem();
                Salada salada = (Salada) comboBoxSalada.getSelectedItem();
                Pao pao = (Pao) comboBoxPao.getSelectedItem();
                Molho molho = (Molho) comboBoxMolho.getSelectedItem();

                montador.adicionarComponenteNoSanduiche(molho);
                montador.adicionarComponenteNoSanduiche(salada);
                montador.adicionarComponenteNoSanduiche(hamburger);
                montador.adicionarComponenteNoSanduiche(pao);
                
                BigDecimal total = montador.getValorSanduiche();
                rotuloTotal.setText("Total: "+total);
            }
        });
    }
    
    

}
