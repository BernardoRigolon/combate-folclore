/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogo.view;

/**
 *
 * @author Vinicius
 */
import com.mycompany.jogo.characters.Personagem;
import com.mycompany.jogo.characters.Saci;
import com.mycompany.jogo.characters.Bandeira;
import com.mycompany.jogo.characters.BoiBumba;
import com.mycompany.jogo.characters.Boitata;
import com.mycompany.jogo.characters.BotoCorDeRosa;
import com.mycompany.jogo.characters.Caipora;
import com.mycompany.jogo.characters.Cuca;
import com.mycompany.jogo.characters.Curupira;
import com.mycompany.jogo.characters.Iara;
import com.mycompany.jogo.characters.Lobisomem;
import com.mycompany.jogo.characters.MulaSemCabeca;
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
        // um monteiro lobato pra cada um
        tab[0][5]=new Bandeira(1);
        tab[10][5]=new Bandeira(2);
        // uma cuca pra cada lado
        tab[0][0]=new Cuca(1);
        tab[10][0]=new Cuca(2);
        //4 curupira pra cada lado
        tab[0][1]=tab[1][0]=tab[0][9]=tab[1][10]=new Curupira(1);
        tab[10][1]=tab[9][0]=tab[10][9]=tab[9][10]=new Curupira(2);
        //2 boitata pra cada lado
        tab[0][2]=tab[0][8]=new Boitata(1);
        tab[10][2]=tab[10][8]=new Boitata(2);
        //4 bumba meu boi pra cada lado
        tab[0][3]=tab[0][7]=tab[2][2]=tab[2][8]=new BoiBumba(1);
        tab[10][3]=tab[10][7]=tab[8][2]=tab[8][8]=new BoiBumba(2);
        // 2 lobisomem pra cada lado
        tab[0][4]=tab[0][6]=new Lobisomem(1);
        tab[10][4]=tab[10][6]=new Lobisomem(2);
        // 1 mula sem cabeça pra cada lado
        tab[0][0]=new MulaSemCabeca(1);
        tab[10][0]=new MulaSemCabeca(2);
        //4 saci pra cada lado
        tab[1][1]=tab[1][4]=tab[1][6]=tab[1][9]=new Saci(1);
        tab[9][1]=tab[9][4]=tab[9][6]=tab[9][9]=new Saci(2);
        //3 caipora pra cada lado
        tab[1][2]=tab[1][8]=tab[2][5]=new Caipora(1);
        tab[9][2]=tab[9][8]=tab[8][5]=new Caipora(2);
        //4 boto cor de rosa pra cada lado
        tab[1][3]=tab[1][7]=tab[2][0]=tab[2][10]=new BotoCorDeRosa(1);
        tab[9][3]=tab[9][7]=tab[8][0]=tab[8][10]=new BotoCorDeRosa(2);
        //4 iara pra cada lado
        tab[2][1]=tab[2][4]=tab[2][6]=tab[2][9]=new Iara(1);
        tab[8][1]=tab[8][4]=tab[8][6]=tab[8][9]=new Iara(2);
        /*//6 montanha
        tab[4][1]=tab[4][5]=tab[4][9]=
        tab[6][1]=tab[6][5]=tab[6][9]=new Montanha();
        //12 agua
        tab[4][2]=tab[4][3]=tab[5][2]=tab[5][3]=
        tab[4][7]=tab[8][3]=tab[5][7]=tab[5][8]=
        tab[5][4]=tab[5][9]=tab[7][4]=tab[7][9]=new Agua();
        */
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