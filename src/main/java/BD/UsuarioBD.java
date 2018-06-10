package BD;

import Entidades.Alumno;
import Entidades.Usuario;

import java.sql.*;

public class UsuarioBD {
    ConectorBD cc = new ConectorBD();
    Connection cn = cc.ConectarBD();

    public void insertar(Alumno usuario) {
        try{
            PreparedStatement pstat = cn.prepareStatement("INSERT INTO usuario(legajo, nombre, apellido, mail, password, perfil) VALUES (?,?,?,?,?,?)");

            pstat.setString(1, null);
            pstat.setString(2, usuario.getNombre());
            pstat.setString(3, usuario.getApellido());
            pstat.setString(4, usuario.getMail());
            pstat.setString(5, usuario.getPassword());
            pstat.setString(6, usuario.getPefil());

            //Se ejecuta el query de envío de datos
            pstat.execute();

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public Usuario buscarPorLegajo(int legajo){
        Usuario usuario=null;
        try {
            PreparedStatement pstat = cn.prepareStatement("SELECT * FROM  usuario WHERE legajo=?");

            pstat.setInt(1, legajo);
            ResultSet rs = pstat.executeQuery();

            while (rs.next()) {
                if(rs.getString("perfil").equalsIgnoreCase("Alumno")) {
                    usuario = new Alumno(rs.getInt("legajo"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("mail"),
                            rs.getString("password"));
                }else{
//                    usuario = new Docente(rs.getString("legajo"),
//                            rs.getString("nombre"),
//                            rs.getString("apellido"),
//                            rs.getString("legajo"));
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return usuario;
    }

    public Usuario buscarPorMail(String mail){
        Usuario usuario=null;
        try {
            PreparedStatement pstat = cn.prepareStatement("SELECT * FROM  usuario WHERE mail=?");

            pstat.setString(1, mail);
            ResultSet rs = pstat.executeQuery();

            while (rs.next()) {
                if(rs.getString("perfil").equalsIgnoreCase("Alumno")) {
                    usuario = new Alumno(rs.getInt("legajo"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("mail"),
                            rs.getString("password"));
                }else{
//                    usuario = new Docente(rs.getString("legajo"),
//                            rs.getString("nombre"),
//                            rs.getString("apellido"),
//                            rs.getString("legajo"));
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return usuario;
    }
}
