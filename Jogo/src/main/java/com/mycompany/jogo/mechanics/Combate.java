/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogo.mechanics;

import com.mycompany.jogo.characters.Personagem;
import com.mycompany.jogo.view.Tabuleiro;
import javax.swing.JOptionPane;

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
    public boolean ataque(Posicao pAtaque, Posicao pDefesa, Tabuleiro tab)
    {
        this.atacante=pAtaque;
        this.defensor=pDefesa;
        Personagem PersoAtaque=tab.getPersonagem(atacante.getL(), atacante.getC());
        Personagem PersoDefesa=tab.getPersonagem(defensor.getL(), defensor.getC());
        if(PersoAtaque.verificaMovimentacao(pAtaque, pDefesa, tab)==false)
        {
            System.out.println("Movimento invalido!");
            return false;
        }
        if(PersoDefesa!=null){
            if(PersoAtaque.getPoder()>PersoDefesa.getPoder())
            {
                verificaVitoria(PersoAtaque, PersoDefesa);
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
        return true;
    }
    
    public void verificaVitoria(Personagem pAtq, Personagem pDef)
    {
        if("Monteiro".equals(pDef.getNome()))
        {           
            JOptionPane.showMessageDialog(null, "Vitória do time " + pAtq.getTime()); 
        }
    }
}
