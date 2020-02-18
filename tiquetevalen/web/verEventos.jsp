<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelos.Mensajes"%>
<%@include file="header.jsp" %>


    <div class="container">
        <center><h2 style="color:#FDF3E7">Lista de Usuarios</h2></center>
        <hr>
        <br>
        <c:if test="${not empty Eventos.listaEventos}">
        <table class="table">
            <tr class="success">
                <th>ID</th>
                <th>Nombre</th>
                <th>Categoria</th>
                <th>Fecha</th>
                <th>Lugar</th>
                <th>Descripcion</th>
            </tr>
            <c:forEach items="${Eventos.listaEventos}" var="eventoAct">
            <form class="divTableRow" method="GET" action="./servletEstudiante">
                <tr>
                    <th>${eventoAct.getCodigoEvento()}</th>
                    <th>${eventoAct.getNombre()}</th>
                    <th>${eventoAct.getCategoria()}</th>
                    <th>${eventoAct.getFecha()}</th>
                    <th>${eventoAct.getLugar()}</th>
                    <th>${eventoAct.getDescripcion()}</th>
                </tr>
            </form>
            </c:forEach>
        </table>
        </c:if>
    </div>
<%@ include file="footer.jsp" %>
