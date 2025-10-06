package cliente.area.cadastro;
import cliente.area.cliente.Cliente;

import java.util.Scanner;

import static cliente.area.cliente.Cliente.clientes;


public class CadastroDeUsuario {

    /*
        Adicionar este array em cliente; fazido
        exportar a classe cliente para ela poder ser usada em outras classes;
        importar a classe cliente para essa classe de cadastro
            após isso criar um método para dicionar o cliente na lista
    */

    public void cadastrandoCliente(Cliente usuario){
        clientes.add(usuario);
    }

    public void formularioDeCadastro(){
        Scanner scanner = new Scanner(System.in);
        Cliente usuario = new Cliente();
        System.out.println("----Formulário de cadastro----");
        System.out.print("Nome: ");
        usuario.setNome(scanner.nextLine());
        System.out.print("CPF: ");
        usuario.setCpf(scanner.nextLine());
        System.out.print("Email: ");
        usuario.setEmail(scanner.nextLine());
        System.out.print("Senha: ");
        usuario.setSenha(scanner.nextLine());
        System.out.println("Deseja aderir ao plano Vip?\nO primeiro mês é gratuito!\nApós o teste é debitado 15 reais mensalmente do seu cartão de crédito\n1-Sim 2-Não");
        int escolhaDePlanoinicial = scanner.nextInt();
        boolean escolha = escolhaDePlanoinicial == 1;
        usuario.setStatusVip(escolha);

        cadastrandoCliente(usuario);

        System.out.println("Cadastrando Concluído...\n\n\n\n\n\n\n\n");

        System.out.println(imprimindoCadastrosAtivos());

    }

    public String imprimindoCadastrosAtivos(){
        var user = clientes.get(0);
        String nome = user.getNome();
        String email = user.getEmail();
        String cpf = user.getCpf();
        String senha = user.getSenha();
        boolean vip = user.isStatusVip();

        String formulario = """
                --------------------
                Nome: %s
                Email: %s
                Senha: %s
                Cpf: %s
                Status: %b
                --------------------
                """;
        return String.format(formulario,nome,email,cpf,senha,vip);
    }
}
