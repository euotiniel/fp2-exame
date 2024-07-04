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

    public void salvarDados(VendaModelo modelo) {
        try {
            // Colocar file pointer no final do ficheiro
            stream.seek(stream.length());

            modelo.write(stream);

            incrementarProximoCodigo();

            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso.");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao salvar os dados...");
        }
    }

    public static void listarVendas() {
        VendaFile ficheiro = new VendaFile();
        VendaModelo modelo = new VendaModelo();
        String output = "Listagem das vendas\n\n";
        try {
            ficheiro.stream.seek(4);
            for (int i = 0; i < ficheiro.getNregistos(); ++i) {
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
            JOptionPane.showMessageDialog(null, new JScrollPane(area));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static List<String> getBookTitles() {
        List<String> titles = new ArrayList<>();
        LivroFile ficheiro = new LivroFile();
        LivroModelo modelo = new LivroModelo();
        try {
            ficheiro.getStream().seek(4);
            for (int i = 0; i < ficheiro.getNregistos(); ++i) {
                modelo.read(ficheiro.getStream());
                if (modelo.getStatus() == true && modelo.getQuantidadeEstoque() > 0) {
                    titles.add(modelo.getTitulo().trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return titles;
    }

    public static List<String> getBookCode() {
        List<String> codes = new ArrayList<>();
        VendaFile ficheiro = new VendaFile();
        VendaModelo modelo = new VendaModelo();
        try {
            ficheiro.getStream().seek(4);
            for (int i = 0; i < ficheiro.getNregistos(); ++i) {
                modelo.read(ficheiro.getStream());
                if (modelo.getStatus() == true) {
                codes.add(Integer.toString(modelo.getId()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return codes;
    }

    public static List<String> getClientNames() {
        List<String> names = new ArrayList<>();
        ClienteFile ficheiro = new ClienteFile();
        ClienteModelo modelo = new ClienteModelo();
        try {
            ficheiro.getStream().seek(4);
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

    public static StringVector getAllNames() {
    VendaFile ficheiro = new VendaFile();
    VendaModelo modelo = new VendaModelo();
    StringVector vector = new StringVector();

    try {
    ficheiro.stream.seek(4);
    for (int i = 0; i < ficheiro.getNregistos(); ++i){
    modelo.read(ficheiro.stream);

    if (modelo.getStatus() == true) {
    vector.add(modelo.getId());
    }
    }

    vector.sort();
    } catch (Exception ex) {
    ex.printStackTrace();
    }

    return vector;
    }

    // public static StringVector getAllGenders() {
    // VendaFile ficheiro = new VendaFile();
    // VendaModelo modelo = new VendaModelo();
    // StringVector vector = new StringVector();

    // try {
    // ficheiro.stream.seek(4);
    // for (int i = 0; i < ficheiro.getNregistos(); ++i){
    // modelo.read(ficheiro.stream);
    // vector.add(modelo.getGenero());
    // }

    // vector.sort();
    // } catch (Exception ex) {
    // ex.printStackTrace();
    // }

    // return vector;
    // }

    public static VendaModelo getVendaPorCodigo(int vendaProcurada) {
    VendaFile ficheiro = new VendaFile();
    VendaModelo modelo = new VendaModelo();

    try {
    ficheiro.stream.seek(4);
    for (int i = 0; i < ficheiro.getNregistos(); ++i){

    modelo.read(ficheiro.stream);

    if (modelo.getId() == vendaProcurada && modelo.getStatus() == true) {
    return modelo;
    }
    }
    } catch (Exception ex) {
    ex.printStackTrace();
    }

    return modelo;
    }

    public static List<String> PesquisarVendaPorNome(int codigoProcurado) {
        List<String> titles = new ArrayList<>();
        VendaFile ficheiro = new VendaFile();
        VendaModelo modelo = new VendaModelo();
        try {
            ficheiro.stream.seek(4);
            for (int i = 0; i < ficheiro.getNregistos(); ++i) {

                modelo.read(ficheiro.stream);

                if (modelo.getId() == codigoProcurado && modelo.getStatus() == true) {
                    JOptionPane.showMessageDialog(null, modelo.toString());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return titles;
    }

    public static void PesquisarVendaPorCliente(String clienteProcurado) {
        VendaFile ficheiro = new VendaFile();
        VendaModelo modelo = new VendaModelo();

        try {
            ficheiro.stream.seek(4);
            for (int i = 0; i < ficheiro.getNregistos(); ++i) {

                modelo.read(ficheiro.stream);

                if (modelo.getCliente().equalsIgnoreCase(clienteProcurado) && modelo.getStatus() == true) {
                    JOptionPane.showMessageDialog(null, modelo.toString());
                    return;
                }
            }
            JOptionPane.showMessageDialog(null, "Cliente não encontrado", "Not found", JOptionPane.ERROR_MESSAGE);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void PesquisarVendaPorData(String dataProcurada) {
        VendaFile ficheiro = new VendaFile();
        VendaModelo modelo = new VendaModelo();

        try {
            ficheiro.stream.seek(4);
            for (int i = 0; i < ficheiro.getNregistos(); ++i) {

                modelo.read(ficheiro.stream);

                if (modelo.getDataVenda().equalsIgnoreCase(dataProcurada) && modelo.getStatus() == true) {
                    JOptionPane.showMessageDialog(null, modelo.toString());
                    break;
                }
            }

            JOptionPane.showMessageDialog(null, "Data não encontrado", "Not found", JOptionPane.ERROR_MESSAGE);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void alterarDados(VendaModelo modelo_novo) {
        VendaModelo modelo_antigo = new VendaModelo();

        try {
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

    public void eliminarDados (VendaModelo modelo_novo) {
    VendaModelo modelo_antigo = new VendaModelo();

    try {
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
