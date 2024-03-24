// Clase Mucama.java
package Hotel;

import java.util.List;

public class Mucama extends Empleado {

    public Mucama(String nombre, String id) {
        super(nombre, id);
    }

    public Mucama(String nombre1, int id1) {
    }
    

    public void limpiarHabitacion(Habitacion habitacion, List<String> herramientas) {
        System.out.println("La mucama " + nombre + " con el ID " + id + " limpió la habitación " + habitacion.getNumero() + " con las siguientes herramientas:");
        for (String herramienta : herramientas) {
            System.out.println("- " + herramienta);
        }
    }
}
