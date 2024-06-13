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
		
		//setSize(400, 300);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);	
    }

    class PainelCentro extends JPanel {
        JComboBox tituloJCB;
        public PainelCentro() {
            setLayout(new GridLayout(1, 2));

            add(new JLabel("Escolha o titulo do livro"));
            add( tituloJCB = new JComboBox(LivroFile.getAllNames()));
        }

        public String getTituloProcurado() {
            return String.valueOf(tituloJCB.getSelectedItem());
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
				LivroFile.pesquisarLivroPorTitulo( centro.getTituloProcurado());
			}
        }
    }
}
