package com.mycompany.jogo.characters;

import com.mycompany.jogo.mechanics.Posicao;

public class Saci extends Personagem{

    @Override
    public boolean verificaMovimentacao(Posicao atual, Posicao depois)
    {
        int x, y;
        x = depois.getL() - atual.getL();
        y = depois.getC() - atual.getC();
        if(Math.abs(y) > 1 || Math.abs(x) > 1)
        {
            return false;
        }
        else
        {
        return true;
        }
    }
    
}
