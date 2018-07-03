package BD;

import Entidades.Materia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CorrelativasBD {
    ConectorBD cc = ConectorBD.getInstance();

    public void insertar(Materia correlativa, Materia materia) {
        Connection cn = cc.ConectarBD();

        try{

            PreparedStatement pstat = cn.prepareStatement("INSERT INTO correlativas (id, materia_id, materia_correlativa_id) VALUES (?,?,?)");

            pstat.setString(1, null);
            pstat.setInt(2, materia.getId());
            pstat.setInt(3, correlativa.getId());

            //Se ejecuta el query de envío de datos
            pstat.execute();

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }

        cc.desconectar();
    }

    public ArrayList<Materia> buscarPorMateriaID(int id){
        Connection cn = cc.ConectarBD();

        MateriaBD materiaBD=new MateriaBD();
        ArrayList<Materia> correlativas=new ArrayList<>();
        try {
            PreparedStatement pstat = cn.prepareStatement("SELECT * FROM  correlativas WHERE materia_id=?");

            pstat.setInt(1, id);
            ResultSet rs = pstat.executeQuery();
            while (rs.next()) {
                correlativas.add(materiaBD.buscarPorID(rs.getInt("materia_correlativa_id")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        cc.desconectar();

        return correlativas;
    }

    public void createCorrelativas(){
        Connection cn = cc.ConectarBD();

        MateriaBD materiaBD=new MateriaBD();
        this.insertar(materiaBD.buscarPorNombre("Matematica I"),materiaBD.buscarPorNombre("Matematica II"));
        this.insertar(materiaBD.buscarPorNombre("Objetos I"),materiaBD.buscarPorNombre("Objetos II"));
        this.insertar(materiaBD.buscarPorNombre("Ingles I"),materiaBD.buscarPorNombre("Ingles II"));
        this.insertar(materiaBD.buscarPorNombre("Objetos II"),materiaBD.buscarPorNombre("Interfaces de usuario"));
        this.insertar(materiaBD.buscarPorNombre("Base de datos"),materiaBD.buscarPorNombre("Interfaces de usuario"));

        cc.desconectar();


    }

}
