package Entidades;

public class Inscripciones {

    private int id;
    private int alumno_id;
    private int cursada_id;

    public Inscripciones(int id, int alumno_id, int cursada_id) {
        this.id = id;
        this.alumno_id = alumno_id;
        this.cursada_id = cursada_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlumno_id() {
        return alumno_id;
    }

    public void setAlumno_id(int alumno_id) {
        this.alumno_id = alumno_id;
    }

    public int getCursada_id() {
        return cursada_id;
    }

    public void setCursada_id(int cursada_id) {
        this.cursada_id = cursada_id;
    }

    @Override
    public String toString() {
        return "Inscripciones{" +
                "id=" + id +
                ", alumno_id=" + alumno_id +
                ", cursada_id=" + cursada_id +
                '}';
    }
}
