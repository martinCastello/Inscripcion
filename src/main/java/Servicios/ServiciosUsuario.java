package Servicios;
import Entidades.*;
import BD.*;

public abstract class ServiciosUsuario {
    private boolean validation= false;
    private  User user;
    private MateriaBD materiaBD= new MateriaBD();


    public boolean logIn(int legajo, String pass)
    {
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

    protected void setUser(User usuario){
        this.user = usuario;
    }

    protected User getUser() {
        return this.user;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }

    public boolean getValidation() {
        return validation;
    }
}