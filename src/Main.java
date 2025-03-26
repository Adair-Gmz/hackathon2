import com.generations.agenda.Agenda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        System.out.println("----AGENDA DE 10 CONTACTOS----");
        do {
            System.out.println("\n***Menú***:");
            System.out.println("1. Añadir nuevo contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Eliminar contacto");
            System.out.println("5. Modificar teléfono");
            System.out.println("6. Mostrar espacios libres");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del contacto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese el apellido del contacto: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Ingrese el teléfono del contacto: ");
                    String telefono = scanner.nextLine();
                    agenda.añadirContacto(nombre, apellido, telefono);
                    break;
                case 2:
                    agenda.listarContactos();
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del contacto a consultar: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese el apellido del contacto a consultar: ");
                    apellido = scanner.nextLine();
                    agenda.buscarContacto(nombre, apellido);
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del contacto a eliminar: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese el apellido del contacto a eliminar: ");
                    apellido = scanner.nextLine();
                    agenda.eliminarContacto(nombre, apellido);
                    break;
                case 5:
                    System.out.print("Ingrese el nombre del contacto a modificar: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese el apellido del contacto a modificar: ");
                    apellido = scanner.nextLine();
                    System.out.print("Ingrese el nuevo teléfono del contacto: ");
                    telefono = scanner.nextLine();
                    agenda.modificarTelefono(nombre, apellido, telefono);
                    break;
                case 6:
                    if (agenda.agendaLlena()) {
                        System.out.println("La agenda está llena. No se pueden añadir más contactos.");
                    } else {
                        System.out.println("La agenda no está llena.");
                    }
                    break;
                case 7:
                    System.out.println("Espacios libres: " + agenda.espacioLibres());
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