package CursoJava_InterfacesGraficas.Actividad1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hotel {

    private Habitacion[] habitacion;
    private List<Reservas> reservas;

    public Hotel() {
        this.habitacion = new Habitacion[10];
        this.reservas = new ArrayList<>();
        inicializacion();
    }

    public Habitacion[] getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion[] habitacion) {
        this.habitacion = habitacion;
    }

    public List<Reservas> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reservas> reservas) {
        this.reservas = reservas;
    }
    

    private void inicializacion() {
        for (int i = 0; i < 6; i++) {
            habitacion[i] = new Habitacion(Tipos.SIMPLE, 50);
        }
        for (int i = 6; i < 8; i++) {
            habitacion[i] = new Habitacion(Tipos.DOUBLE, 80);
        }
        for (int i = 8; i < 10; i++) {
            habitacion[i] = new Habitacion(Tipos.SUITE, 150);
        }

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(habitacion);
        result = prime * result + ((reservas == null) ? 0 : reservas.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Hotel other = (Hotel) obj;
        if (!Arrays.equals(habitacion, other.habitacion))
            return false;
        if (reservas == null) {
            if (other.reservas != null)
                return false;
        } else if (!reservas.equals(other.reservas))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Hotel [habitacion=" + Arrays.toString(habitacion) + ", reservas=" + reservas + "]";
    }

}