package com.mycompany.pruebatf2.servlet;

import com.mycompany.pruebatf2.dao.UsuarioDAO;
import com.mycompany.pruebatf2.modelo.usuario; 
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet encargado de controlar el flujo de la aplicación.
 * Gestiona el registro, edición, eliminación y listado de usuarios.
 */
@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {

    private final UsuarioDAO dao = new UsuarioDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");

        if (accion == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        switch (accion) {
            case "listar":
                request.setAttribute("listaUsuarios", dao.listar());
                request.getRequestDispatcher("listar.jsp").forward(request, response);
                break;

            case "editar":
                int idEditar = Integer.parseInt(request.getParameter("id"));
                usuario usuarioEditar = dao.buscarPorId(idEditar);
                request.setAttribute("usuario", usuarioEditar);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;

            case "eliminar":
                int idEliminar = Integer.parseInt(request.getParameter("id"));
                dao.eliminar(idEliminar);
                response.sendRedirect("UsuarioServlet?accion=listar");
                break;

            default:
                response.sendRedirect("index.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String accion = request.getParameter("accion");

        if (accion == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        switch (accion) {
            case "guardar":
                String nombre = request.getParameter("nombre_usuario");
                String clave = request.getParameter("clave");
                String correo = request.getParameter("correo");

                usuario nuevoUsuario = new usuario(nombre, clave, correo);
                dao.insertar(nuevoUsuario);
                response.sendRedirect("UsuarioServlet?accion=listar");
                break;

            case "actualizar":
                int id = Integer.parseInt(request.getParameter("id"));
                String nombreAct = request.getParameter("nombre");
                String claveAct = request.getParameter("clave");
                String correoAct = request.getParameter("correo");

                usuario usuarioActualizado = new usuario(id, nombreAct, claveAct, correoAct, null);
                dao.actualizar(usuarioActualizado);
                response.sendRedirect("UsuarioServlet?accion=listar");
                break;

            default:
                response.sendRedirect("index.jsp");
                break;
        }
    }
}