package puravida;

import conexion.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PuraVida {
    public static void main(String[] args) {
        try (Connection conn = ConexionBD.getConnection()) {
            System.out.println("Conexión exitosa a la base de datos PuraVida.");

            // Ejemplo: listar categorías
            String sql = "SELECT id, nombre FROM puravida.categoria ORDER BY id";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                System.out.println("Listado de categorías:");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    System.out.println(id + " - " + nombre);
                }
            }

        } catch (Exception e) {
            System.err.println("Error al conectar o consultar la base de datos:");
            e.printStackTrace();
        }
    }
}
