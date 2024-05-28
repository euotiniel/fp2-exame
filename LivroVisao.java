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

public class LivroVisao extends JFrame
{
	PainelCentro centro;
	PainelSul sul;
	public LivroVisao()
	{
		getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
		getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);
		setTitle("Cadastro de Novo Livro");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setVisible(true);		
	}
	
	class PainelCentro extends JPanel{
		
		public PainelCentro(){
			
		}
	}
	
	class PainelSul extends JPanel implements ActionListener
	{
		JButton cadastrarJB;
		
		public PainelSul()
		{
			add( cadastrarJB = new JButton("Cadastrar livro") );
			
			cadastrarJB.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent evt)
		{
			if (evt.getSource() == cadastrarJB) {
				JOptionPane.showMessageDialog(null, "Cadastrado");
			}
				
		}
	}
}
