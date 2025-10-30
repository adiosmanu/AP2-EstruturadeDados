import java.util.Comparator;

public class Playlist {
    private No inicio;
    private No fim;
    private No musicaAtual;

    public Playlist() {
        this.inicio = null;
        this.fim = null;
        this.musicaAtual = null;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public void adicionarNoFim(Musica musica) {
        No novoNo = new No(musica);
        if (isEmpty()) {
            inicio = novoNo;
            fim = novoNo;
            musicaAtual = novoNo;
        } else {
            fim.setProximo(novoNo);
            novoNo.setAnterior(fim);
            fim = novoNo;
        }
        System.out.println("Música adicionada: " + musica.getTitulo());
    }

    public void listarMusicas() {
        if (isEmpty()) {
            System.out.println("A playlist está vazia.");
            return;
        }
        System.out.println("--- Minha Playlist ---");
        No atual = inicio;
        while (atual != null) {
            System.out.println(atual.getMusica());
            atual = atual.getProximo();
        }
        System.out.println("----------------------");
    }

    public void tocarMusica() {
        if (musicaAtual == null) {
            System.out.println("Nenhuma música para tocar. A playlist pode estar vazia.");
            return;
        }
        System.out.println("Tocando agora: " + musicaAtual.getMusica());
    }

    public void proximaMusica() {
        if (musicaAtual != null && musicaAtual.getProximo() != null) {
            musicaAtual = musicaAtual.getProximo();
            tocarMusica();
        } else {
            System.out.println("Você já está na última música da playlist.");
        }
    }

    public void musicaAnterior() {
        if (musicaAtual != null && musicaAtual.getAnterior() != null) {
            musicaAtual = musicaAtual.getAnterior();
            tocarMusica();
        } else {
            System.out.println("Você já está na primeira música da playlist.");
        }
    }

    public void removerMusica(String titulo) {
        if (isEmpty()) {
            System.out.println("Playlist vazia.");
            return;
        }

        No atual = inicio;
        while (atual != null && !atual.getMusica().getTitulo().equalsIgnoreCase(titulo)) {
            atual = atual.getProximo();
        }

        if (atual == null) {
            System.out.println("Música não encontrada: " + titulo);
            return;
        }

        if (atual == musicaAtual) {
            if (atual.getProximo() != null) {
                musicaAtual = atual.getProximo();
            } else {
                musicaAtual = atual.getAnterior();
            }
        }

        if (atual == inicio) {
            inicio = atual.getProximo();
            if (inicio != null) {
                inicio.setAnterior(null);
            } else {
                fim = null;
            }
        } else if (atual == fim) {
            fim = atual.getAnterior();
            fim.setProximo(null);
        } else {
            atual.getAnterior().setProximo(atual.getProximo());
            atual.getProximo().setAnterior(atual.getAnterior());
        }

        System.out.println("Música removida: " + titulo);
    }

    public Playlist getPlaylistOrdenada(Comparator<Musica> comparador) {
        if (isEmpty()) {
            return new Playlist();
        }

        Playlist playlistOrdenada = new Playlist();
        No atual = this.inicio;
        while (atual != null) {
            playlistOrdenada.adicionarDeFormaOrdenada(atual.getMusica(), comparador);
            atual = atual.getProximo();
        }
        playlistOrdenada.musicaAtual = playlistOrdenada.inicio;
        return playlistOrdenada;
    }

    private void adicionarDeFormaOrdenada(Musica musica, Comparator<Musica> comparador) {
        No novoNo = new No(musica);
        if (isEmpty()) {
            inicio = fim = novoNo;
            return;
        }

        if (comparador.compare(musica, inicio.getMusica()) < 0) {
            novoNo.setProximo(inicio);
            inicio.setAnterior(novoNo);
            inicio = novoNo;
            return;
        }

        No atual = inicio;
        while (atual.getProximo() != null && comparador.compare(musica, atual.getProximo().getMusica()) > 0) {
            atual = atual.getProximo();
        }

        if (atual.getProximo() == null) {
            atual.setProximo(novoNo);
            novoNo.setAnterior(atual);
            fim = novoNo;
        } else {
            novoNo.setProximo(atual.getProximo());
            novoNo.setAnterior(atual);
            atual.getProximo().setAnterior(novoNo);
            atual.setProximo(novoNo);
        }
    }
}