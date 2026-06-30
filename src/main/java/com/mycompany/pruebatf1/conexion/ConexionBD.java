package com.mycompany.pruebatf1.conexion; // Define el paquete donde se organiza la clase de conexión a la base de datos

import java.sql.Connection; // Importa la interfaz que representa una conexión con la base de datos
import java.sql.DriverManager; // Importa la clase que permite establecer la conexión con la base de datos
import java.sql.SQLException; // Importa la clase que maneja errores relacionados con SQL

public class ConexionBD { // Declaración de la clase encargada de gestionar la conexión a la base de datos

private static final String URL = "jdbc:mysql://localhost:3306/taskflow_sql"; 
// URL de conexión a la base de datos: indica el motor, servidor, puerto y nombre de la base de datos

private static final String USER = "root"; 
// Usuario de MySQL que tiene permisos para acceder a la base de datos

private static final String PASSWORD = "Trujillo140704_"; 
// Contraseña del usuario de la base de datos (debe coincidir con la configurada en MySQL)

public static Connection obtenerConexion() throws SQLException { 
// Método público y estático que permite obtener una conexión a la base de datos

return DriverManager.getConnection(URL, USER, PASSWORD); 
// Establece la conexión usando la URL, usuario y contraseña definidos
}
} 