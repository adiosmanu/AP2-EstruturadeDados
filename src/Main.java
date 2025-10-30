import java.util.Comparator;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist minhaPlaylist = new Playlist();

        minhaPlaylist.adicionarNoFim(new Musica("Helena", "My Chemical Romance", "Helena", 355));
        minhaPlaylist.adicionarNoFim(new Musica("Mentirosa", "Hugo e Guilherme", "H&G", 301));
        minhaPlaylist.adicionarNoFim(new Musica("Sophia", "Esteban", "Adios Esteban", 251));
        minhaPlaylist.adicionarNoFim(new Musica("Ultima Vez", "Nx Zero", "Razões e Emoções", 325));

        int opcao;
        do {
            System.out.println("\n===== Gerenciador de Músicas =====");
            System.out.println("1. Próxima música");
            System.out.println("2. Música anterior");
            System.out.println("3. Ordenar playlist");
            System.out.println("4. Tocar música atual");
            System.out.println("5. Adicionar música");
            System.out.println("6. Remover música");
            System.out.println("7. Listar músicas");
            System.out.println("8. Sair");
            System.out.print("Digite a opção desejada: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Por favor, digite um número.");
                opcao = -1;
                continue;
            }

            switch (opcao) {
                case 1:
                    minhaPlaylist.proximaMusica();
                    break;
                case 2:
                    minhaPlaylist.musicaAnterior();
                    break;
                case 3:
                    System.out.print("Ordenar por (1-Título, 2-Artista): ");
                    int criterio = Integer.parseInt(scanner.nextLine());
                    if (criterio == 1) {
                        minhaPlaylist = minhaPlaylist.getPlaylistOrdenada(Comparator.comparing(Musica::getTitulo));
                        System.out.println("Playlist ordenada por título.");
                    } else if (criterio == 2) {
                        minhaPlaylist = minhaPlaylist.getPlaylistOrdenada(Comparator.comparing(Musica::getArtista));
                        System.out.println("Playlist ordenada por artista.");
                    } else {
                        System.out.println("Critério inválido.");
                    }
                    minhaPlaylist.listarMusicas();
                    break;
                case 4:
                    minhaPlaylist.tocarMusica();
                    break;
                case 5:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Artista: ");
                    String artista = scanner.nextLine();
                    System.out.print("Álbum: ");
                    String album = scanner.nextLine();
                    System.out.print("Duração (em segundos): ");
                    int duracao = Integer.parseInt(scanner.nextLine());
                    minhaPlaylist.adicionarNoFim(new Musica(titulo, artista, album, duracao));
                    break;
                case 6:
                    System.out.print("Digite o título da música a ser removida: ");
                    String tituloRemover = scanner.nextLine();
                    minhaPlaylist.removerMusica(tituloRemover);
                    break;
                case 7:
                    minhaPlaylist.listarMusicas();
                    break;
                case 8:
                    System.out.println("Fechando programa!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 8);

        scanner.close();
    }
}