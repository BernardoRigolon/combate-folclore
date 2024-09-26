/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogo.view;

import com.mycompany.jogo.characters.Personagem;
import com.mycompany.jogo.mechanics.Combate;
import com.mycompany.jogo.mechanics.Posicao;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTab extends JFrame {
    private Tabuleiro tabuleiro;
    private Personagem[][] tab;
    private final int TAM = 11;
    private JButton[][] tela = new JButton[TAM][TAM];
    
    private int linhaAtc = -1;
    private int colunaAtc = -1;
    private Personagem personagemAtc = null;
    
    private Posicao ataque;
    private Posicao defesa;
    
    private boolean vez1 = true;

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
                atualizaCelula(botoes,i,j);
                
                botoes.setBackground(Color.white);
                
                final int l = i;
                final int c = j;
                
                // Adicionar um listener de clique se quiser permitir interação
               botoes.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton botao = tela[l][c];
                        
                        if(personagemAtc == null){
                           if(tab[l][c] != null){
                               if((tab[l][c].getTime()==1 && vez1) || (tab[l][c].getTime()==2 && !vez1)){
                                    personagemAtc = tab[l][c];
                                    linhaAtc = l;
                                    colunaAtc = c;
                                    ataque = new Posicao(l,c);
                                    botao.setBackground(Color.blue); 
                                    vez1 = !vez1;
                                    System.out.println("Entrou e trocou o vez");
                               }
                               else
                                   JOptionPane.showMessageDialog(null, "Vez do outro jogador");   
                           }
                        }
                        else{
                            defesa = new Posicao(l,c);
                            Combate combate = new Combate(tabuleiro);
                            boolean podeAtacar = combate.ataque(ataque, defesa, tabuleiro);
                            
                            if(podeAtacar){
                               atualizaCelula(tela[linhaAtc][colunaAtc],linhaAtc,colunaAtc);
                               atualizaCelula(tela[l][c],l,c); 
                               botao.setBackground(Color.green);
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Movimento inválido!");
                                vez1=!vez1;
                            }
                            
                            tela[linhaAtc][colunaAtc].setBackground(Color.white);
                            tela[l][c].setBackground(Color.white);
                            personagemAtc = null;
                            linhaAtc = -1;
                            colunaAtc = -1;
                            
                            
                            
                        }
                    }
                   
               });
               
               
               tela[i][j] = botoes;
               botoes.setBackground(Color.white);
               board.add(botoes);
            }
        }

        add(board);
        setSize(900, 900);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    private void atualizaCelula(JButton button, int l, int c) {
        if (tab[l][c] != null) {
            button.setText(tab[l][c].getNome() + "-" + tab[l][c].getPoder());
            if(tab[l][c].getTime() == 1)
                button.setForeground(Color.red);
            else
                button.setForeground(Color.green);
        } else {
            button.setText("");
        }
    }
}

