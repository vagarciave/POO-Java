package modelos;

import java.util.ArrayList;
import java.util.Arrays;

public class Usuario {

    public static String tipo = "user";
    private String email;
    private String clave;
    private String credito;
    private String documento;
    private String nombre;
    private String celular;
    private ArrayList<Factura> facturas = new ArrayList<Factura>();
    public static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    //Constructor
    public Usuario(String email, String clave, String documento,
            String nombre, String celular) {
        this.email = email;
        this.clave = clave;
        this.documento = documento;
        this.nombre = nombre;
        this.celular = celular;
    }

    //Metodos Set
    public void setEmail(String email) {
        this.email = email;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setCuenta(String credito) {
        this.credito = credito;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    //Metodos Get
    public static String getTipo() {
        return Usuario.tipo;
    }

    public String getEmail() {
        return this.email;
    }

    public String getClave() {
        return this.clave;
    }

    public String getCuenta() {
        return this.credito;
    }

    public String getDocuneto() {
        return this.documento;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getCelular() {
        return this.celular;
    }

    public ArrayList<Factura> getListaFacturas() {
        return this.facturas;
    }

    public ArrayList getFacturas() {
        ArrayList<String> info = new ArrayList<>();
        for (Factura factura : this.facturas) {
            info.add(factura.toString());
        }
        return info;
    }

    public void agregarFactura(Factura... args) {
        this.facturas.addAll(Arrays.asList(args));
    }

    public static Usuario consultarUsuario(String email, String clave) {
        Usuario usuario = null;
        for (Usuario usuarioAct : Usuario.usuarios) {
            if (usuarioAct.getEmail().equals(email)
                    || usuarioAct.getClave().equals(clave)) {
                usuario = usuarioAct;
            }
        }
        return usuario;
    }

    public static Usuario usuarioConMasFacturas() {
        Usuario usuario = null;
        int numFacturas = 0;
        for (Usuario usuarioAct : Usuario.usuarios) {
            if (usuarioAct.getListaFacturas().size() > numFacturas) {
                numFacturas = usuarioAct.getListaFacturas().size();
                usuario = usuarioAct;
            }
        }
        return usuario;
    }

    public static Factura usuarioConMayorCompra() {
        Factura factura = null;
        Usuario usuario = null;
        double mayorCompra = 0;
        for (Usuario usuarioAct : Usuario.usuarios) {
            for (Factura facturaAct : usuarioAct.getListaFacturas()) {
                if (facturaAct.getTotal() > mayorCompra) {
                    mayorCompra = facturaAct.getTotal();
                    usuario = usuarioAct;
                    factura = facturaAct;
                }
            }
        }
        return factura;
    }

    public static Usuario usuarioConMasBoletas() {
        int numBoletas = 0;
        Usuario usuario = null;
        for (Usuario usuarioAct : Usuario.usuarios) {
            for (Factura facturaAct : usuarioAct.getListaFacturas()) {
                int cantidadBoletas = 0;
                for (Item itemAct : facturaAct.getItems()) {
                    cantidadBoletas += itemAct.getCantidadItems();
                }
                if (cantidadBoletas > numBoletas) {
                    numBoletas = cantidadBoletas;
                    usuario = usuarioAct;
                }
            }
        }
        return usuario;
    }
}
