/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogo.view;

import com.mycompany.jogo.characters.Personagem;
import com.mycompany.jogo.characters.Saci;
import com.mycompany.jogo.mechanics.Posicao;

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
        
        tab[1][2] = new Saci();
        tab[3][5] = new Saci();
        tab[7][8] = new Saci();
    } 
    
    public void imprimeTab(){
         for(int i = 0; i<TAM;i++){
            for(int j = 0; j<TAM;j++){
                if(this.tab[i][j] == null)
                    System.out.print("Vazio" + " ");
                else
                    System.out.print(this.tab[i][j].getNome() + " ");
            }
             System.out.println();
        }
    }
    
    public Posicao parser(String ponto){
        if(ponto.charAt(0) != '(' || ponto.charAt(ponto.length()-1) != ')'){
            System.out.println("Escrito errado");
            return null;
        }
        
        String pontoSemExtremos = ponto.substring(1,ponto.length()-1);
        
        String[] numeros = pontoSemExtremos.split(",");
        
        if(numeros.length != 2){
            System.out.println("Escrito errado");
            return null;
        }
        
        String primeiro = numeros[0];
        String segundo = numeros[1];
        
        if(!ehInteiro(primeiro) || !ehInteiro(segundo)){
            System.out.println("Escrito errado");
            return null;
        }
        
        int l,c;
        l = Integer.parseInt(primeiro);
        c = Integer.parseInt(segundo);
        
        if(l<0 || l>10 || c<0 || c>10){
            System.out.println("Escrito errado");
            return null;
        }
        
        return new Posicao(l,c);       
    }
    
    private static boolean ehInteiro(String inteiro){
        
        for (int i = 0; i < inteiro.length(); i++) {
            if(inteiro.charAt(i) < '0' || inteiro.charAt(i) > '9')
                return false;
        }
        
        return true;
    }

    public Personagem getPersonagem(int l, int c) {
        return tab[l][c];
    }

    public void setPersonagem(Personagem p, int l, int c) {
        this.tab[l][c] = p;
    }
    
    
    
    
    
}
