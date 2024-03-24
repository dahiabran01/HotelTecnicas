package Hotel;

public class FacturaAlimentacion extends Recepcionista {
    private final double costoAlimentacion;
    private final boolean chefFrances;
    private final double sobreCostoChefFrances;

    public FacturaAlimentacion(double costoAlimentacion, boolean chefFrances, double sobreCostoChefFrances) {
        this.costoAlimentacion = costoAlimentacion;
        this.chefFrances = chefFrances;
        this.sobreCostoChefFrances = sobreCostoChefFrances;
    }

    public double calcularCostoTotal() {
        double costoTotal = costoAlimentacion;

        if (chefFrances) {
            costoTotal += (costoAlimentacion * sobreCostoChefFrances);
        }

        return costoTotal;
    }
}
