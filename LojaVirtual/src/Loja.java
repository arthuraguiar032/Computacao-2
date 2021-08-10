import java.util.ArrayList;

/**
 * Implementa uma loja virtual para produtos de qualquer tipo,
 * desde que tenham descrição, preço e dimensões.
 *
 * Essa classe será um singleton, isto é, permitiremos apenas
 * uma instância desde objeto no sistema.
 */
public class Loja {

    private static final Loja instanciaUnica = new Loja();

    private ArrayList<Produto> estoque = new ArrayList<>();

    private ArrayList<Usuario> compradores = new ArrayList<>();

    static {
        System.out.println("Estou subindo a classe Loja...");
    }

    protected Loja() {
        // escrevo código normalmente para o construtor
    }

    public static Loja getInstanciaUnica() {
        return instanciaUnica;
    }

    public void limparEstado() {
        estoque.clear();
        compradores.clear();
    }

    /**
     * Inclui no estoque da loja a quantidade informado do produto.
     *
     * @param produto o produto a ser incluído
     * @param quantidadeAIncluir a quantidade que será acrescentada à quantidade existente.
     */
    public void incluirProduto(Produto produto, int quantidadeAIncluir) {
        if(!estoque.contains(produto)){
            estoque.add(produto);
        }
        produto.adicionaEstoqueProduto(quantidadeAIncluir);
    }

    public void cadastrarUsuario(Usuario usuario) {
        compradores.add(usuario);
    }

    /**
     * Efetua a venda do produto desejado na quantidade especificada.
     *
     * @param produto o produto
     * @param quantidadeDesejada a quantidade
     *
     * @return um Recibo indicando a venda feita, se o produto existia (em quantidade suficiente)
     *         no estoque da loja; null, caso o usuário ou o produto sejam desconhecidos,
     *         ou não haja quantidade suficiente do produto desejado
     */
    public Recibo efetuarVenda(Produto produto, int quantidadeDesejada, Usuario usuario) {
        Recibo recibo;
        if(!estoque.contains(produto)||!compradores.contains(usuario)||informarQuantidadeEmEstoque(produto)<quantidadeDesejada){
            recibo =null;
        } else{
            recibo = new Recibo(produto, quantidadeDesejada, usuario);
            produto.removeEstoqueProduto(quantidadeDesejada);
        }




        return recibo;
    }

    /**
     * @param produto o produto a ser consultado
     *
     * @return a quantidade em estoque;
     *         0 se não houver nenhuma unidade;
     *         -1 se o produto não é sequer vendido pela loja
     */
    public int informarQuantidadeEmEstoque(Produto produto) {
        if(!estoque.contains(produto)){
            return -1;
        } else{
            return produto.getQuantidadeEmEstoque();
        }
    }
}
