<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.pruebatf2.modelo.usuario" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Usuarios</title>
</head>
<body>

    <h2>Usuarios Registrados</h2>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Clave</th>
                <th>Correo</th>
                <th>Fecha de Registro</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <% 
                // Obtenemos la lista enviada desde el Servlet
                List<usuario> lista = (List<usuario>) request.getAttribute("listaUsuarios");
                
                // Verificamos que la lista no sea nula para evitar errores
                if (lista != null) {
                    // Recorremos la lista y asignamos cada objeto a la variable 'u'
                    for (usuario u : lista) {
            %>
            <tr>
                <%-- Usamos los nuevos métodos getters definidos en la clase usuario --%>
                <td><%= u.getIdUsuario() %></td>
                <td><%= u.getNombreUsuario() %></td>
                <td><%= u.getClave() %></td>
                <td><%= u.getCorreo() %></td>
                <td><%= u.getFechaRegistro() %></td>
                <td>
                    <%-- Enlaces con los parámetros correctos para el Servlet --%>
                    <a href="UsuarioServlet?accion=editar&id=<%= u.getIdUsuario() %>">Editar</a>
                    <a href="UsuarioServlet?accion=eliminar&id=<%= u.getIdUsuario() %>" 
                       onclick="return confirm('¿Está seguro de eliminar este usuario?')">Eliminar</a>
                </td>
            </tr>
            <% 
                    }
                } 
            %>
        </tbody>
    </table>

    <br>
    <a href="index.jsp">Registrar nuevo usuario</a>

</body>
</html>