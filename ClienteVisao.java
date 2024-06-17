/*------------------------------------
Tema: Gestão de uma Livraria
Nome: Otoniel Emanuel
Numero: 33039
Ficheiro: LivroVisaosao.java
Data: 17.06.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;

public class ClienteVisao extends JFrame {
    PainelCentro centro;
	PainelSul sul;

	public ClienteVisao() {
		getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
		getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);
		setTitle("Cadastrar novo Cliente");
		pack();
		// setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	class PainelCentro extends JPanel {
		JTextField idJTF, nomeJTF, emailJTF, telefoneJTF;

		private ClienteFile clienteFile;

		public PainelCentro() {
			setLayout(new GridLayout(4, 2, 5, 10));

			clienteFile = new ClienteFile();

			// Linha 1

			add(new Label("ID"));
			add(idJTF = new JTextField());
			idJTF.setText( String.valueOf(clienteFile.getProximoCodigo()));
			// idJTF.setText( "" + clienteFile.getProximoCodigo());
			idJTF.setFocusable(false);

			add(new Label("Nome completo"));
			add(nomeJTF = new JTextField());

			// Linha 2

			add(new Label("Telefone"));
			add(telefoneJTF = new JTextField());

			add(new Label("Email"));
			add(emailJTF = new JTextField());
		}

		// Methods GET
		public int getId() {
			return Integer.parseInt(idJTF.getText().trim());
		}

		public String getNome() {
			return nomeJTF.getText().trim();
		}

		public String getTelefone() {
			return telefoneJTF.getText().trim();
		}

		public String getEmail() {
			return emailJTF.getText().trim();
		}

		// Save

		public void cadastrar() {
			ClienteModelo modelo = new ClienteModelo(getId(), getNome(), getTelefone(), getEmail());

			JOptionPane.showMessageDialog(null, modelo.toString());

			modelo.salvar();
			dispose();
		}
	}

	class PainelSul extends JPanel implements ActionListener {
		JButton cadastrarJB;

		public PainelSul() {
			add(cadastrarJB = new JButton("Cadastrar cliente"));

			cadastrarJB.addActionListener(this);
		}

		public void actionPerformed(ActionEvent evt) {
			if (evt.getSource() == cadastrarJB) {
				centro.cadastrar();
			}

		}
	}
}
