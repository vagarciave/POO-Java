package modelos;

public class Item {
    private Boleta boleta;
    private int cantidadItems;
    
    //constructor
    public Item(Boleta boleta,int cantidadItems){
        this.boleta = boleta;
        this.cantidadItems = cantidadItems;
    }
    
    //Metodos Set
    public void setBoleta(Boleta boleta){
        this.boleta = boleta;
    }
    public void setCantidadItems(int cantidadItems){
        this.cantidadItems = cantidadItems;
    }
    
    //Metodos Get
    public Boleta getBoleta(){
        return this.boleta;
    }
    public int getCantidadItems(){
        return this.cantidadItems;
    }
    public int getSubTotal(){
        int subTotal = this.boleta.getPrecio()*this.getCantidadItems();
        return subTotal;
    }
    public void restarBoletas(){
        int boletasTotales = this.boleta.getCantidad();
        int itemsARestar = this.getCantidadItems();
        int nuevaCantidad = boletasTotales - itemsARestar;
        this.boleta.setCantidad(nuevaCantidad);
    }
}
