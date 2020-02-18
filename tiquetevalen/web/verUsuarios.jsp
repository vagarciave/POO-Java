<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelos.Mensajes"%>
<%@include file="header.jsp" %>


    <div class="container">
        <center><h2 style="color:#FDF3E7">Lista de Usuarios</h2></center>
        <hr>
        <br>
        <c:if test="${not empty Usuario.usuarios}">
        <table class="table">
            <tr class="success">
                <th>Nombre</th>
                <th>Documento</th>
                <th>Celular</th>
                <th>Email</th>
                <th>Clave</th>
                <th>Credito</th>
            </tr>
            <c:forEach items="${Usuario.usuarios}" var="userAct">
            <form class="divTableRow" method="GET" action="./servletEstudiante">
                <tr>
                    <th>${userAct.getNombre()}</th>
                    <th>${userAct.getDocumento()}</th>
                    <th>${userAct.getCelular()}</th>
                    <th>${userAct.getEmail()}</th>
                    <th>${userAct.getClave()}</th>
                    <th>${userAct.getCredito()}</th>
                </tr>
            </form>
            </c:forEach>
        </table>
        </c:if>
    </div>
<%@ include file="footer.jsp" %>
