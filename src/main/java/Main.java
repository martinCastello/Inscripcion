import BD.*;

public class Main {

    public static void main(String[] args) {

        ConectorBD conectorBD = new ConectorBD();
        conectorBD.createAll();

        MateriaBD materiaBD=new MateriaBD();
        materiaBD.createMaterias();

        ProfesorBD profesorBD=new ProfesorBD();
        profesorBD.createProfesores();

        CursadasBD cursadasBD=new CursadasBD();
        cursadasBD.createCursadas();

        AlumnoBD alumnoBD=new AlumnoBD();
        alumnoBD.createAlumnos();

        Menus menus = new Menus();
        menus.menuPrincipal();


    }

}

