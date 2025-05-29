package method;

import java.util.Date;

public class Book {
    private int id;
    private String titulo;
    private Author author;
    private boolean available;
    private Date bookRecord;
    private Date bookChange;

    public Book(int id, String titulo, Author author) {
        this.id = id;
        this.titulo = titulo;
        this.author = author;
        this.available = true; // Inicialmente, todos os livros são disponibilizados
        this.bookRecord = new Date();
        this.bookChange = new Date();
    }

    public int getid() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Author author() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public Date getBookRecord() {
        return bookRecord;
    }

    public Date getBookChange() {
        return bookChange;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
        this.bookChange = new Date();
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", author=" + author +
                ", available=" + available +
                ", bookRecord=" + bookRecord +
                ", bookChange=" + bookChange +
                '}';
    }
}
