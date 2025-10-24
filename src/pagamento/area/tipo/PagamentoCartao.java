package pagamento.area.tipo;
import pagamento.area.FormaPagamento;

public class PagamentoCartao implements FormaPagamento {

    @Override
    public boolean realizarPagamento(double valor) {
        return true;
    }
}
