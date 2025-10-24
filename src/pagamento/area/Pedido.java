package pagamento.area;

import cliente.area.cliente.Cliente;
import pagamento.area.tipo.PagamentoCartao;
import pagamento.area.tipo.PagamentoPix;
import produtos.area.Carrinho;

import java.util.Scanner;

public class Pedido {
    Cliente cliente;
    Carrinho carrinho;
    FormaPagamento formaPagamento;
    StatusPedido status;


    public void tipoPagamento(double valorCarrinho){
        Scanner scanner = new Scanner(System.in);
        FormaPagamento pagamento;
        System.out.println("Opções de pagamento:\n1-Cartão de crédito\n2-Pix");
        int opcao = scanner.nextInt();

        switch(opcao){
            case 1:
                pagamento = new PagamentoCartao();
                realizarPagamento(pagamento, valorCarrinho);
                break;
            case 2:
                pagamento = new PagamentoPix();
                realizarPagamento(pagamento, valorCarrinho);
                break;
            default:
                System.out.println("Erro...\nTente novamente!");
                tipoPagamento(valorCarrinho);
                break;
        }

    }

    public String statusPedido(String statusPedido) {
        try {
            status = StatusPedido.valueOf(statusPedido);
            return status.getDescricao();
        } catch (IllegalArgumentException e) {
            return "Status inválido! Erro no sistema!";
        }
    }

    public void realizarPagamento(FormaPagamento formaPagamento, double valorCarrinho){
        System.out.println(this.statusPedido("PENDENTE"));
        boolean validacaoPagamento = formaPagamento.realizarPagamento(valorCarrinho);
        String mensagemValidade = validacaoPagamento ? this.statusPedido("ENVIADO") : "Erro ao realizar pagamento";
        System.out.println(mensagemValidade);
    }
}
