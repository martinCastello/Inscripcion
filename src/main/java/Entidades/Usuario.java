package Entidades;

public class Usuario {
    private int legajo;
    private String nombre;
    private String apellido;
    private String mail;
    private String password;
    private Usuario perfil;

    public Usuario(int legajo, String nombre, String apellido, String mail, String password) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String mail) {
        this.password = password;
    }

    public void setPerfil(Usuario usuario){
        this.perfil = usuario;
    }

    public Usuario getPerfil() {
        return perfil;
    }

    //@Override
    //public String toString() {
    //    return "Usuario{" +
    //            ", nombre='" + nombre + '\'' +
    //            ", apellido='" + apellido + '\'' +
    //            ", legajo='" + legajo + '\'' +
    //            '}';
    //}

}
