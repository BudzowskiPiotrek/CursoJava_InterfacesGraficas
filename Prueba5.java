package CursoJava_InterfacesGraficas;
import javax.swing.JFrame;

public class Prueba5 {

    public static void main(String[] args) {
        // Crear un JFrame
        JFrame ventana = new JFrame("Mi primera ventana");

        // Configurar tamaño
        ventana.setSize(200, 1000);

        // Establecer comportamiento de cierre (cuando se cierra la ventana)
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hacer visible la ventana
        ventana.setVisible(true);
    }
}