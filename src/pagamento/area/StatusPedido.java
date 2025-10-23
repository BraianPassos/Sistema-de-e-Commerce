package pagamento.area;

public enum StatusPedido {
    PENDENTE("Pagamento pendente..."),
    PAGO("Pagamento realizado com sucesso!"),
    ENVIADO("Seus produtos estão sendo enviados"),
    CANCELADO("Pedido cancelado...");

    private String descricao;

    StatusPedido(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return descricao;
    }

}
