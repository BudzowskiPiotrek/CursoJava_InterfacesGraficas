package CursoJava_InterfacesGraficas.Actividad3Refactorizada;

import javax.swing.*;
import java.awt.*;

public class PanelSur extends JPanel {
    private final JButton modo, enviar, borrar;

    public PanelSur() {
        setLayout(new GridLayout(1, 3, 10, 5));
        modo = new JButton("Modo Oscuro");
        enviar = new JButton("Enviar Datos");
        borrar = new JButton("Borrar Datos");
        add(modo);
        add(enviar);
        add(borrar);
    }

    public JButton getModoButton() {
        return modo;
    }

    public JButton getEnviarButton() {
        return enviar;
    }

    public JButton getBorrarButton() {
        return borrar;
    }
}