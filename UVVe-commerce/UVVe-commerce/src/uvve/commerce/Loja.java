package uvve.commerce;

import java.util.List;
import java.util.ArrayList;
public class Loja {
    int lojaid;
    String nomeFantasia;
    String cnpj;
    double valorDeMercado;

    Funcionario funcionario;
    List<Pedido> pedidos;
    public Loja() {
    pedidos = new ArrayList<>();
    }

    void AdcionarPedido(Pedido pedido){
        pedidos.add(pedido);
    }


    public static void main(String[] args) {
      AdcionarPedido(pedido)
    }
}
