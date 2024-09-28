/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogo.mechanics;

/**
 *
 * @author micka
 */
public class Jogador {
    private String nome;
    private String senha;

    public Jogador(String nome, String senha) {
        this.nome = nome;
        this.senha=senha;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha()
    {
        return senha;
    }
}