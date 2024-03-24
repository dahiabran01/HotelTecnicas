package Hotel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Housekeeping {
    private String nombre;
    private int id;
    private Scanner scanner;
    private Lectura lectura;

    public Housekeeping() {
        this.scanner = new Scanner(System.in);
        this.lectura = new Lectura();
    }

    public void limpiarHabitacion(Habitacion habitacion, List<String> herramientas) {
        System.out.println("La mucama " + nombre + " con el ID " + id + " limpió la habitación " + habitacion.getNumero() + " con las siguientes herramientas:");
        for (String herramienta : herramientas) {
            System.out.println("- " + herramienta);
        }
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
                opcion = lectura.leerIntHk("Seleccione una opción (1-3)", 1, 3);
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

