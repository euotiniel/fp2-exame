/*------------------------------------
Tema: Gestão de uma Livraria
Nome: Otoniel Emanuel
Numero: 33039
Ficheiro: LivroVisao.java
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
	boolean editar;

	public LivroVisao(boolean alterar, LivroModelo modelo) {
		// getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
		getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);

		editar = alterar;

		if (!alterar) {
			getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
		} else {
			getContentPane().add(centro = new PainelCentro(modelo), BorderLayout.CENTER);
		}
		setTitle("Cadastro de Novo Livro");
		ImageIcon appIcone = new ImageIcon(
				"C:\\Users\\euotinielpc\\Documents\\UCAN\\Proj\\FP2\\OtonielEmanuel33039\\images\\book.png");
		setIconImage(appIcone.getImage());
		// defineTheme();
		pack();
		// setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	class PainelCentro extends JPanel {
		JTextField idJTF, tituloJTF, autorJTF;
		JComboBox<String> generoJCB, estadoDoLivroJCB;
		JSpinner quantidadeEstoqueJS, precoJS;
		private LivroFile livroFile;

		public PainelCentro() {
			setLayout(new GridLayout(4, 2, 5, 10));

			livroFile = new LivroFile();
			// Linha 1

			add(new Label("ID"));
			add(idJTF = new JTextField());
			idJTF.setText(String.valueOf(livroFile.getProximoCodigo()));
			// idJTF.setText( "" + livroFile.getProximoCodigo());
			idJTF.setFocusable(false);

			add(new Label("Título do livro"));
			add(tituloJTF = new JTextField());

			// Linha 2

			add(new Label("Autor"));
			add(autorJTF = new JTextField());

			add(new Label("Gênero do livro"));
			add(generoJCB = UInterfaceBox.createJComboBoxPersonalTab2("Genero.tab"));

			// Linha 3

			add(new Label("Preço"));
			add(precoJS = new JSpinner());

			add(new Label("Quantidade"));
			add(quantidadeEstoqueJS = new JSpinner());

			// Linha 4

			add(new Label("Estado do livro"));
			add(estadoDoLivroJCB = UInterfaceBox.createJComboBoxPersonalTab2("EstadoDoLivro.tab"));
		}

		public PainelCentro(LivroModelo modelo) {
			setLayout(new GridLayout(4, 2, 5, 10));

			livroFile = new LivroFile();
			// Linha 1

			add(new Label("ID"));
			add(idJTF = new JTextField());
			// idJTF.setText( String.valueOf(livroFile.getProximoCodigo()));
			idJTF.setText(" " + modelo.getId());
			idJTF.setFocusable(false);

			add(new Label("Título do livro"));
			add(tituloJTF = new JTextField());
			tituloJTF.setText(modelo.getTitulo());

			// Linha 2

			add(new Label("Autor"));
			add(autorJTF = new JTextField());
			autorJTF.setText(modelo.getAutor());

			add(new Label("Gênero do livro"));
			add(generoJCB = UInterfaceBox.createJComboBoxPersonalTab2("Genero.tab"));
			generoJCB.setSelectedItem(modelo.getGenero());

			// Linha 3

			add(new Label("Preço"));
			add(precoJS = new JSpinner());
			precoJS.setValue(modelo.getPreco());

			add(new Label("Quantidade"));
			add(quantidadeEstoqueJS = new JSpinner());
			quantidadeEstoqueJS.setValue(modelo.getQuantidadeEstoque());

			// Linha 4

			add(new Label("Estado do livro"));
			add(estadoDoLivroJCB = UInterfaceBox.createJComboBoxPersonalTab2("EstadoDoLivro.tab"));
			estadoDoLivroJCB.setSelectedItem(modelo.getEstado());
		}

		// Methods GET
		public int getId() {
			return Integer.parseInt(idJTF.getText().trim());
		}

		public String getTitulo() {
			return tituloJTF.getText().trim();
		}

		public String getAutor() {
			return autorJTF.getText().trim();
		}

		public String getGenero() {
			return String.valueOf(generoJCB.getSelectedItem());
		}

		public String getEstado() {
			return String.valueOf(estadoDoLivroJCB.getSelectedItem());
		}

		public int getPreco() {
			return (int) precoJS.getValue();
		}

		public int getQuantidadeEstoque() {
			return (Integer) quantidadeEstoqueJS.getValue();
		}

		// Methods SET
		public void setId(int id) {
			idJTF.setText(" " + id);
		}

		public void setTitulo(String titulo) {
			tituloJTF.setText(titulo);
		}

		public void setAutor(String autor) {
			autorJTF.setText(autor);
		}

		public void setGenero(String genero) {
			generoJCB.setSelectedItem(genero);
		}

		public void setEstado(String estadoDoLivro) {
			estadoDoLivroJCB.setSelectedItem(estadoDoLivro);
		}

		public void setPreco(int preco) {
			precoJS.setValue(preco);
		}

		public void setQuantidadeEstoque(int quantidadeEstoque) {
			quantidadeEstoqueJS.setValue(quantidadeEstoque);
		}

		// Save

		public void cadastrar() {
			LivroModelo modelo = new LivroModelo(getId(), getTitulo(), getAutor(), getGenero(), getEstado(), getPreco(),
					getQuantidadeEstoque(), true);

			JOptionPane.showMessageDialog(null, modelo.toString());

			modelo.salvar();
			dispose();
		}

		// Edit
		public void editar() {
			LivroModelo modelo = new LivroModelo(getId(), getTitulo(), getAutor(), getGenero(), getEstado(), getPreco(),
					getQuantidadeEstoque(), true);

			JOptionPane.showMessageDialog(null, modelo.toString());

			modelo.salvarDados();
			dispose();
		}
	}

	class PainelSul extends JPanel implements ActionListener {
		JButton cadastrarJB;

		public PainelSul() {
			add(cadastrarJB = new JButton(" Cadastrar livro"));
			ImageIcon createIcon = new ImageIcon(
					"C:\\Users\\euotinielpc\\Documents\\UCAN\\Proj\\FP2\\OtonielEmanuel33039\\images\\add.png");
			Image createImagem = createIcon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
			createIcon = new ImageIcon(createImagem);
			cadastrarJB.setIcon(createIcon);
			cadastrarJB.addActionListener(this);
		}

		public void actionPerformed(ActionEvent evt) {

			if (centro.getTitulo().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O campo 'Título do livro' não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (centro.getAutor().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O campo 'Autor do livro' não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (centro.getGenero().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O campo 'Genero do livro' não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (centro.getPreco() <= 100) {
				JOptionPane.showMessageDialog(null, "O campo 'Preço do livro' deve conter um valor válido.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (centro.getQuantidadeEstoque() < 1) {
				JOptionPane.showMessageDialog(null, "O campo 'Quantidade do livro' não pode estar vazio e nem conter número negativos.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (centro.getEstado().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O campo 'Estado do livro' não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (evt.getSource() == cadastrarJB) {
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
