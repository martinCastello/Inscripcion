package test;

import BD.UsuarioBD;
import Entidades.Usuario;
import org.junit.Test;

import static org.junit.Assert.*;

public class InscripcionTDD {

    @Test
    public void consultaUsuarioPorLegajo(){
        UsuarioBD usuarioBD=new UsuarioBD();
        usuarioBD.insertar(new Usuario(null, "Omar", "Gomez","123"));
        Usuario usuario=usuarioBD.buscarPorLegajo("123");
        assertEquals("123", usuario.getLegajo());

    }



    }



