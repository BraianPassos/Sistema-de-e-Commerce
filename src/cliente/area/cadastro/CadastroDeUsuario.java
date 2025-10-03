package cliente.area.cadastro;
import cliente.area.cliente.Cliente;
import java.util.ArrayList;

public class CadastroDeUsuario {

    ArrayList<Cliente> clientes = new  ArrayList<>();

    public void cadastrandoCliente(Cliente usuario){
        clientes.add(usuario);

    }

    //public void imprimindoCadastrosAtivos(){

    //}
}
