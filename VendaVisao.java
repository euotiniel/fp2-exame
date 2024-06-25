/*------------------------------------
Tema: Gestão de uma Livraria
Nome: Otoniel Emanuel
Numero: 33039
Ficheiro: VendaVisao.java
Data: 25.06.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VendaVisao extends JFrame {

	PainelCentro centro;
	PainelSul sul;
	boolean editar;

	public VendaVisao(boolean alterar, VendaModelo modelo) {
		// getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
		getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);

		editar = alterar;

		if (!alterar) {
			getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
		} else {
			getContentPane().add(centro = new PainelCentro(modelo), BorderLayout.CENTER);
		}
		setTitle("Nova venda");
		defineTheme();
		pack();
		// setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	class PainelCentro extends JPanel {
		JTextField idJTF, quantidadeJTF, valorTotalJTF, dataVendaJTF;
		JComboBox<String> clienteJCB, livroJCB;
		private VendaFile vendaFile;

		public PainelCentro() {
			setLayout(new GridLayout(3, 4, 5, 10));

			vendaFile = new VendaFile();
			// Linha 1

			add(new Label("ID"));
			add(idJTF = new JTextField());
			idJTF.setText(String.valueOf(vendaFile.getProximoCodigo()));
			// idJTF.setText( "" + livroFile.getProximoCodigo());
			idJTF.setFocusable(false);

			add(new Label("Título do livro"));
        add(livroJCB = new JComboBox<>(VendaFile.getBookTitles().toArray(new String[0])));

			// Linha 2

			add(new Label("Cliente"));
			add(clienteJCB = new JComboBox<>(VendaFile.getClientNames().toArray(new String[0])));

			add(new Label("Quantidade"));
			add(quantidadeJTF = new JTextField());

			// Linha 3

			add(new Label("Valor total"));
			add(valorTotalJTF = new JTextField());

			add(new Label("Data"));

			// Create and format the current date
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			String currentDate = sdf.format(new Date());

			// Create the JTextField and set its text to the current date
			add(dataVendaJTF = new JTextField(currentDate));
			dataVendaJTF.setFocusable(false);
		}

		public PainelCentro(VendaModelo modelo) {
			setLayout(new GridLayout(3, 4, 5, 10));

			vendaFile = new VendaFile();
			// Linha 1

			add(new Label("ID"));
			add(idJTF = new JTextField());
			// idJTF.setText( String.valueOf(livroFile.getProximoCodigo()));
			idJTF.setText(" " + modelo.getId());
			idJTF.setFocusable(false);

			add(new Label("Título do livro"));
        add(livroJCB = new JComboBox<>(VendaFile.getBookTitles().toArray(new String[0])));
        livroJCB.setSelectedItem(modelo.getLivro());

			// Linha 2

			add(new Label("Cliente"));
			add(clienteJCB = new JComboBox<>(VendaFile.getClientNames().toArray(new String[0])));
			clienteJCB.setSelectedItem(modelo.getCliente());

			add(new Label("Quantidade"));
			add(quantidadeJTF = new JTextField());
			quantidadeJTF.setText(" " + modelo.getQuantidade());

			// Linha 3

			add(new Label("Valor total"));
			add(valorTotalJTF = new JTextField());
			valorTotalJTF.setText(" " + modelo.getValorTotal());

			add(new Label("Data"));
			add(dataVendaJTF = new JTextField());
			dataVendaJTF.setText(modelo.getDataVenda());
		}

		// Methods GET
		public int getId() {
			return Integer.parseInt(idJTF.getText().trim());
		}

		public String getLivro() {
			return String.valueOf(livroJCB.getSelectedItem());
		}
	
		public String getCliente() {
			return String.valueOf(clienteJCB.getSelectedItem());
		}
	
		public int getQuantidade() {
			try {
				return Integer.parseInt(quantidadeJTF.getText().trim());
			} catch (NumberFormatException e) {
				return 0; // Handle parsing error gracefully
			}
		}
	
		public double getValorTotal() {
			try {
				return Double.parseDouble(valorTotalJTF.getText().trim());
			} catch (NumberFormatException e) {
				return 0.0; // Handle parsing error gracefully
			}
		}
	
		public String getDataVenda() {
			return dataVendaJTF.getText().trim();
		}

		// Methods SET
		public void setId(int id) {
			idJTF.setText(" " + id);
		}

		public void setLivro(String livro) {
			livroJCB.setSelectedItem(livro);
		}
	
		public void setCliente(String cliente) {
			clienteJCB.setSelectedItem(cliente);
		}
	
		public void setQuantidade(int quantidade) {
			quantidadeJTF.setText(" " + quantidade);
		}
	
		public void setValorTotal(double valorTotal) {
			valorTotalJTF.setText(" " + valorTotal);
		}
	
		public void setDataVenda(String dataVenda) {
			dataVendaJTF.setText(dataVenda);
		}
	

		// Save

		public void cadastrar() {
			VendaModelo modelo = new VendaModelo(getId(), getLivro(), getCliente(), getQuantidade(), getValorTotal(),
					getDataVenda(), true);

			JOptionPane.showMessageDialog(null, modelo.toString());

			modelo.salvar();
			dispose();
		}

		// Edit
		public void editar() {
			VendaModelo modelo = new VendaModelo(getId(), getLivro(), getCliente(), getQuantidade(), getValorTotal(),
					getDataVenda(), true);

			JOptionPane.showMessageDialog(null, modelo.toString());

			modelo.salvarDados();
			dispose();
		}
	}

	class PainelSul extends JPanel implements ActionListener {
		JButton criarVendaJB;

		public PainelSul() {
			add(criarVendaJB = new JButton("Criar venda"));

			criarVendaJB.addActionListener(this);
		}

		public void actionPerformed(ActionEvent evt) {
			if (evt.getSource() == criarVendaJB) {
				if (editar) {
					centro.editar();
				} else {
					centro.cadastrar();
				}
			}

		}
	}

	public void defineTheme() {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
		}
	}
}
