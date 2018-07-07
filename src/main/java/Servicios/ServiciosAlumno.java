package Servicios;
import BD.*;
import Entidades.*;

import javax.xml.ws.Service;

public class ServiciosAlumno extends ServiciosUsuario {
    private AlumnoBD alumnoBD= new AlumnoBD();
    private InscripcionesBD inscripcionesBD = new InscripcionesBD();
    private CursadasBD cursadasBD = new CursadasBD();

    @Override
    public boolean logIn(int legajo, String pass) {
        try{
            this.setUser(alumnoBD.buscarPorLegajo(legajo));
            this.setValidation(this.getUser().validateUser(legajo, pass));
        }catch (Exception e){
            System.out.println("Usuario/Password Incorrectas \n");
        }
        return this.getValidation();
    }

    public void inscribirACursada(int id_user, int id_cursada){
        //Materia materia= super.lookUpSubject(name_materia);
        //Cursadas cursada= this.cursadasBD.buscarPorIdMateria(materia.getId());
        Cursadas cursada= this.cursadasBD.buscarPorID(id_cursada);
        //if (super.validation()){
            Inscripciones inscripcion = new Inscripciones(0, id_user,cursada.getId());
            this.inscripcionesBD.insertar(inscripcion);
        //}

    }

}
