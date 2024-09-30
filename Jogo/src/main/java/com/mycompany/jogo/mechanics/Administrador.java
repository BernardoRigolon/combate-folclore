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

public class Administrador extends JFrame {
    private static final String admArq = "administradores.txt";
    private static final String jogArq = "jogadores.txt";

    public Administrador() {
        if (loginAdm()) { // chama o metodo para liberar o acesso
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

            return verificarLogin(sNome, sSenha); // chama o metodo para verificar se a credencial inserida é valida
        }
        return false;
    }

    private boolean verificarLogin(String nome, String senha) { // acessa o arquivo dos administradores e verifica se o login inserido bate com algum dos que estão lá
        try (BufferedReader br = new BufferedReader(new FileReader(admArq))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] cadastro = linha.split(":"); 
                if (cadastro.length == 2) {
                    String nomeArquivo = cadastro[0];
                    String senhaArquivo = cadastro[1];

                    if (nomeArquivo.equals(nome) && senhaArquivo.equals(senha)) {
                        return true; 
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo de administrador" ); 
        }
        return false; 
    }

    
    private void opcoesAdm() { // mostra as ações que o ADM pode realizar
        String[] opcoes = {"Adicionar Jogador", "Remover Jogador", "Ver Lista de Jogadores"};
        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Menu de Administração",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

        switch (escolha) {
            case 0: cadastrar();      break;
            case 1: removerJogador(); break;
            case 2: exibirJogadores();break;
        }
    }

    public void cadastrar() { // faz o cadastro de um novo jogador
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
            while(!verificaNome(nome)){
                nome = JOptionPane.showInputDialog(null, "Nome inválido! Digite novamente:");
            }
            String senha = new String(senhaJ.getPassword());
            Jogador novo = new Jogador(nome, senha);
            salvarJogador(novo);
            JOptionPane.showMessageDialog(null, "Jogador cadastrado!");
        }
    }

    private void salvarJogador(Jogador jogador) { // insere o jogador cadastrado no arquivo de jogadores
        try (FileWriter fw = new FileWriter(jogArq, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(jogador.getNome() + ":" + jogador.getSenha());
            bw.newLine();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro arquivo jogadores");
        }
    }
    
    public void removerJogador() { // remove o jogador selecionado do arquivo
        ArrayList<Jogador> jogadores = getJogadores();
        if (jogadores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum jogador cadastrado.");
            return;
        }
        String[] nomes = jogadores.stream().map(Jogador::getNome).toArray(String[]::new);

        String jgdrSelecionado = (String) JOptionPane.showInputDialog(null, "Selecione o jogador para remover",
                "Remover Jogador", JOptionPane.QUESTION_MESSAGE, null, nomes, nomes[0]);

        if (jgdrSelecionado != null) {
            jogadores.removeIf(jogador -> jogador.getNome().equals(jgdrSelecionado)); // remove o jogador selecionado da lista
            salvarTodosJogadores(jogadores);
            JOptionPane.showMessageDialog(null, "Jogador removido");
        }
    }
    
    private void salvarTodosJogadores(ArrayList<Jogador> jogadores) { // coloca no arquivo jogadores todos os jogadores exceto o removido
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

    public ArrayList<Jogador> getJogadores() { // acessa o arquivo jogadores e retorna uma lista com todos eles
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
    
    public void exibirJogadores() { // exibe os jogadores cadastrados na tela
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
    
    private boolean verificaNome(String nome){
        for(int i=0;i<nome.length();i++){
            if(nome.charAt(i)>='0' && nome.charAt(i)<='9')
                return false;
        }
        return true;
    }
}
