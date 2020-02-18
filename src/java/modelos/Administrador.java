package modelos;

import java.util.ArrayList;

public class Administrador extends Usuario {

    private String llave;
    private String tipo;
    public static ArrayList<Administrador> administradores = new ArrayList<Administrador>();

    public Administrador(String email, String clave, String documento, String nombre,
            String celular, String llave) {
        super(email, clave, documento, nombre, celular);
        this.llave = llave;
        this.tipo = "admin";
    }

    public String getLlave() {
        return this.llave;
    }

}
