package CursoJava_InterfacesGraficas.Actividad2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;

public class CalculadoraBasica {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Trulululu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel(new GridLayout(5, 0, 0, 0));
        JLabel espacio1 = new JLabel("");
        panel.add(espacio1);
        JLabel espacio2 = new JLabel("");
        panel.add(espacio2);
        JLabel espacio3 = new JLabel("");
        panel.add(espacio3);
        JTextField resultado = new JTextField(20);
        panel.add(resultado);
        
        JButton siete = new JButton("7");
        panel.add(siete);
        JButton ocho = new JButton("8");
        panel.add(ocho);
        JButton nueve = new JButton("9");
        panel.add(nueve);
        JButton dividir = new JButton("/");
        panel.add(dividir);
        
        JButton cuatro = new JButton("4");
        panel.add(cuatro);
        JButton cinco = new JButton("5");
        panel.add(cinco);
        JButton seis = new JButton("6");
        panel.add(seis);
        JButton multiplicar = new JButton("*");
        panel.add(multiplicar);
             
        JButton uno = new JButton("1");
        panel.add(uno);
        JButton dos = new JButton("2");
        panel.add(dos);
        JButton tres = new JButton("3");
        panel.add(tres);
        JButton sumar = new JButton("+");
        panel.add(sumar);
       
        JLabel espacio4 = new JLabel("");
        panel.add(espacio4);
        JButton cero = new JButton("6");
        panel.add(cero);
        JLabel espacio5 = new JLabel("");
        panel.add(espacio5);
        JButton restar = new JButton("-");
        panel.add(restar);

        frame.add(panel);
        frame.setVisible(true);

    }
}
