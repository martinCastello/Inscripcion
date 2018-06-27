package test;

import BD.*;
import Servicios.*;
import Entidades.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class InscripcionTDD {
    private ServiciosAlumno aluServ= new ServiciosAlumno();
    private ServiciosProfesor profServ= new ServiciosProfesor();

    @Before
    public void setUp(){
        ConectorBD conectorBD = new ConectorBD();
        conectorBD.createAll();

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

    @Test
    public void login(){
        ProfesorBD profesorBD=new ProfesorBD();
        profesorBD.insertar(new Profesor(0, "Diego", "Perez",121,"diego@gmail.com", "1111"));

        AlumnoBD alumnoBD =new AlumnoBD();
        alumnoBD.insertar(new Alumno(0, "Omar", "Gomez",123,1, "omar.gomez@gmail.com","1110"));

        profServ.logIn(121,"1111", "profesor");

        aluServ.logIn(123,"1110","alumno");

        assert (profServ.validation());
        assert (aluServ.validation());

    }

    @Test
    public void inscripcion_De_alumno_loggeado(){
        ProfesorBD profesorBD=new ProfesorBD();
        Profesor prof= new Profesor(0, "Diego", "Perez",121,"diego@gmail.com", "1111");
        profesorBD.insertar(prof);
        int idprof= profesorBD.buscarPorLegajo(121).getId();

        Materia materia= new Materia(0, "OOP1", 23);
        MateriaBD materiaBD= new MateriaBD();
        materiaBD.insertar(materia);
        int idmat= materiaBD.buscarPorNombre("OOP1").getId();

        Cursadas cursada= new Cursadas(0,"martes de 12 a 15", idmat,"32", 40,idprof);
        CursadasBD cdb= new CursadasBD();
        cdb.insertar(cursada);
        int idcursada= cdb.buscarPorIdMateria(idmat).getId();


        AlumnoBD alumnoBD= new AlumnoBD();
        Alumno alumno= new Alumno(0, "Omar", "Gomez",123,1, "omar.gomez@gmail.com","1110");
        alumnoBD.insertar(alumno);
        int idalu= alumnoBD.buscarPorLegajo(123).getId();

        aluServ.logIn(123,"1110","alumno");


        aluServ.inscribirACursada(idalu,idcursada);

        InscripcionesBD insc= new InscripcionesBD();

        Inscripciones i= insc.buscar(idalu);

        assertEquals(i.getCursada_id(), idcursada);

    }
}