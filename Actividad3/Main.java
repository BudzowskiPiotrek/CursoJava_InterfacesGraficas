package CursoJava_InterfacesGraficas.Actividad3;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Formulario de registro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setResizable(false);


        // PANEL PRINCIPAL
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
        JPasswordField contrasena = new JPasswordField(20);
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
        JPanel panelCentro = new JPanel(new GridLayout(4, 1, 5, 5));
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
        JPanel panelSur = new JPanel(new GridLayout(1, 3, 10, 5));
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

        // VARIAS FUNCIONES DE LOS BOTONES Y OTROS ESCUCHAS

        // BORRAR
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

        // MODO DIA/NOCHE
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

        // ENVIAR CON CAONVALIDAR TODOS LOS DATOS
        enviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreValor = nombre.getText().trim();
                String apellidoValor = apellido.getText().trim();
                String generoValor = genero.getText().trim().toLowerCase();
                String usuarioValor = usuario.getText().trim();
                String contrasenaValor = new String(((JPasswordField) contrasena).getPassword());
                String telefonoValor = telefono.getText().trim();
                String destinoValor = (String) destino.getSelectedItem();
                StringBuilder vacunasTexto = new StringBuilder();

                if (nombreValor.isEmpty()) {
                    mostrarError("El campo nombre no puede estar vacio.");
                    return;
                }

                if (!apellidoValor.matches("^[A-Za-zÁÉÍÓÚáéíóúñÑ]+\\s[A-Za-zÁÉÍÓÚáéíóúñÑ]+$")) {
                    mostrarError("El apellido debe contener exactamente dos palabras separadas por un espacio.");
                    return;
                }

                if (!generoValor.equals("masculino") && !generoValor.equals("femenino")
                        && !generoValor.equals("no contestar")) {
                    mostrarError("El genero debe ser Masculino, Femenino o No contestar.");
                    return;
                }

                if (usuarioValor.isEmpty()) {
                    mostrarError("El campo usuario no puede estar vacio.");
                    return;
                }

                if (!telefonoValor.matches("\\d+")) {
                    mostrarError("El teléfono debe contener solo numeros.");
                    return;
                }

                if (destino.getSelectedIndex() == 0) {
                    mostrarError("Debe elegir un destino.");
                    return;
                }

                int opcionesElegidas = 0;
                if (vacunados.isSelected()) {
                    opcionesElegidas++;
                    vacunasTexto.append("- Vacunado\n");
                }

                if (recien.isSelected()) {
                    opcionesElegidas++;
                    vacunasTexto.append("- Recien salio de enfermedad\n");
                }

                if (autoinmune.isSelected()) {
                    opcionesElegidas++;
                    vacunasTexto.append("- Autoinmune\n");
                }

                if (opcionesElegidas < 3) {
                    mostrarError("Debe seleccionar al menos tres opciones de vacunas.");
                    return;
                }

                StringBuilder comunicado = new StringBuilder();
                comunicado.append("Repaso de tu registro:\n\n");
                comunicado.append("Nombre: ").append(nombreValor).append("\n");
                comunicado.append("Apellidos: ").append(apellidoValor).append("\n");
                comunicado.append("Genero: ").append(generoValor).append("\n");
                comunicado.append("Usuario: ").append(usuarioValor).append("\n");
                comunicado.append("Contraseña: ").append(contrasenaValor).append("\n");
                comunicado.append("Telefono: ").append(telefonoValor).append("\n");
                comunicado.append("Destino: ").append(destinoValor).append("\n");
                comunicado.append("Vacunas:\n").append(vacunasTexto);

                javax.swing.JOptionPane.showMessageDialog(null, comunicado.toString(), "Datos Registrados",
                        javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        });

    }

    // METODO PARA EN CUAL INGRESAS TEXTO Y TE COMUNICA EL ERROR PARA AHORAR CODIGO
    private static void mostrarError(String mensaje) {
        javax.swing.JOptionPane.showMessageDialog(null, mensaje, "Error de validación",
                javax.swing.JOptionPane.ERROR_MESSAGE);
    }

    // METODO PARA CAMBIAR DISEÑO DE LA APP, COMO LA UTILIZO TANTO EL
    // ACCIONLISTENING Y EN EL MAIN
    // RECOGE TODOS BOTONES Y DOS COLORES, UNO DE FONDO OTRO DE TEXTO
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
