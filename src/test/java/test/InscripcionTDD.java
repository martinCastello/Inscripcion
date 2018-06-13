package test;

import BD.*;
import Entidades.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class InscripcionTDD {

    @Test
    public void consultaProfesor(){
        ProfesorBD profesorBD=new ProfesorBD();
        profesorBD.insertar(new Profesor(0, "Diego", "Perez",121,"diego@gmail.com", "1111"));
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

    @Test
    public void consultarCursda(){
        MateriaBD materiaBD= new MateriaBD();
        materiaBD.insertar(new Materia(0,"Matematica2",15));
        Materia matematica2= materiaBD.buscarPorNombre("Matematica2");
        CursadasBD cursadasBD= new CursadasBD();
        cursadasBD.insertar(new Cursadas(0,"lunes de 12 a 15",matematica2.getId(),"37B",30,1));
        Cursadas cursada_mat2 = cursadasBD.buscarPorAula("37B");

        assertEquals("lunes de 12 a 15", cursada_mat2.getDias_y_horarios());
        
    }
    @Test
    public  void consultarInscripcion(){
        Materia materia= new Materia(0, "OOP1", 23);
        MateriaBD materiaBD= new MateriaBD();
        materiaBD.insertar(materia);
        AlumnoBD alumnoBD= new AlumnoBD();
        Alumno alumno= new Alumno(0,"pepe","argento",122,0,"pepe@mail","racing");
        alumnoBD.insertar(alumno);

        Materia matBD= materiaBD.buscarPorNombre("OOP1");
        Alumno aluBD= alumnoBD.buscarPorLegajo(122);

        CursadasBD cursadasBD= new CursadasBD();
        cursadasBD.insertar(new Cursadas(0,"lunes de 12 a 15",matBD.getId(),"37B",30,1));
        Cursadas cursada_matBD = cursadasBD.buscarPorAula("37B");

        Inscripciones inscripciones= new Inscripciones(0, aluBD.getId(), cursada_matBD.getId());

        InscripcionesBD inscripcionesBD= new InscripcionesBD();
        inscripcionesBD.insertar(inscripciones);
       Inscripciones i=  inscripcionesBD.buscar(aluBD.getId());



        assertEquals (cursada_matBD.getId(), i.getCursada_id());

    }
        
}



