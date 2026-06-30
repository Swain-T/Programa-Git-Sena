package com.mycompany.pruebatf1.modelo;

//Clase modelo Usuario: Representa la entidad de usuario en TaskFlow. 
//Utiliza el patrón de encapsulamiento para proteger la integridad de los datos.
 
public class Usuario {

    // --- ATRIBUTOS ---
    // Definidos como "private" para restringir el acceso directo desde otras clases,
    // obligando al uso de métodos públicos (Getters/Setters).
    private int id;          // Identificador único (llave primaria en la base de datos)
    private String nombre;   // Nombre de usuario
    private String correo;    // Correo electrónico único
    private String clave;    // Contraseña de acceso

    // --- CONSTRUCTORES ---
    // Usamos "Sobrecarga de Constructores" para flexibilizar la creación de objetos
    // según la información disponible en cada momento del ciclo de vida de la app.

    // 1. Constructor vacío: Necesario para frameworks de persistencia 
    // y para instancias que serán llenadas gradualmente vía 'setters'.
    public Usuario() {}

    // 2. Constructor para INSERCIÓN: Se usa cuando creamos un usuario nuevo 
    // desde la interfaz, antes de que la base de datos le asigne un ID automáticamente.
    public Usuario(String nombre, String correo, String clave) {
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
    }

    // 3. Constructor COMPLETO: Se usa al consultar la base de datos, 
    // donde el ID ya existe y debemos reconstruir el objeto tal cual está en la BD.
    public Usuario(int id, String nombre, String correo, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
    }

    // --- MÉTODOS DE ACCESO (Getters y Setters) ---
    // Proporcionan una interfaz pública y segura para manipular los atributos privados.

    // Obtiene el identificador del usuario
    public int getId() { return id; }
    // Asigna el identificador
    public void setId(int id) { this.id = id; }

    // Obtiene el nombre del usuario
    public String getNombre() { return nombre; }
    // Modifica el nombre del usuario
    public void setNombre(String nombre) { this.nombre = nombre; }

    // Obtiene el correo (usado para validaciones de inicio de sesión)
    public String getCorreo() { return correo; }
    // Modifica el correo
    public void setCorreo(String correo) { this.correo = correo; }

    // Obtiene la clave (normalmente para verificación interna)
    public String getClave() { return clave; }
    // Modifica la clave (útil para la función de cambio de contraseña)
    public void setClave(String clave) { this.clave = clave; }
}