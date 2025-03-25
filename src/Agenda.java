import java.util.HashMap;
import java.util.Map;

public class Agenda {
    private int tamMax;
    //key: String con nombre y apellido en minúsculas value: Objeto contacto
    private Map<String, Contacto> contactos;

    public Agenda(int tamMax) {
        this.tamMax = tamMax;
        this.contactos = new HashMap<>();
    }

    public void añadirContacto(Contacto c){
        //método que establecimos en el objeto contacto que construye el nombre completo usando nombre y apellido
        String key = c.getNombreCompleto().toLowerCase();
        //compara el tamaño de la agenda y si es mayor a 10, devuelve un aviso
        //usa el método .size() propio de HashMap
        if(contactos.size() >= tamMax){
            System.out.println("La agenda está llena, no se pueden añadir más");
        }
        //usa el método .containskey() propio de HashMap para evaluar si el nombre la existe
        if(contactos.containsKey(key)){
            System.out.println("El contacto con ese nombre ya existe");
        }else {
            contactos.put(key, c);
            System.out.println("Contacto añadido: " + c);
        }
    }

    public void eliminarContacto(String nombre, String apellido){
        // recibe nom y apellido y construye un nombre completo para formar una key
        String key = (nombre + " " + apellido ).toLowerCase();
        if(contactos.containsKey(key)){
            System.out.println("Contacto eliminado");
            contactos.remove(key);
        } else {
            System.out.println("El contacto no existe");
        }
    }

    public void listarTodos(){
        if(contactos.isEmpty()){
            System.out.println("La agenda está vacía");
        } else {
            System.out.println(contactos.values());
        }
    }

    public void modificarContacto(Contacto c){
        // recibe nom/apellido, construye una key y la usa para buscar ese valor y modificar directamente el teléfono
        String key = c.getNombreCompleto().toLowerCase();
        if(contactos.containsKey(key)){
            contactos.get(key).setTelefono(c.getTelefono());
        } else{
            System.out.println("El contacto no existe");
        }

    }

    public void buscarContacto(String nombre, String apellido){
        String key = (nombre + " " + apellido ).toLowerCase();
        if(contactos.containsKey(key)){
            System.out.println(contactos.get(key));
        } else{
            System.out.println("El contacto no existe");
        }
    }

    public void espacioAgenda(){
        if(contactos.size() >= tamMax){
            System.out.println("La agenda llegó a su capacidad máxima");
        }else{
            System.out.println("El espacio disponible es de: " + (tamMax-contactos.size()));
        }
    }


}
