package test;

import BD.MateriaBD;
import BD.UsuarioBD;
import Entidades.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class InscripcionTDD {

    //@Test
    //public void consultaProfesor(){
    //    UsuarioBD usuarioBD=new UsuarioBD();
    //    usuarioBD.insertar(new Usuario(null, "Diego", "Perez","123", "Profesor"));
    //    Usuario usuario=usuarioBD.buscarPorLegajo("123");
    //    assertEquals("123", usuario.getLegajo());
    //}

    @Test
    public void consultaAlumno(){
        UsuarioBD usuarioBD=new UsuarioBD();
        usuarioBD.insertar(new Alumno(0, "Omar", "Gomez","omar.gomez@gmail.com", "1111"));
        Usuario omar = usuarioBD.buscarPorMail("omar.gomez@gmail.com");
        //Usuario usuario=usuarioBD.buscarPorLegajo(omar.getLegajo());
        assertEquals("1111", omar.getPassword());

    }

    @Test
    public void  consultaMateri(){
        MateriaBD materiaBD = new MateriaBD();
        materiaBD.insertar(new Materia(null, "Matematica", 32, 12,  "Lunes de 8 a 12, Miercoles de 12 a 16, Viernes de 10 a 14", 214));
        Materia matematica = materiaBD.buscarPorNombre("Matematica");
        assertEquals("Matematica", matematica.getNombre());
    }




    }



