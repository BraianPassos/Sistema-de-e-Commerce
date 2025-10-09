package cliente.area.cliente;

public class ClienteVip extends Cliente{


    @Override
    public double calcularDesconto(double precoTotal){
        double valorDescontado = precoTotal - (precoTotal * 0.10);
        return valorDescontado;
    }
}

