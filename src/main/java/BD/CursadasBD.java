package BD;

import Entidades.Cursadas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CursadasBD {
    ConectorBD cc = ConectorBD.getInstance();

    public void insertar(Cursadas cursadas) {
        Connection cn = cc.ConectarBD();

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

        cc.desconectar();

    }


    public List<Cursadas> listar(){
        Connection cn = cc.ConectarBD();

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

        cc.desconectar();

        return cursadas;
    }

    public Cursadas buscarPorAula(String aula){
        Connection cn = cc.ConectarBD();

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

        cc.desconectar();

        return cursada;
    }

    public Cursadas buscarPorID(int id){
        Connection cn = cc.ConectarBD();

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

        cc.desconectar();

        return cursada;
    }

    public List<Cursadas> buscarPorProfesor(int id){
        Connection cn = cc.ConectarBD();

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

        cc.desconectar();

        return cursadas;
    }


    public Cursadas buscarPorIdMateria(int id) {
        Connection cn = cc.ConectarBD();

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

        cc.desconectar();

        return cursada;
    }

    public void upDateDias_y_horarios(int id, String value) {
        Connection cn = cc.ConectarBD();

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

        cc.desconectar();

    }

    public void upDateAula(int materia_id, String value) {
        Connection cn = cc.ConectarBD();

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

        cc.desconectar();

    }

    public void updateCupo(int cursada_id) {
        Connection cn = cc.ConectarBD();

        try {
            int value = this.buscarPorID(cursada_id).getCupo();
            PreparedStatement ps = cn.prepareStatement("UPDATE cursadas SET cupo = ? WHERE id = ? ");

            ps.setInt(1, value-1);
            ps.setInt(2, cursada_id);

            // call executeUpdate to execute our sql update statement
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        cc.desconectar();

    }

    public void createCursadas(){
        Connection cn = cc.ConectarBD();

        List<Cursadas> cursadas=new ArrayList<Cursadas>();

        //OBJETOS I - PROFESOR: JOSE - 2016 1er cuatrimestre
        cursadas.add(new Cursadas(0,"Miercoles 12 a 15 hs y viernes 12 a 15 hs.",3, "A27",0,3));
        cursadas.add(new Cursadas(0,"Miercoles 18 a 22 hs y viernes 18 a 21 hs.",3, "A27",0,3));
        //OBJETOS II - PROFESOR: MANUEL - 2016 2do cuatrimestre
        cursadas.add(new Cursadas(0,"Martes 12 a 15 hs y jueves 12 a 15 hs.",4, "A21",0,4));
        cursadas.add(new Cursadas(0,"Martes 18 a 21 hs y jueves 18 a 21 hs.",4, "A21",0,4));
        //MATEMATICA I - PROFESOR: DIEGO - 2016 1er cuatrimestre
        cursadas.add(new Cursadas(0,"Lunes 12 a 16 hs",1, "A23",0,1));
        cursadas.add(new Cursadas(0,"Lunes 18 a 22 hs",1, "A23",0,1));
        //MATEMATICA II - PROFESOR: CARLOS - 2016 2do cuatrimestre
        cursadas.add(new Cursadas(0,"Martes 12 a 16 hs",2, "A23",0,2));
        cursadas.add(new Cursadas(0,"Martes 18 a 22 hs",2, "A23",0,2));
        //BASE DE DATOS - PROFESOR: PEDRO - 2016 2do cuatrimestre
        cursadas.add(new Cursadas(0,"Lunes 12 a 15 hs y jueves 12 a 15 hs.",5, "B21",0,5));
        cursadas.add(new Cursadas(0,"Lunes 18 a 21 hs y jueves 18 a 21 hs.",5, "B21",0,5));
        //INTERFACES DE USUARIO - PROFESOR: PEDRO - 2017 - 1er cuatrimestre
        cursadas.add(new Cursadas(0,"Jueves 18 a 22 hs.",8, "B21",0,5));
        //ESTRATEGIA DE PERSISTENCIA - PROFESOR: MANUEL - 2017 - 1er cuatrimestre
        cursadas.add(new Cursadas(0,"Viernes 18 a 22 hs.",9, "37B",0,4));

        //INTRODUCCION A LA PROGRAMACION - PROFESOR: DIEGO PEREZ - 2018 1er cuatrimestre
        cursadas.add(new Cursadas(0,"Martes 16 a 20 hs",12, "213",1,1));
        //ORGANIZACION DE COMPUTADORAS - PROFESOR: CARLOS GOMEZ - 2018 1er cuatrimestre
        cursadas.add(new Cursadas(0,"Lunes 12 a 16 hs",11, "213",30,2));
        //OBJETOS I - PROFESOR: JOSE FERNANDEZ - 2018 1er cuatrimestre
        cursadas.add(new Cursadas(0,"Miercoles 12 a 15 hs y viernes 12 a 15 hs.",3, "A27",30,3));
        cursadas.add(new Cursadas(0,"Miercoles 18 a 22 hs y viernes 18 a 21 hs.",3, "A27",30,3));
        //OBJETOS II - PROFESOR: MANUEL GONZALEZ - 2018 1er cuatrimestre
        cursadas.add(new Cursadas(0,"Martes 12 a 15 hs y jueves 12 a 15 hs.",4, "A21",30,4));
        cursadas.add(new Cursadas(0,"Martes 18 a 21 hs y jueves 18 a 21 hs.",4, "A21",30,4));
        //MATEMATICA I - PROFESOR: DIEGO PEREZ - 2018 1er cuatrimestre
        cursadas.add(new Cursadas(0,"Lunes 12 a 16 hs",1, "A23",30,1));
        cursadas.add(new Cursadas(0,"Lunes 18 a 22 hs",1, "A23",30,1));
        //MATEMATICA II - PROFESOR: CARLOS GOMEZ - 2018 1er cuatrimestre
        cursadas.add(new Cursadas(0,"Martes 12 a 16 hs",2, "A23",30,2));
        cursadas.add(new Cursadas(0,"Martes 18 a 22 hs",2, "A23",0,2));
        //BASE DE DATOS - PROFESOR: PEDRO LOPEZ - 2018 1er cuatrimestre
        cursadas.add(new Cursadas(0,"Lunes 12 a 15 hs y jueves 12 a 15 hs.",5, "B21",2,5));
        cursadas.add(new Cursadas(0,"Lunes 18 a 21 hs y jueves 18 a 21 hs.",5, "B21",0,5));
        //INTERFACES DE USUARIO - PROFESOR: PEDRO LOPEZ - 2018 - 1er cuatrimestre
        cursadas.add(new Cursadas(0,"Viernes 18 a 22 hs.",8, "B21",1,5));
        //ESTRATEGIA DE PERSISTENCIA - PROFESOR: MANUEL GONZALEZ - 2018 - 1er cuatrimestre
        cursadas.add(new Cursadas(0,"Viernes 14 a 18 hs.",9, "37B",1,4));
        //REDES - PROFESOR: RAUL RE - 2018 - 1er cuatrimestre
        cursadas.add(new Cursadas(0,"Viernes 16 a 19 hs.",7, "203",30,6));
        //ESTRUCTURAS DE DATOS - PROFESOR: PABLO TOLEDO - 2018 - 1er cuatrimestre
        cursadas.add(new Cursadas(0,"Viernes 16 a 19 hs.",6, "205",30,7));
        //PRACTICAS DE DESARROLLO DE SOFTWARE - PROFESOR: PABLO TOLEDO - 2018 - 1er cuatrimestre
        cursadas.add(new Cursadas(0,"Lunes 18 a 22 hs y jueves 18 a 22 hs.",10, "205",30,7));



        for (Cursadas cursada:cursadas) {
            this.insertar(cursada);
        }

        cc.desconectar();

    }

}
