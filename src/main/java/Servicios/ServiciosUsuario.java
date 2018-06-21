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

    public void logIn(int legajo, String pass,String type){
        if (type == "alumno"){
            this.user= alumnoBD.buscarPorLegajo(legajo);
            this.validation = this.user.validateUser(legajo, this.user.getPassword());
            System.out.println("Success access");
        }
        else{
    //        this.user= profesorBD.buscarPorLegajo(legajo);
            this.validation = this.user.validateUser(legajo, this.user.getPassword());
            System.out.println("Success access");
        }
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

    public Cursadas lookUpCursadas (String aula){
        if (validation){
            return this.cursadasBD.buscarPorAula(aula);
        }
        else {
            return null;
        }
    }

    public  boolean validation(){
        return this.validation;
    }

}
