package com.mycompany.jogo.characters;

import com.mycompany.jogo.mechanics.Posicao;
import java.awt.Image;

public abstract class Personagem {
    private String nome;
    private int time;
    private int poder;
    private Image imagem;
    
    //Pega os mecanicas através de um vetor com o button click
    public abstract boolean verificaMovimentacao(Posicao atual, Posicao depois);
    public void setNome(String nome)
    {
        this.nome=nome;
    }
    public void setPoder(int poder)
    {
        this.poder=poder;
    }
    public void setTime(int time)
    {
        this.time=time;
    }
    public String getNome()
    {
        return this.nome;
    }
    public int getPoder()
    {
        return this.poder;
    }
    public int getTime()
    {
        return this.time;
    }
}

