package Servicios;
import Entidades.*;
import BD.*;

public class ServiciosUsuario {
    private boolean validation= false;
    private AlumnoBD alumnoBD= new AlumnoBD();
    private ProfesorBD profesorBD= new ProfesorBD();
    private  User user;
    private MateriaBD materiaBD= new MateriaBD();
    private CursadasBD cursadasBD= new CursadasBD();

    public boolean logIn(int legajo, String pass,String type)
    {
        if (type == "alumno")
        {
            this.user = alumnoBD.buscarPorLegajo(legajo);
            if (this.user != null)
            {
                this.validation = this.user.validateUser(legajo, pass);
            }
        }
        else
            {
                this.user = profesorBD.buscarPorLegajo(legajo);
                if (this.user != null)
                {
                    this.validation = this.user.validateUser(legajo, pass);
                }
            }
            return this.validation;
    }
    public void updatePersonalData(String field, String value){
        if (validation){
            this.user.updatePersonalData(field,value);
        }
    }

    public Materia lookUpSubject (String name){
        if (validation){
            return this.materiaBD.buscarPorNombre(name);
        }
        else{
            return null;
        }
    }


    public  boolean validation(){
        return this.validation;
    }

}
