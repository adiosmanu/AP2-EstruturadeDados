// Arquivo: Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Fila filaPedidos = new Fila();
        Pilha pilhaCancelados = new Pilha();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\n===== Sistema de Pedidos da Cafeteria =====");
            System.out.println("1. Adicionar Novo Pedido");
            System.out.println("2. Atender Pedido");
            System.out.println("3. Cancelar Pedido");
            System.out.println("4. Restaurar Pedido Cancelado");
            System.out.println("5. Imprimir Pedidos Pendentes");
            System.out.println("6. Imprimir Pedidos Cancelados");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Por favor, digite um número.");
                opcao = -1;
                continue;
            }


            switch (opcao) {
                case 1:
                    System.out.print("Digite a descrição do pedido: ");
                    String descricao = scanner.nextLine();
                    filaPedidos.enqueue(new Pedido(descricao));
                    break;
                case 2:
                    Pedido pedidoAtendido = filaPedidos.dequeue();
                    if (pedidoAtendido != null) {
                        System.out.println("Pedido atendido: " + pedidoAtendido);
                    }
                    break;
                case 3:
                    Pedido pedidoParaCancelar = filaPedidos.dequeue();
                    if (pedidoParaCancelar != null) {
                        pilhaCancelados.push(pedidoParaCancelar);
                        System.out.println("Pedido cancelado e movido para a pilha: " + pedidoParaCancelar);
                    }
                    break;
                case 4:
                    Pedido pedidoParaRestaurar = pilhaCancelados.pop();
                    if (pedidoParaRestaurar != null) {
                        filaPedidos.enqueue(pedidoParaRestaurar);
                        System.out.println("Pedido restaurado e movido para a fila: " + pedidoParaRestaurar);
                    }
                    break;
                case 5:
                    filaPedidos.printQueue();
                    break;
                case 6:
                    pilhaCancelados.printStack();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}