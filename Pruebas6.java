package CursoJava_InterfacesGraficas;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Pruebas6 {
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Ejemplo de Componentes en JPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        // Crear un panel
        JPanel panel = new JPanel(new GridLayout(4, 5, 1, 6));

        // Crear etiqueta añadimos la etiqueta al panel
        JLabel label = new JLabel("Introduce tu nombre:");
        panel.add(label);

        // Crear campo de texto añadimos el campo de texto al panel
        JTextField textField = new JTextField(20); // 20 columnas de ancho
        panel.add(textField);

        // Crear botón añadimos el boton al panel
        JButton button = new JButton("Saludar");
        panel.add(button);
        panel.add(new JButton("Botón 1"));

        // Crear casilla de verificación añadimos la casilla al panel
        JCheckBox checkBox = new JCheckBox("Mostrar saludo");
        panel.add(checkBox);

        // añadimos escucha
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        // le damos color al fondo
        panel.setBackground(Color.BLUE);

        // Agregar el panel al marco
        frame.add(panel);

        // Hacer visible la ventana
        frame.setVisible(true);
    }
}
