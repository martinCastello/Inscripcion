package Servicios;
import  BD.*;
import  Entidades.*;

public class ServiciosProfesor extends ServiciosUsuario {
    private  ProfesorBD profesorBD= new ProfesorBD();
    private CursadasBD cursadasBD= new CursadasBD();


    public boolean logIn(int legajo, String pass) {
        try{
            this.setUser(profesorBD.buscarPorLegajo(legajo));
            this.setValidation(this.getUser().validateUser(legajo, pass));
        }catch (Exception e){
            System.out.println("Usuario/Password Incorrectas \n");
        }
        return this.getValidation();
    }

    public  void changeData( String materia, String field, String value){
        if ( super.validation()){
           Materia mat= super.lookUpSubject(materia);
           Cursadas cursada= cursadasBD.buscarPorIdMateria(mat.getId());
           switch (field){
               case "dias_y_horarios":
                   cursadasBD.upDateDias_y_horarios(mat.getId(),value);
                   break;
               case "nro_aula":
                   cursadasBD.upDateAula(cursada.getMateria_id(), value);
                   break;
           }
        }
    }

}
