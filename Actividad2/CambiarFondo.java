package CursoJava_InterfacesGraficas.Actividad2;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class CambiarFondo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Trulululu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel(new GridLayout(2, 0, 0, 0));

        JButton button = new JButton("Gray");
        panel.add(button);
        JButton button2 = new JButton("Green");
        panel.add(button2);
        JButton button3 = new JButton("Orange");
        panel.add(button3);

        frame.add(panel);
        frame.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.GRAY);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.GREEN);
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setBackground(Color.ORANGE);
            }
        });

        /*
         * button.addActionListener(new ActionListener() {
         * 
         * @Override
         * public void actionPerformed(ActionEvent e) {
         * if (panel.getBackground() == Color.BLUE) {
         * panel.setBackground(Color.GRAY); // Cambiar a gris
         * } else {
         * panel.setBackground(Color.BLUE); // Cambiar a azul
         * }
         * }
         * });
         */

    }
}
