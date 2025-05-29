package services;

import method.Author;
import method.Book;
import method.Loan;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> livros = new ArrayList<>();
    private List<Author> autores = new ArrayList<>();
    private List<Loan> emprestimo = new ArrayList<>();

    public void adicionarLivro(Book book) {
        livros.add(book);
    }

    public List<Book> listarLivros() {
        return livros;
    }

    public List<Book> listarLivrosDisponiveis() {
        List<Book> livrosDisponiveis = new ArrayList<>();
        for (Book book : livros) {
            if (book.isAvailable()) {
                livrosDisponiveis.add(book); // Adiciona à lista correta
            }
        }
        return livrosDisponiveis;
    }

    public void adicionarAutor(Author author) {
        autores.add(author);
    }

    public Book buscarLivroPorId(int id) {
        for (Book book : livros) {
            if (book.getid() == id) {
                return book;
            }
        }
        return null;
    }

    public void atualizarLivro(int id, String novoTitulo) {
        for (Book book : livros) {
            if (book.getid() == id) {
                book.setTitulo(novoTitulo);
                break;
            }
        }
    }

    public void removerLivro(int id) {
        livros.removeIf(livro -> livro.getid() == id);
    }


    public void emprestarLivro(Book book, String nameUser) {
        if (book.isAvailable()) {
            Loan loan = new Loan(book, nameUser);
            emprestimo.add(loan);
            book.setAvailable(false);
        } else {
            System.out.println("Livro não disponível para empréstimo.");
        }
    }

    public void devolverLivro(int idEmprestimo) {
        for (Loan loan : emprestimo) {
            if (loan.getId() == idEmprestimo && loan.isActive()) {
                loan.returnBook();
                break;
            }
        }
    }

    public List<Loan> listLoan() {
        return emprestimo;
    }
}
