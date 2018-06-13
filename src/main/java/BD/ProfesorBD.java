package BD;

import Entidades.Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfesorBD {
    ConectorBD cc = new ConectorBD();
    Connection cn = cc.ConectarBD();

    public void insertar(Profesor profesor) {
        try{
            PreparedStatement pstat = cn.prepareStatement("INSERT INTO profesor (id, nombre, apellido,legajo, mail, password) VALUES (?,?,?,?,?,?)");

            pstat.setString(1, null);
            pstat.setString(2, profesor.getNombre());
            pstat.setString(3, profesor.getApellido());
            pstat.setInt(4, profesor.getLegajo());
            pstat.setString(5, profesor.getMail());
            pstat.setString(6, profesor.getPassword());

            //Se ejecuta el query de envío de datos
            pstat.execute();

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public Profesor buscarPorLegajo(int l){
        Profesor profesor=null;
        try {
            PreparedStatement pstat = cn.prepareStatement("SELECT * FROM  profesor WHERE legajo=?");

            pstat.setInt(1, l);
            ResultSet rs = pstat.executeQuery();

            while (rs.next()) {
                profesor = new Profesor(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("legajo"),
                        rs.getString("mail"),
                        rs.getString("password"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return profesor;
    }

    public Profesor buscarPorMail(String mail){
        Profesor profesor=null;
        try {
            PreparedStatement pstat = cn.prepareStatement("SELECT * FROM  profesor WHERE mail=?");

            pstat.setString(1, mail);
            ResultSet rs = pstat.executeQuery();

            while (rs.next()) {
                profesor = new Profesor(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("legajo"),
                        rs.getString("mail"),
                        rs.getString("password"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return profesor;
    }
    
}
