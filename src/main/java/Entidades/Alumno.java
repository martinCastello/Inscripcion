package Entidades;

public class Alumno extends Usuario{

    public Alumno(int legajo, String nombre, String apellido, String mail, String password) {
        super(legajo, nombre, apellido, mail, password);
        this.setPerfil(this);
    }

    public String getPefil(){
        return "Alumno";
    }


}
