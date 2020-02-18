<%@ include file="header.jsp" %>
<br>
<br>
<div class="container center_div" style="width:30%;">
    <form style="color:" action="/ServletUsuario" method="POST">
        <center><h2>Crear estudiante</h2></center>
        <hr>
        <br>
        <div class="form-group-row">
            <label for="Nombre">Nombre :</label>
            <input class="form-control" type="text" name="nombreR" id="example-text-input" required>
        </div>
        <br>
        <div class="form-group-row">
            <label for="Email">Email :</label>
            <input class="form-control" type="email" name="emailR" id="example-email-input" required>
        </div>
        <br>
        <div class="form-group-row">
            <label for="Cedula">Documento de Identidad :</label>
            <input class="form-control" type="text" name="documentoR" id="example-url-input" required>
        </div>
        <br>
        <div class="form-group-row">
            <label for="celular" >Celular :</label>
            <input class="form-control" type="text" name="celularR" id="example-tel-input" required>
        </div>
        <br>
        <div class="form-group-row">
            <label for="contraseña" >Contraseña :</label>
            <input class="form-control" type="password" name="claveR" id="example-tel-input" required>
        </div>
        <br>
        <br>
        <br>
        <center><input class="btn btn-primary btn-lg" style="width:50%" value="Enviar" name="registrarse" type="submit"></center>
    </form>
</div>
<br>
<br>
<br>
<br>
<%@ include file="footer.jsp" %>