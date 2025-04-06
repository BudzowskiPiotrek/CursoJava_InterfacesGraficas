package CursoJava_InterfacesGraficas.Actividad1;

public class Cliente extends Persona {
    private String numeroTarjeta;

    public Cliente(String nombre, String apellido, String documento, String numeroTarjeta) {
        super(nombre, apellido, documento);
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((numeroTarjeta == null) ? 0 : numeroTarjeta.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (numeroTarjeta == null) {
            if (other.numeroTarjeta != null)
                return false;
        } else if (!numeroTarjeta.equals(other.numeroTarjeta))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre  + " " + apellido+ "\nNumero tarjeta: " + numeroTarjeta
                + "\nDocumento: " + documento;
    }

    

}
