public class Pedido {
    private static int contadorId = 1;
    private int id;
    private String descricao;

    public Pedido(String descricao) {
        this.id = contadorId++;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Pedido { ID: " + id + ", Descrição: '" + descricao + "' }";
    }
}