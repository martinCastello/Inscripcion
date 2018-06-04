import java.sql.*;

public class UsuarioBD {
    ConectorBD cc = new ConectorBD();
    Connection cn = cc.ConectarBD();

    public void guardarBD() {
        try{

            PreparedStatement pstat = cn.prepareStatement("INSERT INTO usuario(id, nombre, apellido, legajo) VALUES (?,?,?,?)");

            pstat.setString(1, null);
            pstat.setString(2, "Omar");
            pstat.setString(3, "gomez");
            pstat.setString(4, "4444444");

            //Se ejecuta el query de envío de datos
            pstat.execute();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
