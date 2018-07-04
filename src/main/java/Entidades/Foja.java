package Entidades;
import BD.CursadasBD;
import BD.HistorialDB;
import BD.MateriaBD;
import BD.HistorialDB;

import java.util.ArrayList;
import java.util.List;

public class Foja {
  private Alumno alumno;
  private List<Historial> historial=new ArrayList<>();
  private ArrayList<Materia> materiasAprobadas=new ArrayList<>();

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

    public List<Historial> getHistorial() { return historial; }

    public void setHistorial(List<Historial> historial) {
        this.historial = historial;
    }

    public ArrayList<Materia> getMateriasAprobadas() {
        return materiasAprobadas;
    }

    public void generarHistorial(){
        HistorialDB historialDB=new HistorialDB();
        this.historial=historialDB.buscarPorAlumnoId(this.alumno.getId());
    }

    public void generarMateriasAprobadas(Alumno alumno){
        ArrayList<Materia>materiasAprobadas=new ArrayList<>();
        HistorialDB historialDB=new HistorialDB();
        CursadasBD cursadasBD=new CursadasBD();
        MateriaBD materiaBD=new MateriaBD();
        for(Historial historial:historialDB.buscarPorAlumnoId(alumno.getId())){
            if(historial.getPromedio()>=4){
                Cursadas cursadas=cursadasBD.buscarPorID(historial.getCursada_id());
                Materia materia=materiaBD.buscarPorID(cursadas.getMateria_id());
                materiasAprobadas.add(materia);
            }
        }
        this.materiasAprobadas=materiasAprobadas;

    }
}
