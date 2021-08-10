public class Usuario {

    private String nome;

    private long cpf;

    private String endereco;

    public Usuario(String nome, long cpf, String endereco) {
        this.nome=nome;
        this.cpf=cpf;
        this.endereco=endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
