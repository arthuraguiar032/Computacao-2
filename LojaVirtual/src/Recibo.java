public class Recibo {

    private Produto produto;

    private int quantidade;

    private Usuario comprador;

    public Recibo(Produto produto, int quantidade,  Usuario comprador) {
        this.produto = produto;
        this.quantidade=quantidade;
        this.comprador = comprador;
    }

    public float getValorTotalDaCompra() {
        return quantidade*produto.getPrecoEmReais();
    }

    public Usuario getUsuario() {
        return comprador;
    }

    @Override
    public String toString() {
        return String.format("Recibo no valor de R$%.2f para %s " +
                "referente à compra de %d unidades de %s", getValorTotalDaCompra(), comprador.getNome(),
                quantidade, produto.getDescricao());
    }
}
