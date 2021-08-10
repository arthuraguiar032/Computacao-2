import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UsuarioTest {

    private static final long valorParaTestarPerformance = 10000;

    private Usuario usuario1;
    private Usuario usuario2;
    private Usuario usuario3;
    private CalculadorIntersecaoIngenuo calculadorIntersecaoIngenuo = new CalculadorIntersecaoIngenuo();
    private CalculadorIntersecaoViaBuscaBinaria calculadorIntersecaoViaBuscaBinaria = new CalculadorIntersecaoViaBuscaBinaria();
    private CalculadorIntersecaoEsperto calculadorIntersecaoEsperto = new CalculadorIntersecaoEsperto();

    @Before
    public void setUp(){
        usuario1 = new Usuario(1, calculadorIntersecaoIngenuo);
        usuario2 = new Usuario(2, calculadorIntersecaoViaBuscaBinaria);
        usuario3 = new Usuario(3, calculadorIntersecaoEsperto);

    }

    @Test
    public void testarTamanhoIntersecao(){
        usuario1.adicionarAmigo(usuario2);
        usuario1.adicionarAmigo(usuario3);
        usuario2.adicionarAmigo(usuario3);

        assertEquals("A quantidade de amigos em comum deve refletir a interseção das lista dos usuarios.",
                usuario1.obterQuantidadeDeAmigosEmComum(usuario2), usuario2.obterQuantidadeDeAmigosEmComum(usuario1));
        assertEquals("A quantidade de amigos em comum deve refletir a interseção das lista dos usuarios.",
                usuario2.obterQuantidadeDeAmigosEmComum(usuario3), usuario3.obterQuantidadeDeAmigosEmComum(usuario2));
    }

    @Test
    public void testarPerfomance(){

        for(int i =4; i< valorParaTestarPerformance; i++){ //povoando a lista de amigos
            Usuario aux = new Usuario(i, calculadorIntersecaoIngenuo);
            if(i%2==0){
                usuario1.adicionarAmigo(aux);
            }
            if(i%2==1){
                usuario2.adicionarAmigo(aux);
            }
            usuario3.adicionarAmigo(aux);
        }

        //calculando o tempo que cada metodo vai gastar

        long inicio = System.nanoTime();
        int intersecaoUser1comUser3 = usuario1.obterQuantidadeDeAmigosEmComum(usuario3);//metodo Ingenuo
        long fim = System.nanoTime();
        float tempoIngenuo = (fim - inicio)/1000000;

        inicio = System.nanoTime();
        int intersecaoUser3comUser1 = usuario3.obterQuantidadeDeAmigosEmComum(usuario1);//metodo Esperto
        fim = System.nanoTime();
        float tempoEsperto1 = (fim - inicio)/1000000;

        inicio = System.nanoTime();
        int intersecaoUser2comUser3 = usuario2.obterQuantidadeDeAmigosEmComum(usuario3);//metodo via Busca Binaria
        fim = System.nanoTime();
        float tempoViaBuscaBinaria = (fim - inicio)/1000000;

        inicio = System.nanoTime();
        int intersecaoUser3comUser2 = usuario3.obterQuantidadeDeAmigosEmComum(usuario2);//metodo Esperto
        fim = System.nanoTime();
        float tempoEsperto2 = (fim - inicio)/1000000;



        System.out.printf("Interseção entre os usuarios 1 e 3:\nTempo Ingenuo: %.3f ms \nTempo Esperto: %.3f ms\n\n", tempoIngenuo, tempoEsperto1);
        System.out.printf("Interseção entre os usuarios 2 e 3:\nTempo via Busca Binaria: %.3f ms \nTempo Esperto: %.3f ms\n", tempoViaBuscaBinaria, tempoEsperto2);

        assertEquals("A quantidade de amigos em comum deve refletir a interseção das lista dos usuarios.",
                intersecaoUser1comUser3, intersecaoUser3comUser1);
        assertEquals("A quantidade de amigos em comum deve refletir a interseção das lista dos usuarios.",
                intersecaoUser2comUser3, intersecaoUser3comUser2);

    }
}
