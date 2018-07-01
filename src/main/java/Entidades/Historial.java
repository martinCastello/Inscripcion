package Entidades;

public class Historial {

    private int id;
    private int alumno_id;
    private int cursada_id;
    private float promedio;
    private String fecha;

    public Historial(int id, int alumno_id, int cursada_id, float promedio, String fecha) {
        this.id = id;
        this.alumno_id = alumno_id;
        this.cursada_id = cursada_id;
        this.promedio = promedio;
        this.fecha = fecha;
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

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
