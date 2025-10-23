package pagamento.area;

import cliente.area.cliente.Cliente;
import produtos.area.Carrinho;

public class Pedido {
    Cliente cliente;
    Carrinho carrinho;
    FormaPagamento formaPagamento;
    StatusPedido status;


    public void realizarPagamento(){


    }

    public String statusPedido(String statusPedido) {
        try {
            status = StatusPedido.valueOf(statusPedido);
            return status.getDescricao();
        } catch (IllegalArgumentException e) {
            return "Status inválido! Erro no sistema!";
        }
    }
}
