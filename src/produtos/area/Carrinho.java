package produtos.area;
import cliente.area.cliente.Cliente;
import java.util.ArrayList;
import java.util.Scanner;
/*
- Fazer cálculo dopreço
- No produto do carrinho, manter a quantidade requisitada pelo cliente (talvez usar o remove e caso ele esvazie a o carrinho, devolve a quantidade anterior);

 */
public class Carrinho {
    //public Cliente cliente;--> adicionar uma referência para saber se o cliente possui ou não status vip

    /*
    Terá duas listas, a de produtos e a do carrinho;
    carrinho armazena, exclui, soma o valor total (mostra o valor com desconto) os produtos
     */
    ArrayList<Produto> carrinhoDoCliente =  new ArrayList<>();

    public void menuDoCarrinho(){
        Scanner sc = new Scanner(System.in);
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
                    excluindoProduto();;
                    break;
                case 3:
                    //Fechar carrinho e realizar pagamento
                    break;
                case 4:
                    //esvaziar carrinho e sair
                    System.exit(0);
                    break;
                default:
                    //saída
                    break;
            }
        }while (controlador != 1) ;
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
            System.out.println("Qtd disponível: " + prod.getEstoque());
            System.out.println("-----------------------------------");
        }
        System.out.println("Preço: " + calculandoPrecoTotal());
        System.out.println("///----------------------------------------------------///");
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
                carrinhoDoCliente.get(i).setEstoque(quantidadeDoProduto);
            };
        }

        exibirListaDoCarrinho();
        menuDeCompra();
    }
    public void excluindoProduto(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual produto deseja excluir?");
        System.out.println("Digite o código do produto:");
        var codigoDoProduto = sc.nextInt();
        System.out.println("Digite a quantidade do produto: ");
        var quantidadeDoProduto = sc.nextInt();

        //fazer a comparação do produto com da lista atual e excluir
    }
    public int calculandoPrecoTotal(){
        // Fazer calculo do produto e aceitar um double, adicionar na assinatura a quantidade requisitada pelo cliente
        int precoTotal = 0;
        for(int i = 0; i < carrinhoDoCliente.size(); i++){
            precoTotal += carrinhoDoCliente.get(i).getPreco();
        }
        //calcular preco com desconto para o cliente
        return precoTotal;
    }
}