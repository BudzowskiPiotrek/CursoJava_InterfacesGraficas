package CursoJava_InterfacesGraficas.Actividad1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();

        while (true) {
            int seleccion = JOptionPane.showConfirmDialog(null, "Quieres hacer una reserva?: ");

            if (seleccion == 0) {
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
                String apellido = JOptionPane.showInputDialog("Ingrese el apellido del cliente:");
                String documento = JOptionPane.showInputDialog("Ingrese el documento del cliente:");
                // VAMOS A COMPROBAR SI EL DOCUMENTO ES VALIDO
                String regex = "^\\d{8}[a-zA-Z]$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(documento);
                if (!matcher.matches()) {
                    JOptionPane.showMessageDialog(null, "El DNI no es válido.");
                    continue;
                }
                String numeroTarjeta = JOptionPane.showInputDialog("Ingrese el numero de tarjeta del cliente:");
                // VAMOS A COMPROBAR SI NUMERO DE TARJETA ESTA BIEN
                regex = "^(\\d{4}[-\\s]?){3}\\d{4}$";
                pattern = Pattern.compile(regex);
                matcher = pattern.matcher(numeroTarjeta);
                if (!matcher.matches()) {
                    JOptionPane.showMessageDialog(null, "La cuenta bancaria no esta correcta.");
                    continue;
                }
                // CREAMOS EL OBJETO
                Cliente cliente = new Cliente(nombre, apellido, documento, numeroTarjeta);
                try {
                    String numeroHabitacionString = JOptionPane
                            .showInputDialog("Ingrese el numero de la habitacion (1-10)");
                    int numeroHabitacion = Integer.parseInt(numeroHabitacionString);
                    // COMPROBAMOS SI NUMERO DE HABITACION EXISTE
                    if (numeroHabitacion < 1 || numeroHabitacion > 10) {
                        JOptionPane.showMessageDialog(null, "Numero de habitacion invalido.");
                        continue;
                    }
                    Habitacion habitacionSeleccionada = hotel.getHabitacion()[numeroHabitacion - 1];
                    try {
                        String fechaStartString = JOptionPane
                                .showInputDialog("Ingrese fecha de comienzo (formato: yyyy/MM/dd)");
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                        LocalDate fechaStart = LocalDate.parse(fechaStartString, formatter);
                        // COMPROBAMOS SI LA FECHA NO ES ANTERIOR A LA DE HOY
                        if (fechaStart.isBefore(LocalDate.now())) {
                            JOptionPane.showMessageDialog(null,
                                    "La fecha es incorrecta, no puedes reservar en el pasado");
                            continue;
                        }
                        String duracionString = JOptionPane.showInputDialog("Ingrese duracion de su estancia:");
                        int duracion = Integer.parseInt(duracionString);
                        Reservas reserva = new Reservas(fechaStart, duracion, cliente, habitacionSeleccionada);
                        hotel.getReservas().add(reserva);
                    } catch (DateTimeParseException e) {
                        JOptionPane.showMessageDialog(null, "Has ingresado Mal la fecha");
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Has ingresado letra en vez de numero de la habitacion");
                }

            } else {
                break;
            }
        }
    }

}
