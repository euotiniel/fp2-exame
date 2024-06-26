/*------------------------------------
Tema: Gestão de uma Livraria
Nome: Otoniel Emanuel
Numero: 33039
Ficheiro: VendaFile.java
Data: 25.06.2024
--------------------------------------*/

import javax.swing.*;
import SwingComponents.*;
import Calendario.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VendaFile extends ObjectsFile {
    
    public VendaFile() {
        super("VendaFile.dat", new VendaModelo());
    }

    public void salvarDados (VendaModelo modelo) {
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

    public  static void listarVendas() {
        VendaFile ficheiro = new VendaFile();
        VendaModelo modelo = new VendaModelo();
        String output = "Listagem das vendas\n\n"; 
        try {
            ficheiro.stream.seek(4);
            for (int i = -1; i < ficheiro.getNregistos(); ++i){
                modelo.read(ficheiro.stream);

                if (modelo.getStatus() == true) {
                    output += "--------------------------------------------\n";
                    output += modelo.toString() + "\n";
                }

                // output += "--------------------------------------------\n";
                // output += modelo.toString() + "\n";
            }

            JTextArea area = new JTextArea(40, 60);
            area.setText(output);
            area.setFocusable(false);
            JOptionPane.showMessageDialog(null, new JScrollPane( area ));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

 public static List<String> getBookTitles() {
        List<String> titles = new ArrayList<>();
        LivroFile ficheiro = new LivroFile();
        LivroModelo modelo = new LivroModelo();
        try {
            ficheiro.getStream().seek(4); // Skip the first 4 bytes
            for (int i = 0; i < ficheiro.getNregistos(); ++i) {
                modelo.read(ficheiro.getStream());
                if (modelo.getStatus() == true) {
                    titles.add(modelo.getTitulo().trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return titles;
    }

 public static List<String> getClientNames() {
        List<String> names = new ArrayList<>();
        ClienteFile ficheiro = new ClienteFile();
        ClienteModelo modelo = new ClienteModelo();
        try {
            ficheiro.getStream().seek(4); // Skip the first 4 bytes
            for (int i = 0; i < ficheiro.getNregistos(); ++i) {
                modelo.read(ficheiro.getStream());
                if (modelo.getStatus() == true) {
                    names.add(modelo.getNome().trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
    }



    // public static StringVector getAllNames() {
    //     VendaFile ficheiro = new VendaFile();
    //     VendaModelo modelo = new VendaModelo();
    //     StringVector vector = new StringVector();

    //     try {
    //         ficheiro.stream.seek(4);
    //         for (int i = 0; i < ficheiro.getNregistos(); ++i){
    //             modelo.read(ficheiro.stream);

    //             if (modelo.getStatus() == true) {
    //                 vector.add(modelo.getTitulo());
    //             }
    //         }

    //         vector.sort();
    //     } catch (Exception ex) {
    //         ex.printStackTrace();
    //     } 

    //     return vector;
    // }

    // public static StringVector getAllGenders() {
    //     VendaFile ficheiro = new VendaFile();
    //     VendaModelo modelo = new VendaModelo();
    //     StringVector vector = new StringVector();

    //     try {
    //         ficheiro.stream.seek(4);
    //         for (int i = 0; i < ficheiro.getNregistos(); ++i){
    //             modelo.read(ficheiro.stream);
    //             vector.add(modelo.getGenero());
    //         }

    //         vector.sort();
    //     } catch (Exception ex) {
    //         ex.printStackTrace();
    //     } 

    //     return vector;
    // }

    // public  static VendaModelo getLivroPorTitulo(String tituloProcurado) {
    //     VendaFile ficheiro = new VendaFile();
    //     VendaModelo modelo = new VendaModelo();

    //     try {
    //         ficheiro.stream.seek(4);
    //         for (int i = 0; i < ficheiro.getNregistos(); ++i){
                
    //             modelo.read(ficheiro.stream);

    //             if (modelo.getTitulo().equalsIgnoreCase(tituloProcurado) && modelo.getStatus() == true) {
    //                 return modelo;
    //             }
    //         }
    //     } catch (Exception ex) {
    //         ex.printStackTrace();
    //     }

    //     return modelo;
    // }

    // public  static void pesquisarLivroPorTitulo(String tituloProcurado) {
    //     VendaFile ficheiro = new VendaFile();
    //     VendaModelo modelo = new VendaModelo();

    //     try {
    //         ficheiro.stream.seek(4);
    //         for (int i = 0; i < ficheiro.getNregistos(); ++i){
                
    //             modelo.read(ficheiro.stream);

    //             if (modelo.getTitulo().equalsIgnoreCase(tituloProcurado) && modelo.getStatus() == true) {
    //                 JOptionPane.showMessageDialog(null, modelo.toString());
    //                 break;
    //             }
    //         }
    //     } catch (Exception ex) {
    //         ex.printStackTrace();
    //     }
        
    // }

    // public  static void pesquisarLivroPorAutor(String getAutorProcurado) {
    //     VendaFile ficheiro = new VendaFile();
    //     VendaModelo modelo = new VendaModelo();

    //     try {
    //         ficheiro.stream.seek(4);
    //         for (int i = 0; i < ficheiro.getNregistos(); ++i){
                
    //             modelo.read(ficheiro.stream);

    //             if (modelo.getAutor().equalsIgnoreCase(getAutorProcurado) && modelo.getStatus() == true) {
    //                 JOptionPane.showMessageDialog(null, modelo.toString());
    //                 return;
    //             } 
    //         }
    //         JOptionPane.showMessageDialog(null, "404, Autor não encontrado", "Not found", JOptionPane.ERROR_MESSAGE);

    //     } catch (Exception ex) {
    //         ex.printStackTrace();
    //     }
        
    // }

    // public  static void pesquisarLivroPorGenero(String generoProcurado) {
    //     VendaFile ficheiro = new VendaFile();
    //     VendaModelo modelo = new VendaModelo();

    //     try {
    //         ficheiro.stream.seek(4);
    //         for (int i = 0; i < ficheiro.getNregistos(); ++i){
                
    //             modelo.read(ficheiro.stream);

    //             if (modelo.getGenero().equalsIgnoreCase(generoProcurado) && modelo.getStatus() == true) {
    //                 JOptionPane.showMessageDialog(null, modelo.toString());
    //                 break;
    //             }
    //         }
    //     } catch (Exception ex) {
    //         ex.printStackTrace();
    //     }
        
    // }

     public void alterarDados (VendaModelo modelo_novo) {
         VendaModelo modelo_antigo = new VendaModelo();

         try  {
             stream.seek(4);

             for (int i = 0; i < getNregistos(); ++i) {
                 modelo_antigo.read(stream);

                 if (i == 0 && modelo_antigo.getId() == modelo_novo.getId()) {
                     stream.seek(4);
                     modelo_novo.write(stream);
                     JOptionPane.showMessageDialog(null, "Dados editados com sucesso.");
                     return;
                 } else {
                     if (modelo_antigo.getId() + 1 == modelo_novo.getId()) {
                         modelo_novo.write(stream);
                         return;
                     }
                 }
             }
         } catch (Exception ex) {
             ex.printStackTrace();
         }
     }

    // public void eliminarDados (VendaModelo modelo_novo) {
    //     VendaModelo modelo_antigo = new VendaModelo();

    //     try  {
    //         stream.seek(4);

    //         for (int i = 0; i < getNregistos(); ++i) {

    //             modelo_antigo.read(stream);

    //             if (i == 0 && modelo_antigo.getId() == modelo_novo.getId()) {
    //                 stream.seek(4);
    //                 modelo_novo.write(stream);
    //                 JOptionPane.showMessageDialog(null, "Livro elimados com sucesso.");
    //                 return;
    //             } else {
    //                 if (modelo_antigo.getId() + 1 == modelo_novo.getId()) {
    //                     modelo_novo.write(stream);
    //                     return;
    //                 }
    //             }
    //         }
    //     } catch (Exception ex) {
    //         ex.printStackTrace();
    //     }
    // }
}