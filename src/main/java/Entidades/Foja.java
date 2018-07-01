package Entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Foja {
    private int notasSinPromediar;
    private float promedio;
    private List<MateriaCursada> materiasCursadas= new ArrayList<MateriaCursada>();


    public Foja(){
        this.notasSinPromediar= 0;
        this.promedio=0;
    }

    public void addSubject(Materia materia, int notaFinal, Date fecha) {
        this.notasSinPromediar=+ notaFinal;
        MateriaCursada mat= new MateriaCursada(materia, notaFinal, fecha);
        this.materiasCursadas.add(mat);
        this.promedio= notasSinPromediar/ this.materiasCursadas.size();
    }

    public float getPromedio() {
        return promedio;
    }
}
