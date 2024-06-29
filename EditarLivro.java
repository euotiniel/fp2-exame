/*------------------------------------
Tema: Gestão de uma Livraria
Nome: Otoniel Emanuel
Numero: 33039
Ficheiro: EditarLivro.java
Data: 17.06.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;

public class EditarLivro extends JFrame{
    PainelCentro centro;
    PainelSul sul;
     public EditarLivro () {
        super("Pesquisa para editar livro");
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

            add(new JLabel("Escolha o titulo do livro: "));
            add(tituloJCB = new JComboBox(LivroFile.getAllNames()));

            add(new JLabel("Escolha o autor do livro: "));
            add(autorJTF = new JTextField());
            autorJTF.setEnabled(false);

            add(new JLabel("Escolha o genero do livro: "));
            add(generoJCB = new JComboBox(LivroFile.getAllGenders()));
            generoJCB.setEnabled(false);

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
            add(pesquisarJB = new JButton(" Editar livro"));
            ImageIcon editIcon = new ImageIcon(
                    "C:\\Users\\euotinielpc\\Documents\\UCAN\\Proj\\FP2\\OtonielEmanuel33039\\images\\edit.png");
            Image editImagem = editIcon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
            editIcon = new ImageIcon(editImagem);
            pesquisarJB.setIcon(editIcon);
            pesquisarJB.addActionListener(this);
        }

        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == pesquisarJB) {

                LivroModelo modelo;
                if (centro.getTipoPesquisa() == 1) {
                    modelo = LivroFile.getLivroPorTitulo(centro.getTituloProcurado());
                    new LivroVisao(true, modelo);
                } else if (centro.getTipoPesquisa() == 2) {
                    modelo = LivroFile.getLivroPorAutor(centro.getAutorProcurado());
                    new LivroVisao(true, modelo);
                } else if (centro.getTipoPesquisa() == 3) {
                    modelo = LivroFile.getLivroPorGenero(centro.getGeneroProcurado());
                    new LivroVisao(true, modelo);
                }
            }
        }
        }
}
