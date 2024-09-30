package com.mycompany.jogo.view;

import com.mycompany.jogo.mechanics.Administrador;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
Bernardo de Carvalho Rigolon – 202365561C 
Mickaell de Oliveira - 202365514B 
Miguel de Deus Oliveira – 202365521B 
Vinicius Campos Priamo – 202365567C 
*/

public class TelaInicial extends JFrame {
    private static final String jogArq = "jogadores.txt";
    private static final String regrasArq = "regras.txt";
    public TelaInicial() { // inicializa a janela com as opções 

        super("Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLayout(new BorderLayout());

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(3, 1, 3, 3));
        this.setLocationRelativeTo(null);
        painelBotoes.setBackground(new Color(46,118,4));
        JButton btnNovoJogo = new JButton("Novo Jogo"); // botão para iniciar um novo jogo
        btnNovoJogo.setBackground(new Color(142,204,59));
        btnNovoJogo.setForeground(new Color(0,0,0));
        btnNovoJogo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarNovoJogo();
            }
        });
        painelBotoes.add(btnNovoJogo);
        JButton btnAdministracao = new JButton("Administração"); //botao para acessar a administração
        btnAdministracao.setBackground(new Color(142,204,59));
        btnAdministracao.setForeground(new Color(0,0,0));
        btnAdministracao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirTelaAdministracao();
            }
        });
        painelBotoes.add(btnAdministracao);

        JButton btnRegras = new JButton("Regras do Jogo"); // botão para ver as regras do jogo
        btnRegras.setBackground(new Color(142,204,59));
        btnRegras.setForeground(new Color(0,0,0));
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

    private void iniciarNovoJogo() { // inicia um novo jogo
    
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

            if (verificarLogin(nome, senha, jogArq)) { // caso o jogador esteja cadastrado inicia um novo jogo
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

    private void mostrarRegras() { // acessa o arquivo regras e mostra as regras
        
        String regras="";

        try (BufferedReader br = new BufferedReader(new FileReader(regrasArq))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                regras+=linha;
                regras+="\n";
                
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro arquivo regras");
        }
        JOptionPane.showMessageDialog(this, regras, "Regras do Jogo", JOptionPane.INFORMATION_MESSAGE);
    }
        
    private boolean verificarLogin(String nome, String senha, String arquivo) { // verifica se o login passado esta no arquivo desejado
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
            JOptionPane.showMessageDialog(null, "Erro arquivo " + arquivo);
        }
        return false; 
    }
}