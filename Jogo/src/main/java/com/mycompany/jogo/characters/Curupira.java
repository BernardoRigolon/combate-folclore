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
    public boolean verificaMovimentacao(Posicao atual, Posicao depois)
    {
        int x, y;
        x = depois.getL() - atual.getL();
        y = depois.getC() - atual.getC();
        if(((y > 1 || y < -4) || Math.abs(x) > 1) || (Math.abs(y) == Math.abs(x)))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
