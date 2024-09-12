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
}
