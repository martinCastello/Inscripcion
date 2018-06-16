import BD.CursadasBD;
import BD.MateriaBD;
import Entidades.Cursadas;

import java.util.Scanner;

public class Menus {

    //Creación de un objeto Scanner
    Scanner entradaEscaner = new Scanner(System.in);

    public void menuPrincipal(){
        System.out.println (
                "Bienvenido a Inscripción. \n" +
                "Ingrese una opción y presione intro: \n" +
                    "1-Inscripción. \n" +
                    "2-Profesores. \n" +
                    "3-Salir.");

        //Invocamos un método sobre un objeto Scanner
        String entradaTeclado = entradaEscaner.nextLine ();

        switch (entradaTeclado){
            case "1":
                this.clearScreen();
                this.menuPrincipalInscripcion();
                break;
            case "2":
                this.clearScreen();
                this.menuPrincipalProfesores();
                break;
            case "3":
                this.clearScreen();
                System.out.println("Adios.");
                break;
                default:
                    System.out.println("Opción invalida, reintente.");
                    break;
        }

    }

    public void menuPrincipalProfesores(){
        CursadasBD cursadasBD=new CursadasBD();
        MateriaBD materiaBD=new MateriaBD();

        System.out.println (
                "Seleccione la una de las siguientes cursadas: \n");

        for (Cursadas cursada: cursadasBD.listar()) {
            System.out.println(cursada.getId()+" - "+materiaBD.buscarPorID(cursada.getMateria_id())+". \n");
        }
    }

    public void menuPrincipalInscripcion(){
        CursadasBD cursadasBD=new CursadasBD();
        MateriaBD materiaBD=new MateriaBD();

        System.out.println (
                "Seleccione la una de las siguientes cursadas: \n");

        for (Cursadas cursada: cursadasBD.listar()) {
            System.out.println(cursada.getId()+" - "+materiaBD.buscarPorID(cursada.getMateria_id())+". \n");
        }
    }


    public void clearScreen() {
            for(int i=0;i<50;i++){
                System.out.print(" \n");
            }


    }

}
