package modelos;

public class Boleta {

    private String localidad;
    private int cantidad;
    private int precio;
    private Evento evento;

    public Boleta(String localidad, int cantidad, int precio, Evento evento) {
        this.localidad = localidad;
        this.cantidad = cantidad;
        this.precio = precio;
        this.evento = evento;

    }
    public Boleta(int cantidad, int precio, Evento evento) {
        this.localidad = "Unica";
        this.cantidad = cantidad;
        this.precio = precio;
        this.evento = evento;

    }

    public Boleta() {

    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Evento getEvento() {
        return evento;
    }

    @Override
    public String toString() {
        return "Boleta{" + "localidad=" + localidad + ", precio=" + precio + ", cantidad=" + cantidad + '}';
    }

}
