import java.util.ArrayList;
import java.util.List;

public class CalculadorIntersecaoIngenuo implements CalculadorIntersecao {

    @Override
    public List<Usuario> obterIntersecao(List<Usuario> lista1, List<Usuario> lista2) {
        List<Usuario> intersecao = new ArrayList<>();

        for (Usuario usuarioLista1: lista1) {
            for(Usuario usuarioLista2 : lista2){
                if(usuarioLista1.compareTo(usuarioLista2)==0){
                    intersecao.add(usuarioLista2);
                }
            }
        }
        return intersecao;
    }
}
