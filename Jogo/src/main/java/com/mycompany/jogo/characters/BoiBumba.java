package com.mycompany.jogo.characters;

import com.mycompany.jogo.mechanics.Posicao;
import com.mycompany.jogo.view.Tabuleiro;

/*
Bernardo de Carvalho Rigolon – 202365561C 
Mickaell de Oliveira - 202365514B 
Miguel de Deus Oliveira – 202365521B 
Vinicius Campos Priamo – 202365567C 
*/

public class BoiBumba extends Personagem{
    
    public BoiBumba(int time)
    {
        this.setNome("BoiBumba");
        this.setPoder(3);
        this.setTime(time);
        this.setDescricao("Pode andar até 2 para frente ou até 2 para o lado e pula obstáculos");
    }
    
    @Override
    public boolean verificaPosicao(Posicao atual, Posicao depois, Tabuleiro tab)
    {
        if(tab.getPersonagem(depois.getL(), depois.getC()) == null || tab.getPersonagem(depois.getL(), depois.getC()).getTime() != this.getTime())
            return true;
        else
            return false;
    }
    
    @Override
    public boolean verificaMovimentacao(Posicao atual, Posicao depois, Tabuleiro tab)
    {
        if(this.verificaPosicao(atual, depois, tab))
        {
        int x, y;
        x = depois.getL() - atual.getL();
        y = depois.getC() - atual.getC();
        if(Math.abs(y) > 2 || Math.abs(x) > 2 || (Math.abs(x)!=0 && Math.abs(y)!=0) || (x==0 && y==0))
        {
            return false;
        }
        else
        {
        return true;
        }
        }
        
        return false;
    }
}
