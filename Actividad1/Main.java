package CursoJava_InterfacesGraficas.Actividad1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Main {
    public static Hotel hotel = new Hotel();

    public static void main(String[] args) {
        agregarDosReservasDePrueba(hotel);
        boolean flag = true;

        while (flag) {
            String menu = "Bienvenido al menu del usuario:\n" +
                    "1. Añadir reserva\n" +
                    "2. Ver reservas\n" +
                    "3. Salir";
            int seleccion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            flag = menuSwitch(seleccion, flag);
        }
    }

    private static boolean menuSwitch(int seleccion, boolean flag) {
        switch (seleccion) {
            case 1:
                // CREAMOS CLIENTE LLAMANDO METODO CREARCLIENTE
                Cliente cliente = crearCliente();
                if (cliente == null)
                    return true; // SI NO SE CREA CLIENTE AL MENU

                // CREAMOS RESERVA LLAMANDO METODO CREARRESERVA
                Reservas reserva = crearReserva(cliente);
                if (reserva != null) {
                    hotel.getReservas().add(reserva); // Añadimos la reserva al hotel
                }
                break;
            case 2:
                mostrarResevas();
                break;
            case 3:
                Icon icono = new ImageIcon("yo.png");
                JOptionPane.showMessageDialog(null, "¡Gracias por usar mi Super App!", "Bye Bye my Love",
                        JOptionPane.INFORMATION_MESSAGE, icono);
                return false;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, 1,2 o 3");
                break;
        }
        return true;
    }

    // METODO PARA MOSTRAR RESERVAS
    private static void mostrarResevas() {
        String reservasList = "";
        for (Reservas reservaMostrar : hotel.getReservas()) {
            reservasList += reservaMostrar.toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, "Reservas actuales:\n" + reservasList);
    }

    // METODO SI PULSAS CANCELAR O X NO AVANZA
    public static String pedirEntrada(String mensaje) {
        String input = JOptionPane.showInputDialog(mensaje);
        if (input == null) {
            JOptionPane.showMessageDialog(null, "Volviendo al menu de la super App @Cristobal 2025");
        }
        return input;
    }

    // METODO CREAR CLIENTE
    public static Cliente crearCliente() {

        String nombre = pedirEntrada("Ingrese el nombre del cliente:");
        if (nombre == null)
            return null;

        String apellido = pedirEntrada("Ingrese el apellido del cliente:");
        if (apellido == null)
            return null;

        String documento = pedirEntrada("Ingrese el documento del cliente:");
        if (documento == null)
            return null;

        // VAMOS A COMPROBAR SI EL DOCUMENTO ES VALIDO
        String regex = "^\\d{8}[a-zA-Z]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(documento);
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(null, "El DNI no es válido.");
            return null;
        }

        String numeroTarjeta = pedirEntrada("Ingrese el numero de cuenta bancaria (formato: xxxx-xxxx-xxxxxxxx):");
        if (numeroTarjeta == null)
            return null;

        // VAMOS A COMPROBAR SI NUMERO DE TARJETA ESTA BIEN
        regex = "^(\\d{4}[-\\s]?){3}\\d{4}$";
        pattern = Pattern.compile(regex);
        matcher = pattern.matcher(numeroTarjeta);
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(null, "La cuenta bancaria no está correcta.");
            return null;
        }

        // CREAMOS EL OBJETO CLIENTE
        return new Cliente(nombre, apellido, documento, numeroTarjeta);
    }

    public static Reservas crearReserva(Cliente cliente) {
        try {
            String numeroHabitacionString = pedirEntrada("Ingrese el numero de la habitacion (1-10):");
            if (numeroHabitacionString == null)
                return null;

            // SE PARCEA STRING A INT
            int numeroHabitacion = Integer.parseInt(numeroHabitacionString);

            // COMPROBAMOS SI NUMERO DE HABITACION EXISTE
            if (numeroHabitacion < 1 || numeroHabitacion > 10) {
                JOptionPane.showMessageDialog(null, "Número de habitación inválido.");
                return null;
            }

            // CREAMOS OBJETO HABITACION
            Habitacion habitacionSeleccionada = hotel.getHabitacion()[numeroHabitacion - 1];

            String fechaStartString = pedirEntrada("Ingrese fecha de comienzo (formato: yyyy/MM/dd):");
            if (fechaStartString == null)
                return null;

            // SE PARCEA LA FECHA
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate fechaStart = LocalDate.parse(fechaStartString, formatter);

            // COMPROBAMOS SI LA FECHA NO ES ANTERIOR A LA DE HOY
            if (fechaStart.isBefore(LocalDate.now())) {
                JOptionPane.showMessageDialog(null, "La fecha es incorrecta, no puedes reservar en el pasado");
                return null;
            }

            String duracionString = pedirEntrada("Ingrese duración de su estancia:");
            if (duracionString == null)
                return null;

            // SE PARCEA STRING A INT
            int duracion = Integer.parseInt(duracionString);

            // CREAMOS Y RETORNAMOS EL OBJETO RESERVA
            return new Reservas(fechaStart, duracion, cliente, habitacionSeleccionada);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Has ingresado letra en vez de número de la habitación.");
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Has ingresado mal la fecha.");
        }

        return null; // En caso de error, retornamos null
    }

    public static void agregarDosReservasDePrueba(Hotel hotel) {
        // CREAMOS DOS CLIENTES PARA VER SI FUNCIONA MSOTRAR RESERVAS
        hotel.getReservas().add(new Reservas(LocalDate.of(2025, 5, 10), 3,
                new Cliente("Juan", "Pérez", "12345678A", "1234-1234-12345678"), hotel.getHabitacion()[0]));
        hotel.getReservas().add(new Reservas(LocalDate.of(2025, 5, 15), 5,
                new Cliente("Ana", "Gómez", "23456789B", "2345-2345-23456789"), hotel.getHabitacion()[1]));
    }
}
