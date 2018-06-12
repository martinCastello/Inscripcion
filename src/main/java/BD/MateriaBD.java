package BD;

import Entidades.Materia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MateriaBD {
    ConectorBD cc = new ConectorBD();
    Connection cn = cc.ConectarBD();

    public void insertar(Materia materia) {
        try{

            PreparedStatement pstat = cn.prepareStatement("INSERT INTO materia(id, nombre, carga_horaria) VALUES (?,?,?)");

            pstat.setString(1, null);
            pstat.setString(2, materia.getNombre());
            pstat.setInt(3, materia.getCarga_horaria());

            //Se ejecuta el query de envío de datos
            pstat.execute();

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public Materia buscarPorNombre(String nombre){
        Materia materia=null;
        try {
            PreparedStatement pstat = cn.prepareStatement("SELECT * FROM  materia WHERE nombre=?");

            pstat.setString(1, nombre);
            ResultSet rs = pstat.executeQuery();
            while (rs.next()) {
                materia = new Materia(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("carga_horaria")
                        );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return materia;
    }

}
