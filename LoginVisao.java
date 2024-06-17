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

        setTitle("Entrar");
        setSize(400, 300);
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
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10); // Define margens para os componentes

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            add(new JLabel("N processo: "), gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(numberJTF = new JTextField(20), gbc);

            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.WEST;
            add(new JLabel("Password: "), gbc);

            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(passwordJPF = new JPasswordField(20), gbc);

            // Definir caracter de ocultar senha
            passwordJPF.setEchoChar('o');

            // Adicionar KeyListener para o campo de senha
            passwordJPF.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        String user = centro.getNumber();
                        dispose();
                        new MenuPrincipal(user);
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
            add(entrarJB = new JButton("Entrar"));
            entrarJB.addActionListener(this);
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
