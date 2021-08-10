import java.util.HashMap;
import java.util.Map;

public class CaracterMaisFrequente {

    public static void encontrarCaracterMaisFrequente(String string){
        Map<Character, Integer> quantidadeByLetra = new HashMap<>();
        //char letraMaisFrequente;

        for (int i = 0; i < string.length(); i++) {
            char caracter = string.charAt(i);
            if(quantidadeByLetra.containsKey(caracter)){
                int qtd = quantidadeByLetra.get(caracter);
                quantidadeByLetra.put(caracter, qtd+1);
            }else {
                quantidadeByLetra.put(caracter, 1); //primeira vez que aparece determinada letra
            }
        }

        //achar a mais frequente a mais frequente
        String letraMaisFrequente = "";
        for (Map.Entry<Character, Integer> pair: quantidadeByLetra.entrySet()) {
            if(letraMaisFrequente.length()==0){
                letraMaisFrequente = String.valueOf(pair.getKey());
            }else {
                if(pair.getValue()>quantidadeByLetra.get(letraMaisFrequente.charAt(0))){
                    letraMaisFrequente = String.valueOf(pair.getKey());
                }
            }
        }

        System.out.printf("%s, %d", letraMaisFrequente, quantidadeByLetra.get(letraMaisFrequente.charAt(0)));
    }

    public static void main(String[] args) {
        String string = new String("pneumoultramicroscopicossilicovulcanoconiotico");
        encontrarCaracterMaisFrequente(string);
    }
}