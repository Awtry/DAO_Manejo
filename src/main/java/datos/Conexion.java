/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.*;

/**
 *
 * @author jorge
 */
public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/prueba?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "Joderastra@mia22";
    
    //Generamos el método de conexión, si hay un error en los usuarios mandará el SQL Error
    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
    }
    
    public static void close(ResultSet rs) throws SQLException
    {
        rs.close();
    }
    
    public static void close(Statement stmt) throws SQLException
    {
        stmt.close();
    }
    
    //Mejora la optimización de las SQL, es más rápido
    public static void close(PreparedStatement stmt) throws SQLException
    {
        stmt.close();
    }
    
    public static void close(Connection conn) throws SQLException
    {
        conn.close();
    }
}
