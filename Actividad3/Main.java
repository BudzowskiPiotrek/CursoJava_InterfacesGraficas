package CursoJava_InterfacesGraficas.Actividad3;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Formulario de registro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        frame.add(panelPrincipal);
        panelPrincipal.setBackground(Color.WHITE);

        // PANEL NORTE
        JPanel panelNorte = new JPanel(new GridLayout(6, 2, 5, 5));
        panelNorte.setPreferredSize(new Dimension(400, 300));
        panelNorte.setBackground(Color.WHITE);
        panelNorte.setForeground(Color.RED);

        JLabel nombreTexto = new JLabel("Introduce tu nombre:");
        JTextField nombre = new JTextField(20);
        JLabel apellidoTexto = new JLabel("Introduce tu apellido:");
        JTextField apellido = new JTextField(20);
        JLabel generoTexto = new JLabel("Introduce tu genero:");
        JTextField genero = new JTextField(20);
        JLabel usuarioTexto = new JLabel("Introduce tu nombre:");
        JTextField usuario = new JTextField(20);
        JLabel contrasenaTexto = new JLabel("Introduce tu nombre:");
        JTextField contrasena = new JTextField(20);
        JLabel telefonoTexto = new JLabel("Introduce tu nombre:");
        JTextField telefono = new JTextField(20);

        panelNorte.add(nombreTexto);
        panelNorte.add(nombre);
        panelNorte.add(apellidoTexto);
        panelNorte.add(apellido);
        panelNorte.add(generoTexto);
        panelNorte.add(genero);
        panelNorte.add(usuarioTexto);
        panelNorte.add(usuario);
        panelNorte.add(contrasenaTexto);
        panelNorte.add(contrasena);
        panelNorte.add(telefonoTexto);
        panelNorte.add(telefono);

        // PANEL CENTRO
        JPanel panelCentro = new JPanel(new GridLayout(4, 1, 1, 1));
        panelCentro.setPreferredSize(new Dimension(400, 170));
        panelCentro.setBackground(Color.WHITE);
        String[] destinos = {
                "Elija su destino", "Argentina", "Brasil", "Canadá", "Chile",
                "Colombia", "España", "Francia", "Italia", "México", "Perú"
        };
        JComboBox<String> destino = new JComboBox<>(destinos);
        destino.setSelectedIndex(0);
        JCheckBox vacunados = new JCheckBox("Vacunado");
        JCheckBox recien = new JCheckBox("Recien salio de enfermedad");
        JCheckBox autoinmune = new JCheckBox("Autoinmune");
        panelCentro.add(destino);
        panelCentro.add(vacunados);
        panelCentro.add(recien);
        panelCentro.add(autoinmune);

        // PANEL SUR
        JPanel panelSur = new JPanel(new GridLayout(1, 3, 10, 0));
        panelSur.setPreferredSize(new Dimension(400, 30));
        panelSur.setBackground(Color.WHITE);
        JButton modo = new JButton("Cambiar Modo");
        JButton enviar = new JButton("Enviar Datos");
        JButton borrar = new JButton("Borrar Datos");
        panelSur.add(modo);
        panelSur.add(enviar);
        panelSur.add(borrar);

        // AGREGANDO TODO AL FRAME

        panelPrincipal.add(panelNorte, BorderLayout.NORTH);
        panelPrincipal.add(panelCentro, BorderLayout.CENTER);
        panelPrincipal.add(panelSur, BorderLayout.SOUTH);

        frame.setVisible(true);

        modo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color nuevoFondo;
                Color nuevoTexto;

                if (panelPrincipal.getBackground() == Color.WHITE) {
                    nuevoFondo = Color.GRAY;
                    nuevoTexto = Color.WHITE;
                } else {
                    nuevoFondo = Color.WHITE;
                    nuevoTexto = Color.BLUE;
                }

                panelPrincipal.setBackground(nuevoFondo);
                panelNorte.setBackground(nuevoFondo);
                panelCentro.setBackground(nuevoFondo);
                panelSur.setBackground(nuevoFondo);
                nombreTexto.setForeground(nuevoTexto);
                apellidoTexto.setForeground(nuevoTexto);
                apellidoTexto.setForeground(nuevoTexto);
                apellidoTexto.setForeground(nuevoTexto);
                apellidoTexto.setForeground(nuevoTexto);
                
            }
        });

    }

}
