package Entidades;

import java.util.Date;

public class Alumno extends  User{

    private int regular;
    private Foja foja;


    public Alumno(int id, String nombre, String apellido, int legajo, int regular, String mail, String password) {
       super (id,nombre,apellido,legajo,mail,password);
       this.regular= regular;
    }


    public int getRegular() {
        return regular;
    }

    public void setRegular(int regular) {
        this.regular = regular;
    }

    public  Foja getFoja(){
        return this.foja;
    }

    public void addASubject(Materia materia, int notaFinal, Date fecha){
        this.foja.addSubject(materia, notaFinal, fecha);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + super.getId() +
                ", nombre='" + super.getNombre() + '\'' +
                ", apellido='" + super.getApellido() + '\'' +
                ", legajo=" + super.getLegajo() +
                ", regular=" + regular +
                ", mail='" + super.getMail() + '\'' +
                ", password='" + super.getPassword() + '\'' +
                '}';
    }
}
