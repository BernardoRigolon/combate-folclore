package com.mycompany.jogo.characters;

import com.mycompany.jogo.mechanics.Posicao;

public class Agua extends Personagem {
    
    public Agua() {
    this.setNome("Agua");
}
    
    @Override
    public boolean verificaMovimentacao(Posicao atual, Posicao depois) {
        return false;
    }

    @Override
    public boolean verificaPosicao(Posicao atual, Posicao depois) {
        return false;
    }
    
}
