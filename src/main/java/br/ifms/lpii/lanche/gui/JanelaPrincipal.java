/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifms.lpii.lanche.gui;

import br.ifms.lpii.lanche.modelo.Componente;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Gustavo
 */
public class JanelaPrincipal extends JFrame {

    private JComboBox comboBox;
    private JPanel painel;
    private JButton botao;

    public JanelaPrincipal() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 400);
        painel = new JPanel();

        String[] vet = new String[]{"Maçã", "Banana", "Abacate"};

        comboBox = new JComboBox(vet);
        botao = new JButton("OK");
        painel.add(comboBox);
        painel.add(botao);
        
        add(painel, BorderLayout.CENTER);

        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Componente item = (Componente) comboBox.getSelectedItem();
                JOptionPane.showMessageDialog(null, item);
            }
        });
    }

}
