/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogo.characters;

import com.mycompany.jogo.mechanics.Posicao;
import java.awt.Image;

/**
 *
 * @author Vinicius
 */
public abstract class Personagem {
    private String nome;
    private int time;
    private int poder;
    private Image imagem;
    
    //Pega os mecanicas através de um vetor com o button click
    public abstract boolean verificaMovimentacao(Posicao atual, Posicao depois);
}
