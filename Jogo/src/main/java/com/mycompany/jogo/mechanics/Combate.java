/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogo.mechanics;

import com.mycompany.jogo.characters.Personagem;
import com.mycompany.jogo.view.Tabuleiro;

/**
 *
 * @author Vinicius
 */
public class Combate {
    private Posicao atacante;
    private Posicao defensor;
    private Tabuleiro tab;

    public Combate(Tabuleiro tab) {
        this.tab = tab;
    }
    public void ataque(Posicao pAtaque, Posicao pDefesa)
    {
        this.atacante=pAtaque;
        this.defensor=pDefesa;
        Personagem PersoAtaque=tab.getPersonagem(atacante.getL(), atacante.getC());
        Personagem PersoDefesa=tab.getPersonagem(defensor.getL(), defensor.getC());
        if(PersoDefesa!=null){
            if(PersoAtaque.getPoder()>PersoDefesa.getPoder())
            {
     
                PersoAtaque.setPoder(PersoAtaque.getPoder()-PersoDefesa.getPoder());
                System.out.println("Agora "+PersoAtaque.getNome()+" Tem "+PersoAtaque.getPoder()+" de poder");
                tab.setPersonagem(PersoAtaque,defensor.getL(),defensor.getC());
                tab.setPersonagem(null, atacante.getL(), atacante.getC());
            }
            else if(PersoAtaque.getPoder()<PersoDefesa.getPoder())
            {
                PersoDefesa.setPoder(PersoDefesa.getPoder()-PersoAtaque.getPoder());
                tab.setPersonagem(null, atacante.getL(), atacante.getC());
            }
            else
            {
                tab.setPersonagem(null, atacante.getL(), atacante.getC());
                tab.setPersonagem(null, defensor.getL(), defensor.getC());
            }
        }
        else
        {
            tab.setPersonagem(PersoAtaque, defensor.getL(), defensor.getC());
            tab.setPersonagem(null, atacante.getL(), atacante.getC());
        }
    }
}
