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
    StringBufferModelo nome, email, endereco, telefone, provincia, municipio, comuna;
    private boolean status;

    public ClienteModelo() {
        id = 0;
        nome = new StringBufferModelo("", 100 );
        email = new StringBufferModelo("", 254);
        telefone = new StringBufferModelo("", 13);
        provincia = new StringBufferModelo("", 20);
        municipio = new StringBufferModelo("", 20);
        comuna = new StringBufferModelo("", 20);
        status = false;
    }

    public ClienteModelo(int id, String nome, String email, String telefone, String provincia, String municipio, String comuna, boolean status) {
        this.id = id;
        this.nome = new StringBufferModelo(nome, 100);
        this.email = new StringBufferModelo(email, 254);
        this.telefone = new StringBufferModelo(telefone, 13);
        this.provincia = new StringBufferModelo(provincia, 20);
        this.municipio = new StringBufferModelo(municipio, 20);
        this.comuna = new StringBufferModelo(comuna, 20);
        this.status = status;
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

    public String getProvincia() {
        return provincia.toStringEliminatingSpaces();
    }

    public String getMunicipio() {
        return municipio.toStringEliminatingSpaces();
    }

    public String getComuna() {
        return comuna.toStringEliminatingSpaces();
    }

    public boolean getStatus() {
        return status;
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

    public void setProvincia(String novaProvincia) {
        provincia = new StringBufferModelo(novaProvincia, 20);
    }

    public void setMunicipio(String novoMunicipio) {
        municipio = new StringBufferModelo(novoMunicipio, 20);
    }

    public void setComuna(String novaComuna) {
        comuna = new StringBufferModelo(novaComuna, 20);
    }

    public void setStatus(boolean novoStatus) {
        // this.status = novoStatus; 
        status = novoStatus; 
    }

    // toString

    public String toString () {
        String str = "Dados do cliente \n\n";

        str += "id: " + getId() + "\n";
        str += "Nome: " + getNome() + "\n";
        str += "Email: " + getEmail() + "\n";
        str += "Telefone: " + getTelefone() + "\n";
        str += "Provincia: " + getProvincia() + "\n";
        str += "Municipio: " + getMunicipio() + "\n";
        str += "Comuna: " + getComuna() + "\n";
        str += "Status: " + getStatus() + "\n";

        return str;
    }

    // Tamanho geral de cada registro/modelo

    public long sizeof() {
        try {
            return 427 * 2 + 4 + 1;
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
        provincia.write(stream);
        municipio.write(stream);
        comuna.write(stream);
        stream.writeBoolean(status);
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
        provincia.read(stream);
        municipio.read(stream);
        comuna.read(stream);
        status = stream.readBoolean();
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Falha ao tentar ler...");
        }
    }

    public void salvar () {
        ClienteFile file = new ClienteFile();
        file.salvarDados(this);
    }

    public void salvarDados(){
        ClienteFile file = new ClienteFile();
        file.alterarDados(this);
    }

}
