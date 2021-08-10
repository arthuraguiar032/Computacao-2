import java.util.ArrayList;
import java.util.List;

public class EncontraPar {

    static void encontrarPar(List<Integer> lista, int k){

        for(int i =0; i<lista.size();i++) {
            int candidato1 = lista.get(i);
            int desejado = k- candidato1;
            for(int j = i+1; j<lista.size(); j++){
                if(lista.get(j)==desejado){
                    System.out.printf("%d, %d", candidato1, lista.get(j));
                    break;
                }
            }
        }
    }

    public static void main(String[] args){
        List<Integer> lista = new ArrayList<Integer>();
        lista.add(1);
        lista.add(5);
        lista.add(-10);
        lista.add(56);
        lista.add(44);
        lista.add(12);
        lista.add(18);

        encontrarPar(lista, 34);
    }
}
