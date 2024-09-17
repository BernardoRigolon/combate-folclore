package com.mycompany.jogo.characters;

import com.mycompany.jogo.mechanics.Posicao;

public class BotoCorDeRosa extends Personagem {
    
    public BotoCorDeRosa(int time)
    {
        this.setNome("BotoCorDeRosa");
        this.setPoder(4);
        this.setTime(time);
    }
    
    @Override
    public boolean verificaPosicao(Posicao atual, Posicao depois)
    {
        if(tab[depois.getL()][depois.getC()] == null || tab[depois.getL()][depois.getC()].getPersonagem(depois.getL(), depois.getC()).getNome() == "Agua" || tab[depois.getL()][depois.getC()].getPersonagem(depois.getL(), depois.getC()).getTime() != this.getTime())
            return true;
        else
            return false;
    }
    
    @Override
    public boolean verificaMovimentacao(Posicao atual, Posicao depois)
    {
        if(this.verificaPosicao(atual, depois))
        {
        int x, y;
        x = depois.getL() - atual.getL();
        y = depois.getC() - atual.getC();
        if(Math.abs(y) > 1 || Math.abs(x) > 1 || (Math.abs(x)!=0 && Math.abs(x)!=0) || (x==0 && y==0))
            return false;
        else
            return true;
        }
        System.out.println("Posição inválida");
        return false;
    }    
}
