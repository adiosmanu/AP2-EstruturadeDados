public class Fila {
    private No inicio;
    private No fim;

    public Fila() {
        this.inicio = null;
        this.fim = null;
    }

    public boolean isEmpty() {
        return inicio == null;
    }

    public void enqueue(Pedido pedido) {
        No novoNo = new No(pedido);
        if (isEmpty()) {

            inicio = novoNo;
            fim = novoNo;
        } else {

            fim.setProximo(novoNo);
            fim = novoNo;
        }
        System.out.println("Pedido adicionado à fila: " + pedido.getDescricao());
    }

    public Pedido dequeue() {
        if (isEmpty()) {
            System.out.println("A fila de pedidos está vazia. Nenhum pedido para atender.");
            return null;
        }
        Pedido pedidoAtendido = inicio.getPedido();
        inicio = inicio.getProximo();

        if (inicio == null) {
            fim = null;
        }

        return pedidoAtendido;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("--- Fila de Pedidos Pendentes ---");
            System.out.println("A fila está vazia.");
            System.out.println("---------------------------------");
            return;
        }
        System.out.println("--- Fila de Pedidos Pendentes ---");
        No atual = inicio;
        while (atual != null) {
            System.out.println(atual.getPedido());
            atual = atual.getProximo();
        }
        System.out.println("---------------------------------");
    }
}