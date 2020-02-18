package modelos;

import java.util.*;

public class Evento {
    private static int Cod = 0;
    public static ArrayList<Evento> listaEventos = new ArrayList<>();
    private String categoria;
    private String nombre;
    private String descripcion;
    private int codigoEvento;
    private String lugar;
    private String fecha;
    private ArrayList<Boleta> listaBoletas;
    
    //constructor
    public Evento(String categoria, String nombre,String descripcion, String lugar, String fecha){
        this.categoria = categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigoEvento = Evento.Cod;
        this.lugar = lugar;
        this.fecha = fecha;
        this.listaBoletas = new ArrayList();
        Evento.Cod++;
    }
    
    //Metodos Set
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public void setLugar(String lugar){
        this.lugar = lugar;
    }
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    public void setCodigoEvento(int codigoEvento){
        this.codigoEvento = codigoEvento;
    }
    
    
    //Metodos Get
    public String getCategoria(){
        return this.categoria;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    public String getLugar(){
        return this.lugar;
    }
    public String getFecha(){
        return this.fecha;
    }
    public int getCodigoEvento(){
        return this.codigoEvento;
    }
    public ArrayList<Boleta> getBoletas(){
        return this.listaBoletas;
    }
    //Otros metodos
    public void agregarBoletas(Boleta... args){
        this.listaBoletas.addAll(Arrays.asList(args));
    }
    public int boletasDisponibles(){
        int cantidadTotal = 0;
        for (Boleta boletaAct: this.listaBoletas){
            cantidadTotal +=boletaAct.getCantidad(); 
        }
        return cantidadTotal;
    }
    
    public ArrayList infoBoletas(){
        ArrayList<String> info = new ArrayList<>();
        for (Boleta boletaAct: this.listaBoletas) {
            info.add(boletaAct.toString());
        }
        return info;
    }
    public Boleta obtenerBoletaLocalidad(String opcion){
        Boleta objeto = new Boleta();
        for (Boleta boleta: this.listaBoletas){
            if (boleta.getLocalidad().equals(opcion)) {
                objeto = boleta;
            }
        }
        return objeto;
    }
    
    //Funciones interesantes
    public static Evento eventoConMasBoletas(){
        Evento evento = null;
        int boletas = 0;
        for (Evento eventoAct: Evento.listaEventos){
            if (eventoAct.boletasDisponibles() > boletas){
                boletas = eventoAct.boletasDisponibles();
                evento = eventoAct;
            }
        }
        return evento;
    }
    public static Evento eventoConMenosBoletas(){
        Evento evento = null;
        int boletas = listaEventos.get(0).boletasDisponibles();
        for (Evento eventoAct: Evento.listaEventos){
            if (eventoAct.boletasDisponibles() < boletas) {
                boletas = eventoAct.boletasDisponibles();
                evento = eventoAct;
            }
        }
        return evento; 
    }
    public static  Evento eventoBoletaCostosa(){
        Boleta boleta;
        Evento evento = null;
        int valor = 0;
        for (Evento eventoAct: Evento.listaEventos) {
            for(Boleta boletaAct: eventoAct.getBoletas()){
                if (boletaAct.getPrecio() > valor){
                    boleta = boletaAct;
                    evento = eventoAct;
                    valor = boletaAct.getPrecio();
                }           
            }
        }
        return evento;
    }
    public static Evento eventoBoletaBarata(){
    Boleta boleta;
    Evento evento = null;
    int valor = Evento.listaEventos.get(0).getBoletas().get(0).getPrecio();
    for (Evento eventoAct: Evento.listaEventos) {
        for(Boleta boletaAct: eventoAct.getBoletas()){
            if (boletaAct.getPrecio() < valor){
                boleta = boletaAct;
                evento = eventoAct;
                valor = boletaAct.getPrecio();
            }
        }
    }
    return evento;
    }
}
