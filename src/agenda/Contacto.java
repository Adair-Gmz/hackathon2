package agenda;

public class Contacto {
    private String nombre;
    private String apellido;
    private int numero;

    public Contacto(String nombre, String apellido, int numero) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero = numero;
    }

    public Contacto(String nombre) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public boolean equals(Contacto contacto) {
        if (nombre.trim().equalsIgnoreCase(contacto.getNombre().trim())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\nNombre : " + nombre + "\nApellido : " + apellido + "\nNumero : " + numero + "\n";
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Contacto contacto = (Contacto) obj;
        return nombre.equals(contacto.nombre) &&
                apellido.equals(contacto.apellido) &&
                numero == contacto.numero;
    }

}
