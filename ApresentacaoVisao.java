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
        ImageIcon appIcone = new ImageIcon(
                "C:\\Users\\euotinielpc\\Documents\\UCAN\\Proj\\FP2\\OtonielEmanuel33039\\images\\book.png");
        setIconImage(appIcone.getImage());
        setTitle("Seja bem-vindo");
        // pack();
        setSize(460, 430);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    class PainelCentro extends JPanel {
        JTextArea textoJT;

        public PainelCentro() {
            setLayout(new BorderLayout());

            setBackground(Color.WHITE);

            ImageIcon livroIcone = new ImageIcon(
                    "C:\\Users\\euotinielpc\\Documents\\UCAN\\Proj\\FP2\\OtonielEmanuel33039\\images\\book.png");
            Image livroImagem = livroIcone.getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
            livroIcone = new ImageIcon(livroImagem);
            JLabel iconeLivro = new JLabel(livroIcone);
            iconeLivro.setHorizontalAlignment(SwingConstants.CENTER);
            iconeLivro.setBorder(BorderFactory.createEmptyBorder(30, 0, 10, 0));
            add(iconeLivro, BorderLayout.NORTH);

            JEditorPane textoJEP = new JEditorPane("text/html",
                    "<html><div style='text-align: center;font-family: Arial;'>" +
                            "<p style='font-size: 12px; font-weight: bold;'>Bem-vindo ao Sistema de Gestão de Livraria<p>"
                            +
                            "O Sistema de Gestão de Livraria é uma aplicação desenvolvida para gerenciar de forma eficiente as operações de uma livraria, abrangendo a administração de livros, vendas e clientes. Este sistema foi projetado para facilitar o controle de estoque, as vendas e manter registros.<br><br>"
                            +
                            "</div></html>");
            textoJEP.setFocusable(false);

            JPanel centralPanel = new JPanel(new BorderLayout());
            centralPanel.add(textoJEP, BorderLayout.CENTER);
            centralPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            add(centralPanel, BorderLayout.CENTER);
            centralPanel.setBackground(Color.WHITE);
        }
    }

    class PainelSul extends JPanel implements ActionListener {
        private JButton entrarJB, sairJB;
        private JCheckBox concordarJCB;

        public PainelSul() {
            setLayout(new BorderLayout());

            setBackground(Color.WHITE);

            JPanel checkBoxPanel = new JPanel();
            checkBoxPanel.setBackground(Color.WHITE);

            add(concordarJCB = new JCheckBox("Concordar com os termos e condicoes"));
            concordarJCB.addActionListener(this);
            checkBoxPanel.add(concordarJCB);
            add(checkBoxPanel, BorderLayout.NORTH);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(Color.WHITE);
            entrarJB = new JButton("   Entrar");
            ImageIcon entrarIcon = new ImageIcon(
                    "C:\\Users\\euotinielpc\\Documents\\UCAN\\Proj\\FP2\\OtonielEmanuel33039\\images\\enter.png");
            Image entrarImagem = entrarIcon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
            entrarIcon = new ImageIcon(entrarImagem);
            entrarJB.setIcon(entrarIcon);

            sairJB = new JButton("   Sair");
            ImageIcon sairIcon = new ImageIcon(
                    "C:\\Users\\euotinielpc\\Documents\\UCAN\\Proj\\FP2\\OtonielEmanuel33039\\images\\logout.png");
            Image sairImagem = sairIcon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
            sairIcon = new ImageIcon(sairImagem);
            sairJB.setIcon(sairIcon);

            activarBotao(false);
            entrarJB.addActionListener(this);
            sairJB.addActionListener(this);
            buttonPanel.add(entrarJB);
            buttonPanel.add(sairJB);
            add(buttonPanel, BorderLayout.CENTER);
        }

        public void activarBotao(boolean status) {
            entrarJB.setEnabled(status);
        }

        public void actionPerformed(ActionEvent evt) {
            Object source = evt.getSource();

            if (source == concordarJCB) {
                if (concordarJCB.isSelected()) {
                    activarBotao(true);
                } else {
                    activarBotao(false);
                }
            } else if (source == entrarJB) {
                dispose();
                new LoginVisao();
            } else if (source == sairJB) {
                dispose();
            }
        }
    }

    public static void main(String args[]) {
        Vector_Tabelas.inic(); // cria a conexao do projecto com a API SWINGCOMPONENTS
        new ApresentacaoVisao();
    }
}
