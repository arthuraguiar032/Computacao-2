public class UsuarioDesconhecidoException extends Exception {

    private String email;

    public UsuarioDesconhecidoException(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
