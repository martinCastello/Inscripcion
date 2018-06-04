import BD.UsuarioBD;
import Entidades.Usuario;

public class Main {

    public static void main (String [ ] args) {
        System.out.println ("Empezamos la ejecución del programa");
        UsuarioBD usuarioBD=new UsuarioBD();
        //usuarioBD.insertar(new Usuario(null, "Omar", "Gomez","123"));
        Usuario usuario=usuarioBD.buscarPorLegajo("123");
        System.out.println ("Usuario: "+usuario.toString());
        System.out.println ("Finalizamos la ejecución del programa");

    }
}
