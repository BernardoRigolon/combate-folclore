package com.mycompany.jogo.characters;

import com.mycompany.jogo.mechanics.Posicao;

public class Lobisomem extends Personagem {
    
    public Lobisomem(int time)
    {
        this.setNome("Lobisomem");
        this.setPoder(1);
        this.setTime(time);
    }
    
    @Override
    public boolean verificaMovimentacao(Posicao atual, Posicao depois)
    {
        int x, y;
        x = depois.getL() - atual.getL();
        y = depois.getC() - atual.getC();
        if(Math.abs(y) > 1 || Math.abs(x) > 1 || (Math.abs(x)!=0 && Math.abs(x)!=0))
        {
            return false;
        }
        else
        {
        return true;
        }
    }
}
