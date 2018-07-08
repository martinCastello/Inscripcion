package BD;

import Entidades.Alumno;
import Entidades.Historial;
import Entidades.Materia;
import Entidades.Historial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistorialDB {
    ConectorBD cc = ConectorBD.getInstance();
        

    public void insertar(Historial historial) {
        Connection cn = cc.ConectarBD();
        try{
            PreparedStatement pstat = cn.prepareStatement("INSERT INTO historial(id, alumno_id, cursada_id, promedio, fecha) VALUES (?,?,?,?,?)");

            pstat.setString(1, null);
            pstat.setInt(2, historial.getAlumno_id());
            pstat.setInt(3, historial.getCursada_id());
            pstat.setFloat(4, historial.getPromedio());
            pstat.setString(5, historial.getFecha());

            //Se ejecuta el query de envío de datos
            pstat.execute();

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        cc.desconectar();

    }

    public Historial buscarPorId(int id){
        Connection cn = cc.ConectarBD();
        Historial historial=null;
        try {
            PreparedStatement pstat = cn.prepareStatement("SELECT * FROM  historial WHERE id=?");

            pstat.setInt(1, id);
            ResultSet rs = pstat.executeQuery();

            while (rs.next()) {
                historial = new Historial(
                        rs.getInt("id"),
                        rs.getInt("alumno_id"),
                        rs.getInt("cursada_id"),
                        rs.getFloat("promedio"),
                        rs.getString("fecha"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        cc.desconectar();

        return historial;
    }

    public List<Historial> buscarPorAlumnoId(int alumno_id){
        Connection cn = cc.ConectarBD();

        List<Historial> historiales=new ArrayList<>();
        try {
            PreparedStatement pstat = cn.prepareStatement("SELECT * FROM  historial WHERE alumno_id=?");

            pstat.setInt(1, alumno_id);
            ResultSet rs = pstat.executeQuery();

            while (rs.next()) {
                Historial historial = new Historial(
                        rs.getInt("id"),
                        rs.getInt("alumno_id"),
                        rs.getInt("cursada_id"),
                        rs.getFloat("promedio"),
                        rs.getString("fecha"));
                historiales.add(historial);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        cc.desconectar();

        return historiales;
    }

    public List<Historial> buscarPorMateriaId(int materia_id){
        Connection cn = cc.ConectarBD();

        List<Historial> historiales=new ArrayList<>();
        try {
            PreparedStatement pstat = cn.prepareStatement("SELECT * FROM  historial WHERE materia_id=?");

            pstat.setInt(1, materia_id);
            ResultSet rs = pstat.executeQuery();

            while (rs.next()) {
                Historial historial = new Historial(
                        rs.getInt("id"),
                        rs.getInt("alumno_id"),
                        rs.getInt("cursada_id"),
                        rs.getFloat("promedio"),
                        rs.getString("fecha"));
                historiales.add(historial);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        cc.desconectar();

        return historiales;
    }

    public List<Historial> buscarPorMateriaIDYAlumnoID(int materia_id, int alumno_id){
        Connection cn = cc.ConectarBD();

        List<Historial> historiales=new ArrayList<>();
        try {
            PreparedStatement pstat = cn.prepareStatement("SELECT * FROM  historial WHERE materia_id=? AND alumno_id=?");

            pstat.setInt(1, materia_id);
            pstat.setInt(2, alumno_id);

            ResultSet rs = pstat.executeQuery();

            while (rs.next()) {
                Historial historial = new Historial(
                        rs.getInt("id"),
                        rs.getInt("alumno_id"),
                        rs.getInt("cursada_id"),
                        rs.getFloat("promedio"),
                        rs.getString("fecha"));
                historiales.add(historial);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        cc.desconectar();

        return historiales;
    }

    public void createHistorial(){
        Connection cn = cc.ConectarBD();


        List<Historial> historiales=new ArrayList<Historial>();

        historiales.add(new Historial(0,1,1, 6,"06/2018"));//Matematica I
        historiales.add(new Historial(0,1,3, 6,"06/2018"));//Matematica II
        historiales.add(new Historial(0,1,5, 6,"12/2017"));//Objetos I
        historiales.add(new Historial(0,1,7, 6,"12/2017"));//Objetos II

        historiales.add(new Historial(0,2,1, 6,"06/2018"));//Matematica I
        historiales.add(new Historial(0,2,9, 6,"12/2017"));//Base de Datos

        for (Historial historial:historiales) {
            this.insertar(historial);
        }

        cc.desconectar();
    }

}
