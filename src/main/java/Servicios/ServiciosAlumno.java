package Servicios;
import BD.*;
import Entidades.*;

public class ServiciosAlumno extends ServiciosUsuario {
    private AlumnoBD alumnoBD= new AlumnoBD();
    private InscripcionesBD inscripcionesBD= new InscripcionesBD();
    private CursadasBD cursadasBD= new CursadasBD();

    public void inscribirACursada(int id_user, String name_materia){
        Materia materia= super.lookUpSubject(name_materia);
        Cursadas cursada= this.cursadasBD.buscarPorIdMateria(materia.getId());
        if (super.validation()){
            Inscripciones inscripcion = new Inscripciones(0, id_user,cursada.getId());
            this.inscripcionesBD.insertar(inscripcion);
        }

    }

}
