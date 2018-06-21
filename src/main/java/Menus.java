import BD.*;
import Entidades.*;

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
                    this.clearScreen();
                    this.menuPrincipal();
                    System.out.println("Opción invalida, reintente.");

                    break;
        }

    }

    public void menuPrincipalProfesores(){

        //***********************PROVISIORIO*************************//
        ProfesorBD profesorBD=new ProfesorBD();
        //**********************************************************//

        System.out.println (
                "Menu profesores: \n" +
                        "1- Ver cursadas asignadas. \n" +
                        "2- Menu principal.");

        //Invocamos un método sobre un objeto Scanner
        String entradaTeclado = entradaEscaner.nextLine ();

        switch (entradaTeclado){
            case "1":
                this.clearScreen();
                this.menuListarCursadas(profesorBD.buscarPorMail("dperez@unq.com"));
                break;
            case "2":
                this.clearScreen();
                this.menuPrincipal();
                break;
            default:
                this.clearScreen();
                this.menuPrincipalProfesores();
                System.out.println("Opción invalida, reintente. \n");
                break;
        }
    }

    private void menuListarCursadas(Profesor profesor) {
        CursadasBD cursadasBD=new CursadasBD();
        MateriaBD materiaBD=new MateriaBD();

        System.out.println ("Cusadas de "+profesor.getNombre()+" "+profesor.getApellido()+":  \n ");

        for (Cursadas cursada: cursadasBD.buscarPorProfesor(profesor.getId())) {
            System.out.println(cursada.getId() + " - "
                    + materiaBD.buscarPorID(cursada.getMateria_id()).info() + ", "
                    + cursada.getDias_y_horarios() + ". ");
        }

        System.out.println ("Presione intro para volver.  \n ");

        //Invocamos un método sobre un objeto Scanner
        String entradaTeclado = entradaEscaner.nextLine ();

        this.clearScreen();
        this.menuPrincipalProfesores();



    }

    public void menuPrincipalInscripcion(){
        CursadasBD cursadasBD=new CursadasBD();
        MateriaBD materiaBD=new MateriaBD();

        System.out.println ("Seleccione una de las siguientes cursadas: \n");

        for (Cursadas cursada: cursadasBD.listar()) {
            System.out.println(cursada.getId() + " - "
                    + materiaBD.buscarPorID(cursada.getMateria_id()).info() + ", "
                    + cursada.getDias_y_horarios() + ". ");
        }

        //***********************PROVISIORIO*************************//
        AlumnoBD alumnoBD=new AlumnoBD();
        Alumno alumno=alumnoBD.buscarPorMail("ogomez@unq.com");
        //***********************************************************//

        //Invocamos un método sobre un objeto Scanner
        String entradaTeclado = entradaEscaner.nextLine ();
        Integer entrada=Integer.parseInt(entradaTeclado);

        if(entrada.intValue()>0&&entrada.intValue()<=cursadasBD.listar().size()){
            InscripcionesBD inscripcionesBD=new InscripcionesBD();
            inscripcionesBD.insertar(new Inscripciones(0,alumno.getId(),entrada.intValue()));
            Cursadas cursada=cursadasBD.buscarPorID(entrada.intValue());

            this.clearScreen();
            System.out.println("Te inscribiste en "+materiaBD.buscarPorID(cursada.getMateria_id()).info() + ", "
                    + cursada.getDias_y_horarios() +". \n");
            this.menuPrincipal();
        }
        else{
            this.clearScreen();
            System.out.println("Opción invalida, reintente. \n");
            this.menuPrincipalInscripcion();

        }
    }


    public void clearScreen() {
            for(int i=0;i<50;i++){
                System.out.print(" \n");
            }


    }

}
