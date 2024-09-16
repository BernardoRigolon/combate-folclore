/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogo.characters;

import com.mycompany.jogo.mechanics.Posicao;

/**
 *
 * @author berig
 */
public class Boitata extends Personagem{
    public Boitata(int time)
    {
        this.setNome("Boitata");
        this.setPoder(8);
        this.setTime(time);
    }
    @Override
    public boolean verificaMovimentacao(Posicao atual, Posicao depois)
    {
        return false;
    }
}
