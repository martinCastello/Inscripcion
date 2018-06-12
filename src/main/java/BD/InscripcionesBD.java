package BD;

import Entidades.Inscripciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InscripcionesBD {
    ConectorBD cc = new ConectorBD();
    Connection cn = cc.ConectarBD();

    public void insertar(Inscripciones inscripciones) {
        try{
            PreparedStatement pstat = cn.prepareStatement("INSERT INTO inscripciones(id, alumno_id, cursada_id) VALUES (?,?,?)");

            pstat.setString(1, null);
            pstat.setInt(2, inscripciones.getAlumno_id());
            pstat.setInt(3, inscripciones.getCursada_id());

            //Se ejecuta el query de envío de datos
            pstat.execute();

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }

}
