/*------------------------------------
Tema: Gestão de uma Livraria
Nome: Otoniel Emanuel
Numero: 33039
Ficheiro: PesquisarLivro.java
Data: 13.06.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;

public class PesquisarLivro extends JFrame {

    PainelCentro centro;
    PainelSul sul;

    public PesquisarLivro() {
        super("Pesquisar livro");
        ImageIcon appIcone = new ImageIcon(
            "C:\\Users\\euotinielpc\\Documents\\UCAN\\Proj\\FP2\\OtonielEmanuel33039\\images\\book.png");
    setIconImage(appIcone.getImage());
        getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);

        // setSize(400, 300);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    class PainelCentro extends JPanel implements ActionListener {
        JComboBox tituloJCB, generoJCB;
        JTextField autorJTF;
        JRadioButton searchTitulo, searchAutor, searchGender;
        JViewport searchVoid;
        ButtonGroup group;

        public PainelCentro() {
            setLayout(new GridLayout(6,2));
            group = new ButtonGroup();
            add(searchTitulo = new JRadioButton("Título", true));
            add(searchAutor = new JRadioButton("Autor"));
            add(searchGender = new JRadioButton("Genero"));
            add(searchVoid = new JViewport());

            group.add(searchTitulo);
            group.add(searchAutor);
            group.add(searchGender);

            add(new JLabel("Escolha o titulo do livro"));
            add(tituloJCB = new JComboBox(LivroFile.getAllNames()));

            add(new JLabel("Escolha o genero do livro"));
            add(generoJCB = new JComboBox(LivroFile.getAllGenders()));
            generoJCB.setEnabled(false);

            add(new JLabel("Escolha o autor do livro"));
            add(autorJTF = new JTextField());
            autorJTF.setEnabled(false);

            searchTitulo.addActionListener(this);
            searchAutor.addActionListener(this);
            searchGender.addActionListener(this);
        }

        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == searchAutor) {
                autorJTF.setEnabled(true);
                tituloJCB.setEnabled(false);
                generoJCB.setEnabled(false);
            } else if (evt.getSource() == searchGender) {
                generoJCB.setEnabled(true);
                tituloJCB.setEnabled(false);
                autorJTF.setEnabled(false);
            } else {
                tituloJCB.setEnabled(true);
                autorJTF.setEnabled(false);
                generoJCB.setEnabled(false);
            }
        }

        public String getTituloProcurado() {
            return String.valueOf(tituloJCB.getSelectedItem());
        }

        public String getAutorProcurado() {
            return autorJTF.getText().trim();
        }

        public String getGeneroProcurado() {
            return String.valueOf(generoJCB.getSelectedItem());
        }

        public int getTipoPesquisa() {
            if (searchTitulo.isSelected()) {
                return 1;
            } else if (searchAutor.isSelected()) {
                return 2;
            } else {
                return 3;
            }
        }
    }

    class PainelSul extends JPanel implements ActionListener {
        JButton pesquisarJB;

        public PainelSul() {
            add(pesquisarJB = new JButton("Pesquisar livro"));
            ImageIcon createIcon = new ImageIcon(
					"C:\\Users\\euotinielpc\\Documents\\UCAN\\Proj\\FP2\\OtonielEmanuel33039\\images\\add.png");
			Image createImagem = createIcon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
			createIcon = new ImageIcon(createImagem);
			pesquisarJB.setIcon(createIcon);
            pesquisarJB.addActionListener(this);
        }

        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == pesquisarJB) {
                if (centro.getTipoPesquisa() == 1) {
                    LivroFile.pesquisarLivroPorTitulo(centro.getTituloProcurado());
                } else if (centro.getTipoPesquisa() == 2) {
                    LivroFile.pesquisarLivroPorAutor(centro.getAutorProcurado());
                } else if (centro.getTipoPesquisa() == 3) {
                    LivroFile.pesquisarLivroPorGenero(centro.getGeneroProcurado());
                }
            }
        }
    }
}
