import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlbumTest {

    private Album<Figurinha> albumFigurinhas;
    private Repositorio<Figurinha> repositorioFigurinhas;

    private static final int TAMANHO_DO_ALBUM = 200;
    private static final int ITENS_POR_PACOTE = 3;
    private Repositorio<Selo> repositorioSelos;

    @Before  // roda antes de cada teste
    public void setUp() {
        this.repositorioFigurinhas = new Repositorio<>("album_copa2014", TAMANHO_DO_ALBUM, new Figurinha(-1, null));
        this.repositorioSelos = new Repositorio<>("selo_paises", TAMANHO_DO_ALBUM, new Selo(-1, null, 0));
        
        this.albumFigurinhas = new Album<>(repositorioFigurinhas, ITENS_POR_PACOTE);
    }

    private void popularAlbum(int[] posicoesDesejadas, Repositorio repo, Album album) {
        Pacotinho pacote = new Pacotinho(repo, posicoesDesejadas);
        album.receberNovoPacotinho(pacote);
    }

    @Test
    public void testarPossuiFigurinhaParaFigurinhasExistentes() {
        popularAlbum(new int[] {1, 2, 3}, repositorioFigurinhas, albumFigurinhas);

        for (int i = 1; i <= 3; i++) {
            assertTrue("Figurinhas já inseridas devem ser encontradas",
                    this.albumFigurinhas.possuiItemColado(i));
        }
    }

    @Test
    public void testarPossuiFigurinhaParaFigurinhasAusentes() {
        popularAlbum(new int[] {1, 2, 3}, repositorioFigurinhas, albumFigurinhas);

        assertFalse("Não devemos encontrar no álbum figurinhas nunca inseridas",
                this.albumFigurinhas.possuiItemColado(4));
        assertFalse("Não devemos encontrar figurinhas de posições não-positivas",
                this.albumFigurinhas.possuiItemColado(-390));
        assertFalse("Não devemos encontrar figurinhas maiores do que o tamanho",
                this.albumFigurinhas.possuiItemColado(TAMANHO_DO_ALBUM + 1));
    }

    @Test
    public void testarPossuiRepetidaParaFigurinhaRepetida() {
        popularAlbum(new int[] {1, 2, 3}, repositorioFigurinhas, albumFigurinhas);
        assertFalse(this.albumFigurinhas.possuiItemRepetido(2));  // sanity check

        popularAlbum(new int[] {2, 8, 9}, repositorioFigurinhas, albumFigurinhas);
        assertTrue(this.albumFigurinhas.possuiItemRepetido(2));
    }

    @Test
    public void testarGetTamanhoAlbum() {
        assertEquals(TAMANHO_DO_ALBUM, this.albumFigurinhas.getTamanho());
    }

    @Test
    public void testarGetContFigurinhas() {
        popularAlbum(new int[] {1, 2, 3}, repositorioFigurinhas, albumFigurinhas);
        assertEquals(3, this.albumFigurinhas.getQuantItensColados());

        // vou agora abrir outro pacotinho com as mesmas figurinhas
        // e verificar que o álbum terá ainda 3 figurinhas

        popularAlbum(new int[] {1, 2, 3}, repositorioFigurinhas, albumFigurinhas);
        assertEquals(3, this.albumFigurinhas.getQuantItensColados());
    }

    @Test
    public void testarGetQuantasFaltam() {
        popularAlbum(new int[] {1, 2, 3}, repositorioFigurinhas,albumFigurinhas);
        assertEquals(TAMANHO_DO_ALBUM - 3,
                this.albumFigurinhas.getQuantItensFaltantes());
    }

    @Test
    public void testarAutoCompletar() {
        albumFigurinhas.autoCompletar();
        assertEquals("Não deve ser possível auto-completar um álbum que esteja vazio",
                TAMANHO_DO_ALBUM, albumFigurinhas.getQuantItensFaltantes());

        // agora vamos adicionar pacotinhos aleatórios até o álbum ficar quase cheio

        int minimoFigurinhasColadasParaAutoCompletar =
                (int) (TAMANHO_DO_ALBUM * Album.PERCENTUAL_MINIMO_PARA_AUTO_COMPLETAR / 100f);

        while (albumFigurinhas.getQuantItensColados() < minimoFigurinhasColadasParaAutoCompletar) {
            Pacotinho novoPacotinho = new Pacotinho(
                    this.repositorioFigurinhas, ITENS_POR_PACOTE);  // aleatório
            albumFigurinhas.receberNovoPacotinho(novoPacotinho);
        }

        // sanity check
        assertTrue(albumFigurinhas.getQuantItensFaltantes() > 0);

        albumFigurinhas.autoCompletar();

        assertEquals("O álbum deve estar completo após uma chamada válida ao auto-completar " +
                        "(isto é, após o percentual mínimo de figurinhas já ter sido obtido)",
                0, albumFigurinhas.getQuantItensFaltantes());  // álbum completo!
    }

    @Test
    public void testarGetItemColado() {
        popularAlbum(new int[] {1, 2, 3}, repositorioFigurinhas, albumFigurinhas);
        Figurinha figurinha = (Figurinha) albumFigurinhas.getItemColado(2);

        assertNotNull(figurinha);

        assertEquals(2, figurinha.getPosicao());

        assertNull(albumFigurinhas.getItemColado(4));
    }

    @Test
    public void testarRejeicaoPacotinhosDeTamanhoErrado() {
        popularAlbum(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 8}, repositorioFigurinhas, albumFigurinhas);

        assertEquals("Pacotes de tamanho distinto do informado na construção " +
                "do álbum devem ser rejeitados",
                0, albumFigurinhas.getQuantItensColados());
    }
    
    @Test
    public void testarTipoGenerico(){
        Album<Selo> albumSelos = new Album<>(repositorioSelos, ITENS_POR_PACOTE);
        Album<Figurinha> albumFigurinha2 = new Album<>(repositorioFigurinhas, ITENS_POR_PACOTE);

        popularAlbum(new int[] {1, 2, 3}, repositorioSelos, albumSelos);
        assertEquals(3, albumSelos.getQuantItensColados());
        albumFigurinha2.autoCompletar();
        assertEquals(0, albumFigurinha2.getQuantItensColados());


    }

}