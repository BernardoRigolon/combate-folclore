package com.mycompany.jogo.characters;

import com.mycompany.jogo.mechanics.Posicao;
import com.mycompany.jogo.view.Tabuleiro;

/*
Bernardo de Carvalho Rigolon – 202365561C 
Mickaell de Oliveira - 202365514B 
Miguel de Deus Oliveira – 202365521B 
Vinicius Campos Priamo – 202365567C 
*/

public class Iara extends Personagem {
    
    public Iara(int time)
    {
        this.setNome("Iara");
        this.setPoder(5);
        this.setTime(time);
        this.setDescricao("Pode se movimentar 1 para frente ou 2 para o lado");
    }
    
    @Override
    public boolean verificaPosicao(Posicao atual, Posicao depois, Tabuleiro tab)
    {
        int y;
        y = depois.getC() - atual.getC();
        if(Math.abs(y)>1)
        {
            if(y>0)
            {
                if((tab.getPersonagem(depois.getL(), depois.getC()-1) == null) && (tab.getPersonagem(depois.getL(), depois.getC()) == null || (tab.getPersonagem(depois.getL(), depois.getC()).getTime() != this.getTime()) && (tab.getPersonagem(depois.getL(), depois.getC()-1).getTime() != this.getTime())))
                return true;
        else
            return false;
            }
            else
            {
                if((tab.getPersonagem(depois.getL(), depois.getC()+1) == null) && (tab.getPersonagem(depois.getL(), depois.getC()) == null || (tab.getPersonagem(depois.getL(), depois.getC()).getTime() != this.getTime()) && (tab.getPersonagem(depois.getL(), depois.getC()+1).getTime() != this.getTime())))
                return true;
        else
                return false;
            }
        }
        else
        {
        if(tab.getPersonagem(depois.getL(), depois.getC()) == null || tab.getPersonagem(depois.getL(), depois.getC()).getTime() != this.getTime())
            return true;
        else
            return false;
        }
    }
    
    @Override
    public boolean verificaMovimentacao(Posicao atual, Posicao depois, Tabuleiro tab)
    {
        if(this.verificaPosicao(atual, depois, tab))
        {
        int x, y;
        x = depois.getL() - atual.getL();
        y = depois.getC() - atual.getC();
        if(Math.abs(y) > 2 || Math.abs(x) > 1 || (Math.abs(x)!=0 && Math.abs(y)!=0) || (x==0 && y==0))
        {
            return false;
        }
        else
        {
        return true;
        }
        }
        else
        {
      
        return false;
        }
    }
}
