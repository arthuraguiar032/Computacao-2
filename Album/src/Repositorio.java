import java.util.ArrayList;
import java.util.List;

public class Repositorio<T extends Colecionavel> {

    private static final String PREFIXO_URL_IMAGENS = "http://www.nossoalbum.com.br/imagens/";

    private List<T> todasAsFigurinhas;

    public Repositorio(String sufixoUrlImagens, int quantFigurinhas, T obj) {
        todasAsFigurinhas = new ArrayList<>(quantFigurinhas);
        for (int i = 1; i <= quantFigurinhas; i++) {
            T fig = (T) ColecionavelFactory.create(obj.getClass().getName(), i, PREFIXO_URL_IMAGENS + sufixoUrlImagens);
            //T fig = new Figurinha(i, PREFIXO_URL_IMAGENS + sufixoUrlImagens);
            todasAsFigurinhas.add(fig);
        }
    }

    public int getTotalFigurinhas() {
        return this.todasAsFigurinhas.size();
    }

    public T getFigurinha(int posicao){
        return todasAsFigurinhas.get(posicao-1);
    }
}
