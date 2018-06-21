package BD;

import Entidades.Cursadas;
import Entidades.Materia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Materia> listar(){
        List<Materia> materias=new ArrayList<Materia>();
        try {
            PreparedStatement pstat = cn.prepareStatement("SELECT * FROM  materia");

            ResultSet rs = pstat.executeQuery();
            while (rs.next()) {
                materias.add(new Materia(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("carga_horaria")
                        )
                );
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return materias;
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

    public Materia buscarPorID(int id){
        Materia materia=null;
        try {
            PreparedStatement pstat = cn.prepareStatement("SELECT * FROM  materia WHERE id=?");

            pstat.setInt(1, id);
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


    public void createMaterias(){

        List<Materia> materias=new ArrayList<Materia>();
        materias.add(new Materia(0,"Matematica I",4));
        materias.add(new Materia(0,"Matematica II",4));
        materias.add(new Materia(0,"Objetos I",6));
        materias.add(new Materia(0,"Objetos II",6));
        materias.add(new Materia(0,"Objetos III",6));
//        materias.add(new Materia(0,"Base de datos",3));
//        materias.add(new Materia(0,"Ingles I",2));
//        materias.add(new Materia(0,"Ingles II",2));
//        materias.add(new Materia(0,"Sistemas Operativos",3));
//        materias.add(new Materia(0,"Redes de computadoras",3));
//        materias.add(new Materia(0,"Elem. de Ing. del Software",6));
        for (Materia materia:materias) {
            this.insertar(materia);
        }
    }



}
