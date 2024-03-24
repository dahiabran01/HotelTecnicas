package Hotel;

public class FacturaHospedaje extends Recepcionista{
    private String tipoHabitacion;
    private int tiempoOcupacion; 
    private boolean lavanderiaIncluida;
    private double costoLavanderia;
    private double costoHabitacion;
    private double costoDanios;

    public FacturaHospedaje(String tipoHabitacion, int tiempoOcupacion, boolean lavanderiaIncluida, double costoLavanderia, double costoHabitacion, double costoDanios) {
        this.tipoHabitacion = tipoHabitacion;
        this.tiempoOcupacion = tiempoOcupacion;
        this.lavanderiaIncluida = lavanderiaIncluida;
        this.costoLavanderia = costoLavanderia;
        this.costoHabitacion = costoHabitacion;
        this.costoDanios = costoDanios;
    }

    public double calcularCostoTotal() {
        double costoTotal = costoHabitacion * tiempoOcupacion;

        if (lavanderiaIncluida) {
            costoTotal += costoLavanderia;
        }

        costoTotal += costoDanios;

        return costoTotal;
    }
}
