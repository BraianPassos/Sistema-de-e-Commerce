package produtos.area;
import cliente.area.cliente.Cliente;
import cliente.area.cliente.ClienteVip;
import pagamento.area.Pedido;
import pagamento.area.StatusPedido;

import java.util.ArrayList;
import java.util.Scanner;

/*
- Fazer cálculo dopreço
- No produto do carrinho, manter a quantidade requisitada pelo cliente (talvez usar o remove e caso ele esvazie a o carrinho, devolve a quantidade anterior);

 */

public class Carrinho {
    private Cliente cliente;//--> adicionar uma referência para saber se o cliente possui ou não status vip

    /*
    Terá duas listas, a de produtos e a do carrinho;
    carrinho armazena, exclui, soma o valor total (mostra o valor com desconto) os produtos
     */
    ArrayList<Produto> carrinhoDoCliente =  new ArrayList<>();

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void menuDoCarrinho(){
        Scanner sc = new Scanner(System.in);
        System.out.println(cliente);
        System.out.println("Deseja comprar alguma coisa?");
        System.out.println("1-Exibir Lista de Produtos\n2- Sair");
        int controladorDeEscolhaInicial = sc.nextInt();

        switch(controladorDeEscolhaInicial){
            case 1:
                Produto.ListarProdutos();
                menuDeCompra();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                System.out.println("Escolha inválida\n tente novamente!\nEscolha novamente\n\n");
                menuDoCarrinho();
                break;
        }
    }
    public  void menuDeCompra() {
        Scanner sc = new Scanner(System.in);
        int controlador = 1;
        Pedido pedido = new Pedido();
        do {
            System.out.println("1 - Comprar produto\n2 - Excluir produto\n3 - Fechar carrinho e realizar pagamento\n4 - Esvaziar carrinho e sair");
            int escolhaDeLista = sc.nextInt();
            switch (escolhaDeLista) {
                case 1:
                    //chamar codigo de compra
                    pegandoProduto();
                    break;
                case 2:
                    //excluir produto
                    exibirListaDoCarrinho();
                    excluindoProduto();
                    break;
                case 3:
                    //Fechar carrinho e realizar pagamento
                    pedido.realizarPagamento();
                    break;
                case 4:
                    //esvaziar carrinho e sair
                    esvaziarCarrinho();
                    System.out.println(pedido.statusPedido("CANCELADO"));
                    controlador = 2;
                    break;
                default:
                    System.out.println("Erro... tente novamente!");
                    menuDoCarrinho();
                    break;
            }
        }while (controlador == 1) ;

        System.exit(0);
        //Saída
    }

    public void exibirListaDoCarrinho(){
        System.out.println("///----------------------Carrinho----------------------///");
        for(int i = 0; i < carrinhoDoCliente.size(); i++){
            var prod = carrinhoDoCliente.get(i);
            System.out.println("-----------------------------------");
            System.out.println("Código: " + prod.getCodigo());
            System.out.println("Nome: " + prod.getNome());
            System.out.println("Descrição: " + prod.getDescricao());
            System.out.println("Preço: " + prod.getPreco());
            System.out.println("Categoria: " + prod.getCategoria());
            System.out.println("Qtd Escolhida: " + prod.getQuantidadeEstoque());
            System.out.println("-----------------------------------");
        }
        String preco = """
                Seu StatusVip: %s
                Preço Total: %.2f
                Preço com desconto Vip: %.2f
                """;
        double precoNormal = buscandoPrecoNormal();
                //calculandoPrecoTotal();
        double precoComDesconto = buscandoPrecoComDesconto();
        String statusVip = cliente.isStatusVip() ? "Vip" : "Normal";
        System.out.println(String.format(preco,statusVip, precoNormal, precoComDesconto));
        System.out.println("///----------------------------------------------------///");
    }

    private double buscandoPrecoComDesconto() {
        double precoComDesconto = calculandoPrecoTotal();

        if(precoComDesconto > 300){
            Cliente user = new ClienteVip();
            return user.calcularDesconto(precoComDesconto);
        }
        return cliente.calcularDesconto(calculandoPrecoTotal());
    }

    private double buscandoPrecoNormal() {
        return calculandoPrecoTotal();
    }

    public void pegandoProduto(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o código do produto:");
        var codigoDoProduto = sc.nextInt();
        System.out.println("Digite a quantidade do produto: ");
        var quantidadeDoProduto = sc.nextInt();

        //enviar o id e  quantidade, fazer uma cópia deste objeto no carrinho (ou passar a ref do objeto e depois subtrair a quantidade desejada)
        Produto produto = new Produto();
        try {
            carrinhoDoCliente.add(Produto.passandoProduto(codigoDoProduto, quantidadeDoProduto));
        } catch (Exception ex) {
            System.out.println("Erro ao pegar produto");
        }
        for(int i = 0; i < carrinhoDoCliente.size(); i++){
            if(carrinhoDoCliente.get(i).getCodigo()  == codigoDoProduto){
                carrinhoDoCliente.get(i).setQuantidadeEstoque(quantidadeDoProduto);
            }
        }
        exibirListaDoCarrinho();
        menuDeCompra();
    }

    private void esvaziarCarrinho() {
        carrinhoDoCliente.clear();
        String mensagem = carrinhoDoCliente.isEmpty() ? "Carrinho vazio..." : "Erro ao esvaziar o carrinho";
        System.out.println(mensagem);
    }

    public void excluindoProduto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual produto deseja excluir?");
        System.out.println("Digite o código do produto:");
        var codigoDoProduto = sc.nextInt();

        for (int i = 0; i < carrinhoDoCliente.size(); i++) {
            if (carrinhoDoCliente.get(i).getCodigo() == codigoDoProduto) {
                carrinhoDoCliente.remove(i);
            }
            //fazer a comparação do produto com da lista atual e excluir
        }
        exibirListaDoCarrinho();
        menuDeCompra();
    }
    public double calculandoPrecoTotal(){
        // Fazer calculo do produto e aceitar um double, adicionar na assinatura a quantidade requisitada pelo cliente
        double precoTotal = 0;
        for(int i = 0; i < carrinhoDoCliente.size(); i++){
            for (int j = 0; j < carrinhoDoCliente.get(i).getQuantidadeEstoque(); j++){
                precoTotal += carrinhoDoCliente.get(i).getPreco();
            }
        }
        //calcular preco com desconto para o cliente
        return precoTotal;
    }
}