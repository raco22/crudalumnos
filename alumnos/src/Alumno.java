import java.io.Serializable;

public class Alumno implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private int[] calificaciones; // Calificaciones en 5 materias

    public Alumno(String nombre, int[] calificaciones) {
        this.nombre = nombre;
        this.calificaciones = calificaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public int[] getCalificaciones() {
        return calificaciones;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombre).append(", Calificaciones: ");
        for (int calificacion : calificaciones) {
            sb.append(calificacion).append(" ");
        }
        return sb.toString();
    }
}
