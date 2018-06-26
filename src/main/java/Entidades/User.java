package Entidades;


public class User {
    private int id;
    private String nombre;
    private String apellido;
    private int legajo;
    private String mail;
    private String password;

    public User (int id, String nombre, String getApellido, int legajo, String mail, String pass){
        this.id= id;
        this.nombre= nombre;
        this.apellido= getApellido;
        this.legajo= legajo;
        this.mail= mail;
        this.password = pass;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public  boolean validateUser(int legajo, String password){
        return  (this.getPassword().equals(password));
    }

    public void updatePersonalData(String field, String value){
        switch (field) {
            case "nombre":
               this.setNombre( value);
               break;
            case "apellido":
                this.setApellido(value);
                break;
            case "mail":
                this.setMail(value);
                break;
            case "password":
                this.setPassword(value);
        }
    }
}
