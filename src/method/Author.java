package method;

import java.util.Date;

public class Author {
    private int id;
    private String nome;
    private Date birth;

    public Author(int id, String nome, Date birth) {
        this.id = id;
        this.nome = nome;
        this.birth = birth;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getBirth() {
        return birth;
    }

   public void setNome(String nome) {
        this.nome = nome;
   }

   public void setBirth(Date birth) {
        this.birth = birth;
   }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", birth=" + birth +
                '}';
    }
}
