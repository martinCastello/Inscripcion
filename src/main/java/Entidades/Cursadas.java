package Entidades;

public class Cursadas {

    private int id;
    private String dias_y_horarios;
    private int materia_id;
    private String nro_aula;
    private int cupo;
    private int comision;

    public Cursadas(int id, String dias_y_horarios, int materia_id, String nro_aula, int cupo, int comision) {

        this.id = id;
        this.dias_y_horarios = dias_y_horarios;
        this.materia_id = materia_id;
        this.nro_aula = nro_aula;
        this.cupo = cupo;
        this.comision = comision;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDias_y_horarios() {
        return dias_y_horarios;
    }

    public void setDias_y_horarios(String dias_y_horarios) {
        this.dias_y_horarios = dias_y_horarios;
    }

    public int getMateria_id() {
        return materia_id;
    }

    public void setMateria_id(int materia_id) {
        this.materia_id = materia_id;
    }

    public String getNro_aula() {
        return nro_aula;
    }

    public void setNro_aula(String nro_aula) {
        this.nro_aula = nro_aula;
    }

    public int getCupo() {
        return cupo;
    }

    public void setCupo(int cupo) {
        this.cupo = cupo;
    }

    @Override
    public String toString() {
        return "CursadasBD{" +
                "id=" + id +
                ", dias_y_horarios='" + dias_y_horarios + '\'' +
                ", materia_id=" + materia_id +
                ", nro_aula='" + nro_aula + '\'' +
                ", cupo=" + cupo +
                ", comision="+ comision+
                '}';
    }

    public int getComision() {
        return this.comision;
    }

}
