/*------------------------------------
Tema: Gestão de uma Livraria
Nome: Otoniel Emanuel
Numero: 33039
Ficheiro: LivroVisao.java
Data: 28.05.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class SobreOAutor extends JFrame {
    public SobreOAutor() {
        super("Sobre o Autor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 540);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Criar um painel principal com padding
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Padding de 10 pixels ao redor

        // Adicionar imagem redimensionada
        JLabel imageLabel = new JLabel();
        ImageIcon autorImage = new ImageIcon("C:\\Users\\euotinielpc\\Documents\\UCAN\\Proj\\FP2\\OtonielEmanuel33039\\images\\euotiniel.jpeg"); // Certifique-se de que o caminho da imagem está correto
        Image image = autorImage.getImage(); // Transformar em objeto Image
        Image resizedImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Redimensionar imagem
        autorImage = new ImageIcon(resizedImage); // Transformar de volta em ImageIcon
        imageLabel.setIcon(autorImage);
        imageLabel.setHorizontalAlignment(JLabel.CENTER); // Centralizar a imagem no painel
        imageLabel.setBorder(new EmptyBorder(10, 0, 10, 0)); // Padding acima e abaixo da imagem
        panel.add(imageLabel, BorderLayout.NORTH);

        // Adicionar informações do autor
        JTextArea textArea = new JTextArea();
        textArea.setText("Nome do Autor: Otoniel Emanuel\n\n" +
                "Universidade: Universidade Católica de Angola (UCAN)\n\n" +
                "Turma: A\n\n" +
                "Ano: Primeiro ano\n\n" +
                "Numero: 33039\n\n" +
                "Atualmente é estudante de Eng. Informática e está trabalhando em projetos que envolvem interfaces gráficas e usabilidade.\n\n" +
                "Email: otonielemanuel21@gmail.com\n" +
                "Telefone: 929 392 38");
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(new EmptyBorder(10, 10, 10, 10)); // Padding ao redor do texto
        JScrollPane scrollPane = new JScrollPane(textArea);

        panel.add(scrollPane, BorderLayout.CENTER);

        // Adicionar painel ao frame
        add(panel);

        // Tornar o frame visível
        setVisible(true);
    }
}
