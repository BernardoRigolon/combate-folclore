/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jogo;

import com.mycompany.jogo.view.Tabuleiro;
import com.mycompany.jogo.mechanics.Posicao;
import java.util.Scanner;
/**
 *
 * @author Vinicius
 */
public class Jogo {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Tabuleiro tab = new Tabuleiro();
        tab.imprimeTab();
        
        int i = 0;
        String posicao;
        Posicao ataque = null;
        Posicao alvo = null;
        //Aqui é pra ser tipo while(bandeira.poder > 0)
        while(i<4){
            System.out.println("Escreva a posição do boneco que quer usar:   (0,1)");
            posicao = teclado.nextLine();
            ataque = tab.parser(posicao);
            while(ataque == null){
                System.out.println("Escreva de novo: ");
                posicao = teclado.nextLine();
                ataque = tab.parser(posicao);
            }
            
            System.out.println("Escreva a posição do espaço que quer atacar:   (0,1)");
            posicao = teclado.nextLine();
            alvo = tab.parser(posicao);
            
            
            //Peguei o personagem que tá na posição de ataque e coloquei ele na posição(tab) do alvo;
            tab.setPersonagem(tab.getPersonagem(ataque.getL(), ataque.getC()), alvo.getL(), alvo.getC()); 
            //Botar null na posição do ataque
            tab.setPersonagem(null, ataque.getL(), ataque.getC());

            tab.imprimeTab();
            i++;
            
        } 
        
        System.out.println("Fim do jogo");
        teclado.close();
    }
}
