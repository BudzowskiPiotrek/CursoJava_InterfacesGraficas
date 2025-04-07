package CursoJava_InterfacesGraficas.Actividad2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.*;

public class GenerarNumero {
    public static void main(String[] args) {
        Random rm = new Random();
        JFrame frame = new JFrame("Trulululu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel(new GridLayout(3, 0, 0, 0));

        JButton button = new JButton("General");
        panel.add(button);

        JTextField textField = new JTextField(20);
        panel.add(textField);

        JLabel menor = new JLabel("Introduce tu nombre:");
        panel.add(menor);
        JTextField campoUno = new JTextField(20);
        panel.add(campoUno);

        JLabel mayor = new JLabel("Introduce tu nombre:");
        panel.add(mayor);
        JTextField campoDos = new JTextField(20);
        panel.add(campoDos);

        frame.add(panel);
        frame.setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int minimo = Integer.parseInt(campoUno.getText());
                int maximo = Integer.parseInt(campoDos.getText());

                int numeroAleatorio = rm.nextInt(maximo - minimo + 1) + minimo;
                textField.setText(String.valueOf(numeroAleatorio));
            }
        });
    }
}
