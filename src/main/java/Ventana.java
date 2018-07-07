
import BD.CursadasBD;
import BD.MateriaBD;
import Entidades.Alumno;
import Entidades.Cursadas;
import Entidades.Historial;
import Entidades.Materia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame {
    Ventana ventana;
    JMenuBar barra;
    JMenu menu_roles;
    JMenuItem menu_alumno;
    JMenuItem menu_profesor;

    public  Ventana(){
        barra = new JMenuBar();
        this.menu_roles = new JMenu("Rol");
        this.menu_alumno = new JMenuItem("Alumno");
        this.menu_profesor = new JMenuItem("Profesor");
        menu_roles.add(menu_alumno);
        menu_roles.add(menu_profesor);
        barra.add(menu_roles);
        setJMenuBar(barra);
        this.ventana = this;

        //EVENTOS DE MENU
        menu_alumno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                barra.removeAll();
                JMenu menu_opciones = new JMenu("Opciones");
                JMenuItem menu_foja = new JMenuItem("Ver foja");
                JMenuItem menu_inscribirse = new JMenuItem("Inscripcion");
                menu_opciones.add(menu_foja);
                menu_opciones.add(menu_inscribirse);
                barra.add(menu_opciones);
                setJMenuBar(barra);
                ventana.setTitle("Bienvenido Alumno");

                //JOptionPane.showMessageDialog(Ventana.this, "Click en Nuevo", "Evento en menu", JOptionPane.OK_OPTION);

                menu_foja.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        Alumno alumno = new Alumno(0,"Omar","Gomez", 001,1,"ogomez@unq.com","ogomez");
                        menuMostrarFoja(alumno);
                    }
                });
            }
        });
    }

    private void menuMostrarFoja(Alumno alumno) {
        JLabel texto = new JLabel();
        texto.setText("Foja del alumno " +alumno.getNombre()+" "+alumno.getApellido()+", legajo: "+alumno.getLegajo() +"\n");
        String contenido = texto.getText();
        contenido = contenido + ("- - - - - - - - - - - - - - - - - - - - - - - - - - - - \n");

        alumno.getFoja().generarHistorial();
        if(alumno.getFoja().getHistorial().size()>0) {
            CursadasBD cursadasBD=new CursadasBD();
            MateriaBD materiaBD=new MateriaBD();

            for (Historial historial : alumno.getFoja().getHistorial()) {
                Cursadas cursadas=cursadasBD.buscarPorID(historial.getCursada_id());
                Materia materia=materiaBD.buscarPorID(cursadas.getMateria_id());

                contenido = contenido + "Materia: "+materia.getNombre()+" - Promedio: "+historial.getPromedio()+ " - Fecha: "+historial.getFecha()+"\n";

            }
        }else{
            contenido = contenido + "Foja vacia. \n";
        }
        contenido = contenido + "- - - - - - - - - - - - - - - - - - - - - - - - - - - - \n";
        contenido = contenido + "Presione intro para volver \n";
        texto.setText(contenido);
        this.add(texto);
        this.setVisible(true);
        //Invocamos un método sobre un objeto Scanner
        //entradaEscaner.nextLine ();
       // this.clearScreen();
       // this.menuPrincipalAlumnos();
       // this.setVisible(true);

    }
}
