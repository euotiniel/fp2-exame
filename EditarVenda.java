/*------------------------------------
Tema: Gestão de uma Livraria
Nome: Otoniel Emanuel
Numero: 33039
Ficheiro: EditarVenda.java
Data: 01.07.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;

public class EditarVenda extends JFrame {

    PainelCentro centro;
    PainelSul sul;

    public EditarVenda() {
        super("Pesquisar venda");

        getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);
        ImageIcon appIcone = new ImageIcon(
            "C:\\Users\\euotinielpc\\Documents\\UCAN\\Proj\\FP2\\OtonielEmanuel33039\\images\\book.png");
    setIconImage(appIcone.getImage());
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
            setLayout(new GridLayout(3,2));
            group = new ButtonGroup();
            add(searchLivro = new JRadioButton("Código da venda", true));
            add(searchVoid = new JViewport());

            group.add(searchLivro);

            add(new JLabel("Selecione a venda"));
			add(livroJCB = new JComboBox<>(VendaFile.getBookCode().toArray(new String[0])));

            searchLivro.addActionListener(this);
        }

        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == searchLivro) {
                livroJCB.setEnabled(true);
            } 
        }

        public int codigoProcurado() {
            String selectedItem = String.valueOf(livroJCB.getSelectedItem());
            
            int codigo = Integer.parseInt(selectedItem.trim());
            
            return codigo;
        }
    }

    class PainelSul extends JPanel implements ActionListener {
        JButton pesquisarJB;

        public PainelSul() {
            add(pesquisarJB = new JButton("Pesquisar venda"));
            ImageIcon createIcon = new ImageIcon(
					"C:\\Users\\euotinielpc\\Documents\\UCAN\\Proj\\FP2\\OtonielEmanuel33039\\images\\magnifier.png");
			Image createImagem = createIcon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
			createIcon = new ImageIcon(createImagem);
			pesquisarJB.setIcon(createIcon);
            pesquisarJB.addActionListener(this);
        }

        public void actionPerformed(ActionEvent evt) {
            VendaModelo modelo;

            if (evt.getSource() == pesquisarJB) {
                modelo = VendaFile.getVendaPorCodigo(centro.codigoProcurado());
                new VendaVisao(true, modelo);       
            }
        }
    }
}

