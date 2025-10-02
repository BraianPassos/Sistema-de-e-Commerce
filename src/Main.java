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
        int escolhaInicial = scanner.nextInt();
        switch (escolhaInicial){
            case 1:
            var login = new Login();

        }
    }
}