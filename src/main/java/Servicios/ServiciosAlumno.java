package Servicios;
import BD.*;
import Entidades.*;

import javax.xml.ws.Service;

public class ServiciosAlumno extends ServiciosUsuario {
    private InscripcionesBD inscripcionesBD = new InscripcionesBD();
    private CursadasBD cursadasBD = new CursadasBD();

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
