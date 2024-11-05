import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorAlumnos gestor = new GestorAlumnos();
        int opcion;

        do {
            System.out.println("Menu:");
            System.out.println("1. Agregar Alumno");
            System.out.println("2. Listar Alumnos");
            System.out.println("3. Eliminar Alumno");
            System.out.println("4. Generar Reporte");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del alumno: ");
                    String nombre = scanner.nextLine();
                    int[] calificaciones = new int[5];
                    for (int i = 0; i < 5; i++) {
                        System.out.print("Calificación " + (i + 1) + ": ");
                        calificaciones[i] = scanner.nextInt();
                    }
                    gestor.agregarAlumno(new Alumno(nombre, calificaciones));
                    break;
                case 2:
                    gestor.listarAlumnos();
                    break;
                case 3:
                    System.out.print("Nombre del alumno a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    gestor.eliminarAlumno(nombreEliminar);
                    break;
                case 4:
                    System.out.print("Nombre del archivo para el reporte: ");
                    String nombreArchivo = scanner.nextLine();
                    gestor.generarReporte(nombreArchivo);
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}