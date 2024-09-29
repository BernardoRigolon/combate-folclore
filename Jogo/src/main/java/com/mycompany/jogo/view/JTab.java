package com.mycompany.jogo.view;

import com.mycompany.jogo.characters.Personagem;
import com.mycompany.jogo.mechanics.Combate;
import com.mycompany.jogo.mechanics.Posicao;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


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
        this.tab = tabuleiro.getTab(); 

        // Configura o layout do tabuleiro em uma grade 11x11
        JPanel board = new JPanel(new GridLayout(TAM, TAM));
        
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                JButton botoes = new JButton();
              
                // Definir a aparência das células com base no personagem
                atualizaCelula(botoes,i,j);
                
                final int l = i;
                final int c = j;
                
                // Adicionar um listener de clique se quiser permitir interação
               botoes.addActionListener((ActionEvent e) -> {
                   JButton botao = tela[l][c];
                   
                   if(personagemAtc == null){
                       if(tab[l][c] != null){
                           if((tab[l][c].getTime()==1 && vez1) || (tab[l][c].getTime()==2 && !vez1)){
                               personagemAtc = tab[l][c];
                               linhaAtc = l;
                               colunaAtc = c;
                               ataque = new Posicao(l,c);
                               botao.setForeground(Color.white);
                               vez1 = !vez1;
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
                       }
                       else{
                           if(tab[l][c].getTime() == 1)
                                tela[linhaAtc][colunaAtc].setForeground(new Color(145,8,148));
                           else
                                tela[linhaAtc][colunaAtc].setForeground(new Color(255, 116, 2));
                           JOptionPane.showMessageDialog(null, "Movimento inválido!");
                           vez1=!vez1;
                       }
                       personagemAtc = null;
                       linhaAtc = -1;
                       colunaAtc = -1;
                   }
                });
               tela[i][j] = botoes;
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
            if("Agua".equals(tab[l][c].getNome()) || "Montanha".equals(tab[l][c].getNome())){
                button.setText("");
            }
            else
                button.setText(tab[l][c].getNome() + "-" + tab[l][c].getPoder());
            button.setToolTipText(tab[l][c].getDescricao());
            if(tab[l][c].getTime() == 1)
                button.setForeground(new Color(145,8,148));
            else
                button.setForeground(new Color(255, 116, 2));
            
            if((l+c)%2==0){
                if("Agua".equals(tab[l][c].getNome()))
                    button.setBackground(new Color(15, 142, 171));
                else if("Montanha".equals(tab[l][c].getNome()))
                    button.setBackground(new Color(210, 115, 21));
                else
                    button.setBackground(new Color(142,204,59));
            }                    
            else{
                if("Agua".equals(tab[l][c].getNome()))
                    button.setBackground(new Color(15, 142, 171));
                else if("Montanha".equals(tab[l][c].getNome()))
                    button.setBackground(new Color(210, 115, 21));
                else
                    button.setBackground(new Color(167,218,74));
            }
        } else {
            button.setText("");
            if((l+c)%2==0){
                button.setBackground(new Color(142,204,59));
            }                    
            else
                button.setBackground(new Color(167,218,74));
        }
    }
}

