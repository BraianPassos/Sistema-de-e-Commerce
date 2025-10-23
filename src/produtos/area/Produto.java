package produtos.area;

import java.util.ArrayList;

public class Produto {
    private int codigo;
    private String nome;
    private String descricao;
    private double preco;
    private String categoria;
    private int quantidadeEstoque;
    public static ArrayList<Produto> produtosIniciais = new ArrayList<>();


    public Produto(int codigo, String nome, String descricao, double preco, String categoria, int estoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
        this.quantidadeEstoque = estoque;
    }

    public Produto() {

    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public static void ListarProdutos(){
        for(int i = 0; i < produtosIniciais.size(); i++){
            var prod = produtosIniciais.get(i);
            System.out.println("-----------------------------------");
            System.out.println("Código: " + prod.getCodigo());
            System.out.println("Nome: " + prod.getNome());
            System.out.println("Descrição: " + prod.getDescricao());
            System.out.println("Preço: " + prod.getPreco());
            System.out.println("Categoria: " + prod.getCategoria());
            System.out.println("Qtd disponível: " + prod.getQuantidadeEstoque());
            System.out.println("-----------------------------------");
        }
    }

    public static Produto passandoProduto(int codigo, int quantidadeSolicitada) {
        for (Produto produto : produtosIniciais) {
            if (produto.getCodigo() == codigo) {
                if (produto.getQuantidadeEstoque() < quantidadeSolicitada) {
                    throw new RuntimeException("Estoque insuficiente");
                }
                return produto;
            }
        }
        return null;
    }
        /*for(int i = 0; i < produtosIniciais.size(); i++){
            if(produtosIniciais.get(i).getCodigo() == codigo){
                if (produtosIniciais.get(i).getQuantidadeEstoque() > quantidadeSolicitada){
                    return produtosIniciais.get(i);
                } else {
                    throw new RuntimeException("Estoque insuficiente");
                }
            }
        }
        return  null;
    }*/
    //Zona de testes, clientes criados para teste:

    static{
        Produto sardinha = new Produto(111, "Sardinha", "Lata de sardinha 90g", 3.0, "Enlatados", 60);
        Produto arrozBranco = new Produto(112, "Arroz Branco", "Pacote de arroz tipo 1", 5.5, "Grãos", 100);
        Produto feijaoCarioca = new Produto(113, "Feijão Carioca", "Feijão selecionado 1kg", 7.2, "Grãos", 80);
        Produto macarraoEspaguete = new Produto(114, "Macarrão Espaguete", "Macarrão tipo espaguete 500g", 3.8, "Massas", 120);
        Produto oleoSoja = new Produto(115, "Óleo de Soja", "Óleo vegetal 900ml", 6.0, "Óleos", 90);
        Produto cafeTorrado = new Produto(116, "Café Torrado", "Café moído tradicional 500g", 8.9, "Bebidas", 70);
        Produto leiteIntegral = new Produto(117, "Leite Integral", "Caixa de leite UHT 1L", 4.5, "Laticínios", 150);
        Produto biscoitoRecheado = new Produto(118, "Biscoito Recheado", "Biscoito sabor chocolate 120g", 2.5, "Snacks", 200);
        Produto saboneteNeutro = new Produto(119, "Sabonete Neutro", "Sabonete em barra 90g", 1.8, "Higiene", 300);
        Produto detergenteLiquido = new Produto(120, "Detergente Líquido", "Detergente para louças 500ml", 2.2, "Limpeza", 250);
        Produto refrigeranteCola = new Produto(121, "Refrigerante Cola", "Garrafa 2L de refrigerante sabor cola", 6.5, "Bebidas", 100);

    // Adicionando à lista
        produtosIniciais.add(sardinha);
        produtosIniciais.add(arrozBranco);
        produtosIniciais.add(feijaoCarioca);
        produtosIniciais.add(macarraoEspaguete);
        produtosIniciais.add(oleoSoja);
        produtosIniciais.add(cafeTorrado);
        produtosIniciais.add(leiteIntegral);
        produtosIniciais.add(biscoitoRecheado);
        produtosIniciais.add(saboneteNeutro);
        produtosIniciais.add(detergenteLiquido);
        produtosIniciais.add(refrigeranteCola);

        //-------------------------------------------
    }
}

