package Servicios;
import BD.*;
import Entidades.*;

import javax.crypto.ExemptionMechanismException;

public class ServiciosAlumno extends ServiciosUsuario {
    private AlumnoBD alumnoBD= new AlumnoBD();
    private InscripcionesBD inscripcionesBD = new InscripcionesBD();
    private CursadasBD cursadasBD = new CursadasBD();

    public Alumno logIn(int legajo, String pass) throws Exception {
        Alumno alumno = null;
        try{
            this.setUser(alumnoBD.buscarPorLegajo(legajo));
            this.setValidation(this.getUser().validateUser(legajo, pass));
            if(this.getValidation()){
                alumno = (Alumno) this.getUser();
            }
        }catch (Exception e){
            System.out.println("\n");
        }

        return alumno;
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
