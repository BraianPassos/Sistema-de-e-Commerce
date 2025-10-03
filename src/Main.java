import cliente.area.cadastro.CadastroDeUsuario;
import cliente.area.cliente.Cliente;
import cliente.area.login.Login;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        apresentacao();

    }

    public static void apresentacao(){
        var scanner = new Scanner(System.in);

        System.out.println("Bem-Vindo ao Sistema BOP");
        System.out.println("1-Login\n2-Registro\n0-Sair");
        System.out.print("Escolha: ");
        int escolhaInicial = scanner.nextInt();
        int controlador = 0;

        while(controlador == 0){
            switch (escolhaInicial){
                case 1:
                    var login = new Login();
                    //Pesquisa do cliente
                    System.out.println("Login...");
                    controlador = 1;
                    break;
                case 2:
                    var cadastro = new CadastroDeUsuario();
                    System.out.println("Loading...");
                    //Código de Cadastro
                    pegandoDadosDeCadastro();
                    controlador = 1;
                    break;
                case 0:
                    //encerrar programa
                    System.exit(0);
                    break;
                default:
                    System.out.println("Erro...\nEscolha novamente...");
                    escolhaInicial = scanner.nextInt();

            }

        }
    }

    public static void pegandoDadosDeCadastro(){
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

        CadastroDeUsuario cadastro = new CadastroDeUsuario();
        cadastro.cadastrandoCliente(usuario);

        System.out.println("Cadastrando Concluído...\n\n\n\n\n\n\n\n");

        //casdastro.imprimindoCadastrosAtivos();
    }
}