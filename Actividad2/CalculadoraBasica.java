package CursoJava_InterfacesGraficas.Actividad2;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.awt.*;

public class CalculadoraBasica {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora que no respeta orden del calculo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 400);

        JPanel panel = new JPanel(new GridLayout(5, 0, 0, 0));

        panel.add(new JLabel());
        panel.add(new JLabel());
        panel.add(new JLabel());
        JTextField resultado = new JTextField();
        resultado.setEditable(false); // que no puedes escribir en el directamente
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

        panel.add(new JLabel());
        JButton cero = new JButton("0");
        panel.add(cero);
        JButton igual = new JButton("=");
        panel.add(igual);
        JButton restar = new JButton("-");
        panel.add(restar);

        frame.add(panel);
        frame.setVisible(true);

        StringBuilder expresion = new StringBuilder();

        igual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double resultadoFinal = evaluarExpresion(expresion.toString());
                resultado.setText(String.valueOf(resultadoFinal));
                expresion.setLength(0);
            }

        });

        nueve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expresion.append("9");
                resultado.setText(expresion.toString());
            }
        });

        ocho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expresion.append("8");
                resultado.setText(expresion.toString());
            }
        });

        siete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expresion.append("7");
                resultado.setText(expresion.toString());
            }
        });

        seis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expresion.append("6");
                resultado.setText(expresion.toString());
            }
        });

        cinco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expresion.append("5");
                resultado.setText(expresion.toString());
            }
        });

        cuatro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expresion.append("4");
                resultado.setText(expresion.toString());
            }
        });

        tres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expresion.append("3");
                resultado.setText(expresion.toString());
            }
        });

        dos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expresion.append("2");
                resultado.setText(expresion.toString());
            }
        });

        uno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expresion.append("1");
                resultado.setText(expresion.toString());
            }
        });

        cero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expresion.append("0");
                resultado.setText(expresion.toString());
            }
        });

        multiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expresion.append("*");
                resultado.setText(expresion.toString());
            }
        });

        sumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expresion.append("+");
                resultado.setText(expresion.toString());
            }
        });

        restar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expresion.append("-");
                resultado.setText(expresion.toString());
            }
        });

        dividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expresion.append("/");
                resultado.setText(expresion.toString());
            }
        });
    }

    private static double evaluarExpresion(String cadena) {
        Stack<Double> numeros = new Stack<>();
        Stack<Character> operadores = new Stack<>();

        
        for (int i = 0; i < cadena.length(); ) {
            char c = cadena.charAt(i);
                    if (Character.isDigit(c)) {
                double num = 0;
                        for (; i < cadena.length() && Character.isDigit(cadena.charAt(i)); i++) {
                    num = num * 10 + (cadena.charAt(i) - '0');
                }
                        numeros.push(num);
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                operadores.push(c);
                i++;
            } 
        }

        while (!operadores.isEmpty()) {
            double num1 = numeros.pop();
            double num2 = numeros.pop();
            char operador = operadores.pop();
            double resultado = 0;
            switch (operador) {
                case '+':
                    resultado = num2 + num1;
                    break;
                case '-':
                    resultado = num2 - num1;
                    break;
                case '*':
                    resultado = num2 * num1;
                    break;
                case '/':
                    resultado = num2 / num1;
                    break;
            }
            numeros.push(resultado);
        }
        return numeros.pop();
    }

}
