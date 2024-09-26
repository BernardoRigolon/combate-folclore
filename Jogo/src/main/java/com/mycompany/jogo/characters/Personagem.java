package com.mycompany.jogo.characters;

import com.mycompany.jogo.mechanics.Posicao;
import java.awt.Image;
import com.mycompany.jogo.view.Tabuleiro;

public abstract class Personagem {
    private String nome;
    private int time;
    private int poder;
    private Image imagem;
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

    public Image getImagem() {
        return imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    public Tabuleiro getTab() {
        return tab;
    }

    public String getDescricao() {
        return descricao;
    }
    
    
    
}

