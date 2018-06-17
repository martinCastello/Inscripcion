package BD;

import Entidades.Alumno;
import Entidades.Profesor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoBD {
    ConectorBD cc = new ConectorBD();
    Connection cn = cc.ConectarBD();

    public void insertar(Alumno alumno) {
        try{
            PreparedStatement pstat = cn.prepareStatement("INSERT INTO alumno(id, nombre, apellido, legajo, regular, mail, password) VALUES (?,?,?,?,?,?,?)");

            pstat.setString(1, null);
            pstat.setString(2, alumno.getNombre());
            pstat.setString(3, alumno.getApellido());
            pstat.setInt(4, alumno.getLegajo());
            pstat.setInt(5, alumno.getRegular());
            pstat.setString(6, alumno.getMail());
            pstat.setString(7, alumno.getPassword());

            //Se ejecuta el query de envío de datos
            pstat.execute();

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public Alumno buscarPorLegajo(int legajo){
        Alumno alumno=null;
        try {
            PreparedStatement pstat = cn.prepareStatement("SELECT * FROM  alumno WHERE legajo=?");

            pstat.setInt(1, legajo);
            ResultSet rs = pstat.executeQuery();

            while (rs.next()) {
                alumno = new Alumno(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getInt("legajo"),
                            rs.getInt("regular"),
                            rs.getString("mail"),
                            rs.getString("password"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return alumno;
    }

    public Alumno buscarPorMail(String mail){
        Alumno alumno=null;
        try {
            PreparedStatement pstat = cn.prepareStatement("SELECT * FROM  alumno WHERE mail=?");

            pstat.setString(1, mail);
            ResultSet rs = pstat.executeQuery();

            while (rs.next()) {
                alumno = new Alumno(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getInt("legajo"),
                            rs.getInt("regular"),
                            rs.getString("mail"),
                            rs.getString("password"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return alumno;
    }

    public void createAlumnos(){

        List<Alumno> alumnos=new ArrayList<Alumno>();

        alumnos.add(new Alumno(0,"Omar","Gomez", 001,1,"ogomez@unq.com","ogomez"));


        for (Alumno alumno:alumnos) {
            this.insertar(alumno);
        }
    }

}
