package CursoJava_InterfacesGraficas.Actividad3Refactorizada;

import javax.swing.*;
import java.awt.*;

public class PanelCentro extends JPanel {
    private final JComboBox<String> destino;
    private final JCheckBox vacunados, recien, autoinmune;

    public PanelCentro() {
        setLayout(new GridLayout(4, 1, 5, 5));
        String[] paises = { "Elija su destino", "Argentina", "Brasil", "Canadá", "Chile",
                "Colombia", "España", "Francia", "Italia", "México", "Perú" };
        destino = new JComboBox<>(paises);
        vacunados = new JCheckBox("Vacunado");
        recien = new JCheckBox("Recien salio de enfermedad");
        autoinmune = new JCheckBox("Autoinmune");

        add(destino);
        add(vacunados);
        add(recien);
        add(autoinmune);
    }

    public String getDestino() {
        return (String) destino.getSelectedItem();
    }

    public boolean isVacunado() {
        return vacunados.isSelected();
    }

    public boolean isRecien() {
        return recien.isSelected();
    }

    public boolean isAutoinmune() {
        return autoinmune.isSelected();
    }

    public void resetFields() {
        destino.setSelectedIndex(0);
        vacunados.setSelected(false);
        recien.setSelected(false);
        autoinmune.setSelected(false);
    }
}
