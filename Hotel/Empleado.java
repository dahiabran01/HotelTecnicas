package Hotel;

public class Empleado extends Persona{
    private String turno;
    private String cargo;

    public Empleado(String nombre, String id) {
        super(nombre, id);
    }

    public Empleado() {
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
    
}
