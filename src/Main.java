import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("******Bienvenido a tu agenda telefónica******");
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda(10);
        int opcion;
        do {
            System.out.println("***Selecciona una opción***");
            System.out.println(" 1 = Añadir contacto");
            System.out.println(" 2 = Listar contactos");
            System.out.println(" 3 = Buscar contacto");
            System.out.println(" 4 = Modificar teléfono");
            System.out.println(" 5 = Eliminar contacto");
            System.out.println(" 6 = Ver espacios disponibles");
            System.out.println(" 7 = Salir");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1: // añadir contacto
                    System.out.println("Para añadir un contacto ingresa Nombre | Apellido | Teléfono");
                    System.out.println("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.println("Telefono: ");
                    String telefono = scanner.nextLine();

                    Contacto nuevoContacto = new Contacto(nombre, apellido, telefono);
                    agenda.añadirContacto(nuevoContacto);
                    break;
                case 2: // listar contactos
                    agenda.listarTodos();
                    break;
                case 3: // buscar contacto
                    System.out.println("Para buscar un contacto ingresa Nombre | Apellido");
                    System.out.println("Nombre: ");
                    String nombreBusca = scanner.nextLine();
                    System.out.println("Apellido: ");
                    String apellidoBusca = scanner.nextLine();
                    agenda.buscarContacto(nombreBusca,apellidoBusca);
                    break;
                case 4: // modificar telefono
                    System.out.println("Para modificar un contacto ingresa Nombre | Apellido del contacto a modificar y luego el teléfono nuevo");
                    System.out.println("Nombre: ");
                    String nombreModifica = scanner.nextLine();
                    System.out.println("Apellido: ");
                    String apellidoModifica = scanner.nextLine();
                    System.out.println("Teléfono nuevo: ");
                    String telefonoNuevo = scanner.nextLine();
                    Contacto modificaContacto = new Contacto(nombreModifica,apellidoModifica,telefonoNuevo);
                    agenda.modificarContacto(modificaContacto);
                    break;
                case 5: // eliminar contacto
                    System.out.println("Para eliminar un contacto ingresa Nombre | Apellido del contacto a eliminar");
                    System.out.println("Nombre: ");
                    String nombreElimina = scanner.nextLine();
                    System.out.println("Apellido: ");
                    String apellidoElimina = scanner.nextLine();
                    agenda.eliminarContacto(nombreElimina,apellidoElimina);
                    break;
                case 6: // espacio disponible
                    agenda.espacioAgenda();
                    break;
                case 7:
                    System.out.println("********Adiós vuelve pronto********");
                    break;
                default:
                    throw new IllegalStateException("Valor inválido: " + opcion);
            }

        } while (opcion != 7);
        scanner.close();
    }
}