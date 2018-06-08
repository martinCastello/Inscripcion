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

            PreparedStatement pstat = cn.prepareStatement("INSERT INTO materia(id, nombre, cupo, carga_horaria, dias_y_horarios_de_cursadas, nro_aula) VALUES (?,?,?,?,?,?)");

            pstat.setString(1, null);
            pstat.setString(2, materia.getNombre());
            pstat.setInt(3, materia.getCupo());//
            pstat.setInt(4, materia.getCarga_horaria());//
            pstat.setString(5, materia.getDias_y_horarios_de_cursadas());//
            pstat.setInt(6, materia.getNro_aula());

            //Se ejecuta el query de envío de datos
            pstat.execute();

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public Materia buscarPorNombre(String nmb){
        Materia materia=null;
        try {
            PreparedStatement pstat = cn.prepareStatement("SELECT * FROM  materia WHERE nombre=?");

            pstat.setString(1, nmb);
            ResultSet rs = pstat.executeQuery();
            while (rs.next()) {
                materia = new Materia(
                        rs.getString("id"),
                        rs.getString("nombre"),
                        rs.getInt("cupo"),
                        rs.getInt("carga_horaria"),//
                        rs.getString("dias_y_horarios_de_cursadas"),
                        rs.getInt("nro_aula")
                        );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return materia;
    }

}
