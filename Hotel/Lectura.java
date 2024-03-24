package Hotel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Lectura {
    private final Scanner scanner;
    private final Set<String> identificaciones;

    public Lectura() {
        this.scanner = new Scanner(System.in);
        this.identificaciones = new HashSet<>();
    }

    public String leerNombreCliente(int numCliente) {
        String nombre;
        do {
            System.out.println("Ingrese el nombre del cliente " + numCliente + ":");
            nombre = scanner.nextLine().trim();
        } while (nombre.isEmpty());
        return nombre;
    }

    public String leerIdentificacionCliente(int numCliente) {
        String identificacion;
        do {
            System.out.println("Ingrese la identificación del cliente " + numCliente + " (tenga en cuenta que solo se admiten números positivos enteros y que además, 2 o más clientes no pueden tener el mismo ID):");
            identificacion = scanner.nextLine().trim();
        } while (!esNumero(identificacion) || identificacion.isEmpty() || identificaciones.contains(identificacion));

        identificaciones.add(identificacion);
        return identificacion;
    }

    private boolean esNumero(String str) {
        return str.matches("\\d+");
    }

    public int leerEntero(String mensaje) {
        int valor;
        while (true) {
            try {
                System.out.println(mensaje);
                valor = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar un número entero válido.");
            }
        }
        return valor;
    }

    public String leerTipoHabitacion(int numHabitacion) {
        while (true) {
            System.out.println("Ingrese el tipo de la habitación " + numHabitacion + " ('sencilla', 'doble', 'matrimonial'):");
            String tipo = scanner.nextLine().trim().toLowerCase();
            if (tipo.equals("sencilla") || tipo.equals("doble") || tipo.equals("matrimonial")) {
                return tipo;
            } else {
                System.out.println("Error: El tipo de habitación debe ser 'sencilla', 'doble' o 'matrimonial'.");
            }
        }
    }

    public boolean leerDisponibilidad(int numHabitacion) {
        while (true) {
            System.out.println("¿La habitación " + numHabitacion + " está disponible? (si/no):");
            String disponibilidad = scanner.nextLine().trim().toLowerCase();
            if (disponibilidad.equals("si")) {
                return true;
            } else if (disponibilidad.equals("no")) {
                return false;
            } else {
                System.out.println("Error: Debes ingresar 'si' o 'no'.");
            }
        }
    }

    public double leerDouble(String mensaje) {
        double valor;
        while (true) {
            try {
                System.out.println(mensaje);
                valor = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar un número válido.");
            }
        }
        return valor;
    }
    
    public int leerIntHk(String mensaje, int min, int max) {
        int dato;
        do {
            System.out.print(mensaje + ": ");
            while (!scanner.hasNextInt()) {
                System.out.print("Ingrese un valor entero válido para " + mensaje + ": ");
                scanner.next();
            }
            dato = scanner.nextInt();
            if (dato < min || dato > max) {
                System.out.println("El valor debe estar entre " + min + " y " + max + ".");
            }
        } while (dato < min || dato > max);
        return dato;
    }
    
    public String leerString(String mensaje) {
        System.out.print(mensaje + ": ");
        return scanner.nextLine();
    }

    public boolean leerBoolean(String mensaje) {
        while (true) {
            System.out.println(mensaje + " (true/false):");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                return Boolean.parseBoolean(input);
            } else {
                System.out.println("Error: Debes ingresar 'true' o 'false'.");
            }
        }
    }

    public String seleccionarTurno() {
        while (true) {
            System.out.println("Seleccione el turno del empleado:");
            System.out.println("1. Turno de Mañana");
            System.out.println("2. Turno de Tarde");
            System.out.println("3. Turno de Noche");
            int opcion = leerEntero("Ingrese el número de opción:");
            switch (opcion) {
                case 1:
                    return "Turno de Mañana";
                case 2:
                    return "Turno de Tarde";
                case 3:
                    return "Turno de Noche";
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        }
    }

    public List<Habitacion> agregarHabitaciones() {
        List<Habitacion> habitaciones = new ArrayList<>();
        int numHabitaciones = leerEntero("Ingrese el número de habitaciones a agregar:");
        for (int i = 0; i < numHabitaciones; i++) {
            System.out.println("Habitación " + (i + 1) + ":");
            String tipo = leerTipoHabitacion(i + 1);
            boolean disponible = leerDisponibilidad(i + 1);
            double costoDanios = leerDouble("Ingrese el costo por daños para la habitación:");
            Habitacion habitacion = new Habitacion(1); // Suponiendo que la capacidad es 1 para simplificar
            habitaciones.add(habitacion);
        }
        return habitaciones;
    }

   public String leerNombreEmpleado() {
    System.out.println("Ingrese el nombre del empleado:");
    return scanner.nextLine().trim();
}

    public int leerInt(String mensaje, int min, int max) {
        int dato;
        do {
            System.out.print(mensaje + ": ");
            while (!scanner.hasNextInt()) {
                System.out.print("Ingrese un valor entero válido para " + mensaje + ": ");
                scanner.next();
            }
            dato = scanner.nextInt();
            if (dato < min || dato > max) {
                System.out.println("El valor debe estar entre " + min + " y " + max + ".");
            }
        } while (dato < min || dato > max);
        return dato;
    }

    public int leerIntHabitacion(String mensaje) {
        return leerInt(mensaje, 1, 100);
    }

    public List<String> leerHerramientas() {
        List<String> herramientas = new ArrayList<>();
        boolean agregarMas = true;
        do {
            System.out.println("Seleccione la herramienta con la que limpió la habitación:");
            System.out.println("1. Escoba");
            System.out.println("2. Trapeador");
            System.out.println("3. Productos de limpieza");

            int opcion;
            try {
                opcion = leerInt("Seleccione una opción (1-3)", 1, 3);
            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un valor entero válido.");
                scanner.nextLine(); // Limpiar el buffer del scanner
                continue;
            }
            switch (opcion) {
                case 1:
                    herramientas.add("Escoba");
                    break;
                case 2:
                    herramientas.add("Trapeador");
                    break;
                case 3:
                    herramientas.add("Productos de limpieza");
                    break;
                default:
                    System.out.println("Seleccione una opción válida (1-3).");
                    break;
            }
            System.out.println("¿Utilizó otra herramienta? (si/no)");
            agregarMas = scanner.next().equalsIgnoreCase("si");
        } while (agregarMas);
        return herramientas;
    }

}

