package CursoJava_InterfacesGraficas.Actividad3Refactorizada;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioDeRegistro extends JPanel {
    private final JFrame parentFrame;
    private final PanelNorte panelNorte;
    private final PanelCentro panelCentro;
    private final PanelSur panelSur;
    private boolean oscuro = false;

    public FormularioDeRegistro(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new BorderLayout());

        panelNorte = new PanelNorte();
        panelNorte.setPreferredSize(new Dimension(400, 300));

        panelCentro = new PanelCentro();
        panelCentro.setPreferredSize(new Dimension(400, 170));

        panelSur = new PanelSur();
        panelSur.setPreferredSize(new Dimension(400, 30));

        add(panelNorte, BorderLayout.NORTH);
        add(panelCentro, BorderLayout.CENTER);
        add(panelSur, BorderLayout.SOUTH);

        aplicarTema(Color.WHITE, Color.BLUE);

        panelSur.getEnviarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = panelNorte.getNombre();
                String apellido = panelNorte.getApellido();
                String genero = panelNorte.getGenero().toLowerCase();
                String usuario = panelNorte.getUsuario();
                String contrasena = panelNorte.getContrasena();
                String telefono = panelNorte.getTelefono();
                String destino = panelCentro.getDestino();

                if (nombre.isEmpty()) {
                    showError("El nombre no puede estar vacío.");
                    return;
                }
                if (!apellido.matches("^[A-Za-zÁÉÍÓÚáéíóúñÑ]+\\s[A-Za-zÁÉÍÓÚáéíóúñÑ]+$")) {
                    showError("El apellido debe ser dos palabras.");
                    return;
                }
                if (!(genero.equals("masculino") || genero.equals("femenino") || genero.equals("no contestar"))) {
                    showError("Género inválido.");
                    return;
                }
                if (usuario.isEmpty()) {
                    showError("El usuario no puede estar vacío.");
                    return;
                }
                if (!telefono.matches("\\d+")) {
                    showError("El teléfono solo números.");
                    return;
                }
                if (destino.equals("Elija su destino")) {
                    showError("Seleccione un destino.");
                    return;
                }

                int countVac = 0;
                if (panelCentro.isVacunado())
                    countVac++;
                if (panelCentro.isRecien())
                    countVac++;
                if (panelCentro.isAutoinmune())
                    countVac++;
                if (countVac < 3) {
                    showError("Seleccione al menos 3 vacunas.");
                    return;
                }

                StringBuilder comunicado = new StringBuilder();
                comunicado.append("--- Registro completado ---\n");
                comunicado.append("Nombre: ").append(nombre).append("\n");
                comunicado.append("Apellidos: ").append(apellido).append("\n");
                comunicado.append("Género: ").append(genero).append("\n");
                comunicado.append("Usuario: ").append(usuario).append("\n");
                comunicado.append("Contraseña: ").append(contrasena).append("\n");
                comunicado.append("Teléfono: ").append(telefono).append("\n");
                comunicado.append("Destino: ").append(destino).append("\n");
                comunicado.append("Vacunas seleccionadas:\n");
                if (panelCentro.isVacunado())
                    comunicado.append(" - Vacunado\n");
                if (panelCentro.isRecien())
                    comunicado.append(" - Recién salido de enfermedad\n");
                if (panelCentro.isAutoinmune())
                    comunicado.append(" - Autoinmune\n");
                parentFrame.setVisible(false);
                JOptionPane.showMessageDialog(null, comunicado.toString(), "Datos Registrados",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        panelSur.getBorrarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelNorte.resetFields();
                panelCentro.resetFields();
            }
        });

        panelSur.getModoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color fondo = oscuro ? Color.WHITE : Color.GRAY;
                Color texto = oscuro ? Color.BLUE : Color.WHITE;
                aplicarTema(fondo, texto);
                oscuro = !oscuro;
            }
        });
    }

    private void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error de validación", JOptionPane.ERROR_MESSAGE);
    }

    private void aplicarTema(Color fondo, Color texto) {
        setBackground(fondo);
        panelNorte.setBackground(fondo);
        panelCentro.setBackground(fondo);
        panelSur.setBackground(fondo);
        for (Component c : panelNorte.getComponents()) {
            c.setForeground(texto);
        }
        for (Component c : panelCentro.getComponents()) {
            c.setForeground(texto);
            c.setBackground(fondo);
        }
        for (Component c : panelSur.getComponents()) {
            c.setForeground(texto);
            c.setBackground(fondo);
        }

    }
}
