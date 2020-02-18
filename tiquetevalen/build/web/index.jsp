<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelos.Mensajes"%>
<%@include file="header.jsp" %>


<main role="main">
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">
                <%
                %>
                <c:out value="<%=msj.mensajes.get(bienvenida)%>"/>
            </h1>
            <p>
                <c:out value="<%=msj.mensajes.get(mbienv)%>"/>
            </p>
        </div>
    </div>

    <div class="row">
    <div class="col-md-4">
    <img src="images/boleta.jpg" class="img-responsive">
    </div>
    <div class="col-md-4">
    <img src="images/boleta2.jpg" class="img-responsive">
    </div>
    <div class="col-md-4">
    <img src="images/boleta.jpg" class="img-responsive">
    <style>
        img{
            max-width: 100%
        }
    </style>    
    </div>
    </div>    
        
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <h2>Datos ficticios</h2>
                <p> <c:out value = "<%= msj.mensajes.get(dfict)%>"/>  </p>
                <p><a class="btn btn-outline-secondary" href="ServletUsuario?accion=DatosFicticios" role="button"> Agregar datos &raquo;</a></p>
            </div>
        </div>

        <hr>

    </div> 

</main>

<%@ include file="footer.jsp" %>
