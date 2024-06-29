/*------------------------------------
Tema: Gestão de uma Livraria
Nome: Otoniel Emanuel
Numero: 33039
Ficheiro: LoginVisao.java
Data: 14.06.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginVisao extends JFrame {

    private PainelCentro centro;
    private PainelSul sul;

    public LoginVisao() {

        getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);
        ImageIcon appIcone = new ImageIcon(
                "C:\\Users\\euotinielpc\\Documents\\UCAN\\Proj\\FP2\\OtonielEmanuel33039\\images\\book.png");
        setIconImage(appIcone.getImage());
        setTitle("Entrar");
        setSize(420, 350);
        // pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    class PainelCentro extends JPanel {
        private JTextField numberJTF;
        private JPasswordField passwordJPF;
        private String correctNumber = "33039";
        private String correctPassword = "ucan";

        public PainelCentro() {
            setLayout(new GridBagLayout());
            setBackground(Color.WHITE);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10); // Define margens para os componentes

            // Adicionando imagem no centro
            ImageIcon livroIcone = new ImageIcon(
                    "C:\\Users\\euotinielpc\\Documents\\UCAN\\Proj\\FP2\\OtonielEmanuel33039\\images\\book.png");
            Image livroImagem = livroIcone.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            livroIcone = new ImageIcon(livroImagem);
            JLabel iconeLivro = new JLabel(livroIcone);
            iconeLivro.setHorizontalAlignment(SwingConstants.CENTER);

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.CENTER;
            add(iconeLivro, gbc);

            // gbc.gridx = 0;
            // gbc.gridy = 1;
            // gbc.anchor = GridBagConstraints.CENTER;
            // gbc.fill = GridBagConstraints.HORIZONTAL;
            // add(textoJEP, gbc);

            // Adicionando campos de login abaixo do texto
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.anchor = GridBagConstraints.WEST;
            add(new JLabel("N processo: "), gbc);

            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(numberJTF = new JTextField(20), gbc);

            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.WEST;
            add(new JLabel("Password: "), gbc);

            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(passwordJPF = new JPasswordField(20), gbc);

            // Definir caracter de ocultar senha
            passwordJPF.setEchoChar('o');

            passwordJPF.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        String user = getNumber();
                        if (loginValid()) {
                            dispose();
                            new MenuPrincipal(user);
                        } else {
                            JOptionPane.showMessageDialog(null, "Número ou senha incorretos!");
                        }
                    }
                }
            });
        }

        public String getNumber() {
            return numberJTF.getText().trim();
        }

        public String getPassword() {
            return new String(passwordJPF.getPassword()).trim();
        }

        public boolean loginValid() {
            return getNumber().equals(correctNumber) && getPassword().equals(correctPassword);
        }
    }

    class PainelSul extends JPanel implements ActionListener {
        private JButton entrarJB;

        public PainelSul() {
            setLayout(new FlowLayout(FlowLayout.CENTER));
            setBackground(Color.WHITE);
            add(entrarJB = new JButton("  Entrar"));
            ImageIcon entrarIcon = new ImageIcon(
                    "C:\\Users\\euotinielpc\\Documents\\UCAN\\Proj\\FP2\\OtonielEmanuel33039\\images\\enter.png");
            Image entrarImagem = entrarIcon.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
            entrarIcon = new ImageIcon(entrarImagem);
            entrarJB.setIcon(entrarIcon);
        }

        public void actionPerformed(ActionEvent evt) {
            if (evt.getSource() == entrarJB) {
                if (centro.loginValid()) {
                    String user = centro.getNumber();
                    dispose();
                    new MenuPrincipal(user);
                } else {
                    JOptionPane.showMessageDialog(null, "Login inválido", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                dispose();
            }
        }
    }
}
