public class Brinquedo extends Produto {

    private int idadeMinimaRecomendada;

    private String marca;

    public Brinquedo(String descricao) {
        super("Brinquedo: "+ descricao);
    }

    public void setIdadeMinimaRecomendada(int idadeMinimaRecomendada) {
        this.idadeMinimaRecomendada = idadeMinimaRecomendada;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public int getIdadeMinimaRecomendada() {
        return idadeMinimaRecomendada;
    }
}
