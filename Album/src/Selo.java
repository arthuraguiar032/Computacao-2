import java.awt.*;

public class Selo implements Colecionavel{

    private final Image imagem;
    private final int posicao;
    private float valorNominal;
    private String pais;

    public Selo(int posicao, String urldaimagem, float valorNominal) {
        this.posicao=posicao;
        this.imagem = obterImagem(urldaimagem);
        this.valorNominal=valorNominal;
    }

    public void setValorNominal(float valorNominal) {
        this.valorNominal = valorNominal;
    }

    @Override
    public Image getImagem() {
        return null;
    }

    @Override
    public int getPosicao() {
        return this.posicao;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public float getValorNominal(){
        return this.valorNominal;
    }

    public String getPais(){
        return this.pais;
    }

    private Image obterImagem(String url) {
        // ToDo baixaria da Internet...
        return null;
    }
}
