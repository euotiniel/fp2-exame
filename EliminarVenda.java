/*------------------------------------
Tema: Gestão de uma Livraria
Nome: Otoniel Emanuel
Numero: 33039
Ficheiro: EliminarVenda.java
Data: 02.07.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;

public class EliminarVenda extends JFrame {
    PainelCentro centro;
    PainelSul sul;

    public EliminarVenda() {
        super("Pesquisa para eliminar venda");
        ImageIcon appIcone = new ImageIcon(
                "C:\\Users\\euotinielpc\\Documents\\UCAN\\Proj\\FP2\\OtonielEmanuel33039\\images\\book.png");
        setIconImage(appIcone.getImage());
        getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);

        setSize(300, 200);
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
            setLayout(new GridLayout(6, 2));
            group = new ButtonGroup();
            add(searchTitulo = new JRadioButton("Código da venda", true));
            add(searchVoid = new JViewport());

            group.add(searchTitulo);
            group.add(searchAutor);
            group.add(searchGender);

            add(new JLabel("Escolha o titulo do venda: "));
            add(tituloJCB = new JComboBox(VendaFile.getAllNames()));

            searchTitulo.addActionListener(this);
        }

        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == searchAutor) {
                tituloJCB.setEnabled(false);
            }
        }

        public int getTituloProcurado() {
            String selectedItem = String.valueOf(tituloJCB.getSelectedItem());
            
            int codigo = Integer.parseInt(selectedItem.trim());
            
            return codigo;        
        }

        public int getTipoPesquisa() {
                return 1;
        }
    }

    class PainelSul extends JPanel implements ActionListener {
        JButton pesquisarJB;

        public PainelSul() {
            add(pesquisarJB = new JButton(" Eliminar venda"));
            ImageIcon deleteIcon = new ImageIcon(
                    "C:\\Users\\euotinielpc\\Documents\\UCAN\\Proj\\FP2\\OtonielEmanuel33039\\images\\bin.png");
            Image deleteImagem = deleteIcon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
            deleteIcon = new ImageIcon(deleteImagem);
            pesquisarJB.setIcon(deleteIcon);
            pesquisarJB.addActionListener(this);
        }

        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == pesquisarJB) {

                VendaModelo modelo;
                if (centro.getTipoPesquisa() == 1) {
                    modelo = VendaFile.getVendaPorCodigo(centro.getTituloProcurado());
                    JOptionPane.showMessageDialog(null, modelo.toString());
                    int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza de que pretende elimnar esses dados?");
                    if (opcao == JOptionPane.YES_OPTION) {
                        modelo.setStatus(false);
                        new VendaFile().eliminarDados(modelo);
                        dispose();
                    }
                } 
            }
        }
    }
}
