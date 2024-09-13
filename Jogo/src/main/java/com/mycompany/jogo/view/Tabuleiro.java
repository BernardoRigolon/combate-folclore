/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogo.view;

import com.mycompany.jogo.characters.Personagem;

/**
 *
 * @author Vinicius
 */
public class Tabuleiro {
    private Personagem[][] tab;
    private final int TAM = 11;

    public Tabuleiro() {
        this.tab = new Personagem[TAM][TAM];
        this.inicializaTab();
    }
    
    private void inicializaTab(){
        for(int i = 0; i<TAM;i++){
            for(int j = 0; j<TAM;j++){
                this.tab[i][j] = null;
            }
        }
    } 
    
    public void imprimeTab(){
         for(int i = 0; i<TAM;i++){
            for(int j = 0; j<TAM;j++){
                if(this.tab[i][j] == null)
                    System.out.print("Vazio" + " ");
                else
                    System.out.print(this.tab[i][j] + " ");
            }
             System.out.println();
        }
    }

    
    
}
