package produtos.area;
import java.util.ArrayList;

public class ProdutosIniciais {
    ArrayList<Produto> produtosIniciais = new ArrayList<>();
    
    public ProdutosIniciais() {
        produtosIniciais.add(new Produto("Sardinha", "Lata de sardinha", 3.0, "Enlatados", 60));
        produtosIniciais.add(new Produto("Arroz Branco", "Pacote de arroz tipo 1", 5.5, "Grãos", 100));
        produtosIniciais.add(new Produto("Feijão Carioca", "Feijão selecionado 1kg", 7.2, "Grãos", 80));
        produtosIniciais.add(new Produto("Macarrão Espaguete", "Macarrão tipo espaguete 500g", 3.8, "Massas", 120));
        produtosIniciais.add(new Produto("Óleo de Soja", "Óleo vegetal 900ml", 6.0, "Óleos", 90));
        produtosIniciais.add(new Produto("Café Torrado", "Café moído tradicional 500g", 8.9, "Bebidas", 70));
        produtosIniciais.add(new Produto("Leite Integral", "Caixa de leite UHT 1L", 4.5, "Laticínios", 150));
        produtosIniciais.add(new Produto("Biscoito Recheado", "Biscoito sabor chocolate 120g", 2.5, "Snacks", 200));
        produtosIniciais.add(new Produto("Sabonete Neutro", "Sabonete em barra 90g", 1.8, "Higiene", 300));
        produtosIniciais.add(new Produto("Detergente Líquido", "Detergente para louças 500ml", 2.2, "Limpeza", 250));
        produtosIniciais.add(new Produto("Refrigerante Cola", "Garrafa 2L de refrigerante sabor cola", 6.5, "Bebidas", 100));
    }

    public void ListarProdutos(){
        for(int i = 0; i < produtosIniciais.size(); i++){
            var prod = produtosIniciais.get(i);
            System.out.println("-----------------------------------");
            System.out.println(prod.getNome());
            System.out.println(prod.getDescricao());
            System.out.println(prod.getPreco());
            System.out.println(prod.getCategoria());
            System.out.println(prod.getEstoque());
            System.out.println("-----------------------------------");
        }
    }
}
