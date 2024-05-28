/*------------------------------------
Tema: Gestão de uma Livraria
Nome: Otoniel Emanuel
Numero: 33039
Ficheiro: Analise.java
Data: 20.05.2024
--------------------------------------*/


/*
1. Objectivo
Este projecto tem o objectivo de gerir a venda de livros, incluindo o registo de livros disponíveis, clientes, e as transações de venda realizadas.

2. Visao [Interfaces Graficas]
- ApresentacaoVisao
- LoginVisao
- MenuPrincipal
- LivroVisao
- ClienteVisao
- VendaVisao

3. Entidades Fortes e Seus Atributos (Modelo)
- LivroModelo
	int id
	String titulo
	String autor
	String editora
	String isbn
	double preco
	int quantidadeEstoque
	
- ClienteModelo
	int id
	String nome
	String endereco
	String telefone
	String email
	
- VendaModelo
	int id
	ClienteModelo cliente
	LivroModelo livro
	int quantidade
	double valorTotal
	String dataVenda
	
4. Ficheiro
- LivroFile.dat
- ClienteFile.dat
- VendaFile.dat

5. Tabelas de Apoio (Auxiliares) = Entidades Fracas
- Genero.tab
- FormaDePagamento.tab
- EstadoDoLivro.tab

6. Diversos
6.1 - Implementação: Java Swing
6.2 - IDE: Notepad++
*/
