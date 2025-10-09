package cliente.area.cliente;

public class ClienteComum extends Cliente{

    @Override
    public double calcularDesconto(double precoTotal){
        return precoTotal;
    }
}
