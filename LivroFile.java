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

            incrementarProximoCodigo();

            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso.");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar os dados...");
        }
    }

    public  static void listarLivros() {
        LivroFile ficheiro = new LivroFile();
        LivroModelo modelo = new LivroModelo();
        String output = "Listagem dos dados do Ficheiro\n\n"; 
        try {
            ficheiro.stream.seek(4);
            for (int i = 0; i < ficheiro.getNregistos(); ++i){
                modelo .read(ficheiro.stream);
                output += "--------------------------------------------\n";
                output += modelo.toString() + "\n";
            }

            JTextArea area = new JTextArea(40, 60);
            area.setText(output);
            area.setFocusable(false);
            JOptionPane.showMessageDialog(null, new JScrollPane( area ));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    public static StringVector getAllNames() {
        LivroFile ficheiro = new LivroFile();
        LivroModelo modelo = new LivroModelo();
        StringVector vector = new StringVector();

        try {
            ficheiro.stream.seek(4);
            for (int i = 0; i < ficheiro.getNregistos(); ++i){
                modelo .read(ficheiro.stream);
                vector.add(modelo.getTitulo());
            }

            vector.sort();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 

        return vector;
    }

    public  static void pesquisarLivroPorTitulo(String tituloProcurado) {
        LivroFile ficheiro = new LivroFile();
        LivroModelo modelo = new LivroModelo();

        try {
            ficheiro.stream.seek(4);
            for (int i = 0; i < ficheiro.getNregistos(); ++i){
                
                modelo .read(ficheiro.stream);

                if (modelo.getTitulo().equalsIgnoreCase(tituloProcurado)) {
                    JOptionPane.showMessageDialog(null, modelo.toString());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
}
