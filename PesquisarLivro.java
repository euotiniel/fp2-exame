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
        super("Pesquisas");

        getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);

        // setSize(400, 300);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    class PainelCentro extends JPanel implements ActionListener {
        JComboBox tituloJCB;
        JTextField autorJTF;
        JRadioButton searchTitulo, searchAutor;
        ButtonGroup group;

        public PainelCentro() {
            setLayout(new GridLayout(3, 2));
            group = new ButtonGroup();
            add(searchTitulo = new JRadioButton("Título", true));
            add(searchAutor = new JRadioButton("Autor"));

            group.add(searchTitulo);
            group.add(searchAutor);

            add(new JLabel("Escolha o titulo do livro"));
            add(tituloJCB = new JComboBox(LivroFile.getAllNames()));

            add(new JLabel("Escolha o autor do livro"));
            add(autorJTF = new JTextField());
            autorJTF.setEnabled(false);

            searchTitulo.addActionListener(this);
            searchAutor.addActionListener(this);
        }

        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == searchAutor) {
                autorJTF.setEnabled(true);
                tituloJCB.setEnabled(false);
            } else {
                autorJTF.setEnabled(false);
                tituloJCB.setEnabled(true);
            }
        }

        public String getTituloProcurado() {
            return String.valueOf(tituloJCB.getSelectedItem());
        }

        public String getAutorProcurado() {
            return autorJTF.getText().trim();
        }

        public int getTipoPesquisa() {
            if (searchTitulo.isSelected()) {
                return 1;
            } else {
                return 2;
            }
        }
    }

    class PainelSul extends JPanel implements ActionListener {
        JButton pesquisarJB;

        public PainelSul() {
            add(pesquisarJB = new JButton("Pesquisar livro"));
            pesquisarJB.addActionListener(this);
        }

        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == pesquisarJB) {
                if (centro.getTipoPesquisa() == 1) {
                    LivroFile.pesquisarLivroPorTitulo(centro.getTituloProcurado());
                } else if (centro.getTipoPesquisa() == 2) {
                    LivroFile.pesquisarLivroPorAutor(centro.getAutorProcurado());
                }
            }
        }
    }
}
