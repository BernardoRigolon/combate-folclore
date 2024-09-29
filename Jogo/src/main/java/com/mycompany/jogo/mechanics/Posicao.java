package com.mycompany.jogo.mechanics;

public class Posicao {

    private int l;
    private int c;
    
    public Posicao(int l, int c)
    {
        this.l = l;
        this.c = c;
    }
    
    public int getL()
    {
        return this.l;
    }
    
    public int getC()
    {
        return this.c;
    }

    public void setL(int l) {
        this.l = l;
    }

    public void setC(int c) {
        this.c = c;
    }
    
    
}
