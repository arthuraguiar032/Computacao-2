public class Dimensoes {

    private int altura;
    private int largura;
    private int comprimento;

    public int getComprimentoEmCentimetros() {
        return comprimento;
    }

    public int getLarguraEmCentimetros() {
        return largura;
    }

    public int getAlturaEmCentimetros() {
        return altura;
    }

    public int getVolumeEmCentimetrosCubicos() {
        return altura*largura*comprimento;
    }
}