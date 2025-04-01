package CursoJava_InterfacesGraficas.Actividad1;

import java.time.LocalDate;

public class Reservas {
    private LocalDate fechaStart;
    private int numDias;
    private Cliente cliente;
    private Habitacion habitacion;

    public Reservas(LocalDate fechaStart, int numDias, Cliente cliente, Habitacion habitacion) {
        this.fechaStart = fechaStart;
        this.numDias = numDias;
        this.cliente = cliente;
        this.habitacion = habitacion;
    }

    public LocalDate getFechaStart() {
        return fechaStart;
    }

    public void setFechaStart(LocalDate fechaStart) {
        this.fechaStart = fechaStart;
    }

    public int getNumDias() {
        return numDias;
    }

    public void setNumDias(int numDias) {
        this.numDias = numDias;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public double getImporte() {
        return habitacion.getPrecio() * numDias;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((fechaStart == null) ? 0 : fechaStart.hashCode());
        result = prime * result + numDias;
        result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
        result = prime * result + ((habitacion == null) ? 0 : habitacion.hashCode());
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
        Reservas other = (Reservas) obj;
        if (fechaStart == null) {
            if (other.fechaStart != null)
                return false;
        } else if (!fechaStart.equals(other.fechaStart))
            return false;
        if (numDias != other.numDias)
            return false;
        if (cliente == null) {
            if (other.cliente != null)
                return false;
        } else if (!cliente.equals(other.cliente))
            return false;
        if (habitacion == null) {
            if (other.habitacion != null)
                return false;
        } else if (!habitacion.equals(other.habitacion))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Reservas [fechaStart=" + fechaStart + ", numDias=" + numDias + ", cliente=" + cliente + ", habitacion="
                + habitacion + "]";
    }

}
