package CursoJava_InterfacesGraficas.Actividad1;

public class Habitacion {
    private int numero;
    private Tipos tipos;
    private int precio;
    private static int contador = 1;

    public Habitacion(Tipos tipos, int precio) {
        this.numero = contador;
        this.tipos = tipos;
        this.precio = precio;
        contador++;
    }

    public int getNumero() {
        return numero;
    }

    public Tipos getTipos() {
        return tipos;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTipos(Tipos tipos) {
        this.tipos = tipos;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numero;
        result = prime * result + ((tipos == null) ? 0 : tipos.hashCode());
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
        Habitacion other = (Habitacion) obj;
        if (numero != other.numero)
            return false;
        if (tipos != other.tipos)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Habitacion num: " + numero + ", tipos: " + tipos;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Habitacion.contador = contador;
    }

}
