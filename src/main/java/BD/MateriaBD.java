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
    ConectorBD cc = ConectorBD.getInstance();

    public void insertar(Materia materia) {
        Connection cn = cc.ConectarBD();

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

        cc.desconectar();

    }

    public List<Materia> listar(){
        Connection cn = cc.ConectarBD();

        List<Materia> materias=new ArrayList<Materia>();
        CorrelativasBD correlativasBD=new CorrelativasBD();
        try {
            PreparedStatement pstat = cn.prepareStatement("SELECT * FROM  materia");

            ResultSet rs = pstat.executeQuery();
            while (rs.next()) {
                Materia materia=new Materia(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("carga_horaria"));
                materia.setCorrelativas(correlativasBD.buscarPorMateriaID(rs.getInt("id")));
                materias.add(materia);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        cc.desconectar();


        return materias;
    }


    public Materia buscarPorNombre(String nombre){
        Connection cn = cc.ConectarBD();

        Materia materia=null;
        CorrelativasBD correlativasBD=new CorrelativasBD();

        try {
            PreparedStatement pstat = cn.prepareStatement("SELECT * FROM  materia WHERE nombre=?");

            pstat.setString(1, nombre);
            ResultSet rs = pstat.executeQuery();
            while (rs.next()) {
                materia = new Materia(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("carga_horaria"));
                materia.setCorrelativas(correlativasBD.buscarPorMateriaID(rs.getInt("id")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        cc.desconectar();

        return materia;
    }

    public Materia buscarPorID(int id){
        Connection cn = cc.ConectarBD();

        Materia materia=null;
        CorrelativasBD correlativasBD=new CorrelativasBD();


        try {
            PreparedStatement pstat = cn.prepareStatement("SELECT * FROM  materia WHERE id=?");

            pstat.setInt(1, id);
            ResultSet rs = pstat.executeQuery();
            while (rs.next()) {
                materia = new Materia(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("carga_horaria"));
                materia.setCorrelativas(correlativasBD.buscarPorMateriaID(rs.getInt("id")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        cc.desconectar();

        return materia;
    }


    public void createMaterias(){
        Connection cn = cc.ConectarBD();

        List<Materia> materias=new ArrayList<Materia>();
        materias.add(new Materia(0,"Matematica I",4));//1
        materias.add(new Materia(0,"Matematica II",4));//2
        materias.add(new Materia(0,"Objetos I",6));//3
        materias.add(new Materia(0,"Objetos II",6));//4
        materias.add(new Materia(0,"Base de datos",3));//5
        materias.add(new Materia(0,"Estructuras de datos",3));//6
        materias.add(new Materia(0,"Redes de computadoras",3));//7
        materias.add(new Materia(0,"Interfaces de usuario",6));//8
        materias.add(new Materia(0,"Estrategia de Persistencia",6));//9
        materias.add(new Materia(0,"Practicas del Desarrollo de Software",8));//10
        materias.add(new Materia(0,"Organizacion de computadoras",4));//11
        materias.add(new Materia(0,"Introduccion a la programacion",4));//12

        for (Materia materia:materias) {
            this.insertar(materia);
        }

        cc.desconectar();
    }



}
