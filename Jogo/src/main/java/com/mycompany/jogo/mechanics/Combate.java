package com.mycompany.jogo.mechanics;

import com.mycompany.jogo.characters.Personagem;
import com.mycompany.jogo.view.Tabuleiro;
import javax.swing.JOptionPane;

/*
Bernardo de Carvalho Rigolon – 202365561C 
Mickaell de Oliveira - 202365514B 
Miguel de Deus Oliveira – 202365521B 
Vinicius Campos Priamo – 202365567C 
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
            return false;
        }
        if(PersoDefesa!=null){
            if((PersoDefesa.getNome().equals("Agua") && !"Boto".equals(PersoAtaque.getNome())) || PersoDefesa.getNome().equals("Montanha"))
            {
                return false;
            }
            if(PersoAtaque.getNome().equals("Boto") && PersoDefesa.getNome().equals("Agua"))
            {
                if(defensor.getC()-atacante.getC()>0)
                {
                    defensor.setC(defensor.getC()+2);
                }
                if(defensor.getC()-atacante.getC()<0)
                {
                    defensor.setC(defensor.getC()-2);
                }
                if(defensor.getL()-atacante.getL()>0)
                {
                    defensor.setL(defensor.getL()+3);
                }
                if(defensor.getL()-atacante.getL()<0)
                {
                    defensor.setL(defensor.getL()-3);
                }
            }
            if(PersoAtaque.getPoder()>PersoDefesa.getPoder())
            {
                if(PersoAtaque.getNome().equals("Caipora") && PersoDefesa.getNome().equals("Monteiro"))
                {
                    return false;
                }
                verificaVitoria(PersoAtaque, PersoDefesa);
                if(!"Lobisomem".equals(PersoAtaque.getNome()) || !"Cuca".equals(PersoDefesa.getNome()))
                {
                    if("Caipora".equals(PersoAtaque.getNome()))
                    {
                        PersoAtaque.setPoder(0);
                        PersoDefesa.setPoder(PersoDefesa.getPoder()+PersoAtaque.getPoder());
                    }
                    else
                    PersoAtaque.setPoder(PersoAtaque.getPoder()-PersoDefesa.getPoder());
                }
                if("Caipora".equals(PersoAtaque.getNome()))
                {
                    tab.setPersonagem(null, atacante.getL(), atacante.getC());
                }
                else
                {
                tab.setPersonagem(PersoAtaque,defensor.getL(),defensor.getC());
                tab.setPersonagem(null, atacante.getL(), atacante.getC());
                }
            }
            else if(PersoAtaque.getPoder()<PersoDefesa.getPoder())
            {
                if("Lobisomem".equals(PersoAtaque.getNome()) && "Cuca".equals(PersoDefesa.getNome()))
                {
                    PersoDefesa.setPoder(0);
                    tab.setPersonagem(PersoAtaque,defensor.getL(),defensor.getC());
                    tab.setPersonagem(null, atacante.getL(), atacante.getC());
                }
                else
                {
                    if("Caipora".equals(PersoAtaque.getNome()))
                        PersoDefesa.setPoder(PersoDefesa.getPoder()+PersoAtaque.getPoder());
                    else
                        PersoDefesa.setPoder(PersoDefesa.getPoder()-PersoAtaque.getPoder());
                tab.setPersonagem(null, atacante.getL(), atacante.getC());
                }
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
            System.exit(0);
        }
    }
}
