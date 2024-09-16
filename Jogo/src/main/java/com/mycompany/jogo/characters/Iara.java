package com.mycompany.jogo.characters;

import com.mycompany.jogo.mechanics.Posicao;

public class Iara extends Personagem {
    
    public Iara(int time)
    {
        this.setNome("Iara");
        this.setPoder(5);
        this.setTime(time);
    }
    
    @Override
    public boolean verificaMovimentacao(Posicao atual, Posicao depois)
    {
        int x, y;
        x = depois.getL() - atual.getL();
        y = depois.getC() - atual.getC();
        if(Math.abs(y) > 1 || Math.abs(x) > 2 || (Math.abs(x)!=0 && Math.abs(x)!=0))
        {
            return false;
        }
        else
        {
        return true;
        }
    }
}
