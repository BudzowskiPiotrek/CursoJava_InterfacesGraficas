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
        agregarDosReservasDePrueba(hotel);

        while (true) {
            String menu = "Bienvenido al menu del usuario:\n" +
                    "1. Añadir reserva\n" +
                    "2. Ver reservas\n" +
                    "3. Salir";
            int seleccion = Integer.parseInt(JOptionPane.showInputDialog(menu));

            if (seleccion == 1) {
                String nombre = pedirEntrada("Ingrese el nombre del cliente:");
                if (nombre == null)
                    return;

                String apellido = pedirEntrada("Ingrese el apellido del cliente:");
                if (apellido == null)
                    return;

                String documento = pedirEntrada("Ingrese el documento del cliente:");
                if (documento == null)
                    return;

                // VAMOS A COMPROBAR SI EL DOCUMENTO ES VALIDO
                String regex = "^\\d{8}[a-zA-Z]$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(documento);
                if (!matcher.matches()) {
                    JOptionPane.showMessageDialog(null, "El DNI no es válido.");
                    continue;
                }

                String numeroTarjeta = pedirEntrada(
                        "Ingrese el numero de cuenta bancaria (formato: xxxx-xxxx-xxxxxxxx):");
                if (numeroTarjeta == null)
                    return;

                // VAMOS A COMPROBAR SI NUMERO DE TARJETA ESTA BIEN
                regex = "^(\\d{4}[-\\s]?){3}\\d{4}$";
                pattern = Pattern.compile(regex);
                matcher = pattern.matcher(numeroTarjeta);
                if (!matcher.matches()) {
                    JOptionPane.showMessageDialog(null, "La cuenta bancaria no esta correcta.");
                    continue;
                }

                // CREAMOS EL OBJETO CLIENTE
                Cliente cliente = new Cliente(nombre, apellido, documento, numeroTarjeta);

                try {
                    String numeroHabitacionString = pedirEntrada("Ingrese el numero de la habitacion (1-10):");
                    if (numeroHabitacionString == null)
                        return;

                    // SE PARCEA STRING A INT
                    int numeroHabitacion = Integer.parseInt(numeroHabitacionString);

                    // COMPROBAMOS SI NUMERO DE HABITACION EXISTE
                    if (numeroHabitacion < 1 || numeroHabitacion > 10) {
                        JOptionPane.showMessageDialog(null, "Numero de habitacion invalido.");
                        continue;
                    }

                    // CREAMOS OBJETO HABITACION
                    Habitacion habitacionSeleccionada = hotel.getHabitacion()[numeroHabitacion - 1];

                    try {
                        String fechaStartString = pedirEntrada("Ingrese fecha de comienzo (formato: yyyy/MM/dd):");
                        if (fechaStartString == null)
                            return;

                        // SE PARCEA LA FECHA
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                        LocalDate fechaStart = LocalDate.parse(fechaStartString, formatter);

                        // COMPROBAMOS SI LA FECHA NO ES ANTERIOR A LA DE HOY
                        if (fechaStart.isBefore(LocalDate.now())) {
                            JOptionPane.showMessageDialog(null,
                                    "La fecha es incorrecta, no puedes reservar en el pasado");
                            continue;
                        }

                        String duracionString = pedirEntrada("Ingrese duracion de su estancia:");
                        if (duracionString == null)
                            return;

                        // SE PARCEA STRING A INT
                        int duracion = Integer.parseInt(duracionString);
                        Reservas reserva = new Reservas(fechaStart, duracion, cliente, habitacionSeleccionada);
                        hotel.getReservas().add(reserva);

                    } catch (DateTimeParseException e) {
                        JOptionPane.showMessageDialog(null, "Has ingresado Mal la fecha");
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Has ingresado letra en vez de numero de la habitacion");
                }

                // PARA MOSTRAR LAS RESERVAS
            } else if (seleccion == 2) {
                String reservasList = "";
                for (Reservas reserva : hotel.getReservas()) {
                    reservasList += reserva.toString() + "\n";
                }
                JOptionPane.showMessageDialog(null, "Reservas actuales:\n" + reservasList);

                // PARA SALIR DEL PROGRAMA
            } else if (seleccion == 3) {

                JOptionPane.showMessageDialog(null, "¡Gracias por usar el sistema! Adiós.");
                return;
            }
        }
    }

    public static String pedirEntrada(String mensaje) {
        String input = JOptionPane.showInputDialog(mensaje);
        if (input == null) {
            JOptionPane.showMessageDialog(null, "Cerrando la super App @Cristobal 2025");
        }
        return input;
    }

    public static void agregarDosReservasDePrueba(Hotel hotel) {
        // CREAMOS DOS CLIENTES PARA VER SI FUNCIONA MSOTRAR RESERVAS
        hotel.getReservas().add(new Reservas(LocalDate.of(2025, 5, 10), 3,
                new Cliente("Juan", "Pérez", "12345678A", "1234-1234-12345678"), hotel.getHabitacion()[0]));
        hotel.getReservas().add(new Reservas(LocalDate.of(2025, 5, 15), 5,
                new Cliente("Ana", "Gómez", "23456789B", "2345-2345-23456789"), hotel.getHabitacion()[1]));
    }
}
