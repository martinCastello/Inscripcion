package test;

import BD.UsuarioBD;
import Entidades.Usuario;
import org.junit.Test;

import static org.junit.Assert.*;

public class InscripcionTDD {

    @Test
    public void consultaProfesor(){
        UsuarioBD usuarioBD=new UsuarioBD();
        usuarioBD.insertar(new Usuario(null, "Diego", "Perez","123", "Profesor"));
        Usuario usuario=usuarioBD.buscarPorLegajo("123");
        assertEquals("123", usuario.getLegajo());

    }
    @Test
    public void consultaAlumno(){
        UsuarioBD usuarioBD=new UsuarioBD();
        usuarioBD.insertar(new Usuario(null, "Omar", "Gomez","456", "Alumno"));
        Usuario usuario=usuarioBD.buscarPorLegajo("456");
        assertEquals("456", usuario.getLegajo());

    }



    }



