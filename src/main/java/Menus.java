import BD.*;
import Entidades.*;

import Servicios.ServiciosAlumno;
import Servicios.ServiciosProfesor;
import Servicios.ServiciosUsuario;


import java.util.Scanner;

public class Menus {

    public void menuPrincipal() throws Exception {
        Scanner entradaEscaner = new Scanner(System.in);
        System.out.println (
                "Bienvenido a Inscripción. \n" +
                "Ingrese una opción y presione intro: \n" +
                    "1-Alumno. \n" +
                    "2-Profesor. \n" +
                    "3-Salir.");

        //Invocamos un método sobre un objeto Scanner
        String entradaTeclado = entradaEscaner.nextLine ();

        switch (entradaTeclado){
            case "1":
                this.clearScreen();
                this.menuLoginAlumno();
                break;
            case "2":
                this.clearScreen();
                this.menuLoginProfesor();
                //this.menuPrincipalProfesores();
                break;
            case "3":
                this.clearScreen();
                System.out.println("Adios.");
                break;
            default:
                this.clearScreen();
                System.out.println("Opción invalida, reintente.\n");
                this.menuPrincipal();
                break;
        }

    }

    private void menuLoginProfesor() throws Exception {
        Scanner entradaEscaner = new Scanner(System.in);
        Scanner entradaEscaner2 = new Scanner(System.in);
        ServiciosProfesor service = new ServiciosProfesor();
        System.out.println (
                "Iniciar Sesión: \n" +
                        "\nUsuario: ");

        //Invocamos un método sobre un objeto Scanner
        int legajo = entradaEscaner.nextInt();

        System.out.println (
                "\nIngrese la contraseña: ");

        String clave = entradaEscaner2.nextLine();

        Profesor profesor = service.logIn(legajo, clave);
        if(profesor != null){
            this.menuPrincipalProfesores();
        }else{
            System.out.println("Usuario/Password Incorrectas \n\n");
            this.menuLoginProfesor();
        }
    }

    private void menuLoginAlumno() throws Exception {
        Scanner entradaEscaner = new Scanner(System.in);
        Scanner entradaEscaner2 = new Scanner(System.in);
        ServiciosAlumno service = new ServiciosAlumno();
        System.out.println (
                "Iniciar Sesión: \n" +
                        "\nUsuario: ");

        //Invocamos un método sobre un objeto Scanner
        int legajo = entradaEscaner.nextInt();

        System.out.println (
                        "\nIngrese la contraseña: ");

        String clave = entradaEscaner2.nextLine();

        Alumno alumno = service.logIn(legajo, clave);
        if(alumno != null){
            this.menuPrincipalAlumnos(alumno);
        }else{
            System.out.println("Usuario/Password Incorrectas \n\n");
            this.menuLoginAlumno();
        }

    }

    public void menuPrincipalProfesores() throws Exception {
        Scanner entradaEscaner = new Scanner(System.in);

        //***********************PROVISIORIO*************************//
        ProfesorBD profesorBD=new ProfesorBD();
        //**********************************************************//

        System.out.println (
                "Menu profesores: \n" +
                        "1- Ver cursadas asignadas. \n" +
                        "2- Ver alumnos por curso. \n" +
                        "3- Menu principal.");


        //Invocamos un método sobre un objeto Scanner
        String entradaTeclado = entradaEscaner.nextLine();

        switch (entradaTeclado){
            case "1":
                this.clearScreen();
                this.menuListarCursadas(profesorBD.buscarPorMail("dperez@unq.com"));
                break;
            case "2":
                this.clearScreen();
                this.menuListarAlumnos(profesorBD.buscarPorMail("dperez@unq.com"));
                break;
            case "3":
                this.clearScreen();
                this.menuPrincipal();
                break;
            default:
                this.clearScreen();
                System.out.println("Opción invalida, reintente. \n");
                this.menuPrincipalProfesores();
                break;
        }
    }

    public void menuPrincipalAlumnos(Alumno alumno) throws Exception {

        Scanner entradaEscaner = new Scanner(System.in);

        //***********************PROVISIORIO*************************//
        //AlumnoBD alumnoBD=new AlumnoBD();
        //Alumno alumno=alumnoBD.buscarPorId(1);
        //**********************************************************//

        System.out.println (
                "Menu alumnos: \n" +
                        "1- Ver foja. \n" +
                        "2- Materias recomendadas. \n" +
                        "3- Inscripción. \n" +
                        "4- Menu principal.");


        //Invocamos un método sobre un objeto Scanner
        String entradaTeclado = entradaEscaner.nextLine ();

        switch (entradaTeclado){
            case "1":
                this.clearScreen();
                this.menuMostrarFoja(alumno);
                break;
            case "2":
                this.clearScreen();
                this.menuMateriasRecomendadas(alumno);
                break;
            case "3":
                this.clearScreen();
                this.menuPrincipalInscripcion();
                break;
            case "4":
                this.clearScreen();
                this.menuPrincipal();
                break;
            default:
                this.clearScreen();
                System.out.println("Opción invalida, reintente. \n");
                this.menuPrincipalAlumnos(alumno);
                break;
        }
    }

    private void menuMateriasRecomendadas(Alumno alumno) throws Exception {
        Scanner entradaEscaner = new Scanner(System.in);
        System.out.println("Materias recomendadas:\n");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - \n");
        alumno.getFoja().generarMateriasAprobadas(alumno);
        MateriaBD materiaBD=new MateriaBD();
       for(Materia materia:materiaBD.listar()){
            if(materia.esRecomenada(alumno)){
                System.out.println(materia.getNombre()+".\n");

            }

        }
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - \n");

        System.out.println ("Presione intro para volver\n");

        //Invocamos un método sobre un objeto Scanner
        entradaEscaner.nextLine ();
        this.clearScreen();
        this.menuPrincipalAlumnos(alumno);
    }

    private void menuMostrarFoja(Alumno alumno) throws Exception {
        Scanner entradaEscaner = new Scanner(System.in);
        System.out.println("Foja del alumno " +alumno.getNombre()+" "+alumno.getApellido()+", legajo: "+alumno.getLegajo() +"\n");
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - \n");
        alumno.getFoja().generarHistorial();
        if(alumno.getFoja().getHistorial().size()>0) {
            CursadasBD cursadasBD=new CursadasBD();
            MateriaBD materiaBD=new MateriaBD();

            for (Historial historial : alumno.getFoja().getHistorial()) {
                Cursadas cursadas=cursadasBD.buscarPorID(historial.getCursada_id());
                Materia materia=materiaBD.buscarPorID(cursadas.getMateria_id());

                System.out.println("Materia: "+materia.getNombre()+" - Promedio: "+historial.getPromedio()+ " - Fecha: "+historial.getFecha()+"\n");
            }
        }else{
            System.out.println("Foja vacia. \n");
        }
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - \n");
        System.out.println("Presione intro para volver \n");
        //Invocamos un método sobre un objeto Scanner
        entradaEscaner.nextLine ();
        this.clearScreen();
        this.menuPrincipalAlumnos(alumno);

    }

    private void menuListarCursadas(Profesor profesor) throws Exception {
        Scanner entradaEscaner = new Scanner(System.in);
        CursadasBD cursadasBD=new CursadasBD();
        MateriaBD materiaBD=new MateriaBD();
        System.out.println ("Cursadas de "+profesor.getNombre()+" "+profesor.getApellido()+":  \n ");

        for (Cursadas cursada: cursadasBD.buscarPorProfesor(profesor.getId())) {
            System.out.println(cursada.getId() + " - "
                    + materiaBD.buscarPorID(cursada.getMateria_id()).info() + ", "
                    + cursada.getDias_y_horarios() + ". ");
        }

        System.out.println ("Presione intro para volver.  \n ");

        //Invocamos un método sobre un objeto Scanner
        entradaEscaner.nextLine ();

        this.clearScreen();
        this.menuPrincipalProfesores();


    }

    private void menuListarAlumnos(Profesor profesor) throws Exception {
        Scanner entradaEscaner = new Scanner(System.in);
        CursadasBD cursadasBD=new CursadasBD();
        MateriaBD materiaBD=new MateriaBD();
        InscripcionesBD inscripcionesBD = new InscripcionesBD();
        AlumnoBD alumnoBD = new AlumnoBD();

        System.out.println ("Cursos del profesor "+profesor.getNombre()+" "+profesor.getApellido()+":  \n ");

        for (Cursadas cursada: cursadasBD.buscarPorProfesor(profesor.getId())) {
            System.out.println(cursada.getId() + " - "
                    + materiaBD.buscarPorID(cursada.getMateria_id()).info() + ", "
                    + cursada.getDias_y_horarios() + ". ");
            System.out.println("    Alumnos: ");
            for(int alumno_id: inscripcionesBD.buscarIDAlumnos(cursada.getId())) {
                Alumno alumno = alumnoBD.buscarPorId(alumno_id);
                System.out.println("             " + alumno.getNombre() + " "
                        + alumno.getApellido() + ", "
                        + "Legajo: " + alumno.getLegajo() + ". " + "\n");
            }
        }

        System.out.println ("Presione intro para volver.  \n ");

        //Invocamos un método sobre un objeto Scanner
        entradaEscaner.nextLine ();

        this.clearScreen();
        this.menuPrincipalProfesores();



    }

    public void menuPrincipalInscripcion() throws Exception {
        Scanner entradaEscaner = new Scanner(System.in);
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
        Integer entrada = 0;
        try{
            entrada=Integer.parseInt(entradaTeclado);
            if(entrada.intValue()>0&&entrada.intValue()<=cursadasBD.listar().size()){
                //InscripcionesBD inscripcionesBD=new InscripcionesBD();
                //inscripcionesBD.insertar(new Inscripciones(0,alumno.getId(),entrada.intValue()));
                Cursadas cursada=cursadasBD.buscarPorID(entrada.intValue());
                Materia materia = materiaBD.buscarPorID(cursada.getMateria_id());
                ServiciosAlumno serviceAlumno = new ServiciosAlumno();
                serviceAlumno.inscribirACursada(alumno.getId(), entrada.intValue());

                this.clearScreen();
                System.out.println("Te inscribiste en "+materia.info() + ", "
                        + cursada.getDias_y_horarios() +". \n");
                this.menuPrincipalAlumnos(alumno);
            }
            else{
                this.clearScreen();
                System.out.println("Opción invalida, se vuelve al menu principal. \n");
                this.menuPrincipalAlumnos(alumno);
            }
        }catch(Exception e){
            this.clearScreen();
            System.out.println("Opción invalida, se vuelve al menu principal. \n");
            this.menuPrincipalAlumnos(alumno);
        }
    }

    public void clearScreen() {
            for(int i=0;i<50;i++){
                System.out.print(" \n");
            }
    }

}
