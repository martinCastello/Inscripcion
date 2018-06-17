package BD;

import Entidades.Cursadas;
import Entidades.Materia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursadasBD {
    ConectorBD cc = new ConectorBD();
    Connection cn = cc.ConectarBD();

    public void insertar(Cursadas cursadas) {
        try{

            PreparedStatement pstat = cn.prepareStatement(
                    "INSERT INTO cursadas(id, dias_y_horarios, materia_id, nro_aula, cupo, profesor_id)" +
                            " VALUES (?,?,?,?,?,?)");

            pstat.setString(1, null);
            pstat.setString(2, cursadas.getDias_y_horarios());
            pstat.setInt(3, cursadas.getMateria_id());
            pstat.setString(4, cursadas.getNro_aula());
            pstat.setInt(5, cursadas.getCupo());
            pstat.setInt(6, cursadas.getProfesor_id());

            //Se ejecuta el query de envío de datos
            pstat.execute();

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }


    public List<Cursadas> listar(){

        List<Cursadas> cursadas=new ArrayList<Cursadas>();
        try {
            PreparedStatement pstat = cn.prepareStatement("SELECT * FROM  cursadas");

            ResultSet rs = pstat.executeQuery();

            while (rs.next()) {
                cursadas.add(new Cursadas(
                        rs.getInt("id"),
                        rs.getString("dias_y_horarios"),
                        rs.getInt("materia_id"),
                        rs.getString("nro_aula"),
                        rs.getInt("cupo"),
                        rs.getInt("profesor_id")
                        )
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return cursadas;
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
                        rs.getInt("profesor_id")
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return cursada;
    }

    public Cursadas buscarPorID(int id){

        Cursadas cursada=null;
        try {
            PreparedStatement pstat = cn.prepareStatement("SELECT * FROM  cursadas WHERE id=?");

            pstat.setInt(1, id);
            ResultSet rs = pstat.executeQuery();


            while (rs.next()) {
                cursada = new Cursadas(
                        rs.getInt("id"),
                        rs.getString("dias_y_horarios"),
                        rs.getInt("materia_id"),
                        rs.getString("nro_aula"),
                        rs.getInt("cupo"),
                        rs.getInt("profesor_id")
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return cursada;
    }

    public List<Cursadas> buscarPorProfesor(int id){

        List<Cursadas> cursadas=new ArrayList<Cursadas>();
        try {
            PreparedStatement pstat = cn.prepareStatement("SELECT * FROM  cursadas WHERE profesor_id=?");

            pstat.setInt(1, id);
            ResultSet rs = pstat.executeQuery();


            while (rs.next()) {
                cursadas.add( new Cursadas(
                        rs.getInt("id"),
                        rs.getString("dias_y_horarios"),
                        rs.getInt("materia_id"),
                        rs.getString("nro_aula"),
                        rs.getInt("cupo"),
                        rs.getInt("profesor_id")
                        )
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return cursadas;
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
                        rs.getInt("profesor_id")
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

    public void createCursadas(){

        List<Cursadas> cursadas=new ArrayList<Cursadas>();
        //MATEMATICA I - PROFESOR: DIEGO
        cursadas.add(new Cursadas(0,"Lunes 12 a 16 hs",1, "A23",30,1));
        cursadas.add(new Cursadas(0,"Lunes 18 a 22 hs",1, "A23",30,1));
        //MATEMATICA II - PROFESOR: CARLOS
        cursadas.add(new Cursadas(0,"Martes 12 a 16 hs",2, "A23",30,2));
        cursadas.add(new Cursadas(0,"Martes 18 a 22 hs",2, "A23",30,2));
        //OBJETOS I - PROFESOR: JOSE
        cursadas.add(new Cursadas(0,"Miercoles 12 a 15 hs y viernes 12 a 15 hs.",3, "A27",30,3));
        cursadas.add(new Cursadas(0,"Miercoles 18 a 22 hs y viernes 18 a 21 hs.",3, "A27",30,3));
        //OBJETOS II - PROFESOR: MANUEL
        cursadas.add(new Cursadas(0,"Martes 12 a 15 hs y jueves 12 a 15 hs.",4, "A21",30,4));
        cursadas.add(new Cursadas(0,"Martes 18 a 21 hs y jueves 18 a 21 hs.",4, "A21",30,4));
        //OBJETOS III - PROFESOR: PEDRO
        cursadas.add(new Cursadas(0,"Lunes 12 a 15 hs y jueves 12 a 15 hs.",5, "B21",30,5));
        cursadas.add(new Cursadas(0,"Lunes 18 a 21 hs y jueves 18 a 21 hs.",5, "B21",30,5));


        for (Cursadas cursada:cursadas) {
            this.insertar(cursada);
        }
    }

}
