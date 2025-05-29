import method.Author;
import method.Book;
import services.Library;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Adicionar autores
        Author author1 = new Author(1, "C.S Lewis", new Date());
        Author author2 = new Author(2, "J.R.R. Tolkien", new Date());

        library.adicionarAutor(author1);
        library.adicionarAutor(author2);

        // Adicionar livros
        Book livro1 = new Book(1, "Harry Potter e a Pedra Filosofal", author1);
        Book livro2 = new Book(2, "O Senhor dos Anéis: A Sociedade do Anel", author2);

        library.adicionarLivro(livro1);
        library.adicionarLivro(livro2);

        // Loop para a interação do usuário
        while (true) {
            System.out.println("Deseja ver os livros disponíveis? (sim/não)");
            String resposta = scanner.nextLine().toLowerCase();

            if (resposta.equals("sim")) {
                List<Book> livrosDisponiveis = library.listarLivrosDisponiveis();

                if (livrosDisponiveis.isEmpty()) {
                    System.out.println("Não há livros disponíveis no momento");
                } else {
                    System.out.println("Livros disponíveis:");
                    for (Book book : livrosDisponiveis) {
                        System.out.println(book.getid() + ": " + book.getTitulo());
                    }

                    System.out.println("Digite o ID do livro que você deseja emprestar:");
                    try {
                        int idLivro = scanner.nextInt();
                        scanner.nextLine(); // Limpa o buffer

                        Book livroSelecionado = library.buscarLivroPorId(idLivro);

                        if (livroSelecionado == null) {
                            System.out.println("Livro não encontrado!");
                        } else if (!livroSelecionado.isAvailable()) {
                            System.out.println("Livro já emprestado!");
                        } else {
                            System.out.println("Digite seu nome:");
                            String nomeUsuario = scanner.nextLine();
                            library.emprestarLivro(livroSelecionado, nomeUsuario);
                            System.out.println("O livro " + livroSelecionado.getTitulo() + " foi emprestado para " + nomeUsuario);
                        }
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Por favor, digite um ID de livro válido (número inteiro).");
                        scanner.nextLine(); // Limpa o buffer
                        continue;
                    }
                }
            } else if (resposta.equals("não")) {
                System.out.println("Obrigado por utilizar o sistema da biblioteca");
                break;
            } else {
                System.out.println("Resposta inválida. Por favor, responda com 'sim' ou 'não'.");
            }
        }

        scanner.close();
    }
}