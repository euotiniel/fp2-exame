/*------------------------------------
Tema: Gestão de uma Livraria
Nome: Otoniel Emanuel
Numero: 33039
Ficheiro: ApresentacaoVisao.java
Data: 14.06.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;

public class ApresentacaoVisao extends JFrame {

    private PainelCentro centro;
    private PainelSul sul;

    public ApresentacaoVisao() {

        getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);

        setTitle("Seja bem-vindo");
        // pack();
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    class PainelCentro extends JPanel implements ActionListener {
        JTextArea textoJT;
        JCheckBox concordarJCB;

        public PainelCentro() {
            setLayout(new GridLayout(2, 1));
            add(textoJT = new JTextArea(50, 50));
            textoJT.setFocusable(false);
            textoJT.setText("\n" +
                    "Bem vindo ao Sistema de Gestao de Livraria\n\n" +
                    "Descrever o sistema here\n" +
                    "Opaaa\n");
            add(concordarJCB = new JCheckBox("Concordar com os termos e condicoes"));
            concordarJCB.addActionListener(this);
        }

        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == concordarJCB) {
                if (concordarJCB.isSelected()) {
                    sul.activarBotao(true);
                } else {
                    sul.activarBotao(false);
                }
            }
        }
    }

    class PainelSul extends JPanel implements ActionListener {
        private JButton entrarJB, sairJB;

        public PainelSul() {
            add(entrarJB = new JButton("Entrar"));
            add(sairJB = new JButton("Sair"));
            activarBotao(false);
            entrarJB.addActionListener(this);
            sairJB.addActionListener(this);
        }

        public void activarBotao(boolean status) {
            entrarJB.setEnabled(status);
        }

        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == entrarJB) {
                dispose();
                new LoginVisao();
            } else {
                dispose();
            }
        }
    }

    public static void main(String args[]) {
        Vector_Tabelas.inic(); // cria a conexao do projecto com a API SWINGCOMPONENTS
        new ApresentacaoVisao();
    }
}
