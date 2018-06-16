import BD.CursadasBD;
import BD.MateriaBD;
import BD.ProfesorBD;

public class Main {

    public static void main(String[] args) {

        MateriaBD materiaBD=new MateriaBD();
        materiaBD.createMaterias();

        ProfesorBD profesorBD=new ProfesorBD();
        profesorBD.createProfesores();

        CursadasBD cursadasBD=new CursadasBD();
        cursadasBD.createCursadas();

        Menus menus = new Menus();
        menus.menuPrincipal();


    }

}

