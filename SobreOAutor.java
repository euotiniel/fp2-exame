/*------------------------------------
Tema: Gestão de uma Livraria
Nome: Otoniel Emanuel
Numero: 33039
Ficheiro: SobreOAutor.java
Data: 28.05.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;

public class SobreOAutor extends JFrame {

    private PainelCentro centro;

    public SobreOAutor() {

        getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        ImageIcon appIcone = new ImageIcon(
                "C:\\Users\\euotinielpc\\Documents\\UCAN\\Proj\\FP2\\OtonielEmanuel33039\\images\\book.png");
        setIconImage(appIcone.getImage());
        setTitle("Sobre o autor");
        // pack();
        setSize(460, 420);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    class PainelCentro extends JPanel {
        JTextArea textoJT;

        public PainelCentro() {
            setLayout(new BorderLayout());

            setBackground(Color.WHITE);

            ImageIcon livroIcone = new ImageIcon(
                    "C:\\Users\\euotinielpc\\Documents\\UCAN\\Proj\\FP2\\OtonielEmanuel33039\\images\\euotiniel.png");
            Image livroImagem = livroIcone.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            livroIcone = new ImageIcon(livroImagem);
            JLabel iconeLivro = new JLabel(livroIcone);
            iconeLivro.setHorizontalAlignment(SwingConstants.CENTER);
            iconeLivro.setBorder(BorderFactory.createEmptyBorder(30, 0, 10, 0));
            add(iconeLivro, BorderLayout.NORTH);

            JEditorPane textoJEP = new JEditorPane("text/html",
                    "<html><div style='text-align: center; font-family: Arial;'>" +
                            "<p style='font-size: 12px; font-weight: bold; margin-bottom: 10px'>Otoniel Kavungu Dos Santos Emanuel</p>"
                            +
                            "<p style='font-style: italic; font-weight: bold; margin-bottom: 10px'>Turma: A | 1º ano | 33039 | 929 392 384</p>"
                            +
                            "Desenvolvedor front-end, entusiasta de código aberto e escritor. Atualmente, estou cursando Engenharia Informática em Luanda na Universidade: Universidade Católica de Angola (UCAN) e dedico boa parte do meu tempo à minha paixão pela programação."
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

    public static void main(String args[]) {
        Vector_Tabelas.inic(); // cria a conexao do projecto com a API SWINGCOMPONENTS
        new ApresentacaoVisao();
    }
}
