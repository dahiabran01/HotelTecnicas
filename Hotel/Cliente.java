package Hotel;

public class Cliente extends Persona{
    private String Trabajo;
    private String Celular;

    public Cliente(String Trabajo, String Celular, String nombre, String id) {
        super(nombre, id);
        this.Trabajo = Trabajo;
        this.Celular = Celular;
    }

    public Cliente(String Trabajo, String Celular) {
        this.Trabajo = Trabajo;
        this.Celular = Celular;
    }

    public Cliente() {
    }

    public String getTrabajo() {
        return Trabajo;
    }

    public void setTrabajo(String Trabajo) {
        this.Trabajo = Trabajo;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("Trabajo=").append(Trabajo);
        sb.append(", Celular=").append(Celular);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
    
    
}
