package BD;

import Entidades.Cursadas;
import Entidades.Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfesorBD {
    ConectorBD cc = ConectorBD.getInstance();

    public void insertar(Profesor profesor) {
        Connection cn = cc.ConectarBD();

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
        cc.desconectar();

    }


   public Profesor buscarPorLegajo(int legajo){
       Connection cn = cc.ConectarBD();

       Profesor profesor=null;
       try {
            PreparedStatement pstat = cn.prepareStatement("SELECT * FROM  profesor WHERE legajo=?");

            pstat.setInt(1, legajo);

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
       cc.desconectar();

        return profesor;
    }



    public Profesor buscarPorMail(String mail){
        Connection cn = cc.ConectarBD();

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
        cc.desconectar();

        return profesor;
    }

    public void createProfesores(){
        Connection cn = cc.ConectarBD();


        List<Profesor> profesores=new ArrayList<Profesor>();

        profesores.add(new Profesor(0,"Diego","Perez", 001,"dperez@unq.com","dperez"));
        profesores.add(new Profesor(0,"Carlos","Gomez", 002,"cgomez@unq.com","cgomez"));
        profesores.add(new Profesor(0,"Jose","Fernanadez", 003,"jernanadez@unq.com","jernanadez"));
        profesores.add(new Profesor(0,"Manuel","Gonzalez", 004,"mgonzalez@unq.com","mgonzalez"));
        profesores.add(new Profesor(0,"Pedro","Lopez", 005,"plopez@unq.com","plopez"));


        for (Profesor profesor:profesores) {
            this.insertar(profesor);
        }
        cc.desconectar();

    }
    
}
