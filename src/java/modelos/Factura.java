package modelos;

import java.util.*;

public class Factura {

    private static int cod = 1;
    private static final double iva = 1.19;
    private Usuario usuario;
    private String metodo;
    private int codigo;
    private String estado;
    private java.util.Date fecha;
    private ArrayList<Item> listaItems;

    //Constructor
    public Factura(Usuario usuario, String metodo) {
        this.usuario = usuario;
        this.metodo = metodo;
        this.fecha = new Date();
        this.codigo = Factura.cod;
        this.estado = "No aprobado";
        this.listaItems = new ArrayList<>();
        Factura.cod++;
    }

    //Metodos Set
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //Metodos Get
    public Usuario getUsuario() {
        return this.usuario;
    }

    public String getMetodo() {
        return this.metodo;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public String getEstado() {
        return this.estado;
    }

    public ArrayList<Item> getItems() {
        return listaItems;
    }

    public ArrayList<String> getListaItems() {
        ArrayList<String> info = new ArrayList<>();
        for (Item itemActual : listaItems) {
            info.add(itemActual.toString());
        }
        return info;
    }

    public void agregarItem(Item... args) {
        listaItems.addAll(Arrays.asList(args));
    }

    public void borrarItem(Item item) {
        listaItems.remove(item);
    }

    public void pagarFactura() {
        this.estado = "Aprobado";
        for (Item itemActual : listaItems) {
            itemActual.restarBoletas();
        }
    }

    public double getTotal() {
        double total = 0;
        for (Item itemActual : listaItems) {
            total = total + itemActual.getSubTotal();
        }
        return total * Factura.iva;
    }
}
