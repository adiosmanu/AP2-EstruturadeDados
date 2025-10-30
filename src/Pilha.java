public class Pilha {
    private No topo;

    public Pilha(){
        this.topo = null;
    }

    public  boolean isEmpty(){
        return topo == null;
    }

    public void push(Pedido pedido){
        No novoNo = new No(pedido);
        if (!isEmpty()){
            novoNo.setProximo(topo);
        }
        topo = novoNo;
    }

    public Pedido pop(){
        if (isEmpty()){
            System.out.println("A pilha de cancelados está vazia.");
            return null;
        }

        Pedido pedidoRemovido = topo.getPedido();
        topo = topo.getProximo();

        return pedidoRemovido;
    }

    public void printStack(){
        if (isEmpty()){
            System.out.println("--- Pilha de Pedidos Cancelados ---");
            System.out.println("A pilha está vazia.");
            System.out.println("-----------------------------------");
            return;
        }
        System.out.println("--- Pilha de Pedidos Cancelados ---");
        No atual = topo;
        while (atual != null){
            System.out.println(atual.getPedido());
            atual = atual.getProximo();
        }
        System.out.println("------------------------------------");
    }
}
