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
	boolean editar;

	public ClienteVisao(boolean alterar, ClienteModelo modelo) {

		editar = alterar;

		if (!alterar) {
			getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
		} else {
			getContentPane().add(centro = new PainelCentro(modelo), BorderLayout.CENTER);
		}

		// getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
		getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);
		setTitle("Cadastrar novo Cliente");
		        ImageIcon appIcone = new ImageIcon(
                "C:\\Users\\euotinielpc\\Documents\\UCAN\\Proj\\FP2\\OtonielEmanuel33039\\images\\book.png");
        setIconImage(appIcone.getImage());
		pack();
		// setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	class PainelCentro extends JPanel {
		JTextField idJTF, nomeJTF, emailJTF, telefoneJTF;
		JComboBoxPersonal provinciaJCB, municipioJCB, comunaJCB;
		JComboBoxTabela3_Tabela3 provMunCom;

		private ClienteFile clienteFile;

		public PainelCentro() {
			setLayout(new GridLayout(4, 4, 5, 10));

			clienteFile = new ClienteFile();

			provMunCom = new JComboBoxTabela3_Tabela3("Provincias.tab", "Municipios.tab", "Comunas.tab");

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

			// Linha 3
			add( new JLabel("Provincia"));
			add( provinciaJCB = provMunCom.getComboBoxFather() );
			
			add( new JLabel("Municipio"));
			add( municipioJCB = provMunCom.getComboBoxSun() );

			// Linha 4

			add( new JLabel("Comunas"));
			add( comunaJCB = provMunCom.getComboBoxNeto() );

		}

		public PainelCentro(ClienteModelo modelo) {
			setLayout(new GridLayout(4, 4, 5, 10));

			clienteFile = new ClienteFile();

			// Linha 1

			add(new Label("ID"));
			add(idJTF = new JTextField());
			// idJTF.setText( String.valueOf(clienteFile.getProximoCodigo()));
			idJTF.setText(" " +  modelo.getId());
			idJTF.setFocusable(false);

			add(new Label("Nome completo"));
			add(nomeJTF = new JTextField());
			nomeJTF.setText(modelo.getNome());

			// Linha 2

			add(new Label("Telefone"));
			add(telefoneJTF = new JTextField());
			telefoneJTF.setText(modelo.getTelefone());
			
			add(new Label("Email"));
			add(emailJTF = new JTextField());
			emailJTF.setText(modelo.getEmail());

			// Linha 3

			add(new JLabel("Provincia"));
			add(provinciaJCB = UInterfaceBox.createJComboBoxPersonalTab2("Provincias.tab"));
			// add(provinciaJCB = provMunCom.getComboBoxFather());

			add(new JLabel("Municipio"));
			add(municipioJCB = UInterfaceBox.createJComboBoxPersonalTab2("Municipios.tab"));

			// Linha 4

			add(new JLabel("Comuna"));
			add(comunaJCB = UInterfaceBox.createJComboBoxPersonalTab2("Comunas.tab"));
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

		public String getProvincia() {
			return String.valueOf( provinciaJCB.getSelectedItem() );
		}
		public String getMunicipio() {
			return String.valueOf( municipioJCB.getSelectedItem() );
		}
		public String getComuna() {
			return String.valueOf( comunaJCB.getSelectedItem() );
		}

		// Methods set
		public void setId(int id) {
			idJTF.setText(" " + id);
		}

		public void setNome(String nome) {
			nomeJTF.setText(nome);
		}

		public void setTelefone(String telefone) {
			telefoneJTF.setText(telefone);
		}

		public void setEmail(String email) {
			emailJTF.setText(email);
		}

		public void setProvincia(String provincia) {
			provinciaJCB.setSelectedItem(provincia);
		}

		public void setMunicipio(String municipio) {
			municipioJCB.setSelectedItem(municipio);
		}

		 public void setComuna(String comuna) {
        comunaJCB.setSelectedItem(comuna);
	 }

		// Save

		public void cadastrar() {
			ClienteModelo modelo = new ClienteModelo(getId(), getNome(), getTelefone(), getEmail(), getProvincia(), getMunicipio(), getComuna(), true);

			JOptionPane.showMessageDialog(null, modelo.toString());
				modelo.salvar();
			    dispose();			
		}

		// Editar 

		public void editar() {
			ClienteModelo modelo = new ClienteModelo(getId(), getNome(), getTelefone(), getEmail(), getProvincia(), getMunicipio(), getComuna(), true);

			JOptionPane.showMessageDialog(null, modelo.toString());

			modelo.salvarDados();
			dispose();
		}
	}

	class PainelSul extends JPanel implements ActionListener {
		JButton cadastrarJB;

		public PainelSul() {
			add(cadastrarJB = new JButton(" Cadastrar cliente"));
			ImageIcon createIcon = new ImageIcon(
				"C:\\Users\\euotinielpc\\Documents\\UCAN\\Proj\\FP2\\OtonielEmanuel33039\\images\\add.png");
		Image createImagem = createIcon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		createIcon = new ImageIcon(createImagem);
		cadastrarJB.setIcon(createIcon);
			cadastrarJB.addActionListener(this);
		}

		public void actionPerformed(ActionEvent evt) {

			if (centro.getNome().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O campo 'Nome do cliente' não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (centro.getTelefone().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O campo 'Telefone do cliente' não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (centro.getEmail().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O campo 'Email do cliente' não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (centro.getProvincia().isEmpty()) {
				JOptionPane.showMessageDialog(null, "O campo 'Provincia' não pode estar vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
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
}
