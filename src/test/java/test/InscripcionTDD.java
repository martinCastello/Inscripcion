package test;

import BD.MateriaBD;
import BD.AlumnoBD;
import BD.ProfesorBD;
import Entidades.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class InscripcionTDD {

    @Test
    public void consultaProfesor(){
        ProfesorBD profesorBD=new ProfesorBD();
        profesorBD.insertar(new Profesor(0, "Diego", "Perez","diego@gmail.com", "1111"));
        Profesor profesor=profesorBD.buscarPorMail("diego@gmail.com");

        assertEquals("Diego", profesor.getNombre());
    }

    @Test
    public void consultaAlumno(){
        AlumnoBD alumnoBD =new AlumnoBD();
        alumnoBD.insertar(new Alumno(0, "Omar", "Gomez",123,1, "omar.gomez@gmail.com","1111"));
        Alumno alumno = alumnoBD.buscarPorMail("omar.gomez@gmail.com");

        assertEquals("1111", alumno.getPassword());

    }

    @Test
    public void  consultaMateria(){
        MateriaBD materiaBD = new MateriaBD();
        materiaBD.insertar(new Materia(0, "Matematica", 32));
        Materia matematica = materiaBD.buscarPorNombre("Matematica");

        assertEquals("Matematica", matematica.getNombre());
    }




    }



