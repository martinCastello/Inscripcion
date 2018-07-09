package Entidades;

import java.util.ArrayList;
import java.util.Objects;

public class Materia {

    private int id;
    private String nombre;
    private int carga_horaria;
    private ArrayList<Materia>correlativas=new ArrayList<>();

    public Materia(int id, String nombre, int carga_horaria) {
        this.id = id;
        this.nombre = nombre;
        this.carga_horaria = carga_horaria;
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

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public ArrayList<Materia> getCorrelativas() {
        return correlativas;
    }

    public void setCorrelativas(ArrayList<Materia> correlativas) {
        this.correlativas = correlativas;
    }

    public void agregarCorrelativa(Materia materia){
        this.correlativas.add(materia);
    }

    public void quitarCorrelativa(Materia materia){
        this.correlativas.remove(materia);
    }

    public boolean esRecomenada(Alumno alumno){
        boolean retorno=!alumno.getFoja().getMateriasAprobadas().contains(this);
        for (Materia materia : correlativas) {
            if(!alumno.getFoja().getMateriasAprobadas().contains(materia)){
                retorno = false;
                break;
            }
        }


        return retorno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Materia)) return false;
        Materia materia = (Materia) o;
        return getId() == materia.getId() &&
                getCarga_horaria() == materia.getCarga_horaria() &&
                Objects.equals(getNombre(), materia.getNombre()) &&
                Objects.equals(getCorrelativas(), materia.getCorrelativas());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getNombre(), getCarga_horaria(), getCorrelativas());
    }

    @Override
    public String toString() {
        return "Materia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", carga_horaria=" + carga_horaria +
                ", correlativas=" + correlativas +
                '}';
    }

    public String info(){
        return this.getNombre()+", carga horaria semanal "+this.getCarga_horaria();
    }
}

