/*------------------------------------
Tema: Gestão de uma Livraria
Nome: Otoniel Emanuel
Numero: 33039
Ficheiro: ClienteModelo.java
Data: 17.06.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;
import java.io.*;

public class ClienteModelo implements RegistGeneric {

    int id;
    StringBufferModelo nome, email, endereco, telefone;

    public ClienteModelo() {
        id = 0;
        nome = new StringBufferModelo("", 100 );
        email = new StringBufferModelo("", 254);
        telefone = new StringBufferModelo("", 13);
    }

    public ClienteModelo(int id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = new StringBufferModelo(nome, 100);
        this.email = new StringBufferModelo(email, 254);
        this.telefone = new StringBufferModelo(telefone, 13);
    }

    // Methods GET

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome.toStringEliminatingSpaces();
    }

    public String getEmail() {
        return email.toStringEliminatingSpaces();
    }

    public String getTelefone() {
        return telefone.toStringEliminatingSpaces();
    }

    // Methods SET

    public void setId(int novoId) {
        id = novoId;
    }

    public void setNome(String novoNome) {
        nome = new StringBufferModelo(novoNome, 100);
    }

    public void setEmail(String novoEmail) {
        email = new StringBufferModelo(novoEmail, 254);
    }

    public void setTelefone(String novoTelefone) {
        telefone = new StringBufferModelo(novoTelefone, 13);
    }

    // toString

    public String toString () {
        String str = "Dados do Livro Modelo\n\n";

        str += "id: " + getId() + "\n";
        str += "Nome: " + getNome() + "\n";
        str += "Email: " + getEmail() + "\n";
        str += "Telefone: " + getTelefone() + "\n";

        return str;
    }

    // Tamanho geral de cada registro/modelo

    public long sizeof() {
        try {
            return 367 * 2 + 4;
        } catch (Exception ex) {
            return 0;
        }
    } 

    public void write(RandomAccessFile stream) {
        try {
            stream.writeInt(id);
        nome.write(stream);
        email.write(stream);
        telefone.write(stream);

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Falha ao tentar escrever...");
        }
    }

    public void read(RandomAccessFile stream) {
        try {
            id = stream.readInt();
        nome.read(stream);
        email.read(stream);
        telefone.read(stream);

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Falha ao tentar ler...");
        }
    }

    public void salvar () {
        ClienteFile file = new ClienteFile();
        file.salvarDados(this);
    }

}
