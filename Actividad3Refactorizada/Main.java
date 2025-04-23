package CursoJava_InterfacesGraficas.Actividad3Refactorizada;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Formulario de Registro");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);
            frame.setResizable(false);

            FormularioDeRegistro formulario = new FormularioDeRegistro(frame);
            frame.setContentPane(formulario);
            frame.setVisible(true);
        });
    }
}
