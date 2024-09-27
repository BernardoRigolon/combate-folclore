package com.mycompany.jogo.characters;

import com.mycompany.jogo.mechanics.Posicao;
import com.mycompany.jogo.view.Tabuleiro;

public class Agua extends Personagem {
    
    public Agua() {
    this.setNome("Agua");
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
