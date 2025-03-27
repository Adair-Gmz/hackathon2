import com.generations.agenda.Agenda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        String nombre = "", apellido = "", telefono = "";
        System.out.println("----AGENDA DE 10 CONTACTOS----");
        do {
            System.out.println("\n***Menú***\n");
            System.out.println("1. Añadir nuevo contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Modificar teléfono");
            System.out.println("6. Mostrar espacios libres");
            System.out.println("7. Nuevo límite de la agenda");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Cambiar Scanner a nextLine()

            switch (opcion) {
                case 1:
                    System.out.println("\n+++Añadir nuevo contacto+++\n");
                    System.out.print("Ingrese el nombre del nuevo contacto: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese el apellido del nuevo contacto: ");
                    apellido = scanner.nextLine();
                    System.out.print("Ingrese el teléfono del nuevo contacto: ");
                    telefono = scanner.nextLine();
                    if(nombre==""||apellido==""||telefono==""){
                        System.out.println("\n✖ Error ✖ | Llene todos los campos\nRegresando al menú");
                    }
                    else{
                        agenda.anadirContacto(nombre, apellido, telefono);
                    }
                    break;
                case 2:
                    System.out.println("\n+++Listar contactos+++");
                    agenda.listarContactos();
                    break;
                case 3:
                    System.out.println("\n+++Buscar un contacto+++\n");
                    System.out.print("Ingrese el nombre del contacto a buscar: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese el apellido del contacto a buscar: ");
                    apellido = scanner.nextLine();
                    agenda.buscarContacto(nombre, apellido);
                    break;
                case 4:
                    System.out.println("\n+++Eliminar un contacto+++\n");
                    System.out.print("Ingrese el nombre del contacto a eliminar: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese el apellido del contacto a eliminar: ");
                    apellido = scanner.nextLine();
                    agenda.eliminarContacto(nombre, apellido);
                    break;
                case 5:
                    System.out.println("\n+++Modificar teléfono de un contacto+++\n");
                    System.out.print("Ingrese el nombre del contacto a modificar: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese el apellido del contacto a modificar: ");
                    apellido = scanner.nextLine();
                    System.out.print("Ingrese el nuevo teléfono del contacto: ");
                    telefono = scanner.nextLine();
                    agenda.modificarTelefono(nombre, apellido, telefono);
                    break;
                case 6:
                    System.out.println("\n+++Espacios libres de la agenda+++\n");
                    agenda.espaciosLibres();
                    break;
                case 7:
                    System.out.println("\n+++Nuevo límite de la agenda+++\n");
                    System.out.print("Ingrese el nuevo limite: ");
                    int limite = scanner.nextInt();
                    if(limite>0){
                        agenda.nuevoLimite(limite);
                    }
                    else{
                        System.out.println("✖ Error ✖ | Ingrese un valor mayor a cero");
                    }
                    break;
                case 8:
                    System.out.println("\n---Programa terminado. Gracias por usar la agenda---");
                    break;
                default:
                    System.out.println("\nOpción no válida, ingrese una opción del 1-7");
                    break;
            }
        } while (opcion != 8);

        scanner.close();
    }
}