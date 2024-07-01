/*------------------------------------
Tema: Gestão de uma Livraria
Nome: Otoniel Emanuel
Numero: 33039
Ficheiro: SobreOSoftware.java
Data: 28.05.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;

public class SobreOSoftware extends JFrame {

    private PainelCentro centro;

    public SobreOSoftware() {

        getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        ImageIcon appIcone = new ImageIcon(
                "C:\\Users\\euotinielpc\\Documents\\UCAN\\Proj\\FP2\\OtonielEmanuel33039\\images\\book.png");
        setIconImage(appIcone.getImage());
        setTitle("Sobre o software");
        // pack();
        setSize(460, 400);
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
            Image livroImagem = livroIcone.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            livroIcone = new ImageIcon(livroImagem);
            JLabel iconeLivro = new JLabel(livroIcone);
            iconeLivro.setHorizontalAlignment(SwingConstants.CENTER);
            iconeLivro.setBorder(BorderFactory.createEmptyBorder(30, 0, 10, 0));
            add(iconeLivro, BorderLayout.NORTH);

            JEditorPane textoJEP = new JEditorPane("text/html",
                    "<html><div style='text-align: center; font-family: Arial;'>" +
                            "<p style='font-size: 12px; font-weight: bold; margin-bottom: 10px;'>Sobre o Software</p>" +
                            "Com uma interface amigável e intuitiva, o sistema permite que os usuários gerenciem facilmente o catálogo de livros, acompanhem as transações de vendas e mantenham um banco de dados detalhado de clientes. Além disso, oferece funcionalidades avançadas para geração de relatórios e análise de desempenho, ajudando os administradores a tomar decisões informadas e estratégicas."
                            +
                            "<p style='font-style: italic; font-weight: bold'> Desenvolvido por: Otoniel Emanuel</p>" +
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
