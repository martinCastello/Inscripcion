import BD.*;
import Entidades.*;

import Servicios.ServiciosAlumno;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.bundle.LanternaThemes;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.Scanner;

public class Lanterna {

    public Lanterna() throws IOException {

        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        screen.startScreen();

        Label label = new Label("Bienvenidos a la Universidad Nacional de Quilmes \n");

        BasicWindow window = new BasicWindow();
        window.setComponent(label);

        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(),
                new EmptySpace(TextColor.ANSI.BLACK));
        gui.setTheme(LanternaThemes.getRegisteredTheme("businessmachine"));
        this.menuPrincipal(window, gui);

    }

    public void menuPrincipal(BasicWindow window, MultiWindowTextGUI gui){

        Label label = new Label( "Bienvenido a Inscripción");
        window.setComponent(label);
        gui.addWindow(window);
        gui.addWindowAndWait(window);
    }
}
