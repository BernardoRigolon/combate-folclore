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
        if(this.getTab().getPersonagem(depois.getL(), depois.getC()+i) != null && (this.getTab().getPersonagem(depois.getL(), depois.getC()).getTime() == this.getTime() || this.getTab().getPersonagem(depois.getL(), depois.getC()).getNome() == "Agua"))
            return false;
        }
        }
        else
        {
            for(int i=0; i<x; i++)
        {
        if(this.getTab().getPersonagem(depois.getL(), depois.getC()-i) != null && (this.getTab().getPersonagem(depois.getL(), depois.getC()).getTime() == this.getTime() || this.getTab().getPersonagem(depois.getL(), depois.getC()).getNome() == "Agua"))
            return false;
        }
        }
        return true;
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
        if(((y > 1 || y < -4) || Math.abs(x) > 1) || (Math.abs(y) == Math.abs(y)) || (x==0 && y==0))
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
