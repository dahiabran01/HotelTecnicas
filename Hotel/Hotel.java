package Hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private final List<Cliente> clientesRegistrados;
    private List<Habitacion> inventarioHabitaciones;

    public Hotel() {
        this.clientesRegistrados = new ArrayList<>();
        this.inventarioHabitaciones = new ArrayList<>();
    }

    public void registrarCliente(Cliente cliente) {
        clientesRegistrados.add(cliente);
    }

    public List<Cliente> getClientesRegistrados() {
        return clientesRegistrados;
    }

    public void agregarHabitacion(Habitacion habitacion) {
        inventarioHabitaciones.add(habitacion);
    }

    public List<Habitacion> getInventarioHabitaciones() {
        return inventarioHabitaciones;
    }

    void agregarHabitaciones(List<Habitacion> habitaciones) {
        this.inventarioHabitaciones.addAll(habitaciones);
    }
}

