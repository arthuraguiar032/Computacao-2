public class Livro extends Produto {

    private String nome;

    private String editora;

    private int numeroDePaginas;

    private String autor;

    private int anoDePublicacao;


    public Livro(String nome, String editora) {
        super("Livro: "+nome, null);
        this.editora = editora;
    }

    public String getNome() {
        return nome;
    }

    public String getEditora() {
        return editora;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAnoDePublicacao(int anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }
}