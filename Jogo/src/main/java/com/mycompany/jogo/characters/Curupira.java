package com.mycompany.jogo.characters;

import com.mycompany.jogo.mechanics.Posicao;
import com.mycompany.jogo.view.Tabuleiro;

public class Curupira extends Personagem{
    
    public Curupira(int time)
    {
        this.setNome("Curupira");
        this.setPoder(6);
        this.setTime(time);
    }
    
    @Override
    public boolean verificaPosicao(Posicao atual, Posicao depois, Tabuleiro tab)
    {
        int x;
        x = Math.abs(depois.getL() - atual.getL());
        if(x>1)
        {
        if(this.getTime()==1)
        {
        for(int i=0; i<x; i++)
        {
        if(tab.getPersonagem(depois.getL()-i, depois.getC()) != null && (tab.getPersonagem(depois.getL(), depois.getC()).getTime() == this.getTime() || "Agua".equals(tab.getPersonagem(depois.getL(), depois.getC()).getNome())))
            return false;
        }
        }
        else
        {
            for(int i=0; i<x; i++)
        {
        if(tab.getPersonagem(depois.getL()+i, depois.getC()) != null && (tab.getPersonagem(depois.getL(), depois.getC()).getTime() == this.getTime() || "Agua".equals(tab.getPersonagem(depois.getL(), depois.getC()).getNome())))
            return false;
        }
        }
        return true;
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
        if(((x > 4 || x < -4) || Math.abs(y) > 1) || (Math.abs(x)!=0 && Math.abs(y)!=0) || (x==0 && y==0))
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
        System.out.println("Posição inválida");
        return false;
        }
    }
}
