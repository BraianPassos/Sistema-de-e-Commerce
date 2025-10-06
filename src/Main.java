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

        System.out.println("Bem-Vindo ao Sistema BBOP");
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
                    cadastro.formularioDeCadastro();
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

}