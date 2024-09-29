package com.mycompany.jogo.mechanics;

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