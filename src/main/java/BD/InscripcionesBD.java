package BD;

import Entidades.Inscripciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InscripcionesBD {
    ConectorBD cc = new ConectorBD();
    Connection cn = cc.ConectarBD();

    public void insertar(Inscripciones inscripciones) {
        try{
            PreparedStatement pstat = cn.prepareStatement("INSERT INTO inscripciones(id, usuario_id, cursadas_id) VALUES (?,?,?)");

            pstat.setString(1, null);
            pstat.setInt(2, inscripciones.getAlumno_id());
            pstat.setInt(3, inscripciones.getCursada_id());

            //Se ejecuta el query de envío de datos
            pstat.execute();

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

    public Inscripciones buscar(int id) {
        Inscripciones inscripciones=null;
        try {
            PreparedStatement pstat = cn.prepareStatement("SELECT * FROM  inscripciones WHERE usuario_id=? ");

            pstat.setInt(1, id);
            ResultSet rs = pstat.executeQuery();

            while (rs.next()) {
                inscripciones = new Inscripciones(
                        rs.getInt("id"),
                        rs.getInt("usuario_id"),
                        rs.getInt("cursadas_id"));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return inscripciones;
    }
}
