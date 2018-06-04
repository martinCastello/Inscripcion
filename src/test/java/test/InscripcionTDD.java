package test;

import BD.UsuarioBD;
import Entidades.Usuario;
import org.junit.Test;

import static org.junit.Assert.*;

public class PackmanTDD {

    @Test
    public void consultaUsuarioPorLegajo(){
        UsuarioBD usuarioBD=new UsuarioBD();
        Usuario usuario=usuarioBD.buscarPorLegajo("123");
        assertEquals("123", usuario.getLegajo());

    }



    }


}
