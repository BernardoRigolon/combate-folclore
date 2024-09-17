package com.mycompany.jogo.characters;

import com.mycompany.jogo.mechanics.Posicao;

public class Curupira extends Personagem{
    
    public Curupira(int time)
    {
        this.setNome("Curupira");
        this.setPoder(6);
        this.setTime(time);
    }
    
    @Override
    public boolean verificaPosicao(Posicao atual, Posicao depois)
    {
        int x;
        x = Math.abs(depois.getL() - atual.getL());
        if(x>1)
        {
        if(this.getTime()==1)
        {
        for(int i=0; i<x; i++)
        {
        if(tab[depois.getL()][depois.getC()+i] != null && (tab[depois.getL()][depois.getC()].getPersonagem(depois.getL(), depois.getC()).getTime() == this.getTime() || tab[depois.getL()][depois.getC()].getPersonagem(depois.getL(), depois.getC()).getNome() == "Agua"))
            return false;
        }
        }
        else
        {
            for(int i=0; i<x; i++)
        {
        if(tab[depois.getL()][depois.getC()-i] != null && (tab[depois.getL()][depois.getC()].getPersonagem(depois.getL(), depois.getC()).getTime() == this.getTime() || tab[depois.getL()][depois.getC()].getPersonagem(depois.getL(), depois.getC()).getNome() == "Agua"))
            return false;
        }
        }
        return true;
        }
        else
        {
            if(tab[depois.getL()][depois.getC()] == null || tab[depois.getL()][depois.getC()].getPersonagem(depois.getL(), depois.getC()).getTime() != this.getTime())
            return true;
        else
            return false;
        }
    }
    
    @Override
    public boolean verificaMovimentacao(Posicao atual, Posicao depois)
    {
        if(this.verificaPosicao(atual, depois))
        {
        int x, y;
        x = depois.getL() - atual.getL();
        y = depois.getC() - atual.getC();
        if(((y > 1 || y < -4) || Math.abs(x) > 1) || (Math.abs(y) == Math.abs(x)) || (x==0 && y==0))
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
