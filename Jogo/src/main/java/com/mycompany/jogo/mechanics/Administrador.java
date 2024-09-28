/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogo.mechanics;


import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author micka
 */

public class Administrador extends JFrame {
    private static final String admArq = "administradores.txt";
    private static final String jogArq = "jogadores.txt";

    public Administrador() {
        if (loginAdm()) {
            opcoesAdm();
        } else {
            JOptionPane.showMessageDialog(null, "Credenciais inválidas");
        }
    }

    private boolean loginAdm() {
        JTextField nome = new JTextField(10);
        JPasswordField senha = new JPasswordField(10);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(3, 2));
        painel.add(new JLabel("Nome do ADM:"));
        painel.add(nome);
        painel.add(new JLabel("Senha:"));
        painel.add(senha);

        int res = JOptionPane.showConfirmDialog(null, painel, "Login do Administrador", JOptionPane.OK_CANCEL_OPTION);
        if (res == JOptionPane.OK_OPTION) {
            String sNome = nome.getText();
            String sSenha = new String(senha.getPassword());

            return verificarLogin(sNome, sSenha, admArq);
        }
        return false;
    }

    private boolean verificarLogin(String nome, String senha, String arquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] cadastro = linha.split(":"); // tem que colocar usuario:senha no arquivo
                if (cadastro.length == 2) {
                    String nomeArquivo = cadastro[0];
                    String senhaArquivo = cadastro[1];

                    if (nomeArquivo.equals(nome) && senhaArquivo.equals(senha)) {
                        return true; 
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo de " + arquivo);
        }
        return false; 
    }

    
    private void opcoesAdm() {
        String[] opcoes = {"Adicionar Jogador", "Remover Jogador", "Ver Lista de Jogadores"};
        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu de Administração",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

        switch (escolha) {
            case 0: cadastrar();      break;
            case 1: removerJogador(); break;
            case 2: exibirJogadores();break;
        }
    }

    public void cadastrar() {
        JTextField nomeJ = new JTextField(10);
        JPasswordField senhaJ = new JPasswordField(10);
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(3, 2));
        painel.add(new JLabel("Nome do novo jogador:"));
        painel.add(nomeJ);
        painel.add(new JLabel("Senha do novo jogador:"));
        painel.add(senhaJ);

        int res = JOptionPane.showConfirmDialog(null, painel, "Cadastrar novo jogador", JOptionPane.OK_CANCEL_OPTION);
        if (res == JOptionPane.OK_OPTION) {
            String nome = nomeJ.getText();
            String senha = new String(senhaJ.getPassword());
            Jogador novo = new Jogador(nome, senha);
            salvarJogador(novo);
            JOptionPane.showMessageDialog(null, "Jogador cadastrado!");
        }
    }

    private void salvarJogador(Jogador jogador) {
        try (FileWriter fw = new FileWriter(jogArq, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(jogador.getNome() + ":" + jogador.getSenha());
            bw.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro arquivo jogadores");
        }
    }
    
    public void removerJogador() {
        ArrayList<Jogador> jogadores = getJogadores();
        if (jogadores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum jogador cadastrado.");
            return;
        }
        String[] nomes = jogadores.stream().map(Jogador::getNome).toArray(String[]::new);

        String jgdrSelecionado = (String) JOptionPane.showInputDialog(null, "Selecione o jogador para remover",
                "Remover Jogador", JOptionPane.QUESTION_MESSAGE, null, nomes, nomes[0]);

        if (jgdrSelecionado != null) {
            jogadores.removeIf(jogador -> jogador.getNome().equals(jgdrSelecionado));
            salvarTodosJogadores(jogadores);
            JOptionPane.showMessageDialog(null, "Jogador removido");
        }
    }
    
    private void salvarTodosJogadores(ArrayList<Jogador> jogadores) {
        try (FileWriter fw = new FileWriter(jogArq, false);
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (Jogador jogador : jogadores) {
                bw.write(jogador.getNome() + ":" + jogador.getSenha());
                bw.newLine();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro arquivo jogadores");
        }
    }

    public ArrayList<Jogador> getJogadores() {
        ArrayList<Jogador> jogadores = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(jogArq))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(":");
                if (dados.length == 2) {
                    Jogador jogador = new Jogador(dados[0], dados[1]);
                    jogadores.add(jogador);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro arquivo jogadores");
        }

        return jogadores;
    }
    
    public void exibirJogadores() {
        ArrayList<Jogador> jogadores = getJogadores();
        if (jogadores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum jogador cadastrado.");
        } else {
            StringBuilder sb = new StringBuilder("Jogadores cadastrados:\n");
            for (Jogador jogador : jogadores) {
                sb.append(jogador.getNome()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }
}
