/*------------------------------------
Tema: Gestão de uma Livraria
Nome: Otoniel Emanuel
Numero: 33039
Ficheiro: LivroVisaosao.java
Data: 28.05.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;

public class LivroVisao extends JFrame {
	PainelCentro centro;
	PainelSul sul;

	public LivroVisao() {
		getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
		getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);
		setTitle("Cadastro de Novo Livro");
		dfineTheme();
		pack();
		// setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	class PainelCentro extends JPanel {
		JTextField idJTF, tituloJTF, autorJTF, precoJTF; 
		JComboBox<String> generoJCB, estadoDoLivroJCB; 
		JSpinner quantidadeEstoqueJTF;
		public PainelCentro() {
			setLayout( new GridLayout(4, 2, 5, 10));

			// Linha 1
			
			add(new Label("ID"));
			add(idJTF = new JTextField());
 
			add(new Label("Título do livro"));
			add(tituloJTF = new JTextField());

			// Linha 2

			add(new Label("Autor"));
			add(autorJTF = new JTextField());
 
			add(new Label("Gênero do livro"));
			add(generoJCB = UInterfaceBox.createJComboBoxPersonalTab2("Genero.tab"));

			// Linha 3

			add(new Label("Preço"));
			add(precoJTF = new JTextField());
 
			add(new Label("Quantidade"));
			add(quantidadeEstoqueJTF = new JSpinner());

			// Linha 4

			add(new Label("Estado do livro"));
			add(estadoDoLivroJCB = UInterfaceBox.createJComboBoxPersonalTab2("EstadoDoLivro.tab"));
		}
	}

	class PainelSul extends JPanel implements ActionListener {
		JButton cadastrarJB;

		public PainelSul() {
			add(cadastrarJB = new JButton("Cadastrar livro"));

			cadastrarJB.addActionListener(this);
		}

		public void actionPerformed(ActionEvent evt) {
			if (evt.getSource() == cadastrarJB) {
				JOptionPane.showMessageDialog(null, "Cadastrado");
			}

		}
	}

	public void dfineTheme() 
	 {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
    }
} 
