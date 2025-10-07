package cliente.area.login;
import cliente.area.cadastro.CadastroDeUsuario;
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
        CadastroDeUsuario cadastro = new CadastroDeUsuario();

        System.out.println("Digite seu email: ");
        String email = scanner.nextLine();
        System.out.println("Digite seu senha: ");
        String senha = scanner.nextLine();

        String nomeDoCliente = buscandoCliente(email, senha);
        if (nomeDoCliente == null){
            System.out.println("Nenhum Cliente encontrado");
            System.out.println("Tente novamente...");

            System.out.println("\nNão Possui conta?\n0 - Realizar Cadastro\n1 - Realizar login");
            System.out.print("DIgite seu opcao: ");
            int escolha = scanner.nextInt();
            if (escolha == 0) {
                cadastro.formularioDeCadastro();
            } else {
                LoginDoCliente();
            }
        } else {
            System.out.println("Login realizado...");
            System.out.println("Seja bem vindo " + nomeDoCliente);
        }
    }
}
