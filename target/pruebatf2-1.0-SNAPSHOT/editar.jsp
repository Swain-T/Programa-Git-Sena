<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registro de Usuario</title>
</head>
<body>

    <h2>Registrar Nuevo Usuario</h2>

    <%-- 
        Formulario para capturar los datos de un nuevo usuario.
        Se dirige a 'UsuarioServlet' usando el método POST.
        El campo oculto 'accion' le indica al Servlet que debe ejecutar el bloque 'guardar'.
    --%>
    <form action="UsuarioServlet" method="post">
        
        <input type="hidden" name="accion" value="guardar">

        <label>Nombre:</label><br>
        <input type="text" name="nombre" required><br><br>

        <label>Clave:</label><br>
        <input type="password" name="clave" required><br><br>

        <label>Correo:</label><br>
        <input type="email" name="correo" required><br><br>

        <button type="submit">Guardar Usuario</button>
        
        <%-- Enlace para ir directamente a la lista de usuarios ya registrados --%>
        <a href="UsuarioServlet?accion=listar">Ver lista de usuarios</a>
    </form>

</body>
</html>