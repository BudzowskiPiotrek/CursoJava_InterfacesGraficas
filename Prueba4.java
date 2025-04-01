package CursoJava_InterfacesGraficas;

import javax.swing.JOptionPane;

public class Prueba4 {
    public static void main(String[] args) {
        // Muestra un diálogo de confirmación para asegurarse de que el usuario
        // realmente quiere eliminar el archivo
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres eliminar el archivo?",
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

        switch (respuesta) {
            case 0: // El usuario clic en "Sí"
                System.out.println("El archivo será eliminado.");
                // Aquí iría la lógica para eliminar el archivo
                break;
            case 1: // El usuario clic en "No"
                System.out.println("La eliminación del archivo ha sido cancelada.");
                // Lógica alternativa si el usuario decide no eliminar el archivo
                break;
            case -1: // El usuario cerró el diálogo
                System.out.println("El usuario cerró el diálogo. No se realizará ninguna acción.");
                // Manejo de la situación cuando el diálogo es cerrado sin una respuesta
                break;
        }
    }
}
