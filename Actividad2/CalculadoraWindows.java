package CursoJava_InterfacesGraficas.Actividad2;

import javax.swing.*;
import java.awt.*;

public class CalculadoraWindows {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(340, 540);
        
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        frame.add(panelPrincipal);
        
        JPanel panelInput = new JPanel(new GridLayout(1, 1));
        JTextField display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 150));
        /*display.setEditable(false);*/
        display.setHorizontalAlignment(JTextField.RIGHT);
        panelInput.add(display);

        panelPrincipal.add(panelInput, BorderLayout.NORTH);

        JPanel panelTeclado = new JPanel(new GridLayout(6, 4, 5, 5));

        JButton procentaje = new JButton("%");
        panelTeclado.add(procentaje);
        JButton raiz = new JButton("√");
        panelTeclado.add(raiz);
        JButton cuadrado = new JButton("x²");
        panelTeclado.add(cuadrado);
        JButton inversur = new JButton("¹/x");
        panelTeclado.add(inversur);

        JButton borrar = new JButton("CE");
        panelTeclado.add(borrar);
        JButton borrar2 = new JButton("C");
        panelTeclado.add(borrar2);
        JButton retroceso = new JButton("⌫");
        panelTeclado.add(retroceso);
        JButton dividir = new JButton("/");
        panelTeclado.add(dividir);

        JButton siete = new JButton("7");
        panelTeclado.add(siete);
        JButton ocho = new JButton("8");
        panelTeclado.add(ocho);
        JButton nueve = new JButton("9");
        panelTeclado.add(nueve);
        JButton multiplicar = new JButton("X");
        panelTeclado.add(multiplicar);

        JButton cuatro = new JButton("4");
        panelTeclado.add(cuatro);
        JButton cinco = new JButton("5");
        panelTeclado.add(cinco);
        JButton seis = new JButton("6");
        panelTeclado.add(seis);
        JButton restar = new JButton("-");
        panelTeclado.add(restar);

        JButton uno = new JButton("1");
        panelTeclado.add(uno);
        JButton dos = new JButton("2");
        panelTeclado.add(dos);
        JButton tres = new JButton("3");
        panelTeclado.add(tres);
        JButton sumar = new JButton("+");
        panelTeclado.add(sumar);

        JButton masMenos = new JButton("±");
        panelTeclado.add(masMenos);
        JButton cero = new JButton("0");
        panelTeclado.add(cero);
        JButton coma = new JButton(",");
        panelTeclado.add(coma);
        JButton igual = new JButton("=");
        panelTeclado.add(igual);

        panelPrincipal.add(panelTeclado, BorderLayout.CENTER);
        frame.setVisible(true);
    }

}
