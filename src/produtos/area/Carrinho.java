package produtos.area;
import java.util.ArrayList;
import java.util.Scanner;

public class Carrinho {
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
    public  void menuDeCompra(){
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Comprar produto\n2 - Excluir produto\n3 - Esvaziar carrinho e sair");
        int escolhaDeLista = sc.nextInt();
        switch (escolhaDeLista){
            case 1:
            //chamar codigo de compra
                break;
            case 2:
                //excluir produto
                break;
            case 3:
                //esvaziar lista de produtos no carrinho
                break;
            default:
                //saída
                break;
        }
    }

    public void pegandoProduto(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o código do produto:");
        var codigoDoProduto = sc.nextInt();
        System.out.println("Digite a quantidade do produto: ");
        var quantidadeDoProduto = sc.nextInt();

    }
    public void excluindoProduto(Produto item){
    }
    public void calcuolandoPrecoTotal(){

    }
}
