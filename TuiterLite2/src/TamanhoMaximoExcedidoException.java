public class TamanhoMaximoExcedidoException extends Exception {

    private String texto;

    public TamanhoMaximoExcedidoException(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public int getTamanhoTexto(){
        return this.texto.length();
    }
}
