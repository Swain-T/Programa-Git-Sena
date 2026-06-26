package com.mycompany.pruebatf1.principal;

// Importamos las clases necesarias para la lógica de acceso a datos y el modelo
import com.mycompany.pruebatf1.dao.UsuarioDAO;
import com.mycompany.pruebatf1.modelo.Usuario;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();

        // 1. Insertamos
        dao.insertar(new Usuario("Carlos", "carlos@email.com", "1234"));
        dao.insertar(new Usuario("Maria", "maria@email.com", "abcd"));
        System.out.println("--- Inserciones realizadas ---");

        // 2. Listamos para confirmar
        List<Usuario> lista = dao.listar();
        System.out.println("Usuarios en BD: " + lista.size());

        // 3. Modificamos y eliminamos
        dao.actualizar("Carlos", "carlos_nuevo@email.com", "9999");
        dao.eliminar("Maria");
        System.out.println("--- Actualización y eliminación realizadas ---");
    }
}
