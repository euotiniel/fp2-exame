/*------------------------------------
Tema: Gestão de uma Livraria
Nome: Otoniel Emanuel
Numero: 33039
Ficheiro: ClienteFile.java
Data: 17.06.2024
--------------------------------------*/

import javax.swing.*;
import SwingComponents.*;
import Calendario.*;
import java.io.*;

public class ClienteFile extends ObjectsFile {
    
    public ClienteFile() {
        super("ClienteFile.dat", new ClienteModelo());
    }

    public void salvarDados (ClienteModelo modelo) {
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

    public  static void listarClientes() {
        ClienteFile ficheiro = new ClienteFile();
        ClienteModelo modelo = new ClienteModelo();
        String output = "Listagem dos Clientes\n\n"; 
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


 public  static void pesquisarClientePorNome(String getNomeProcurado) {
     ClienteFile ficheiro = new ClienteFile();
     ClienteModelo modelo = new ClienteModelo();

     try {
         ficheiro.stream.seek(4);
         for (int i = 0; i < ficheiro.getNregistos(); ++i){
                
             modelo.read(ficheiro.stream);

             if (modelo.getNome().equalsIgnoreCase(getNomeProcurado) && modelo.getStatus() == true) {
                 JOptionPane.showMessageDialog(null, modelo.toString());
                 return;
             } 
         }
         JOptionPane.showMessageDialog(null, "Nome não encontrado", "Not found", JOptionPane.ERROR_MESSAGE);

     } catch (Exception ex) {
         ex.printStackTrace();
     }
        
 }

 public static ClienteModelo getClientePorNome(String getNomeProcurado) {
     ClienteFile ficheiro = new ClienteFile();
     ClienteModelo modelo = new ClienteModelo();

     try {
         ficheiro.stream.seek(4);
         for (int i = 0; i < ficheiro.getNregistos(); ++i){
                
             modelo.read(ficheiro.stream);

             if (modelo.getNome().equalsIgnoreCase(getNomeProcurado) && modelo.getStatus() == true) {
                 return modelo;
             } 
         }
         JOptionPane.showMessageDialog(null, "Nome não encontrado", "Not found", JOptionPane.ERROR_MESSAGE);

     } catch (Exception ex) {
         ex.printStackTrace();
     }
       return modelo; 
 }

 public static ClienteModelo getClientePorTelefone(String getTelefoneProcurado) {
     ClienteFile ficheiro = new ClienteFile();
     ClienteModelo modelo = new ClienteModelo();

     try {
         ficheiro.stream.seek(4);
         for (int i = 0; i < ficheiro.getNregistos(); ++i){
                
             modelo.read(ficheiro.stream);

             if (modelo.getTelefone().equalsIgnoreCase(getTelefoneProcurado) && modelo.getStatus() == true) {
                 return modelo;
             } 
         }
         JOptionPane.showMessageDialog(null, "Telefone não encontrado", "Not found", JOptionPane.ERROR_MESSAGE);

     } catch (Exception ex) {
         ex.printStackTrace();
     }
       return modelo; 
 }

 public  static void pesquisarClientePorTelefone(String getTelefoneProcurado) {
     ClienteFile ficheiro = new ClienteFile();
     ClienteModelo modelo = new ClienteModelo();

     try {
         ficheiro.stream.seek(4);
         for (int i = 0; i < ficheiro.getNregistos(); ++i){
                
             modelo.read(ficheiro.stream);

             if (modelo.getTelefone().equalsIgnoreCase(getTelefoneProcurado) && modelo.getStatus() == true) {
                 JOptionPane.showMessageDialog(null, modelo.toString());
                 return;
             } 
         }
         JOptionPane.showMessageDialog(null, "Telefone não encontrado", "Not found", JOptionPane.ERROR_MESSAGE);

     } catch (Exception ex) {
         ex.printStackTrace();
     }
        
 }

 public void alterarDados (ClienteModelo modelo_novo) {
        ClienteModelo modelo_antigo = new ClienteModelo();

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

 public void elimiarDados (ClienteModelo modelo_novo) {
        ClienteModelo modelo_antigo = new ClienteModelo();

        try  {
            stream.seek(4);

            for (int i = 0; i < getNregistos(); ++i) {
                modelo_antigo.read(stream);

                if (i == 0 && modelo_antigo.getId() == modelo_novo.getId()) {
                    stream.seek(4);
                    modelo_novo.write(stream);
                    JOptionPane.showMessageDialog(null, "Dados eliminados com sucesso.");
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
