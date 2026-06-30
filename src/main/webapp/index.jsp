<%-- 
    Directiva JSP.
    Define que la página enviará contenido HTML.
    UTF-8 permite mostrar correctamente caracteres especiales.
--%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<%-- Indica al navegador que el documento está escrito en HTML5 --%>
<!DOCTYPE html>
<html>
<head>
    <%-- Define la codificación de caracteres de la página --%>
    <meta charset="UTF-8">
    <%-- Título que aparecerá en la pestaña del navegador --%>
    <title>Registro de Usuarios</title>
</head>
<body>

    <%-- Encabezado principal visible para el usuario --%>
    <h2>Formulario de Registro</h2>

    <%--
        Formulario HTML.
        action="UsuarioServlet": Envía los datos capturados al Servlet.
        method="post": Envía la información de forma segura mediante POST.
    --%>
    <form action="UsuarioServlet" method="post">

        <%--
            Campo oculto.
            Enviamos la acción "guardar" al Servlet para que sepa exactamente 
            qué método ejecutar en el doPost().
        --%>
        <input type="hidden" name="accion" value="guardar">

        <%-- Etiqueta y campo para el nombre del usuario --%>
        <%-- IMPORTANTE: El nombre "nombre_usuario" debe coincidir con request.getParameter("nombre_usuario") en el Servlet --%>
        <label>Nombre:</label>
        <input type="text" name="nombre_usuario" required>
        <br><br>

        <%-- Etiqueta y campo para la clave de acceso --%>
        <label>Clave:</label>
        <input type="password" name="clave" required>
        <br><br>

        <%-- 
            Etiqueta y campo para el correo electrónico.
            Usamos type="email" para que el navegador valide automáticamente 
            que el formato sea correcto.
        --%>
        <label>Correo:</label>
        <input type="email" name="correo" required>
        <br><br>

        <%--
            Botón de envío.
            Al hacer clic, los datos viajan al Servlet, donde el DAO se encarga 
            de persistir la información en MySQL.
        --%>
        <button type="submit">
            Guardar Usuario
        </button>

    </form>

    <br>

    <%--
        Enlace para ver la lista de usuarios.
        Realiza una petición GET al Servlet con el parámetro 'listar',
        lo que activa la consulta a la base de datos para mostrar todos los registros.
    --%>
    <a href="UsuarioServlet?accion=listar">
        Ver lista de usuarios
    </a>

</body>
</html>