import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Creación de un objeto Scanner
        Scanner entradaEscaner = new Scanner(System.in);
        Menus menus = new Menus();
        menus.menuPrincipal();
        //Invocamos un método sobre un objeto Scanner
        String entradaTeclado = entradaEscaner.nextLine ();
    }

}
