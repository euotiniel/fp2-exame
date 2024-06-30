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
                modelo.read(ficheiro.stream);

                if (modelo.getStatus() == true) {
                    output += "--------------------------------------------\n";
                    output += modelo.toString() + "\n";
                }
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
                modelo.read(ficheiro.stream);

                if (modelo.getStatus() == true) {
                    vector.add(modelo.getTitulo());
                }
            }

            vector.sort();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 

        return vector;
    }

    public static StringVector getAllGenders() {
        LivroFile ficheiro = new LivroFile();
        LivroModelo modelo = new LivroModelo();
        StringVector vector = new StringVector();

        try {
            ficheiro.stream.seek(4);
            for (int i = 0; i < ficheiro.getNregistos(); ++i){
                modelo.read(ficheiro.stream);
                vector.add(modelo.getGenero());
            }

            vector.sort();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 

        return vector;
    }

    public  static LivroModelo getLivroPorTitulo(String tituloProcurado) {
        LivroFile ficheiro = new LivroFile();
        LivroModelo modelo = new LivroModelo();

        try {
            ficheiro.stream.seek(4);
            for (int i = 0; i < ficheiro.getNregistos(); ++i){
                
                modelo.read(ficheiro.stream);

                if (modelo.getTitulo().equalsIgnoreCase(tituloProcurado) && modelo.getStatus() == true) {
                    return modelo;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return modelo;
    }

    public  static int getBookQuantity(String tituloProcurado) {
        LivroFile ficheiro = new LivroFile();
        LivroModelo modelo = new LivroModelo();

        try {
            ficheiro.stream.seek(4);
            for (int i = 0; i < ficheiro.getNregistos(); ++i){
                
                modelo.read(ficheiro.stream);

                if (modelo.getTitulo().equalsIgnoreCase(tituloProcurado) && modelo.getStatus() == true) {
                    return modelo.getQuantidadeEstoque();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    public  static double totalMoney(String tituloProcurado, int myQtt) {
        LivroFile ficheiro = new LivroFile();
        LivroModelo modelo = new LivroModelo();

        try {
            ficheiro.stream.seek(4);
            for (int i = 0; i < ficheiro.getNregistos(); ++i){
                
                modelo.read(ficheiro.stream);

                if (modelo.getTitulo().equalsIgnoreCase(tituloProcurado) && modelo.getStatus() == true) {
                    double money = myQtt * modelo.getPreco();
                    return money;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    public  static double updateStock(String tituloProcurado, int myQtt) {
        LivroFile ficheiro = new LivroFile();
        LivroModelo modelo = new LivroModelo();

        try {
            ficheiro.stream.seek(4);
            for (int i = 0; i < ficheiro.getNregistos(); ++i){
                
                modelo.read(ficheiro.stream);

                if (modelo.getTitulo().equalsIgnoreCase(tituloProcurado) && modelo.getStatus() == true) {
                    int newStock = modelo.getQuantidadeEstoque() - myQtt;
                    modelo.setQuantidadeEstoque(newStock);
                    ficheiro.stream.seek(4);
                modelo.write(ficheiro.stream);
                    // return modelo.setQuantidadeEstoque();
                    return newStock;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return modelo.getQuantidadeEstoque();
    }
    
    public  static LivroModelo getLivroPorAutor(String autorProcurado) {
        LivroFile ficheiro = new LivroFile();
        LivroModelo modelo = new LivroModelo();

        try {
            ficheiro.stream.seek(4);
            for (int i = 0; i < ficheiro.getNregistos(); ++i){
                
                modelo.read(ficheiro.stream);

                if (modelo.getAutor().equalsIgnoreCase(autorProcurado) && modelo.getStatus() == true) {
                    return modelo;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return modelo;
    }
    
    public  static LivroModelo getLivroPorGenero(String generoProcurado) {
        LivroFile ficheiro = new LivroFile();
        LivroModelo modelo = new LivroModelo();

        try {
            ficheiro.stream.seek(4);
            for (int i = 0; i < ficheiro.getNregistos(); ++i){
                
                modelo.read(ficheiro.stream);

                if (modelo.getGenero().equalsIgnoreCase(generoProcurado) && modelo.getStatus() == true) {
                    return modelo;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return modelo;
    }

    public  static void pesquisarLivroPorTitulo(String tituloProcurado) {
        LivroFile ficheiro = new LivroFile();
        LivroModelo modelo = new LivroModelo();

        try {
            ficheiro.stream.seek(4);
            for (int i = 0; i < ficheiro.getNregistos(); ++i){
                
                modelo.read(ficheiro.stream);

                if (modelo.getTitulo().equalsIgnoreCase(tituloProcurado) && modelo.getStatus() == true) {
                    JOptionPane.showMessageDialog(null, modelo.toString());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    public  static void pesquisarLivroPorAutor(String getAutorProcurado) {
        LivroFile ficheiro = new LivroFile();
        LivroModelo modelo = new LivroModelo();

        try {
            ficheiro.stream.seek(4);
            for (int i = 0; i < ficheiro.getNregistos(); ++i){
                
                modelo.read(ficheiro.stream);

                if (modelo.getAutor().equalsIgnoreCase(getAutorProcurado) && modelo.getStatus() == true) {
                    JOptionPane.showMessageDialog(null, modelo.toString());
                    return;
                } 
            }
            JOptionPane.showMessageDialog(null, "404, Autor não encontrado", "Not found", JOptionPane.ERROR_MESSAGE);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    public  static void pesquisarLivroPorGenero(String generoProcurado) {
        LivroFile ficheiro = new LivroFile();
        LivroModelo modelo = new LivroModelo();

        try {
            ficheiro.stream.seek(4);
            for (int i = 0; i < ficheiro.getNregistos(); ++i){
                
                modelo.read(ficheiro.stream);

                if (modelo.getGenero().equalsIgnoreCase(generoProcurado) && modelo.getStatus() == true) {
                    JOptionPane.showMessageDialog(null, modelo.toString());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }

    public void alterarDados (LivroModelo modelo_novo) {
        LivroModelo modelo_antigo = new LivroModelo();

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

    public void eliminarDados (LivroModelo modelo_novo) {
        LivroModelo modelo_antigo = new LivroModelo();

        try  {
            stream.seek(4);

            for (int i = 0; i < getNregistos(); ++i) {

                modelo_antigo.read(stream);

                if (i == 0 && modelo_antigo.getId() == modelo_novo.getId()) {
                    stream.seek(4);
                    modelo_novo.write(stream);
                    JOptionPane.showMessageDialog(null, "Livro elimados com sucesso.");
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
}
