/*------------------------------------
Tema: Gestão de uma Livraria
Nome: Otoniel Emanuel
Numero: 33039
Ficheiro: MenuPrincipal.java
Data: 28.05.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;

public class MenuPrincipal extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu ficheiroMenu, operacoesMenu, listagemMenu, tabelasMenu, ajudaMenu;
    private JMenuItem novoLivroItem, editarLivroItem, eliminarLivroItem, sair;
    private JMenuItem novoClienteItem, novaVendaItem;
    private JMenuItem listarLivroItem, pesquisarLivroItem;
    private JMenuItem generoLivroItem, formaDePagamentoItem, estadoDoLivroItem;
    private JMenuItem ajudaAplicacaoItem, ajudaAutorItem;
    
    public MenuPrincipal() {
        instanciarObjectos();

        setJMenuBar(menuBar);

        setTitle("Menu principal");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        // Define o ícone da aplicação
        // ImageIcon img = new ImageIcon("caminho/para/seu/icone.png");
        // frame.setIconImage(img.getImage());
    }

    public void instanciarObjectos() {
        menuBar = new JMenuBar();

        ficheiroMenu = new JMenu("Ficheiros");
        ficheiroMenu.setMnemonic('F');
        operacoesMenu = new JMenu("Operacoes");
        operacoesMenu.setMnemonic('O');
        listagemMenu = new JMenu("Listagens");
        listagemMenu.setMnemonic('L');
        tabelasMenu = new JMenu("Tabelas");
        tabelasMenu.setMnemonic('T');
        ajudaMenu = new JMenu("Ajuda");
        ajudaMenu.setMnemonic('A');

        // Adicição dos menus a barra

        menuBar.add(ficheiroMenu);
        menuBar.add(operacoesMenu);
        menuBar.add(listagemMenu);
        menuBar.add(tabelasMenu);
        menuBar.add(ajudaMenu);

        // Opções do menu Ficheiros

        ficheiroMenu.add(novoLivroItem = new JMenuItem("Novo Livro"));
        novoLivroItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
        ficheiroMenu.add(editarLivroItem = new JMenuItem("Editar Livro"));
        ficheiroMenu.add(eliminarLivroItem = new JMenuItem("Eliminar Livro"));
        ficheiroMenu.addSeparator();
        ficheiroMenu.add(sair = new JMenuItem("Sair"));
        sair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));

        // Opções do menu Operacoes

        operacoesMenu.add(novoClienteItem = new JMenuItem("Novo Cliente"));
        operacoesMenu.addSeparator();
        operacoesMenu.add(novaVendaItem = new JMenuItem("Nova Venda"));

        // Opções do menu Listagens
        listagemMenu.add(listarLivroItem = new JMenuItem("Listar livros"));
        listagemMenu.addSeparator();
        listagemMenu.add(pesquisarLivroItem = new JMenuItem("Pesquisar livros"));

        // Opções do menu Tabelas

        tabelasMenu.add(generoLivroItem = new JMenuItem("Genero do livro"));
        tabelasMenu.add(formaDePagamentoItem = new JMenuItem("Forma de pagamento"));
        tabelasMenu.add(estadoDoLivroItem = new JMenuItem("Estado do Livro"));

        // Opções do menu Ajuda

        ajudaMenu.add(ajudaAplicacaoItem = new JMenuItem("Sobre o Software"));
        ajudaMenu.addSeparator();
        ajudaMenu.add(ajudaAutorItem = new JMenuItem("Sobre o Autor"));

        // registar o manipulador de eventos aos items

        novoLivroItem.addActionListener(this);
        sair.addActionListener(this);
        listarLivroItem.addActionListener(this);
        ajudaAutorItem.addActionListener(this);
        generoLivroItem.addActionListener(this);
        formaDePagamentoItem.addActionListener(this);
        estadoDoLivroItem.addActionListener(this);
        pesquisarLivroItem.addActionListener(this);
    }

    public void actionPerformed(ActionEvent evt) {

        if (evt.getSource() == novoLivroItem)
            new LivroVisao();

        if (evt.getSource() == generoLivroItem)
            Tabela2.editarNovosItems("Genero.tab", "Novo genero de livro");

        if (evt.getSource() == formaDePagamentoItem)
            Tabela2.editarNovosItems("FormasDePagamento.tab", "Nova forma de pagamento");

        if (evt.getSource() == estadoDoLivroItem)
            Tabela2.editarNovosItems("EstadoDoLivro.tab", "Novo estado do livro");
        
        if (evt.getSource() == listarLivroItem)
            LivroFile.listarLivros();
        if (evt.getSource() == pesquisarLivroItem)
            new PesquisarLivro();

        else if (evt.getSource() == sair)
            dispose();
        else if (evt.getSource() == ajudaAutorItem)
            new SobreOAutor();

    }

    public static void main(String[] args) {
        Vector_Tabelas.inic();
        new MenuPrincipal();
    }
}
