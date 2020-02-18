<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp" %>
<html>
    <div class="container center_div" style="width:30%;">
	<body style="background-color: #868e96;">
        <center>
            <form action="/ServletUsuario" method="POST">
                <h2 style="color: #fff">Ingresar</h2>
                        <br>
			<input class="form-control" type="text" style="width:50%" placeholder="&#128272; Email" name="email" id="example-text-input" required>
                        <br>
			<input class="form-control" type="password" style="width:50%" placeholder="&#128272; Contraseña" name="clave" id="example-text-input" required>
                        <br>
                        <input type="submit" class="btn btn-primary btn-lg" style="width:30%" name="accion" value="Ingresar">
            </form>
            </center>
            </div>       
	</body>
</html>
<%@ include file="footer.jsp" %>
