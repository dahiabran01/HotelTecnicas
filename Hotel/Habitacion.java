package Hotel;

public class Habitacion {
    private String tipo;
    private int capacidad;
    private int numero;
    private boolean disponible;
    private boolean ocupada;
    private double costoDanios;

    public Habitacion(int capacidad) {
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.disponible = disponible;
        this.ocupada = !disponible; 
        this.costoDanios = costoDanios;
        this.numero = numero;
    }
    
    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public boolean estaDisponible() {
        return disponible;
    }

    public void reservar() {
        if (disponible) {
            disponible = false;
            ocupada = true;
        } else {
            System.out.println("La habitación ya está ocupada.");
        }
    }

    public void liberar() {
        if (ocupada) {
            disponible = true;
            ocupada = false;
        } else {
            System.out.println("La habitación no está ocupada.");
        }
    }

    public double getCostoDanios() {
        return costoDanios;
    }

    @Override
    public String toString() {
        String dispStr = disponible ? "Disponible" : "No disponible";
        String ocupStr = ocupada ? "Ocupada" : "No ocupada";
        return "Habitacion{" +
                "tipo='" + tipo + '\'' +
                ", capacidad=" + capacidad +
                ", disponibilidad=" + dispStr +
                ", ocupación=" + ocupStr +
                '}';
    }
}
