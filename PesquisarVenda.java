/*------------------------------------
Tema: Gestão de uma Livraria
Nome: Otoniel Emanuel
Numero: 33039
Ficheiro: PesquisarVenda.java
Data: 01.07.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;

public class PesquisarVenda extends JFrame {

    PainelCentro centro;
    PainelSul sul;

    public PesquisarVenda() {
        super("Pesquisar venda");

        getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);

        // setSize(400, 300);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    

    class PainelCentro extends JPanel implements ActionListener {
        JTextField dataJTF;
        JComboBox livroJCB, clienteJCB;
        JRadioButton searchLivro, searchCliente, searchData;
        JViewport searchVoid;
        ButtonGroup group;

        public PainelCentro() {
            setLayout(new GridLayout(6,2));
            group = new ButtonGroup();
            add(searchLivro = new JRadioButton("Nome", true));
            add(searchCliente = new JRadioButton("Telefone"));
            add(searchData = new JRadioButton("Data"));
            add(searchVoid = new JViewport());

            group.add(searchLivro);
            group.add(searchCliente);
            group.add(searchData);

            add(new JLabel("Selecione o livro"));
			add(livroJCB = new JComboBox<>(VendaFile.getBookTitles().toArray(new String[0])));

            add(new JLabel("Selecionar cliente"));
			add(clienteJCB = new JComboBox<>(VendaFile.getBookTitles().toArray(new String[0])));
            clienteJCB.setEnabled(false);

            add(new JLabel("Digite a data"));
			add(dataJTF = new JTextField());
            dataJTF.setEnabled(false);

            searchLivro.addActionListener(this);
            searchCliente.addActionListener(this);
            searchData.addActionListener(this);
        }

        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == searchLivro) {
                livroJCB.setEnabled(true);
                clienteJCB.setEnabled(false);
                dataJTF.setEnabled(false);
            } else if(evt.getSource() == searchCliente) {
                clienteJCB.setEnabled(true);
                livroJCB.setEnabled(false);
                dataJTF.setEnabled(false);
            } else {
                dataJTF.setEnabled(true);
                livroJCB.setEnabled(false);
                clienteJCB.setEnabled(false);
            }
        }

        public String getLivroProcurado() {
            return String.valueOf(livroJCB.getSelectedItem());
        }

        public String getClienteProcurado() {
            return String.valueOf(clienteJCB.getSelectedItem());
        }

        public String getVendaProcurado() {
            return dataJTF.getText().trim();
        }

        public int getTipoPesquisa() {
            if (searchLivro.isSelected()) {
                return 1;
            } else if (searchCliente.isSelected()) {
                return 2;
            } else {
                return 3;
            }
        }
    }

    class PainelSul extends JPanel implements ActionListener {
        JButton pesquisarJB;

        public PainelSul() {
            add(pesquisarJB = new JButton("Pesquisar venda"));
            pesquisarJB.addActionListener(this);
        }

        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == pesquisarJB) {
                if (centro.getTipoPesquisa() == 1) {
                    VendaFile.PesquisarVendaPorNome(centro.getLivroProcurado());
                } else if (centro.getTipoPesquisa() == 2) {
                    VendaFile.PesquisarVendaPorCliente(centro.getClienteProcurado());
                } else {
                    VendaFile.PesquisarVendaPorData(centro.getClienteProcurado());
                } 
            }
        }
    }
}

