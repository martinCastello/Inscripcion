package BD;

import Entidades.Cursadas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CursadasBD {
    ConectorBD cc = new ConectorBD();
    Connection cn = cc.ConectarBD();

    public void insertar(Cursadas cursadas) {
        try{
            PreparedStatement pstat = cn.prepareStatement("INSERT INTO cursadas(id, dias_y_horarios, materia_id, nro_aula, cupo) VALUES (?,?,?,?,?)");

            pstat.setString(1, null);
            pstat.setString(2, cursadas.getDias_y_horarios());
            pstat.setInt(3, cursadas.getMateria_id());
            pstat.setString(4, cursadas.getNro_aula());
            pstat.setInt(5, cursadas.getCupo());

            //Se ejecuta el query de envío de datos
            pstat.execute();

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }



}
