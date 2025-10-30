public class No {
    private Pedido pedido;
    private No proximo;

    public No(Pedido pedido){
        this.pedido = pedido;
        this.proximo = null;
    }

    public Pedido getPedido(){
        return pedido;
    }

    public No getProximo(){
        return proximo;
    }

    public void setProximo(No proximo){
        this.proximo = proximo;

    }
}
