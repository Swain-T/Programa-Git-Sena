// Indica el paquete donde se encuentra la clase.
// Sirve para organizar el proyecto por capas.
package com.mycompany.pruebatf2.conexion;

// Importa la clase Connection.
// Representa una conexión activa con la base de datos.
import java.sql.Connection;

// Importa DriverManager.
// Se utiliza para crear conexiones con la base de datos.
import java.sql.DriverManager;

// Importa SQLException.
// Permite manejar errores relacionados con SQL.
import java.sql.SQLException;

// Clase encargada de administrar las conexiones con MySQL.
// Todas las clases DAO utilizarán esta clase para conectarse.
public class ConexionBD {

    // URL de conexión a MySQL.
    // localhost: servidor local.
    // 3306: puerto de MySQL.
    // taskflow_sql: nombre de la base de datos.
    // Los parámetros adicionales ayudan a evitar errores de conexión.
    private static final String URL
            = "jdbc:mysql://localhost:3306/taskflow_sql?useSSL=false&serverTimezone=UTC";

    // Usuario con el que se accederá a MySQL.
    private static final String USER = "root";

    // Contraseña del usuario de MySQL.
    private static final String PASSWORD = "Trujillo140704_";

    // Bloque estático.
    // Se ejecuta una sola vez cuando la clase se carga en memoria.
    static {

        try {

            // Carga el controlador JDBC de MySQL.
            // Permite que Java reconozca cómo comunicarse con MySQL.
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Mensaje de confirmación en consola.
            System.out.println("Driver de MySQL cargado correctamente.");

        } catch (ClassNotFoundException e) {

            // Mensaje si el controlador no fue encontrado.
            System.out.println("Error: no se encontró el driver de MySQL.");

            // Muestra el detalle completo del error.
            e.printStackTrace();
        }
    }

    // Método público y estático para obtener una conexión.
    // Puede ser utilizado desde cualquier clase sin crear un objeto.
    public static Connection obtenerConexion() throws SQLException {

        // Retorna una conexión utilizando:
        // URL de la base de datos.
        // Usuario.
        // Contraseña.
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
