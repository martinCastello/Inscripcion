package Entidades;
import BD.HistorialDB;

import java.util.ArrayList;
import java.util.List;

public class Foja {
  private Alumno alumno;
  private List<Historial> historial=new ArrayList<>();

    public Foja(Alumno alumno) {
        this.alumno = alumno;
        this.generarHistorial();
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public List<Historial> getHistorial() {
        return historial;
    }

    public void setHistorial(List<Historial> historial) {
        this.historial = historial;
    }

    public void generarHistorial(){
        HistorialDB historialDB=new HistorialDB();
        this.historial=historialDB.buscarPorAlumnoId(this.alumno.getId());
    }
}
