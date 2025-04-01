package CursoJava_InterfacesGraficas;

import javax.swing.JOptionPane;

public class Prueba2 {
    public static void main(String[] args) {
        String respuesta = JOptionPane.showInputDialog("¿Cuál es tu nombre?");
        JOptionPane.showMessageDialog(null, "Hola, " + respuesta + "!");
    }
}
