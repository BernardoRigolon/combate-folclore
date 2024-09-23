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
        int x, y;
        x = depois.getL() - atual.getL();
        y = depois.getC() - atual.getC();
        if(x>0)
        {
            for(int i=0; i<x; i++)
            {
                if(this.getTab().getPersonagem(depois.getL(), depois.getC()+i) != null && (this.getTab().getPersonagem(depois.getL(), depois.getC()).getTime() == this.getTime() || this.getTab().getPersonagem(depois.getL(), depois.getC()).getNome() == "Agua"))
            return false;
            }
            return true;
        }
        if(x<0)
        {
            for(int i=0; i>x; i--)
            {
                if(this.getTab().getPersonagem(depois.getL(), depois.getC()-i) != null && (this.getTab().getPersonagem(depois.getL(), depois.getC()).getTime() == this.getTime() || this.getTab().getPersonagem(depois.getL(), depois.getC()).getNome() == "Agua"))
            return false;
            }
            return true;
        }
        if(y>0)
        {
           for(int i=0; i<y; i++)
            {
                if(this.getTab().getPersonagem(depois.getL(), depois.getC()+i) != null && (this.getTab().getPersonagem(depois.getL(), depois.getC()).getTime() == this.getTime() || this.getTab().getPersonagem(depois.getL(), depois.getC()).getNome() == "Agua"))
            return false;
            } 
           return true;
        }
        if(y<0)
        {
            for(int i=0; i>y; i--)
            {
                if(this.getTab().getPersonagem(depois.getL(), depois.getC()-i) != null && (this.getTab().getPersonagem(depois.getL(), depois.getC()).getTime() == this.getTime() || this.getTab().getPersonagem(depois.getL(), depois.getC()).getNome() == "Agua"))
            return false;
            }
            return true;
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
        if((Math.abs(y) > 3 || Math.abs(x) > 3) || (Math.abs(x)!=0 && Math.abs(y)!=0) || (x==0 && y==0))
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
