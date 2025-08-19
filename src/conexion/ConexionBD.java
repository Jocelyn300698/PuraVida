/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Tatiana y Jocelyn
 */
public class ConexionBD {
     // Datos de conexión
    private static final String URL = "jdbc:postgresql://localhost:5432/puravida_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admi"; 
    
   public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
