package com.mycompany.jogo.characters;

import com.mycompany.jogo.mechanics.Posicao;

public class Boitata extends Personagem {
    
    public Boitata(int time)
    {
        this.setNome("Boitata");
        this.setPoder(8);
        this.setTime(time);
    }
    
    @Override
    public boolean verificaMovimentacao(Posicao atual, Posicao depois)
    {
        int x, y;
        x = depois.getL() - atual.getL();
        y = depois.getC() - atual.getC();
        if((Math.abs(y) > 3 || Math.abs(x) > 3) || (Math.abs(x)!=0 && Math.abs(x)!=0))
        {
            return false;
        }
        else
        {
        return true;
        }
    }
}
