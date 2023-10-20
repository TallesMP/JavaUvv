package uvve.commerce;

public class ItemPedido {
    int itemPedidoid;
    String item;
    int quantidade;
    double precoUnitario;
    
    public ItemPedido(String item, int quantidade, double d) {
        this.item = item;
        this.quantidade = quantidade;
        this.precoUnitario = d;
    }

    public double calcularPrecoTotal() {
        return precoUnitario * quantidade;
    }
}