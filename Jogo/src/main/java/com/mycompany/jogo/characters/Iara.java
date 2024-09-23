package com.mycompany.jogo.characters;

import com.mycompany.jogo.mechanics.Posicao;
import com.mycompany.jogo.view.Tabuleiro;

public class Iara extends Personagem {
    
    public Iara(int time)
    {
        this.setNome("Iara");
        this.setPoder(5);
        this.setTime(time);
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
                if((this.getTab().getPersonagem(depois.getL(), depois.getC()-1) == null) && (this.getTab().getPersonagem(depois.getL(), depois.getC()) == null || this.getTab().getPersonagem(depois.getL(), depois.getC()).getTime() == this.getTime()))
                return true;
        else
            return false;
            }
            else
            {
                if((this.getTab().getPersonagem(depois.getL(), depois.getC()+1) == null) && (this.getTab().getPersonagem(depois.getL(), depois.getC()) == null || this.getTab().getPersonagem(depois.getL(), depois.getC()).getTime() == this.getTime()))
                return true;
        else
                return false;
            }
        }
        else
        {
        if(this.getTab().getPersonagem(depois.getL(), depois.getC()) == null || this.getTab().getPersonagem(depois.getL(), depois.getC()).getTime() != this.getTime())
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
        if(Math.abs(y) > 1 || Math.abs(x) > 2 || (Math.abs(x)!=0 && Math.abs(y)!=0) || (x==0 && y==0))
        {
            return false;
        }
        else
        {
        return true;
        }
        }
        System.out.println("Posição inválida");
        return false;
    }
}
