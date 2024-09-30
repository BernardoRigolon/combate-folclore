package com.mycompany.jogo.characters;

import com.mycompany.jogo.mechanics.Posicao;
import com.mycompany.jogo.view.Tabuleiro;

public class Boitata extends Personagem {
    
    public Boitata(int time)
    {
        this.setNome("Boitata");
        this.setPoder(8);
        this.setTime(time);
    }
    
    @Override
    public boolean verificaPosicao(Posicao atual, Posicao depois, Tabuleiro tab)
    {
        int x,y;
        x = depois.getL() - atual.getL();
        y = depois.getC() - atual.getC();
        if(Math.abs(x)>1 || Math.abs(y)>1)
        {
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
            if(Math.abs(x)>1)
        {
            if(x>0)
            {
                if((tab.getPersonagem(depois.getL()-1, depois.getC()) == null) && (tab.getPersonagem(depois.getL(), depois.getC()) == null || (tab.getPersonagem(depois.getL(), depois.getC()).getTime() != this.getTime()) && (tab.getPersonagem(depois.getL()-1, depois.getC()).getTime() != this.getTime())))
                return true;
        else
            return false;
            }
            else
            {
                if((tab.getPersonagem(depois.getL()+1, depois.getC()) == null) && (tab.getPersonagem(depois.getL(), depois.getC()) == null || (tab.getPersonagem(depois.getL(), depois.getC()).getTime() != this.getTime()) && (tab.getPersonagem(depois.getL()+1, depois.getC()).getTime() != this.getTime())))
                return true;
        else
                return false;
            }
        }
        }
        else
        {
            if(tab.getPersonagem(depois.getL(), depois.getC()) == null || tab.getPersonagem(depois.getL(), depois.getC()).getTime() != this.getTime())
            return true;
        else
            return false;
        }
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
        if((Math.abs(y) > 2 || Math.abs(x) > 2) || (Math.abs(x)!=0 && Math.abs(y)!=0) || (x==0 && y==0))
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
