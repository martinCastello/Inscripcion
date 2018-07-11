package Servicios;
import  BD.*;
import  Entidades.*;

public class ServiciosProfesor extends ServiciosUsuario {
    private  ProfesorBD profesorBD= new ProfesorBD();
    private CursadasBD cursadasBD= new CursadasBD();


    public Profesor logIn(int legajo, String pass) {
        Profesor profesor = null;
        try{
            this.setUser(profesorBD.buscarPorLegajo(legajo));
            this.setValidation(this.getUser().validateUser(legajo, pass));
            if(this.getValidation()){
                profesor = (Profesor) this.getUser();
            }
        }catch (Exception e){
            System.out.println("\n");
        }
        return profesor;
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
