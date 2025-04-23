package CursoJava_InterfacesGraficas.Actividad3Refactorizada;

import javax.swing.*;
import java.awt.*;

public class PanelNorte extends JPanel {
    private final JTextField nombre, apellido, genero, usuario, telefono;
    private final JPasswordField contrasena;

    public PanelNorte() {
        setLayout(new GridLayout(6, 2, 5, 5));
        nombre = new JTextField(20);
        apellido = new JTextField(20);
        genero = new JTextField(20);
        usuario = new JTextField(20);
        contrasena = new JPasswordField(20);
        telefono = new JTextField(20);

        add(new JLabel("Nombre:"));
        add(nombre);
        add(new JLabel("Apellidos:"));
        add(apellido);
        add(new JLabel("Género:"));
        add(genero);
        add(new JLabel("Usuario:"));
        add(usuario);
        add(new JLabel("Contraseña:"));
        add(contrasena);
        add(new JLabel("Teléfono:"));
        add(telefono);
    }

    public String getNombre() {
        return nombre.getText().trim();
    }

    public String getApellido() {
        return apellido.getText().trim();
    }

    public String getGenero() {
        return genero.getText().trim();
    }

    public String getUsuario() {
        return usuario.getText().trim();
    }

    public String getContrasena() {
        return new String(contrasena.getPassword());
    }

    public String getTelefono() {
        return telefono.getText().trim();
    }

    public void resetFields() {
        nombre.setText("");
        apellido.setText("");
        genero.setText("");
        usuario.setText("");
        contrasena.setText("");
        telefono.setText("");
    }
}