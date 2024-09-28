/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogo.view;
import com.mycompany.jogo.mechanics.Administrador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author micka
 */


public class TelaInicial extends JFrame {
    private static final String jogArq = "jogadores.txt";
    public TelaInicial() {

        super("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setLayout(new BorderLayout());

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(3, 1, 10, 10)); 

        JButton btnNovoJogo = new JButton("Novo Jogo");
        btnNovoJogo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarNovoJogo();
            }
        });
        painelBotoes.add(btnNovoJogo);
        JButton btnAdministracao = new JButton("Administração");
        btnAdministracao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaAdministracao();
            }
        });
        painelBotoes.add(btnAdministracao);

        JButton btnRegras = new JButton("Regras do Jogo");
        btnRegras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarRegras();
            }
        });
        painelBotoes.add(btnRegras);
        add(painelBotoes, BorderLayout.CENTER);
        setVisible(true);
    }


    private void iniciarNovoJogo() {
    
        JTextField nomeJ = new JTextField(10);
        JPasswordField senhaJ = new JPasswordField(10);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(3, 2));
        painel.add(new JLabel("Nome de Usuário:"));
        painel.add(nomeJ);
        painel.add(new JLabel("Senha:"));
        painel.add(senhaJ);

        int res = JOptionPane.showConfirmDialog(null, painel, "Login do Jogador", JOptionPane.OK_CANCEL_OPTION);
        if (res == JOptionPane.OK_OPTION) {
            String nome = nomeJ.getText();
            String senha = new String(senhaJ.getPassword());

            if (verificarLogin(nome, senha, jogArq)) {
                JOptionPane.showMessageDialog(null, "Iniciando o jogo");
                JTab j = new JTab();
            } else {
                JOptionPane.showMessageDialog(null, "Credenciais incorretas.");
            }
        }
    }


    private void abrirTelaAdministracao() {
        Administrador administrador = new Administrador(); 
    }

    private void mostrarRegras() {
        //colocar as regras aq 
        String regras = "Tem que colocar as regras ainda\n";
        JOptionPane.showMessageDialog(this, regras, "Regras do Jogo", JOptionPane.INFORMATION_MESSAGE);
    }
        
    private boolean verificarLogin(String nome, String senha, String arquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] credenciais = linha.split(":"); 
                if (credenciais.length == 2) {
                    String nomeArquivo = credenciais[0];
                    String senhaArquivo = credenciais[1];

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
}