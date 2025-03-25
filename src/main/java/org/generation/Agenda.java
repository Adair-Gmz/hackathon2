package org.generation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 Gestiona una colección de contactos con capacidad limitada.
 Permite añadir, eliminar, buscar y modificar contactos.
 */
public class Agenda {
    private int maxContactos;       // Número máximo de contactos permitidos
    private List<Contacto> contactos; // Lista dinámica para almacenar los contactos

    /*
     Constructor personalizado.
     @param maxContactos Capacidad máxima de la agenda (debe ser un número positivo).
     */
    public Agenda(int maxContactos) {
        // Asigna el máximo de contactos recibido al campo 'maxContactos'
        this.maxContactos = maxContactos;
        // Inicializa la lista de contactos como una ArrayList vacía
        this.contactos = new ArrayList<>();
    }

    /*
     Constructor por defecto.
     Crea una agenda con capacidad para 10 contactos.
     */
    public Agenda() {
        this(10); // Llama al constructor personalizado con el valor por defecto 10
    }

    /*
     Añade un nuevo contacto a la agenda si es válido y hay espacio.
     @param c Contacto a añadir.
     @return true si se añadió exitosamente, false en caso contrario.
     */
    public boolean añadirContacto(Contacto c) {
        // Validación 1: Verifica que nombre y apellido no sean cadenas vacías o espacios en blanco
        if (c.getNombre().trim().isEmpty() || c.getApellido().trim().isEmpty()) {
            System.out.println("Error: Nombre y apellido no pueden estar vacíos.");
            return false; // Retorna temprano si la validación falla
        }

        // Validación 2: Verifica si el contacto ya existe en la lista
        if (existeContacto(c)) {
            System.out.println("Error: El contacto ya existe.");
            return false;
        }

        // Validación 3: Verifica si la agenda ha alcanzado su capacidad máxima
        if (agendaLlena()) {
            System.out.println("Error: Agenda llena.");
            return false;
        }

        // Si pasa todas las validaciones, añade el contacto a la lista
        contactos.add(c);
        System.out.println("Contacto añadido.");
        return true;
    }

    /*
     Verifica si un contacto ya existe en la agenda.
     @param c Contacto a buscar.
     @return true si existe, false en caso contrario.
     */
    public boolean existeContacto(Contacto c) {
        // El método contains() usa el método equals() de Contacto para comparar
        return contactos.contains(c);
    }

    /*
     Muestra todos los contactos ordenados alfabéticamente por nombre y apellido.
     Si la agenda está vacía, muestra un mensaje indicándolo.
     */
    public void listarContactos() {
        // Paso 1: Verifica si la lista está vacía
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacia.");
            return; // Sale del método temprano
        }

        // Paso 2: Crea una copia de la lista para no modificar el orden original
        List<Contacto> ordenados = new ArrayList<>(contactos);

        // Paso 3: Ordena la lista usando un Comparator personalizado
        Collections.sort(ordenados, new Comparator<Contacto>() {
            @Override
            public int compare(Contacto c1, Contacto c2) {
                // Compara los nombres ignorando mayúsculas/minúsculas
                int cmpNombre = c1.getNombre().compareToIgnoreCase(c2.getNombre());
                if (cmpNombre != 0) {
                    return cmpNombre; // Si los nombres son diferentes, retorna el resultado
                }
                // Si los nombres son iguales, compara los apellidos
                return c1.getApellido().compareToIgnoreCase(c2.getApellido());
            }
        });

        // Paso 4: Imprime cada contacto en el formato "Nombre Apellido - Teléfono"
        System.out.println("--- CONTACTOS ---");
        for (Contacto c : ordenados) {
            // Usa printf para formatear la salida de manera clara
            System.out.printf("%s %s - %s%n", c.getNombre(), c.getApellido(), c.getTelefono());
        }
    }

    /*
     Busca un contacto por nombre y apellido y muestra su teléfono.
     @param nombre Nombre del contacto a buscar.
     @param apellido Apellido del contacto a buscar.
     */
    public void buscaContacto(String nombre, String apellido) {
        // Crea un contacto temporal con los datos de búsqueda (teléfono vacío)
        Contacto dummy = new Contacto(nombre, apellido, "");
        // Itera sobre cada contacto en la lista
        for (Contacto c : contactos) {
            // Usa equals() para comparar (ignora teléfono)
            if (c.equals(dummy)) {
                System.out.printf("Telefono: %s%n", c.getTelefono());
                return; // Sale del método si encuentra el contacto
            }
        }
        // Si termina el bucle sin encontrar, muestra mensaje
        System.out.println("Contacto no encontrado.");
    }

    /*
     Elimina un contacto de la agenda.
     @param c Contacto a eliminar.
     @return true si se eliminó exitosamente, false si no existe.
     */
    public boolean eliminarContacto(Contacto c) {
        // Intenta eliminar el contacto (remove() usa equals() para buscar)
        boolean eliminado = contactos.remove(c);
        // Muestra mensaje según el resultado
        System.out.println(eliminado ? "Contacto eliminado." : "Contacto no existe.");
        return eliminado;
    }

    /*
     Actualiza el teléfono de un contacto existente.
     @param nombre Nombre del contacto a modificar.
     @param apellido Apellido del contacto a modificar.
     @param nuevoTelefono Nuevo número de teléfono.
     */
    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        // Crea un contacto temporal para buscar
        Contacto dummy = new Contacto(nombre, apellido, "");
        // Itera sobre cada contacto en la lista
        for (Contacto c : contactos) {
            if (c.equals(dummy)) {
                // Si encuentra el contacto, actualiza su teléfono
                c.setTelefono(nuevoTelefono);
                System.out.println("Telefono actualizado.");
                return; // Sale del método después de actualizar
            }
        }
        // Si no encontró el contacto, muestra mensaje
        System.out.println("Contacto no existe.");
    }

    /*
     Verifica si la agenda ha alcanzado su capacidad máxima.
     @return true si está llena, false si aún hay espacio.
     */
    public boolean agendaLlena() {
        // Compara el tamaño actual de la lista con el máximo permitido
        return contactos.size() >= maxContactos;
    }

    /*
     Calcula cuántos espacios disponibles quedan en la agenda.
     @return Número de contactos que aún se pueden añadir.
     */
    public int espacioLibres() {
        // Resta el tamaño actual de la lista al máximo permitido
        return maxContactos - contactos.size();
    }
}