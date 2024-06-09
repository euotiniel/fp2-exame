/*------------------------------------
Tema: Gestão de uma Livraria
Nome: Otoniel Emanuel
Numero: 33039
Ficheiro: LivroFile.java
Data: 09.06.2024
--------------------------------------*/

import javax.swing.*;
import SwingComponents.*;
import Calendario.*;
import java.io.*;

public class LivroFile extends ObjectsFile {
    
    public LivroFile() {
        super("LivroFile.dat", new LivroModelo());
    }

    public void salvarDados (LivroModelo modelo) {
        try {
            // Colocar file pointer no final do ficheiro
            stream.seek( stream.length());

            modelo.write(stream);

            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso.");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar os dados...");
        }
    }
}
