/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.HashMap;

/**
 *
 * @author valentina
 */
public class Mensajes {

    public HashMap<String, String> mensajes = new HashMap<>();

    public Mensajes() {
        //Mensajes index
        mensajes.put("bienvenida", "Bienvenido a Omni-Boleta");
        mensajes.put("mbienv", "Somos una empresa dedicada a la venta y comercialización"
                + "de boletería para eventos masivos.La cobertura de Omni-Boleta "
                + "tiene presencia a nivel nacional. Entre los espectáculos que "
                + "comercializamos se cuenta con: Teatro, deportes, conciertos, festivales,"
                + " entre otros.");
        mensajes.put("mregis", "Regístrate ahora para tomar ventaja de algunas nuevas características de nuestra página!");
        mensajes.put("mingre", "Si ya tienes una cuenta ingresa para acceder a más servicios");
        mensajes.put("dfict", "Click aquí para agregar datos ficticios");
        mensajes.put("bien", "Bienvenido");
        //Mensajes Admin
        mensajes.put("menuAdm", "Menú Administrador");
        mensajes.put("usuarioMayorCompra", "Ver usuario con compra por mayor valor");
        mensajes.put("usuarioMasBoletas", "Ver usuario que ha comprado más boletas");
        mensajes.put("usuarioMasFacturas", "Ver usuario que tiene mayor cantidad de facturas");
        mensajes.put("verUsuarios", "Ver usuarios registrados");
        mensajes.put("", "");
        mensajes.put("", "");
        //Opciones de evento
        mensajes.put("crearEv", "Crear evento");
        mensajes.put("verEventos", "Ver todos los eventos");
        mensajes.put("consNombre", "Consultar por nombre");
        mensajes.put("consCodido", "Consultar por codigo");
        mensajes.put("verCategoria", "Ver por categoria");
        mensajes.put("evmasBoleta", "Evento con más boletas");
        mensajes.put("evmenBoleta", "Evento con menos boletas");
        mensajes.put("evebolcostosa", "Evento con boleta más costosa");
        mensajes.put("evebolbarata", "Evento con boleta más barata");
        //opciones Usuario
        mensajes.put("verDat", "Ver mis datos");
        mensajes.put("verFact", "Ver mis facturas");
        

    }

}
