package method;

import java.util.Date;

public class Loan {
    private int id;
    private static int contadorId = 1;
    private Book book;
    private String nameUser;
    private Date loanDate;
    private Date dateReturn;
    private boolean active; // ativo ou não

    public Loan(Book book, String nameUser) {
        this.id = contadorId++;
        this.book = book;
        this.nameUser = nameUser;
        this.loanDate = new Date();
        this.active = true;
    }

    public int getId() {
        return id;
    }

    public static int getContadorId() {
        return contadorId;
    }

    public Book getBook() {
        return book;
    }

    public String getNameUser() {
        return nameUser;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public Date getDateReturn() {
        return dateReturn;
    }

    public boolean isActive() {
        return active;
    }

    public void returnBook() {
        this.dateReturn = new Date();
        this.active = false;
        this.book.setAvailable(true);
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "id=" + id +
                ", book=" + book +
                ", nameUser='" + nameUser + '\'' +
                ", loanDate=" + loanDate +
                ", dateReturn=" + dateReturn +
                ", active=" + active +
                '}';
    }
}
