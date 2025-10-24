package pagamento.area.tipo;
import pagamento.area.FormaPagamento;

public class PagamentoPix implements FormaPagamento {


    @Override
    public boolean realizarPagamento(double valor) {
        return false;
    }
}
