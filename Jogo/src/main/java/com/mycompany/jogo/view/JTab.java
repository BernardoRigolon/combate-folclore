/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogo.view;

import com.mycompany.jogo.characters.Personagem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTab extends JFrame {
    private Tabuleiro tabuleiro;
    private Personagem[][] tab;
    private final int TAM = 11;
    private JButton[][] tela = new JButton[TAM][TAM];

    public JTab() {
        super("Tabuleiro do Jogo");
        this.tab = new Personagem[TAM][TAM];
        tabuleiro = new Tabuleiro();
        tabuleiro.inicializaTab();
        this.tab = tabuleiro.getTab(); // Inicializar o tabuleiro com personagens

        // Configura o layout do tabuleiro em uma grade 11x11
        JPanel board = new JPanel(new GridLayout(TAM, TAM));
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                JButton botoes = new JButton();
                
                // Definir a aparência das células com base no personagem
                if (tab[i][j] != null) {
                    botoes.setText(tab[i][j].getNome() + " - " + tab[i][j].getPoder());  // Exibe o nome do personagem
                } else {
                    botoes.setText("");  // Se não houver personagem, exibe "Nada"
                }
                
                tela[i][j] = botoes;
                board.add(botoes);
                
                // Adicionar um listener de clique se quiser permitir interação
                botoes.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton source = (JButton) e.getSource();
                    }
                });
            }
        }

        add(board);
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

