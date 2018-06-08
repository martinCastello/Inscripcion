package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Materia {

    private String id;
    private String nombre;
    private int cupo;
    private int carga_horaria;
    private String dias_y_horarios_de_cursadas;
    private int nro_aula;

    public  Materia (String id, String nomb, int cup, int cant_horas, String dia_y_horarios, int aula){
        this.id = id;
        this.nombre = nomb;
        this.cupo = cup;
        this.carga_horaria = cant_horas;
        this.dias_y_horarios_de_cursadas= dia_y_horarios;
        this.nro_aula= aula;
    }

    public String  getId(){
        return  this.id;
    }

    public String getNombre(){
        return  this.nombre;
    }

    public int getCarga_horaria() {
        return this.carga_horaria;
    }

    public int getCupo() {
        return cupo;
    }

    public int getNro_aula() {
        return this.nro_aula;
    }

    public String getDias_y_horarios_de_cursadas() {
        return this.dias_y_horarios_de_cursadas;
    }

    public void setDias_y_horarios_de_cursadas(String dias_y_horarios_de_cursadas) {
        this.dias_y_horarios_de_cursadas = dias_y_horarios_de_cursadas;
    }

    public void setNro_aula(int nro_aula) {
        this.nro_aula= nro_aula;
    }

@Override
    public String toString() {
        return "Materia{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cupo ='" + cupo + '\'' +
                ", carga horaria='" + carga_horaria + '\'' +
                ", aula ='" + nro_aula + '\'' +
                ", dias_y_horarios_de_cursadass ='" + dias_y_horarios_de_cursadas + '\'' +
                '}';
    }
}

