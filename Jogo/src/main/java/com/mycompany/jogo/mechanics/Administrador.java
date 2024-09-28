/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jogo.mechanics;


import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author micka
 */

public class Administrador extends JFrame
{
    // criei um array list mas nao faço ideia de como usar. A boa era colocar arquivo pra salvar.
    private ArrayList<Jogador> jogadores;
            
    public Administrador()
    {
        this.jogadores=new ArrayList<>();
        //setVisible(true);
        cadastrar();
        
    }
    public void cadastrar()
    {
        JTextField nomeJ=new JTextField(10);
        JPanel painel= new JPanel();
        painel.setLayout(new GridLayout(2,2));
        painel.add(new JLabel("Nome do novo jogador"));
        painel.add(nomeJ);
        int res=JOptionPane.showConfirmDialog(null,painel,"Cadastrar novo jogador",JOptionPane.OK_CANCEL_OPTION);
        if(res==JOptionPane.OK_OPTION)
        {
            String nome=nomeJ.getText();
            Jogador novo=new Jogador(nome);
            jogadores.add(novo);
            JOptionPane.showMessageDialog(null,"Jogador cadastrado");   
        }
    }
        public ArrayList<Jogador> getJogadores()
        {
            return this.jogadores;
        }
}