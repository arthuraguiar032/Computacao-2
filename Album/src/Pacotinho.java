import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pacotinho<T extends Colecionavel> {

    private List<T> figurinhasDoPacote;

    public Pacotinho(Repositorio repo, int[] posicoesDesejadas) {
        figurinhasDoPacote = new ArrayList<>(posicoesDesejadas.length);
        //figurinhasDoPacote = new Figurinha[posicoesDesejadas.length];
        //figurinhasDoPacote[i] = repo.getFigurinha(posicoesDesejadas[i]);
        for(int i =0; i< posicoesDesejadas.length; i++)
            figurinhasDoPacote.add(i, (T) repo.getFigurinha(posicoesDesejadas[i]));
    }

    /**
     * Produz um pacotinho com quantFigurinhas sorteadas aleatoriamente
     * dentre aqueles presentes no repositório informado.
     *
     * @param repo o repositório desejado
     * @param quantFigurinhas a quantidade de figurinhas a constar no pacotinho
     */
    public Pacotinho(Repositorio repo, int quantFigurinhas) {
        int totalFigPretendenteASerSorteada = repo.getTotalFigurinhas();
        figurinhasDoPacote = new ArrayList<>(quantFigurinhas);
        //figurinhasDoPacote = new Figurinha[quantFigurinhas];
        Random gerador = new Random();

        int i =0;
        while(quantFigurinhas>0){
            figurinhasDoPacote.add(i, (T) repo.getFigurinha(gerador.nextInt(totalFigPretendenteASerSorteada)+1));;
            //figurinhasDoPacote[i] = repo.getFigurinha(gerador.nextInt(totalFigPretendenteASerSorteada)+1); //gera numeros aleatorios entre 1 e 200, e guarda no pacote a figurinha correspondente ao numero sorteado
            quantFigurinhas--;
            i++;
        }
    }

    public List<T> getFigurinhas() {
        return figurinhasDoPacote;
    }
}
