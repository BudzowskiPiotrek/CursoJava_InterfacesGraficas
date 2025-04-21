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

        // PANEL NORTE
        JPanel panelNorte = new JPanel(new GridLayout(6, 2, 5, 5));
        panelNorte.setPreferredSize(new Dimension(400, 300));

        JLabel nombreTexto = new JLabel("Introduce tu nombre:");
        JTextField nombre = new JTextField(20);
        JLabel apellidoTexto = new JLabel("Introduce tu apellido:");
        JTextField apellido = new JTextField(20);
        JLabel generoTexto = new JLabel("Introduce tu genero:");
        JTextField genero = new JTextField(20);
        JLabel usuarioTexto = new JLabel("Introduce tu usuario:");
        JTextField usuario = new JTextField(20);
        JLabel contrasenaTexto = new JLabel("Introduce tu contraseña:");
        JTextField contrasena = new JTextField(20);
        JLabel telefonoTexto = new JLabel("Introduce tu telefono:");
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

        JButton modo = new JButton("Cambiar Modo");
        JButton enviar = new JButton("Enviar Datos");
        JButton borrar = new JButton("Borrar Datos");
        panelSur.add(modo);
        panelSur.add(enviar);
        panelSur.add(borrar);

        coloresDiseno(panelPrincipal, panelNorte, panelCentro, panelSur,
                nombreTexto, apellidoTexto, generoTexto, usuarioTexto,
                contrasenaTexto, telefonoTexto,
                vacunados, recien, autoinmune,
                destino, Color.WHITE, Color.BLUE);

        // AGREGANDO TODO AL FRAME
        panelPrincipal.add(panelNorte, BorderLayout.NORTH);
        panelPrincipal.add(panelCentro, BorderLayout.CENTER);
        panelPrincipal.add(panelSur, BorderLayout.SOUTH);
        frame.setVisible(true);


        // FUNCIONES DE LOS BOTONES Y OTROS ESCUCHAS
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombre.setText("");
                apellido.setText("");
                genero.setText("");
                usuario.setText("");
                contrasena.setText("");
                telefono.setText("");
                destino.setSelectedIndex(0);
                vacunados.setSelected(false);
                recien.setSelected(false);
                autoinmune.setSelected(false);
            }
        });

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
                coloresDiseno(panelPrincipal, panelNorte, panelCentro, panelSur,
                        nombreTexto, apellidoTexto, generoTexto, usuarioTexto,
                        contrasenaTexto, telefonoTexto,
                        vacunados, recien, autoinmune,
                        destino, nuevoFondo, nuevoTexto);

            }
        });

    }

    public static void coloresDiseno(JPanel panelPrincipal, JPanel panelNorte, JPanel panelCentro, JPanel panelSur,
            JLabel nombreTexto, JLabel apellidoTexto, JLabel generoTexto, JLabel usuarioTexto,
            JLabel contrasenaTexto, JLabel telefonoTexto,
            JCheckBox vacunados, JCheckBox recien, JCheckBox autoinmune,
            JComboBox<String> destino, Color nuevoFondo, Color nuevoTexto) {

        panelPrincipal.setBackground(nuevoFondo);
        panelNorte.setBackground(nuevoFondo);
        panelCentro.setBackground(nuevoFondo);
        panelSur.setBackground(nuevoFondo);
        vacunados.setBackground(nuevoFondo);
        recien.setBackground(nuevoFondo);
        autoinmune.setBackground(nuevoFondo);
        destino.setBackground(nuevoFondo);

        nombreTexto.setForeground(nuevoTexto);
        apellidoTexto.setForeground(nuevoTexto);
        generoTexto.setForeground(nuevoTexto);
        usuarioTexto.setForeground(nuevoTexto);
        contrasenaTexto.setForeground(nuevoTexto);
        telefonoTexto.setForeground(nuevoTexto);
        vacunados.setForeground(nuevoTexto);
        recien.setForeground(nuevoTexto);
        autoinmune.setForeground(nuevoTexto);
        destino.setForeground(nuevoTexto);

    }

}
