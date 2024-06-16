/*------------------------------------
Tema: Gestão de uma Livraria
Nome: Otoniel Emanuel
Numero: 33039
Ficheiro: ApresentacaoVisao.java
Data: 14.06.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;

public class LoginVisao extends JFrame {

    private PainelCentro centro;
    private PainelSul sul;

    public LoginVisao() {

        getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
        getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);

        setTitle("Entrar");
        // pack();
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    class PainelCentro extends JPanel {
        private JTextField numberJTF;
        private JPasswordField passwordJPF;
        private String correctNumber = "33039";
        private String correctPassword = "ucan";

        public PainelCentro() {
            setLayout(new GridLayout(2, 2));
            add(new JLabel("N processo: "));
            add(numberJTF = new JTextField());
            add(new JLabel("Password: "));
            add(passwordJPF = new JPasswordField());
        }

        public String getNumber() {
            return numberJTF.getText().trim();
        }

        public String getPassword() {
            return passwordJPF.getText().trim();
        }

        public boolean loginValid() {
            if (getNumber().equals(correctNumber) && getPassword().equals(correctPassword)) {
                return true;
            }

            return false;
        }
    }

    class PainelSul extends JPanel implements ActionListener {
        private JButton entrarJB;

        public PainelSul() {
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
                    JOptionPane.showMessageDialog(null, "Login invalido", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                dispose();
            }
        }
    }

    public static void main(String args[]) {
        Vector_Tabelas.inic(); // cria a conexao do projecto com a API SWINGCOMPONENTS
        new ApresentacaoVisao();
    }
}



