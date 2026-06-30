package com.mycompany.pruebatf2.dao;

import com.mycompany.pruebatf2.conexion.ConexionBD;
import com.mycompany.pruebatf2.modelo.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de gestionar las operaciones CRUD sobre la tabla 'usuario'.
 */
public class UsuarioDAO {

    // Método para insertar un usuario nuevo
    public void insertar(usuario usuario) {
        String sql = "INSERT INTO usuario (nombre_usuario, clave, correo) VALUES (?, ?, ?)";

        try (Connection con = ConexionBD.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            // Utilizamos los nuevos métodos get de la clase modelo
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getClave());
            ps.setString(3, usuario.getCorreo());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para listar todos los usuarios
    public List<usuario> listar() {
        List<usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try (Connection con = ConexionBD.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                usuario u = new usuario();
                // Mapeamos los resultados usando los nuevos setters
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setNombreUsuario(rs.getString("nombre_usuario"));
                u.setClave(rs.getString("clave"));
                u.setCorreo(rs.getString("correo"));
                u.setFechaRegistro(rs.getTimestamp("fecha_registro"));

                lista.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Método para buscar un usuario por su ID
    public usuario buscarPorId(int id) {
        usuario u = null;
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";

        try (Connection con = ConexionBD.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    u = new usuario();
                    // Utilizamos los nuevos setters
                    u.setIdUsuario(rs.getInt("id_usuario"));
                    u.setNombreUsuario(rs.getString("nombre_usuario"));
                    u.setClave(rs.getString("clave"));
                    u.setCorreo(rs.getString("correo"));
                    u.setFechaRegistro(rs.getTimestamp("fecha_registro"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    // Método para actualizar un usuario
    public void actualizar(usuario usuario) {
        String sql = "UPDATE usuario SET nombre_usuario = ?, clave = ?, correo = ? WHERE id_usuario = ?";

        try (Connection con = ConexionBD.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            // Utilizamos los nuevos métodos get
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getClave());
            ps.setString(3, usuario.getCorreo());
            ps.setInt(4, usuario.getIdUsuario());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un usuario por ID
    public void eliminar(int id) {
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";

        try (Connection con = ConexionBD.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
