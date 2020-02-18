package modelos;

import java.util.ArrayList;
/**
 *
 * @author valentina
 */
public class datosFicticios {

    //Usuarios
    Usuario u1 = new Usuario("carlos@boleta.com", "1234", "1012522994", "Carlos Garabito",
            "3202034111");
    Usuario u2 = new Usuario("sara@boleta.com", "1234", "1023456368", "Sara Salas",
            "3124574586");
    Usuario u3 = new Usuario("calamardo@boleta.com", "1234", "1073123368",
            "Calamardo tentaculos", "3154586199");
    //Administradores
    Administrador Admin1 = new Administrador("admin1@evento.com", "1234", "1234456789",
            "Pepe McMann", "3008889977", "master1");
    Administrador Admin2 = new Administrador("admin2@evento.com", "1235", "1143678904",
            "Francisco Vogler", "3008889978", "master2");

    //Concierto Guns
    Evento ConciertoGuns = new Evento("Concierto", "Guns & roses",
            "Concierto de despedida Guns & roses", "Medellin",
            "2017-12-24");
    Boleta BoletaGuns = new Boleta(50000, 520000, ConciertoGuns);
    //Partido Barcelona vs Real
    Evento PartidoBR = new Evento("Deporte", "Barcelona vs Real Madrid",
            "Superclásico de España", "Estadio Maracaná",
            "2018-01-25");
    Boleta PBRBoletaPlatino = new Boleta("Platino", 10000, 540000, PartidoBR);
    Boleta PBRBoletaVIP = new Boleta("VIP", 35000, 234000, PartidoBR);
    Boleta PBRBoletaPreferencia = new Boleta("Preferencia", 40000, 134000, PartidoBR);
    //Romeo y Julieta
    Evento TeatroRJ = new Evento("Teatro", "Romeo y Julieta",
            "Clasico de Shakespeare", "Teatro Patria", "2017-12-01");
    Boleta TRJBoletaPlatino = new Boleta("Platino", 2000, 45000, TeatroRJ);
    Boleta TRJBoletaVIP = new Boleta("VIP", 5000, 35000, TeatroRJ);
    Boleta TRJBoletaPreferencia = new Boleta("Preferencia", 5000, 30000, TeatroRJ);
    //Festival Verano
    Evento FestivalVerano = new Evento("Festival", "Festival de verano",
            "Festival de verano 2018-Música", "Parque Metropolitano", "2018-12-01");
    Boleta BoletaFest = new Boleta(52000, 70000, FestivalVerano);

    //Crear facturas usuario 1
    Item Item1user1 = new Item(BoletaGuns, 2);
    Item Item2user1 = new Item(BoletaFest, 7);
    Item Item3user1 = new Item(TRJBoletaPreferencia, 15);
    Item Item4user1 = new Item(PBRBoletaVIP, 2);
    Factura Factura2User1 = new Factura(u1, "Efectivo");
    Factura Factura1User1 = new Factura(u1, "Tarjeta");
    //Crear facturas usuario 2
    Item Item1user2 = new Item(PBRBoletaPlatino, 15);
    Item Item2user2 = new Item(TRJBoletaVIP, 30);
    Factura Factura1User2 = new Factura(u2, "Tarjeta");

    public void agregarDatosFicticios() {
        //Agregar instancias de usuarios
        Usuario.usuarios.add(u1);
        Usuario.usuarios.add(u2);
        Usuario.usuarios.add(u3);
        //Agregar instancias de administradores
        Administrador.administradores.add(Admin1);
        Administrador.administradores.add(Admin2);
        //Agregar Eventos
        Evento.listaEventos.add(ConciertoGuns);
        Evento.listaEventos.add(PartidoBR);
        Evento.listaEventos.add(TeatroRJ);
        Evento.listaEventos.add(FestivalVerano);
        //Agregar boletas a eventos
        ConciertoGuns.agregarBoletas(BoletaGuns);
        PartidoBR.agregarBoletas(PBRBoletaPlatino, PBRBoletaVIP, PBRBoletaPreferencia);
        TeatroRJ.agregarBoletas(TRJBoletaPlatino, TRJBoletaVIP, TRJBoletaPreferencia);
        FestivalVerano.agregarBoletas(BoletaFest);
        //Agregar facturas a usuario 1 y pagar
        Factura1User1.agregarItem(Item1user1, Item2user1);
        Factura2User1.agregarItem(Item3user1, Item4user1);
        Factura1User1.pagarFactura();
        Factura2User1.pagarFactura();
        u1.agregarFactura(Factura1User1, Factura2User1);
        //Agregar factura a usuario2 y pagar
        Factura1User2.agregarItem(Item1user2, Item2user2);
        Factura1User2.pagarFactura();
        u2.agregarFactura(Factura1User2);
    }
}
