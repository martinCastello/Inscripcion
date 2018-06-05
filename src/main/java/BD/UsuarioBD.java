package BD;

import Entidades.Usuario;

import java.sql.*;

public class UsuarioBD {
    ConectorBD cc = new ConectorBD();
    Connection cn = cc.ConectarBD();

    public void insertar(Usuario usuario) {
        try{

            PreparedStatement pstat = cn.prepareStatement("INSERT INTO usuario(id, nombre, apellido, legajo, perfil) VALUES (?,?,?,?,?)");

            pstat.setString(1, null);
            pstat.setString(2, usuario.getNombre());
            pstat.setString(3, usuario.getApellido());
            pstat.setString(4, usuario.getLegajo());
            pstat.setString(5, usuario.getPerfil());

            //Se ejecuta el query de envío de datos
            pstat.execute();

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public Usuario buscarPorLegajo(String legajo){
        Usuario usuario=null;
        try {
            PreparedStatement pstat = cn.prepareStatement("SELECT * FROM  usuario WHERE legajo=?");

            pstat.setString(1, legajo);
            ResultSet rs = pstat.executeQuery();
            while (rs.next()) {
                usuario = new Usuario(rs.getString("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("legajo"),
                        rs.getString("perfil"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return usuario;
    }
}
