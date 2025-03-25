public class Contacto {
    private String nombre;
    private String apellido;
    private String telefono;

    public Contacto(String nombre, String apellido, String telefono) {
        if(nombre == null || apellido == null || nombre.isEmpty() || apellido.isEmpty()){
            throw new IllegalArgumentException("El campo nombre y apellido no pueden estar vacíos");
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreCompleto(){
        return this.nombre + " " + this.apellido;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " " + "- " + telefono;
    }
}
