package com.mycompany.pruebatf1.dao;
// Define el paquete DAO (Data Access Object) encargado de manejar el acceso a la base de datos

import com.mycompany.pruebatf1.conexion.ConexionBD;
// Importa la clase que gestiona la conexión a la base de datos

import com.mycompany.pruebatf1.modelo.Usuario;
// Importa la clase Usuario que representa el modelo de datos

import java.sql.*;
// Importa todas las clases necesarias para trabajar con JDBC

import java.util.ArrayList;
// Importa la clase ArrayList para almacenar listas dinámicas

import java.util.List;
// Importa la interfaz List para manejar colecciones de objetos

public class UsuarioDAO {
// Clase DAO encargada de realizar operaciones CRUD en la base de datos

    public void insertar(Usuario usuario) {
        // Definimos la consulta SQL apuntando a las columnas reales de la tabla 'usuario'
        String sql = "INSERT INTO usuario (nombre_usuario, correo, clave) VALUES (?, ?, ?)";

        // El bloque try-with-resources asegura que la conexión y el PreparedStatement se cierren solos
        try (Connection con = ConexionBD.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            // Mapeamos los atributos del objeto Usuario a los parámetros de la consulta SQL
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getClave());

            // Ejecutamos la actualización (INSERT) en la base de datos
            ps.executeUpdate();

            System.out.println("Usuario insertado correctamente.");

        } catch (SQLException e) {
            // Capturamos cualquier error de base de datos
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }

    public List<Usuario> listar() {
        // Inicializamos la lista vacía donde guardaremos los resultados obtenidos
        List<Usuario> lista = new ArrayList<>();

        // Consulta SQL para extraer todos los registros de la tabla
        String sql = "SELECT * FROM usuario";

        // Ejecutamos la consulta y obtenemos un ResultSet que contiene los datos
        try (Connection con = ConexionBD.obtenerConexion(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {

            // Iteramos sobre cada fila del resultado obtenido
            while (rs.next()) {
                Usuario usuario = new Usuario();

                // Extraemos valores usando el nombre exacto de las columnas de tu BD
                usuario.setId(rs.getInt("id_usuario")); // Asignamos el ID real
                usuario.setNombre(rs.getString("nombre_usuario"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setClave(rs.getString("clave"));

                // Añadimos el objeto lleno a nuestra lista
                lista.add(usuario);
            }

        } catch (SQLException e) {
            // Manejamos errores de lectura de base de datos
            System.out.println("Error al listar: " + e.getMessage());
        }

        // Retornamos la lista final de usuarios cargados
        return lista;
    }

    public void actualizar(String nombre, String nuevoCorreo, String nuevaClave) {
        // Método que actualiza el correo y la clave de un usuario específico
        // Usamos nombre_usuario como filtro para encontrar el registro
        String sql = "UPDATE usuario SET correo=?, clave=? WHERE nombre_usuario=?";

        try (Connection con = ConexionBD.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            // Asignamos los nuevos valores a los signos de interrogación en orden
            ps.setString(1, nuevoCorreo); // Primero el correo
            ps.setString(2, nuevaClave);  // Segundo la clave
            ps.setString(3, nombre);      // Tercero el nombre (filtro)

            // Ejecutamos la actualización en la base de datos
            ps.executeUpdate();

            System.out.println("Usuario actualizado correctamente.");

        } catch (SQLException e) {
            // Captura errores si la actualización falla
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }

    public void eliminar(String nombre) {
        // Método que elimina un usuario según su nombre_usuario
        String sql = "DELETE FROM usuario WHERE nombre_usuario=?";

        try (Connection con = ConexionBD.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombre);

            ps.executeUpdate();
            System.out.println("Usuario eliminado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
        }
    }
}
