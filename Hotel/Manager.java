package Hotel;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private List<Empleado> empleados;

    public Manager() {
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void mostrarProgramacion() {
        System.out.println("Programación de turnos:");
        for (Empleado empleado : empleados) {
            System.out.println(empleado.getNombre() + ": " + empleado.getTurno());
        }
    }
}
