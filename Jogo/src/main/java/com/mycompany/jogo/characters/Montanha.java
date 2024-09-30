package com.mycompany.jogo.characters;

import com.mycompany.jogo.mechanics.Posicao;
import com.mycompany.jogo.view.Tabuleiro;

/*
Bernardo de Carvalho Rigolon – 202365561C 
Mickaell de Oliveira - 202365514B 
Miguel de Deus Oliveira – 202365521B 
Vinicius Campos Priamo – 202365567C 
*/

public class Montanha extends Personagem {
    
    public Montanha()
    {
      this.setNome("Montanha");
      this.setDescricao("Instransponível");
    }
    
    @Override
    public boolean verificaMovimentacao(Posicao atual, Posicao depois, Tabuleiro tab) {
        return false;
    }

    @Override
    public boolean verificaPosicao(Posicao atual, Posicao depois, Tabuleiro tab) {
        return false;
    }
}
