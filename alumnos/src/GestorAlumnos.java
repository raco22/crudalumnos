import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorAlumnos {
    private List<Alumno> alumnos;
    private final String archivo = "alumnos.dat";

    public GestorAlumnos() {
        alumnos = new ArrayList<>();
        cargarAlumnos();
    }

    public void agregarAlumno(Alumno alumno) {
        alumnos.add(alumno);
        guardarAlumnos();
    }

    public void listarAlumnos() {
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }

    public void eliminarAlumno(String nombre) {
        alumnos.removeIf(alumno -> alumno.getNombre().equals(nombre));
        guardarAlumnos();
    }

    public void generarReporte(String nombreArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Alumno alumno : alumnos) {
                writer.write(alumno.toString());
                writer.newLine();
            }
            System.out.println("Reporte generado: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al generar el reporte: " + e.getMessage());
        }
    }

    private void guardarAlumnos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(alumnos);
        } catch (IOException e) {
            System.out.println("Error al guardar alumnos: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void cargarAlumnos() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            alumnos = (List<Alumno>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado, se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar alumnos: " + e.getMessage());
        }
    }
}
