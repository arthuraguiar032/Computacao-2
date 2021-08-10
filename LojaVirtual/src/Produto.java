public class Produto {

    private int quantidadeEmEstoque = -1;

    private String descricao;

    private String imagem;

    private Dimensoes dimensoes;

    private String urlDaImagem;

    private float precoEmReais;

    public Produto(String descricao, String urlDaImagem) {
        this.descricao=descricao;
        this.urlDaImagem = urlDaImagem;
        precoEmReais=0;
    }

    public Produto(String descricao) {
        this.descricao=descricao;
        precoEmReais=0;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void adicionaEstoqueProduto(int qtdAdicionada){
        if(quantidadeEmEstoque==-1){
            quantidadeEmEstoque+=qtdAdicionada+1;
        }else{
            quantidadeEmEstoque+=qtdAdicionada;
        }
    }

    public void removeEstoqueProduto(int qtdRemovida){
            quantidadeEmEstoque -= qtdRemovida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Dimensoes getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(Dimensoes dimensoes) {
        this.dimensoes = dimensoes;
    }

    public String getUrlDaImagem() {
        return urlDaImagem;
    }

    public void setUrlDaImagem(String urlDaImagem) {
        this.urlDaImagem = urlDaImagem;
    }

    public float getPrecoEmReais() {
        return precoEmReais;
    }

    public void setPrecoEmReais(float precoEmReais) {
        this.precoEmReais = precoEmReais;
    }
}
