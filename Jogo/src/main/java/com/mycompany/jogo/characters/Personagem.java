package com.mycompany.jogo.characters;

import com.mycompany.jogo.mechanics.Posicao;
import java.awt.Image;
import com.mycompany.jogo.view.Tabuleiro;

/*
Bernardo de Carvalho Rigolon – 202365561C 
Mickaell de Oliveira - 202365514B 
Miguel de Deus Oliveira – 202365521B 
Vinicius Campos Priamo – 202365567C 
*/

public abstract class Personagem {
    private String nome;
    private int time;
    private int poder;
    Tabuleiro tab;
    private String descricao;  //Fazer a descrição da movimentação de cada
    
    //Pega os mecanicas através de um vetor com o button click
    public abstract boolean verificaMovimentacao(Posicao atual, Posicao depois, Tabuleiro tab);
    
    public abstract boolean verificaPosicao(Posicao atual, Posicao depois, Tabuleiro tab);

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public Tabuleiro getTab() {
        return tab;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    
    
}

