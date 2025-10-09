package cliente.area.cliente;
import produtos.area.Carrinho;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String email;
    private String cpf;
    private String senha;
    private boolean statusVip;
    public static ArrayList<Cliente> clientes = new  ArrayList<>();

    //Zona de testes, clientes criados para teste:
    static {
        Cliente c1 = new Cliente();
        c1.setNome("Ana Souza");
        c1.setEmail("ana@email.com");
        c1.setCpf("12345678900");
        c1.setSenha("senha123");
        c1.setStatusVip(true);
        clientes.add(c1);

        Cliente teste = new Cliente();
        teste.setNome("Testando da Silva");
        teste.setEmail("teste@email.com");
        teste.setCpf("99999999999");
        teste.setSenha("teste123");
        teste.setStatusVip(true);
        clientes.add(teste);

        Cliente c2 = new Cliente();
        c2.setNome("Bruno Lima");
        c2.setEmail("bruno@email.com");
        c2.setCpf("98765432100");
        c2.setSenha("abc123");
        c2.setStatusVip(false);
        clientes.add(c2);

        Cliente c3 = new Cliente();
        c3.setNome("Carlos Mendes");
        c3.setEmail("carlos@email.com");
        c3.setCpf("45678912300");
        c3.setSenha("pass456");
        c3.setStatusVip(true);
        clientes.add(c3);
    }
    //-------------------------------------------------------------


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isStatusVip() {
        return statusVip;
    }

    public void setStatusVip(boolean statusVip) {
        this.statusVip = statusVip;
    }


    public void criandoCarinho(){
        Carrinho carrinho = new Carrinho();
        carrinho.setCliente(this);
        carrinho.menuDoCarrinho();
    }

    public double calcularDesconto(double precoTotal){
        double calculoDeDesconto = precoTotal - (precoTotal * 0.05);
        return calculoDeDesconto;
    }
}
