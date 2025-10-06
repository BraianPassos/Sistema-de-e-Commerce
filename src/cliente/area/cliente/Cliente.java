package cliente.area.cliente;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String email;
    private String cpf;
    private String senha;
    private boolean statusVip;

    public static ArrayList<Cliente> clientes = new  ArrayList<>();

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



    public double calcularDesconto(){

        return 0.0;
    }

}
