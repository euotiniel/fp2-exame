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
	String genero
	double preco
	int quantidadeEstoque
	Setring estado
	boolean status
	
- ClienteModelo
	int id
	String nome
	String telefone
	String email
	String provincia
	String municipio
	String comuna
	boolean status
	
- VendaModelo
	int id
	ClienteModelo cliente
	LivroModelo livro
	int quantidade
	double valorTotal
	String dataVenda
	boolean status
	
4. Ficheiro
- LivroFile.dat
- ClienteFile.dat
- VendaFile.dat

5. Tabelas de Apoio (Auxiliares) = Entidades Fracas
- Genero.tab
- EstadoDoLivro.tab

6. Listagens e Pesquisas
- Listar todos os livros
- Listagem por titulo
- Listagem por autor
- Listagem por genero

- Listar todos os clientes
- Listagem por nome
- Listagem por telefone

- Listar todas as venda
- Listagem por código de venda

7. Diversos
7.1 - Implementação: Java Swing
7.2 - IDE: Notepad++ ou VSCode
*/
