package cliente.area.login;
import cliente.area.cliente.Cliente;

import java.util.Scanner;

import static cliente.area.cliente.Cliente.clientes;

public class Login {

    public String buscandoCliente(String email, String senha) {
        String emailClienteIput = email;
        String senhaClienteIput = senha;
        for (int i = 0; i < clientes.size(); i++){
            String emailClienteLista = clientes.get(i).getEmail();
            String senhaClienteLista = clientes.get(i).getSenha();
            if (emailClienteLista.equals(emailClienteIput) && senhaClienteLista.equals(senhaClienteIput)){
                return clientes.get(i).getNome();
            }
        }
        return null;
    }

    public void LoginDoCliente(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite seu email: ");
        String email = scanner.nextLine();
        System.out.println("Digite seu senha: ");
        String senha = scanner.nextLine();

        String nomeDoCliente = buscandoCliente(email, senha);
        if (nomeDoCliente == null){
            System.out.println("Nenhum Cliente encontrado");
            System.out.println("Tente novamente...");

            LoginDoCliente();
        } else {
            System.out.println("Login realizado...");
            System.out.println("Seja bem vindo " + nomeDoCliente);
        }
    }
}
