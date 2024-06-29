/*------------------------------------
Tema: Gestão de uma Livraria
Nome: Otoniel Emanuel
Numero: 33039
Ficheiro: VendaModelo.java
Data: 25.06.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;
import java.io.*;

public class VendaModelo implements RegistGeneric {

    int id;
    StringBufferModelo livro, cliente, dataVenda;
    int quantidade;
    double valorTotal;
    private boolean status;

    public VendaModelo() {
        id = 0;
        livro = new StringBufferModelo("", 50);
        cliente = new StringBufferModelo("", 50);
        quantidade = 0;
        valorTotal = 0;
        dataVenda = new StringBufferModelo("", 10);
        status = false;
    }

    public VendaModelo(int id, String livro, String cliente, int quantidade, double valorTotal, String dataVenda, boolean status) {
        this.id = id;
        this.livro = new StringBufferModelo(livro, 50);
        this.cliente = new StringBufferModelo(cliente, 50);
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.dataVenda = new StringBufferModelo(dataVenda, 10);
        this.status = status;
    }

    // Methods GET

    public int getId() {
        return id;
    }

    public String getLivro() {
        return livro.toStringEliminatingSpaces();
    }

    public String getCliente() {
        return cliente.toStringEliminatingSpaces();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getDataVenda() {
        return dataVenda.toStringEliminatingSpaces();
    }

    public boolean getStatus() {
        return status;
    }

    // Methods SET

    public void setId(int novoId) {
        id = novoId;
    }

    public void setLivro(String novoLivro) {
        livro = new StringBufferModelo(novoLivro, 50);
    }

    public void setCliente(String novoCliente) {
        cliente = new StringBufferModelo(novoCliente, 50);
    }

    public void setQuantidade(int novaQuantidade) {
        quantidade = novaQuantidade;
    }

    public void setValorTotal(double novoValorTotal) {
        valorTotal = novoValorTotal;
    }

    public void setDataVenda(String novaDataVenda) {
        dataVenda = new StringBufferModelo(novaDataVenda, 10);
    }

    public void setStatus(boolean novoStatus) {
        // this.status = novoStatus; 
        status = novoStatus; 
    }

    // toString

    public String toString () {
        String str = "Dados da venda \n\n";

        str += "id: " + getId() + "\n";
        str += "Livro: " + getLivro() + "\n";
        str += "Cliente: " + getCliente() + "\n";
        str += "Quantidade: " + getQuantidade() + "\n";
        str += "Valor total: " + getValorTotal() + " kzs\n";
        str += "Data da venda: " + getDataVenda() + "\n";
        // str += "Status: " + getStatus() + "\n";

        return str;
    }

    // Tamanho geral de cada registro/modelo
    public long sizeof() {
        try {
            return 110 * 2 + 4 + 4 + 4 + 1;
        } catch (Exception ex) {
            return 0;
        }
    } 

    public void write(RandomAccessFile stream) {
        try {
        stream.writeInt(id);
        livro.write(stream);
        cliente.write(stream);
        stream.writeInt(quantidade);
        stream.writeDouble(valorTotal);
        dataVenda.write(stream);
        stream.writeBoolean(status);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Falha ao tentar escrever...");
        }
    }

    public void read(RandomAccessFile stream) {
        try {
            id = stream.readInt();
        livro.read(stream);
        cliente.read(stream);
        quantidade = stream.readInt();
        valorTotal = stream.readDouble();
        dataVenda.read(stream);
        status = stream.readBoolean();
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Falha ao tentar ler...");
        }
    }

    public void salvar () {
        VendaFile file = new VendaFile();
        file.salvarDados(this);
    }

    public void salvarDados(){
        VendaFile file = new VendaFile();
        file.alterarDados(this);
    }
}
