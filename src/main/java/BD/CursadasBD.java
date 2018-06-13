package BD;

import Entidades.Cursadas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CursadasBD {
    ConectorBD cc = new ConectorBD();
    Connection cn = cc.ConectarBD();

    public void insertar(Cursadas cursadas) {
        try{
            PreparedStatement pstat = cn.prepareStatement(
                    "INSERT INTO cursadas(id, dias_y_horarios, materia_id, nro_aula, cupo, comision)" +
                            " VALUES (?,?,?,?,?,?)");

            pstat.setString(1, null);
            pstat.setString(2, cursadas.getDias_y_horarios());
            pstat.setInt(3, cursadas.getMateria_id());
            pstat.setString(4, cursadas.getNro_aula());
            pstat.setInt(5, cursadas.getCupo());
            pstat.setInt(6, cursadas.getComision());


            //Se ejecuta el query de envío de datos
            pstat.execute();

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
    public Cursadas buscarPorAula(String aula){

        Cursadas cursada=null;
        try {
            PreparedStatement pstat = cn.prepareStatement("SELECT * FROM  cursadas WHERE nro_aula=?");

            pstat.setString(1, aula);
            ResultSet rs = pstat.executeQuery();


            while (rs.next()) {
                cursada = new Cursadas(
                        rs.getInt("id"),
                        rs.getString("dias_y_horarios"),
                        rs.getInt("materia_id"),
                        rs.getString("nro_aula"),
                        rs.getInt("cupo"),
                        rs.getInt("comision")
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return cursada;
    }


    public Cursadas buscarPorIdMateria(int id) {
        Cursadas cursada=null;
        try {
            PreparedStatement pstat = cn.prepareStatement("SELECT * FROM  cursadas WHERE materia_id=?");

            pstat.setInt(1, id);
            ResultSet rs = pstat.executeQuery();


            while (rs.next()) {
                cursada = new Cursadas(
                        rs.getInt("id"),
                        rs.getString("dias_y_horarios"),
                        rs.getInt("materia_id"),
                        rs.getString("nro_aula"),
                        rs.getInt("cupo"),
                        rs.getInt("comision")
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return cursada;
    }

    public void upDateDias_y_horarios(int id, String value) {
            try {
                PreparedStatement ps = cn.prepareStatement("UPDATE cursadas SET dias_y_horatios = ? WHERE id = ? ");

                ps.setString(1, value);
                ps.setInt(2, id);

                // call executeUpdate to execute our sql update statement
                ps.executeUpdate();
                ps.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
    }

    public void upDateAula(int materia_id, String value) {
            try {
                PreparedStatement ps = cn.prepareStatement("UPDATE cursadas SET nro_aula = ? WHERE id = ? ");

                ps.setString(1, value);
                ps.setInt(2, materia_id);

                // call executeUpdate to execute our sql update statement
                ps.executeUpdate();
                ps.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
    }
}
