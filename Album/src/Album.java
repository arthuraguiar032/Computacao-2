import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Album<T extends Colecionavel> {

    public static final int PERCENTUAL_MINIMO_PARA_AUTO_COMPLETAR = 90;

    public static final Image IMAGEM_PADRAO_PARA_POSICAO_VAZIA = null;

    private final Repositorio repositorio;
    private final int quantItensPorPacotinho;

    private List<T> figurinhasColadas;  // direct addressing
    private int quantFigurinhasColadas;

    // poderíamos fazer novamente direct addressing para as repetidas,
    // mas vamos usar um HashMap aqui só para treinarmos
    private Map<Integer, Integer> contRepetidasByPosicao;

    public Album(Repositorio repositorio, int quantItensPorPacotinho) {
        this.repositorio = repositorio;
        this.quantItensPorPacotinho = quantItensPorPacotinho;

        int tamanhoFisicoDaLista = getTamanho() + 1;
        this.figurinhasColadas = new ArrayList<>(tamanhoFisicoDaLista);
        // inicializa as posições com nulls, para poder acessá-las diretamente
        for (int i = 0; i < tamanhoFisicoDaLista; i++) {
            this.figurinhasColadas.add(null);
        }
        this.quantFigurinhasColadas = 0;

        this.contRepetidasByPosicao = new HashMap<>();
    }

    public void receberNovoPacotinho(Pacotinho pacotinho) {
        //Figurinha[] figurinhasDoPacotinho = pacotinho.getFigurinhas();
        //List<Colecionavel> figurinhasDoPacotinho = new ArrayList<>();

        List<T> figurinhasDoPacotinho = new ArrayList<>();
        figurinhasDoPacotinho = pacotinho.getFigurinhas();
        if (figurinhasDoPacotinho.size() != this.quantItensPorPacotinho) {
            return;  // melhor ainda: lançaria uma checked exception
        }

        for(int i =0; i<pacotinho.getFigurinhas().size(); i++){
            T fig = figurinhasDoPacotinho.get(i);
            final int posicao = fig.getPosicao();
            if (possuiItemColado(posicao)) {
                // adiciona como repetida

                // jeito pior
//                Integer contRepetidas = this.contRepetidasByPosicao.get(posicao);
//                this.contRepetidasByPosicao.put(
//                        posicao, contRepetidas == null ? 1 : contRepetidas + 1);

                // jeito mais elegante: getOrDefault
                int contRepetidas = this.contRepetidasByPosicao.getOrDefault(posicao, 0);
                this.contRepetidasByPosicao.put(posicao, contRepetidas + 1);

            } else {
                // item inédito
                this.figurinhasColadas.set(posicao, fig);
                this.quantFigurinhasColadas++;
            }
        }
    }

    public int getQuantItensPorPacotinho() {
        return quantItensPorPacotinho;
    }

    public T getItemColado(int posicao) {
        if(possuiItemColado(posicao)==true){
            return figurinhasColadas.get(posicao);
        }
        return null;
    }

    public boolean possuiItemColado(int posicao) {
        if(posicao>getTamanho()||posicao<1||figurinhasColadas.get(posicao)==null){
            return false;
        }
        return true;
    }

    public boolean possuiItemRepetido(int posicao) {
        if(quantidadeRepetidasByPosicao(posicao)==0){
            return false;
        }
        return true;
    }

    private Integer quantidadeRepetidasByPosicao(int posicao) {
        if(posicao>this.getTamanho()||posicao<1){
            return 0;
        }
        Integer qtd = contRepetidasByPosicao.get(posicao);
        if(qtd==null||qtd==0){
            return 0;
        }
        return qtd;
    }

    public int getTamanho() {
        return this.repositorio.getTotalFigurinhas();
    }

    public int getQuantItensColados() {
//        int contador = 0;
//        for (Figurinha fig : this.figurinhasColadas) {
//            if (fig != null) {
//                contador++;
//            }
//        }
//        return contador;

        // melhor jeito: atributo!
        return this.quantFigurinhasColadas;
    }

    public int getQuantItensFaltantes() {
        return getTamanho() - getQuantItensColados();
    }

    public void autoCompletar() {
        int minimoFigurinhasColadasParaAutoCompletar =
                (int) (this.getTamanho() * Album.PERCENTUAL_MINIMO_PARA_AUTO_COMPLETAR / 100f);
        if(this.getQuantItensColados()<minimoFigurinhasColadasParaAutoCompletar){
            return; //album nao tem o suficiente para autocompletar
        }
        int tamanhoFisicoDaLista = getTamanho() + 1;
        for (int i =1; i<tamanhoFisicoDaLista; i++) {
            T fig = this.getItemColado(i);
            if(fig == null){ //album nao possui essa figurinha
                fig = (T) repositorio.getFigurinha(i);
                this.figurinhasColadas.set(i, fig);
                this.quantFigurinhasColadas++;
            }
        }
    }

    private Image getImagem(int posicao) {
        return possuiItemColado(posicao)
                ? this.getItemColado(posicao).getImagem()
                : IMAGEM_PADRAO_PARA_POSICAO_VAZIA;
    }

//    public static void main(String[] args) {
//        ArrayList<Integer> meuArrayList = new ArrayList<>(200);
//
//        // inicializa as posições com nulls, para poder acessá-las diretamente
//        for (int i = 0; i < 200; i++) {
//            meuArrayList.add(null);
//        }
//
////        System.out.println(meuArrayList.get(3));
//
//        meuArrayList.add(3, 300000);  // insert com shift right
//
//        for (int numero : meuArrayList) {
//            System.out.println(numero);
//        }
//    }
}
