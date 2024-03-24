package Hotel;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String nombre;
    private String direccion;
    private String contacto;
    private ArrayList<Empleado> empleados;
    private Housekeeping housekeeping;

    public Menu(String nombre, String direccion, String contacto) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.contacto = contacto;
        this.empleados = new ArrayList<>();
        this.housekeeping = new Housekeeping(); // Crear una instancia de Housekeeping
    }

    public Menu() {
    }

    // Métodos getter y setter

    public void getMenu() {
        Lectura lectura = new Lectura();
        Hotel hotel = new Hotel();
        Manager programacionTurnos = new Manager();

        boolean salir = false;

        while (!salir) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Registrar inventario de habitaciones");
            System.out.println("3. Servicio de hospedaje");
            System.out.println("4. Servicio de alimentación");
            System.out.println("5. Programar turnos de trabajo");
            System.out.println("6. Servicio de HouseKeeping");
            System.out.println("7. Salir");

            int opcion = lectura.leerEntero("Ingrese el número de opción:");

            switch (opcion) {
                case 1:
                    String nombreCliente = lectura.leerNombreCliente(1);
                    String identificacionCliente = lectura.leerIdentificacionCliente(1);
                    Cliente cliente = new Cliente(nombreCliente, identificacionCliente);
                    hotel.registrarCliente(cliente);
                    System.out.println("Cliente registrado con éxito.");
                    break;
                case 2:
                    List<Habitacion> habitaciones = lectura.agregarHabitaciones();
                    hotel.agregarHabitaciones(habitaciones);
                    System.out.println("Inventario de habitaciones registrado con éxito.");
                    break;
                case 3:
                    // Registrar servicio de hospedaje
                    String tipoHabitacion = lectura.leerTipoHabitacion(1);
                    int tiempoOcupacion = lectura.leerEntero("Ingrese el tiempo de ocupación:");
                    boolean lavanderiaIncluida = lectura.leerBoolean("¿Se incluye lavandería?");
                    double costoLavanderia = lavanderiaIncluida ? lectura.leerDouble("Ingrese el costo de la lavandería:") : 0.0;
                    double costoHabitacion = lectura.leerDouble("Ingrese el costo de la habitación:");
                    double costoDanios = lectura.leerDouble("Ingrese el costo por daños:");
                    FacturaHospedaje facturaHospedaje = new FacturaHospedaje(tipoHabitacion, tiempoOcupacion, lavanderiaIncluida, costoLavanderia, costoHabitacion, costoDanios);
                    double costoTotalHospedaje = facturaHospedaje.calcularCostoTotal();
                    System.out.println("El costo total del servicio de hospedaje es: " + costoTotalHospedaje);
                    break;
                case 4:
                    double costoAlimentacion = lectura.leerDouble("Ingrese el costo de la alimentación:");
                    boolean chefFrances = lectura.leerBoolean("¿Desea chef francés?");
                    double sobreCostoChefFrances = chefFrances ? 0.15 * costoAlimentacion : 0.0; // 15% del costo de la alimentación
                    FacturaAlimentacion facturaAlimentacion = new FacturaAlimentacion(costoAlimentacion, chefFrances, sobreCostoChefFrances);
                    double costoTotalAlimentacion = facturaAlimentacion.calcularCostoTotal();
                    System.out.println("El costo total del servicio de alimentación es: " + costoTotalAlimentacion);
                    break;

                case 5:
                    // Programar turnos de trabajo
                    String nombreEmpleado = lectura.leerNombreEmpleado();
                    String turnoEmpleado = lectura.seleccionarTurno();
                    Empleado empleado = new Empleado(nombreEmpleado, turnoEmpleado);
                    programacionTurnos.agregarEmpleado(empleado);
                    System.out.println("Turno programado con éxito.");
                    break;

                case 6:
                    String nombre = lectura.leerString("Ingrese el nombre de la mucama");
                    int id = lectura.leerIntHk("Ingrese el ID de la mucama", 1, Integer.MAX_VALUE);

                    int numeroHabitacion;
                    do {
                        numeroHabitacion = lectura.leerIntHk("Ingrese el número de la habitación que limpió (1-100)", 1, 100);
                    } while (numeroHabitacion < 1 || numeroHabitacion > 100);

                    List<String> herramientas = housekeeping.leerHerramientas(); // Usar el método de Housekeeping
                    Mucama mucama = new Mucama(nombre, id);
                    Habitacion habitacion = new Habitacion(numeroHabitacion);
                    mucama.limpiarHabitacion(habitacion, herramientas);
                    break;

                case 7:
                    salir = true;
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}

