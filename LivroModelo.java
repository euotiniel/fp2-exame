/*------------------------------------
Tema: Gestão de uma Livraria
Nome: Otoniel Emanuel
Numero: 33039
Ficheiro: LivroModelo.java
Data: 06.06.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;
import java.io.*;

public class LivroModelo implements RegistGeneric {

    int id;
    StringBufferModelo titulo, autor, genero, estado;
    double preco;
    int quantidadeEstoque;

    public LivroModelo() {
        id = 0;
        titulo = new StringBufferModelo("", 50);
        autor = new StringBufferModelo("", 50);
        genero = new StringBufferModelo("", 20);
        estado = new StringBufferModelo("", 30);
        preco = 0;
        quantidadeEstoque = 0;
    }

    public LivroModelo(int id, String titulo, String autor, String genero, String estado, double preco, int quantidadeEstoque) {
        this.id = id;
        this.titulo = new StringBufferModelo(titulo, 50);
        this.autor = new StringBufferModelo(autor, 50);
        this.genero = new StringBufferModelo(genero, 20);
        this.estado = new StringBufferModelo(estado, 30);
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    // Methods GET

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo.toStringEliminatingSpaces();
    }

    public String getAutor() {
        return autor.toStringEliminatingSpaces();
    }

    public String getGenero() {
        return genero.toStringEliminatingSpaces();
    }

    public String getEstado() {
        return estado.toStringEliminatingSpaces();
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    // Methods SET

    public void setId(int novoId) {
        id = novoId;
    }

    public void setTitulo(String novoTitulo) {
        titulo = new StringBufferModelo(novoTitulo, 50);
    }

    public void setAutor(String novoAutor) {
        autor = new StringBufferModelo(novoAutor, 50);
    }

    public void setGenero(String novoGenero) {
        genero = new StringBufferModelo(novoGenero, 20);
    }

    public void setEstado(String novoEstado) {
        estado = new StringBufferModelo(novoEstado, 30);
    }

    public void setPreco(double novoPreco) {
        preco = novoPreco;
    }

    public void setQuantidadeEstoque(int novaQuantidadeEstoque) {
        quantidadeEstoque = novaQuantidadeEstoque;
    }

    // toString

    public String toString () {
        String str = "Dados do Livro Modelo\n\n";

        str += "id: " + getId() + "\n";
        str += "Titulo: " + getTitulo() + "\n";
        str += "Autor: " + getAutor() + "\n";
        str += "Genero: " + getGenero() + "\n";
        str += "Estado: " + getEstado() + "\n";
        str += "Preco: " + getPreco() + " kzs\n";
        str += "Estoque: " + getQuantidadeEstoque() + "\n";

        return str;
    }

    // Tamanho geral de cada registro/modelo
    public long sizeof() {
        try {
            return 150 * 2 + 4 + 6 + 3;
        } catch (Exception ex) {
            return 0;
        }
    } 

    public void write(RandomAccessFile stream) {
        try {
            stream.writeInt(id);
        titulo.write(stream);
        autor.write(stream);
        genero.write(stream);
        estado.write(stream);
        stream.writeDouble(preco);
        stream.writeInt(quantidadeEstoque);

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Falha ao tentar escrever...");
        }
    }

    public void read(RandomAccessFile stream) {
        try {
            id = stream.readInt();
        titulo.read(stream);
        autor.read(stream);
        genero.read(stream);
        estado.read(stream);
        preco = stream.readDouble();
        quantidadeEstoque = stream.readInt();

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Falha ao tentar ler...");
        }
    }

    public void salvar () {
        LivroFile file = new LivroFile();
        file.salvarDados(this);
    }

    public void salvarDados(){
        LivroFile file = new LivroFile();
        file.alterarDados(this);
    }

}
