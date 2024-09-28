/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogo.view;
import com.mycompany.jogo.mechanics.Administrador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author micka
 */


public class TelaInicial extends JFrame {
    
    public TelaInicial() {

        super("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(new BorderLayout());

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(3, 1, 10, 10)); 

        JButton btnNovoJogo = new JButton("Novo Jogo");
        btnNovoJogo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarNovoJogo();
            }
        });
        painelBotoes.add(btnNovoJogo);
        JButton btnAdministracao = new JButton("Tela de Administração");
        btnAdministracao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaAdministracao();
            }
        });
        painelBotoes.add(btnAdministracao);

        JButton btnRegras = new JButton("Regras do Jogo");
        btnRegras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarRegras();
            }
        });
        painelBotoes.add(btnRegras);
        add(painelBotoes, BorderLayout.CENTER);
        setVisible(true);
    }


    private void iniciarNovoJogo() {
            JTab j = new JTab();
    }


    private void abrirTelaAdministracao() {
        Administrador administrador = new Administrador(); 
    }


    private void mostrarRegras() {
        //colocar as regras aq 
        String regras = "Tem que colocar as regras ainda\n";
        JOptionPane.showMessageDialog(this, regras, "Regras do Jogo", JOptionPane.INFORMATION_MESSAGE);
    }
}