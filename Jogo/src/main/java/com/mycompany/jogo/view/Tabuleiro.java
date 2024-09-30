package com.mycompany.jogo.view;

import com.mycompany.jogo.characters.*;

/*
Bernardo de Carvalho Rigolon – 202365561C 
Mickaell de Oliveira - 202365514B 
Miguel de Deus Oliveira – 202365521B 
Vinicius Campos Priamo – 202365567C 
*/

public class Tabuleiro {
    private Personagem[][] tab;
    private final int TAM = 11;

    public Tabuleiro() {
        this.tab = new Personagem[TAM][TAM];
        this.inicializaTab();
    }

    
    public void inicializaTab(){

        tab[0][5]=new Bandeira(1);
        tab[10][5]=new Bandeira(2);
        
        tab[0][10]=new Cuca(1);
        tab[10][10]=new Cuca(2);
        
        tab[0][1]=tab[1][0]=tab[0][9]=tab[1][10]=new Curupira(1);
        tab[10][1]=tab[9][0]=tab[10][9]=tab[9][10]=new Curupira(2);
        
        tab[0][2]=tab[0][8]=new Boitata(1);
        tab[10][2]=tab[10][8]=new Boitata(2);
        
        tab[0][3]=tab[0][7]=tab[2][2]=tab[2][8]=new BoiBumba(1);
        tab[10][3]=tab[10][7]=tab[8][2]=tab[8][8]=new BoiBumba(2);
        
        tab[0][4]=tab[0][6]=new Lobisomem(1);
        tab[10][4]=tab[10][6]=new Lobisomem(2);
        
        tab[0][0]=new MulaSemCabeca(1);
        tab[10][0]=new MulaSemCabeca(2);
        
        tab[1][1]=tab[1][4]=tab[1][6]=tab[1][9]=new Saci(1);
        tab[9][1]=tab[9][4]=tab[9][6]=tab[9][9]=new Saci(2);
        
        tab[1][2]=tab[1][8]=tab[2][5]=new Caipora(1);
        tab[9][2]=tab[9][8]=tab[8][5]=new Caipora(2);
        
        tab[1][3]=tab[1][7]=tab[2][0]=tab[2][10]=new BotoCorDeRosa(1);
        tab[9][3]=tab[9][7]=tab[8][0]=tab[8][10]=new BotoCorDeRosa(2);
        
        tab[2][1]=tab[2][4]=tab[2][6]=tab[2][9]=new Iara(1);
        tab[8][1]=tab[8][4]=tab[8][6]=tab[8][9]=new Iara(2);
        
        tab[2][3]=tab[8][3]=tab[1][5]=tab[9][5]=tab[2][7]=tab[8][7]=new Montanha();
        
        tab[4][2]=tab[4][3]=tab[5][2]=tab[5][3]=tab[6][2]=tab[6][3]=tab[4][7]=tab[5][7]=tab[6][7]=tab[4][8]=tab[5][8]=tab[6][8]=new Agua();
 
        } 
    
    public Personagem getPersonagem(int l, int c) {
        return tab[l][c];
    }

    public void setPersonagem(Personagem p, int l, int c) {
        this.tab[l][c] = p;
    }

    public Personagem[][] getTab() {
        return tab;
    } 
}