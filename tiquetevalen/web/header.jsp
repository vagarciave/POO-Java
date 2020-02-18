<%@page import="modelos.Usuario"%>
<%@page import="modelos.Mensajes"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta charset="utf-8">
        <title>Sistema de notas</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/forFooter.css">
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/algunos.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script type="text/javascript" src="js/npm.js"></script>
        <link href="fonts/glyphicons-halflings-regular.eot">
        <link href="fonts/glyphicons-halflings-regular.svg">
        <link href="fonts/glyphicons-halflings-regular.ttf">
        <link href="fonts/glyphicons-halflings-regular.woff">
        <link href="fonts/glyphicons-halflings-regular.woff2">
        <link href="https://fortawesome.github.io/Font-Awesome/assets/font-awesome/css/font-awesome.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-primary">
            <a class="navbar-brand" href="index.jsp">Omni-Boleta</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault"
                    aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <%     String usuarioLogueado;
                String tipoUsuario;
                Mensajes msj = new Mensajes();
                String bienvenida = "bienvenida",
                        //sistemas
                        mbienv = "mbienv",
                        mregis = "mregis",
                        mingre = "mingre",
                        dfict = "dfict",
                        bien = "bien",
                        //admin
                        menuad = "menuAdm",
                        umaycom = "usuarioMayorCompra",
                        umasbol = "usuarioMasBoletas",
                        veruser = "verUsuarios",
                        usmasfa = "usuarioMasFacturas",
                        //evento
                        crear = "crearEv",
                        verev = "verEventos",
                        consnom = "consNombre",
                        conscod = "consCodigo",
                        vercat = "verCategoria",
                        evemas = "evmasBoletas",
                        evemen = "evmenBoletas",
                        evebolc = "eveboletacara",
                        evebolb = "eveboletabarata",
                //usuario
                        verfact = "verFact",
                        verdat = "verDat";
           

                if (null != session.getAttribute("usuarioLogueado")) {
                    Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
                    usuarioLogueado = usuario.getNombre();
                    tipoUsuario = usuario.getTipo();
                } else {
                    usuarioLogueado = "";
                    tipoUsuario = "invitado";
                }
            %>
            <body style="background-color: #3B3738">
                <nav class="navbar navbar-inverse">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="#"><% out.print(msj.mensajes.get("bien") + usuarioLogueado); %></a>
                        </div>
                        <ul class="nav navbar-nav">
                            <li class="bottom"><a href="index.jsp">Inicio</a></li>
                                <% switch (tipoUsuario) {
                                        case "invitado":
                                %>

                            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Menú Evento<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="ServletEvento?accion=VerEventos"><c:out value="<%=msj.mensajes.get(verev)%>" /></a></li>
                                    <li><a href="ServletEvento?accion=ConsultaEventoCod"><c:out value="<%=msj.mensajes.get(conscod)%>" /></a></li>
                                    <li><a href="ServletEvento?accion=ConsultaEventoNombre"><c:out value="<%=msj.mensajes.get(consnom)%>" /></a></li>
                                                          <li><a href="ServletEvento?accion=VerCategoria"><c:out value="<%=msj.mensajes.get(vercat)%>" /></a>
                                    <ul>
                                        <li><a href="ServletEvento?accion=VerConcierto"><c:out value="Concierto" /></a></li>
                                        <li><a href="ServletEvento?accion=VerTeatro"><c:out value="Teatro" /></a></li>
                                        <li><a href="ServletEvento?accion=VerDeporte"><c:out value="Deporte" /></a></li>
                                        <li><a href="ServletEvento?accion=VerFestival"><c:out value="Festival" /></a></li>
                                    </ul>
                                    </li>
                                </ul>
                            </li>
                            <a class="btn btn-light" href="ServletUsuario?accion=solicitarLogueo" role="button">Ingresar</a>
                            <a class="btn btn-light" href="ServletUsuario?accion=solicitarRegistro" role="button">Registrarse</a>


                            <%
                                    break;
                                case "user":
                            %>
                            
                            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Menú usuario<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="ServletUsuario?accion=VerDatos"><c:out value="<%=msj.mensajes.get(verdat)%>" /></a></li>
                                    <li><a href="ServletUsuario?accion=VerFacturas"><c:out value="<%=msj.mensajes.get(verfact)%>" /></a></li>
                                </ul>
                            </li>
                            
                            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Menu Eventos<span class="caret"></span></a>
                                <ul class="dropdown-menu">         
                                    <li><a href="ServletEvento?accion=VerEventos"><c:out value="<%=msj.mensajes.get(verev)%>" /></a></li>
                                    <li><a href="ServletEvento?accion=ConsultaEventoCod"><c:out value="<%=msj.mensajes.get(conscod)%>" /></a></li>
                                    <li><a href="ServletEvento?accion=ConsultaEventoNombre"><c:out value="<%=msj.mensajes.get(consnom)%>" /></a></li>
                                    <li><a href="ServletEvento?accion=EventoMasBoletas"><c:out value="<%=msj.mensajes.get(evemas)%>" /></a></li>
                                    <li><a href="ServletEvento?accion=EventoMenosBoletas"><c:out value="<%=msj.mensajes.get(evemen)%>" /></a></li>
                                    <li><a href="ServletEvento?accion=EventoBoletaCara"><c:out value="<%=msj.mensajes.get(evebolc)%>" /></a></li>
                                    <li><a href="ServletEvento?accion=EventoBoletaBarata"><c:out value="<%=msj.mensajes.get(evebolb)%>" /></a></li>
                                    <li><a href="ServletEvento?accion=VerCategoria"><c:out value="<%=msj.mensajes.get(vercat)%>" /></a>
                                    <ul>
                                        <li><a href="ServletEvento?accion=VerConcierto"><c:out value="Concierto" /></a></li>
                                        <li><a href="ServletEvento?accion=VerTeatro"><c:out value="Teatro" /></a></li>
                                        <li><a href="ServletEvento?accion=VerDeporte"><c:out value="Deporte" /></a></li>
                                        <li><a href="ServletEvento?accion=VerFestival"><c:out value="Festival" /></a></li>
                                    </ul>
                                    </li>
                                </ul>                    
                            </li>


                            <%
                                    break;
                                case "admin":
                            %>
                            
                            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Menú Administrador<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="ServletUsuario?accion=UsuarioMayorCompra"><c:out value="<%=msj.mensajes.get(umaycom)%>" /></a></li>
                                    <li><a href="ServletUsuario?accion=UsuarioMasBoletas"><c:out value="<%=msj.mensajes.get(umasbol)%>" /></a></li>
                                    <li><a href="ServletUsuario?accion=UsuarioMasFacturas"><c:out value="<%=msj.mensajes.get(usmasfa)%>" /></a></li>
                                    <li><a href="ServletUsuario?accion=VerUsuario"><c:out value="<%=msj.mensajes.get(veruser)%>" /></a></li>
                                </ul>
                            </li>
                            
                            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Menu Eventos<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="ServletEvento?accion=Crear"><c:out value="<%=msj.mensajes.get(crear)%>" /></a></li>        
                                    <li><a href="ServletEvento?accion=VerEventos"><c:out value="<%=msj.mensajes.get(verev)%>" /></a></li>
                                    <li><a href="ServletEvento?accion=ConsultaEventoCod"><c:out value="<%=msj.mensajes.get(conscod)%>" /></a></li>
                                    <li><a href="ServletEvento?accion=ConsultaEventoNombre"><c:out value="<%=msj.mensajes.get(consnom)%>" /></a></li>
                                    <li><a href="ServletEvento?accion=EventoMasBoletas"><c:out value="<%=msj.mensajes.get(evemas)%>" /></a></li>
                                    <li><a href="ServletEvento?accion=EventoMenosBoletas"><c:out value="<%=msj.mensajes.get(evemen)%>" /></a></li>
                                    <li><a href="ServletEvento?accion=EventoBoletaCara"><c:out value="<%=msj.mensajes.get(evebolc)%>" /></a></li>
                                    <li><a href="ServletEvento?accion=EventoBoletaBarata"><c:out value="<%=msj.mensajes.get(evebolb)%>" /></a></li>
                          <li><a href="ServletEvento?accion=VerCategoria"><c:out value="<%=msj.mensajes.get(vercat)%>" /></a>
                                    <ul>
                                        <li><a href="ServletEvento?accion=VerConcierto"><c:out value="Concierto" /></a></li>
                                        <li><a href="ServletEvento?accion=VerTeatro"><c:out value="Teatro" /></a></li>
                                        <li><a href="ServletEvento?accion=VerDeporte"><c:out value="Deporte" /></a></li>
                                        <li><a href="ServletEvento?accion=VerFestival"><c:out value="Festival" /></a></li>
                                    </ul>
                                    </li>
                                </ul>                    
                            </li>

                            <%break;
                                }%>
                                                            
                        </ul>
                    </div>
                </nav>






