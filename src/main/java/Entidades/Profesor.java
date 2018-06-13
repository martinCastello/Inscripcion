package Entidades;

public class Profesor extends  User{


    public Profesor(int id, String nombre, String apellido, int legajo, String mail, String password) {
    super(id,nombre,apellido, legajo,mail, password);
}


    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + super.getId() +
                ", nombre='" + super.getNombre() + '\'' +
                ", apellido='" + super.getApellido() + '\'' +
                ", legajo=" + super.getLegajo() +
                ", mail='" + super.getMail() + '\'' +
                ", password='" + super.getPassword() + '\'' +
                '}';
    }
}
