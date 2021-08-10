import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *  Esta classe implementa um sistema de mensagens curtas estilo Twitter.
 *  É preciso cadastrar um usuário, identificado pelo seu e-mail, para que tuítes possam ser feitos.
 *  Usuários começam como iniciantes, depois são promovidos a senior e a ninja, em função do número de tuítes.
 *  Existe um tamanho máximo permitido por mensagem (constante TAMANHO_MAXIMO_TUITES).
 *  As mensagens podem conter hashtags (palavras iniciadas por #), que são detectadas automaticamente.
 *  Os tuítes podem conter, além da mensagem de texto, um anexo qualquer.
 *  Há um método para retornar, a qualquer momento, qual a hashtag mais usada em toda a história do sistema.
 */
public class TuiterLite {

    private Map<String, Usuario> usuarioByEmail;

    private Map<String, Integer> quantidadeByHashtag;

    private String hashtagMaisComum;

    public static int TAMANHO_MAXIMO_TUITES = 120;

    /**
     * Cadastra um usuário, retornando o novo objeto Usuario criado.
     * @param nome O nome do usuário.
     * @param email O e-mail do usuário (precisa ser único no sistema).
     * @return O Usuario criado.
     */
    public Usuario cadastrarUsuario(String nome, String email) {  // throws UsuarioJaExisteException {
        Usuario novo = new Usuario(nome, email);
        usuarioByEmail.put(email, novo);
        return novo;
    }

    public TuiterLite() {
        usuarioByEmail = new HashMap<>();
        quantidadeByHashtag = new HashMap<>();
        hashtagMaisComum=null;
    }

    /**
     *
     * @param usuario O autor do tuíte
     * @param texto O texto desejado
     * @return Um "tuíte", que será devidamente publicado no sistema
     *
     * PS.: Se o texto exceder o limite pré-definido, ou o usuário não estiver cadastrado, return null
     */
    public Tuite tuitarAlgo(Usuario usuario, String texto) {
        if(texto==null){
            return null;
        }

        Set<String> hashtags = new HashSet<>();
        char[] charArray = texto.toCharArray();
        int tamanho = charArray.length;

        if(tamanho>TAMANHO_MAXIMO_TUITES){
            return null;
        }

        for(int i=0; i<tamanho;i++) { //percorrendo a string até achar #'s
            if(charArray[i]=='#'){
                int j = i;
                while(j<tamanho && charArray[j]!=' '){ //percorrer a palavra com a hashtag ate achar o fim da palavra ou o fim do array
                    j++;
                }
                String novaHashtag = texto.substring(i, j);
                //System.out.println(novaHashtag);
                hashtags.add(novaHashtag);
                atualizaQuantidadeHashtag(novaHashtag);
            }
        }

        Tuite tt = new Tuite(usuario, texto, hashtags);
        return tt;
    }

    /**
     * Retorna a hashtag mais comum dentre todas as que já apareceram.
     * A cada tuíte criado, hashtags devem ser detectadas automaticamente para que este método possa funcionar.
     * @return A hashtag mais comum, ou null se nunca uma hashtag houver sido tuitada.
     */
    public String getHashtagMaisComum() {
        return hashtagMaisComum;
    }

    protected void atualizaQuantidadeHashtag(String hashtag){
        Integer novaqtd;
        if(quantidadeByHashtag.containsKey(hashtag)){
            novaqtd = quantidadeByHashtag.get(hashtag) + 1;
            quantidadeByHashtag.put(hashtag, novaqtd);
        } else{
            novaqtd =1;
            quantidadeByHashtag.put(hashtag, novaqtd);
        }

        if(hashtagMaisComum==null||novaqtd>quantidadeByHashtag.get(hashtagMaisComum)){ // verifica se a quantidade dessa é a mais comum
            this.hashtagMaisComum = hashtag;
        }

    }
}
