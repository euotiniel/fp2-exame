/*------------------------------------
Tema: Gestão de uma Livraria
Nome: Otoniel Emanuel
Numero: 33039
Ficheiro: PesquisarCliente.java
Data: 17.06.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;

public class PesquisarCliente extends JFrame {

    PainelCentro centro;
    PainelSul sul;

    public PesquisarCliente() {
        super("Pesquisar cliente");

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
        JTextField nomeJTF, telefoneJTF;
        JRadioButton searchNome, searchTelefone;
        ButtonGroup group;

        public PainelCentro() {
            setLayout(new GridLayout(6,2));
            group = new ButtonGroup();
            add(searchNome = new JRadioButton("Nome", true));
            add(searchTelefone = new JRadioButton("Telefone"));

            group.add(searchNome);
            group.add(searchTelefone);

            add(new JLabel("Digite o nome"));
            add(nomeJTF = new JTextField());

            add(new JLabel("Digite o telefone"));
            add(telefoneJTF = new JTextField());
            telefoneJTF.setEnabled(false);

            searchNome.addActionListener(this);
            searchTelefone.addActionListener(this);
        }

        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == searchTelefone) {
                telefoneJTF.setEnabled(true);
                nomeJTF.setEnabled(false);
            } else {
                nomeJTF.setEnabled(true);
                telefoneJTF.setEnabled(false);
            }
        }

        public String getNomeProcurado() {
            return nomeJTF.getText().trim();
        }

        public String getTelefoneProcurado() {
            return telefoneJTF.getText().trim();
        }

        public int getTipoPesquisa() {
            if (searchNome.isSelected()) {
                return 1;
            } else {
                return 2;
            }
        }
    }

    class PainelSul extends JPanel implements ActionListener {
        JButton pesquisarJB;

        public PainelSul() {
            add(pesquisarJB = new JButton("Pesquisar cliente"));
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
                    ClienteFile.pesquisarClientePorNome(centro.getNomeProcurado());
                } else if (centro.getTipoPesquisa() == 2) {
                    ClienteFile.pesquisarClientePorTelefone(centro.getTelefoneProcurado());
                } 
            }
        }
    }
}
