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
    private JMenu ficheiroMenu, operacoesMenu, listagemMenu, pesquisaMenu, tabelasMenu, ajudaMenu;
    private JMenuItem novoLivroItem, editarLivroItem, eliminarLivroItem, sair;
    private JMenuItem novoClienteItem, editarClienteItem, eliminarClienteItem, novaVendaItem, editarVendaItem, eliminarVendaItem;
    private JMenuItem listarLivroItem, listarClienteItem, listarVendaItem;
    private JMenuItem pesquisarLivroItem, pesquisarClienteItem, pesquisarVendaItem;
    private JMenuItem generoLivroItem, formaDePagamentoItem, estadoDoLivroItem, provinciaMoradaItem, municipioMoradaItem, comunaMoradaItem;;
    private JMenuItem ajudaAplicacaoItem, ajudaAutorItem;
    
    public MenuPrincipal(String user) {
        instanciarObjectos();

        setJMenuBar(menuBar);

        setTitle("Menu principal - " + user);
        ImageIcon appIcone = new ImageIcon(
                "C:\\Users\\euotinielpc\\Documents\\UCAN\\Proj\\FP2\\OtonielEmanuel33039\\images\\book.png");
        setIconImage(appIcone.getImage());
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
        pesquisaMenu = new JMenu("Pesquisas");
        pesquisaMenu.setMnemonic('P');
        tabelasMenu = new JMenu("Tabelas");
        tabelasMenu.setMnemonic('T');
        ajudaMenu = new JMenu("Ajuda");
        ajudaMenu.setMnemonic('A');

        // Adicição dos menus a barra

        menuBar.add(ficheiroMenu);
        menuBar.add(operacoesMenu);
        menuBar.add(listagemMenu);
        menuBar.add(pesquisaMenu);
        menuBar.add(tabelasMenu);
        menuBar.add(ajudaMenu);

        // Opções do menu Ficheiros

        ficheiroMenu.add(novoLivroItem = new JMenuItem("Novo livro"));
        novoLivroItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
        ficheiroMenu.add(editarLivroItem = new JMenuItem("Editar livro"));
        ficheiroMenu.add(eliminarLivroItem = new JMenuItem("Eliminar livro"));
        ficheiroMenu.addSeparator();
        ficheiroMenu.add(sair = new JMenuItem("Sair"));
        sair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));

        // Opções do menu Operacoes

        operacoesMenu.add(novoClienteItem = new JMenuItem("Novo cliente"));
        operacoesMenu.add(editarClienteItem = new JMenuItem("Editar cliente"));
        operacoesMenu.add(eliminarClienteItem = new JMenuItem("Eliminar cliente"));
        operacoesMenu.addSeparator();
        operacoesMenu.add(novaVendaItem = new JMenuItem("Nova venda"));
        operacoesMenu.add(editarVendaItem = new JMenuItem("Editar venda"));
        operacoesMenu.add(eliminarVendaItem = new JMenuItem("Eliminar venda"));

        // Opções do menu Listagens
        listagemMenu.add(listarLivroItem = new JMenuItem("Listar livros"));
        listagemMenu.addSeparator();
        listagemMenu.add(listarClienteItem = new JMenuItem("Listar clientes"));
        listagemMenu.addSeparator();
        listagemMenu.add(listarVendaItem = new JMenuItem("Listar vendas"));

        // Opções do menu Pesquisas
        pesquisaMenu.add(pesquisarLivroItem = new JMenuItem("Pesquisar livro"));
        listagemMenu.addSeparator();
        pesquisaMenu.add(pesquisarClienteItem = new JMenuItem("Pesquisar cliente"));
        listagemMenu.addSeparator();
        pesquisaMenu.add(pesquisarVendaItem = new JMenuItem("Pesquisar venda"));

        // Opções do menu Tabelas

        tabelasMenu.add(generoLivroItem = new JMenuItem("Genero do livro"));
        // tabelasMenu.add(formaDePagamentoItem = new JMenuItem("Forma de pagamento"));
        tabelasMenu.add(estadoDoLivroItem = new JMenuItem("Estado do livro"));
        tabelasMenu.addSeparator();
        tabelasMenu.add(provinciaMoradaItem = new JMenuItem("Provincia"));
        tabelasMenu.add(municipioMoradaItem = new JMenuItem("Municipio"));
        tabelasMenu.add(comunaMoradaItem = new JMenuItem("Comuna"));

        // Opções do menu Ajuda

        ajudaMenu.add(ajudaAplicacaoItem = new JMenuItem("Sobre o Software"));
        ajudaMenu.addSeparator();
        ajudaMenu.add(ajudaAutorItem = new JMenuItem("Sobre o Autor"));

        // registar o manipulador de eventos aos items

        novoLivroItem.addActionListener(this);
        editarLivroItem.addActionListener(this);
        eliminarLivroItem.addActionListener(this);
        listarLivroItem.addActionListener(this);

        novoClienteItem.addActionListener(this);
        editarClienteItem.addActionListener(this);
        eliminarClienteItem.addActionListener(this);
        listarClienteItem.addActionListener(this);

        novaVendaItem.addActionListener(this);
        editarVendaItem.addActionListener(this);
        eliminarVendaItem.addActionListener(this);
        listarVendaItem.addActionListener(this);

        ajudaAutorItem.addActionListener(this);
        ajudaAplicacaoItem.addActionListener(this);
        generoLivroItem.addActionListener(this);
        // formaDePagamentoItem.addActionListener(this);
        estadoDoLivroItem.addActionListener(this);
        
        provinciaMoradaItem.addActionListener(this);
        municipioMoradaItem.addActionListener(this);
        comunaMoradaItem.addActionListener(this);

        pesquisarLivroItem.addActionListener(this);
        pesquisarClienteItem.addActionListener(this);
        pesquisarVendaItem.addActionListener(this);
        
        sair.addActionListener(this);

    }

    public void actionPerformed(ActionEvent evt) {

        if (evt.getSource() == novoLivroItem)
            new LivroVisao(false, new LivroModelo());

        if (evt.getSource() == editarLivroItem)
            new EditarLivro();

        if (evt.getSource() == eliminarLivroItem)
            new EliminarLivro();

        if (evt.getSource() == novoClienteItem)
            new ClienteVisao(false, new ClienteModelo());

        if (evt.getSource() == editarClienteItem)
            new EditarCliente();

        if (evt.getSource() == eliminarClienteItem)
            new EliminarCliente();

        if (evt.getSource() == novaVendaItem)
            new VendaVisao(false, new VendaModelo());

        if (evt.getSource() == generoLivroItem)
            Tabela2.editarNovosItems("Genero.tab", "Novo genero de livro");

        // if (evt.getSource() == formaDePagamentoItem)
        //     Tabela2.editarNovosItems("FormasDePagamento.tab", "Nova forma de pagamento");

        if (evt.getSource() == estadoDoLivroItem)
            Tabela2.editarNovosItems("EstadoDoLivro.tab", "Novo estado do livro");
        
        if (evt.getSource() == provinciaMoradaItem)
			Tabela2.editarNovosItems("Provincias.tab", "Nova Provincia");
		
        if (evt.getSource() == municipioMoradaItem)
			Tabela3_2.editarNovosItems("Provincias.tab", "Municipios.tab", 
				"Provincias", "Municipios", "Novo Municipio");
		
        if (evt.getSource() == comunaMoradaItem)
			Tabela3_3.editarNovosItems("Provincias.tab", "Municipios.tab", "Comunas.tab", 
				"Provincias", "Municipios", "Comunas", "Nova Comuna");
		
        if (evt.getSource() == listarLivroItem)
            LivroFile.listarLivros();
        if (evt.getSource() == listarClienteItem)
            ClienteFile.listarClientes();
        if (evt.getSource() == listarVendaItem)
            VendaFile.listarVendas();

        if (evt.getSource() == pesquisarLivroItem)
            new PesquisarLivro();
        if (evt.getSource() == pesquisarClienteItem)
            new PesquisarCliente();
        if (evt.getSource() == pesquisarVendaItem)
            new PesquisarVenda();

        else if (evt.getSource() == sair)
            dispose();
            
        else if (evt.getSource() == ajudaAplicacaoItem)
            new SobreOSoftware();
        else if (evt.getSource() == ajudaAutorItem)
            new SobreOAutor();
    
    }

    /*public static void main(String[] args) {
        Vector_Tabelas.inic();
        new MenuPrincipal();
    }*/
    
}
