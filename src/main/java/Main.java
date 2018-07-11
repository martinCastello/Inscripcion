import BD.*;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {

        ConectorBD conectorBD = ConectorBD.getInstance();
        conectorBD.createAll();

        MateriaBD materiaBD=new MateriaBD();
        materiaBD.createMaterias();

        ProfesorBD profesorBD=new ProfesorBD();
        profesorBD.createProfesores();

        CursadasBD cursadasBD=new CursadasBD();
        cursadasBD.createCursadas();

        AlumnoBD alumnoBD=new AlumnoBD();
        alumnoBD.createAlumnos();

        HistorialDB historialDB=new HistorialDB();
        historialDB.createHistorial();

        CorrelativasBD correlativasBD=new CorrelativasBD();
        correlativasBD.createCorrelativas();

        Menus menus = new Menus();
        menus.menuPrincipal();

        //Lanterna menus = new Lanterna();

        //Ventana menus = new Ventana();
        //menus.setTitle("Bienvenido a UNQ");
        //menus.setSize(800, 600);
        //menus.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //menus.setVisible(true);

    }

}

