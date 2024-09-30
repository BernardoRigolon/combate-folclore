package com.mycompany.jogo.mechanics;

/*
Bernardo de Carvalho Rigolon – 202365561C 
Mickaell de Oliveira - 202365514B 
Miguel de Deus Oliveira – 202365521B 
Vinicius Campos Priamo – 202365567C 
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