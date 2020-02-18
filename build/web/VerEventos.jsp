<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelos.Mensajes;"%>
<%@page import="modelos.Evento;"%>
<%@include file="header.jsp" %>
<%
    ArrayList<Evento> Eventos = (ArrayList<Evento>) session.getAttribute("ListaEvento");
%>

    <div class="container">
        <center><h2 style="color:#000">Lista de Eventos</h2></center>
        <hr>
        <br>
        <c:if test="${not empty Eventos}">      
        <table class="table">
            <tr class="success">
                <th>ID</th>
                <th>Nombre</th>
                <th>Categoria</th>
                <th>Fecha</th>
                <th>Lugar</th>
                <th>Descripcion</th>
            </tr>
            <c:forEach items="${Eventos}" var="eventoAct">
            <form class="divTableRow" method="GET" action="./ServletEvento">
                <tr>
                    <%out.print("no estoy vacio");%>
                    <th>${etCodigoEvento()}eventoAct.getNombre()}</th>
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
