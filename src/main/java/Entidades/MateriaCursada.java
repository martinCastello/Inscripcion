package Entidades;

import java.util.Date;

public class MateriaCursada {
    private Materia materia;
    private int nota;
    private Date fecha;
    private String semestre;

    public MateriaCursada(Materia mat, int nota, Date fecha){
        this.materia= mat;
        this.nota= nota;
        this.fecha= fecha;
        if(fecha.getMonth() >01 && fecha.getMonth()<=6){
            this.semestre= "S 01 "+fecha.getYear();
        }
        else{
            this.semestre= "S 02 "+fecha.getYear();
        }
    }
}
