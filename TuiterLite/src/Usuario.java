import java.awt.*;

public class Usuario {

    private final String email;
    private String nome;
    private Image foto;


    public Usuario(String nome, String email) {
        this.email = email;
        this.nome = nome;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public Image getFoto() {
        return this.foto;
    }

    public String getEmail() {
        return this.email;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        return email.equals(usuario.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}
